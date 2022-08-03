package sinexcel.daysPlan.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.annotation.DataSource;
import sinexcel.common.enums.DataSourceType;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.daysPlan.domain.MesTransferHeaderAll;
import sinexcel.daysPlan.domain.MesTransferLineAll;
import sinexcel.daysPlan.domain.PesInvMaterialTxns;
import sinexcel.daysPlan.domain.PesProdPlanTransferAll;
import sinexcel.daysPlan.mapper.PesProdPlanTransferAllMapper;
import sinexcel.daysPlan.mapper.PesProdPlanTransferAllWWMapper;
import sinexcel.daysPlan.service.IPesInvMaterialTxnsService;
import sinexcel.daysPlan.service.IPesProdPlanBeiLiaoAllService;
import sinexcel.daysPlan.service.IPesProdPlanTransferAllService;
import sinexcel.daysPlan.service.MesTransferHeaderAllService;
import sinexcel.mesApi.service.IMesApiCommonService;
import sinexcel.utils.CommonStatic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static sinexcel.utils.CommonStatic.*;

/**
 * 生产计划调拨单Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-07-01
 */
@Service
public class PesProdPlanTransferAllServiceImpl implements IPesProdPlanTransferAllService 
{
    public static final String BASIC_BEI_LIAO = "basic_bei_liao";

    private  Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    IPesProdPlanBeiLiaoAllService beiLiaoAllService;
    @Autowired
    private PesProdPlanTransferAllMapper pesProdPlanTransferAllMapper;
    @Autowired
    private PesProdPlanTransferAllWWMapper pesProdPlanTransferAllWWMapper;
    @Autowired
    private MesTransferHeaderAllService mesTransferHeaderAllService;
    @Autowired
    private IPesInvMaterialTxnsService invMaterialTxnsService;
    @Autowired
    private IMesApiCommonService mesApiCommonService;

    /**
     * 查询生产计划调拨单列表
     *
     * @param pesProdPlanTransferAll 生产计划调拨单
     * @return 生产计划调拨单
     */
    @Override
    public List<PesProdPlanTransferAll> selectPesProdPlanTransferAllList(PesProdPlanTransferAll pesProdPlanTransferAll)
    {
        return pesProdPlanTransferAllMapper.selectPesProdPlanTransferAllList(pesProdPlanTransferAll);
    }

    /**
     * 新增生产计划调拨单
     * 
     * @param id 生产计划调拨单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @DataSource(DataSourceType.MASTER)
    public synchronized int insertPesProdPlanTransferAll(Long id,String sourceType)
    {
        String max_subcode = "0";
        BigDecimal max_quantity = BigDecimal.ZERO;
        Long inventoryItemId = 0L;
        Long organizationId = 0L;
        List<PesProdPlanTransferAll> selectPesProdPlanTransferAllByIds = pesProdPlanTransferAllMapper.selectPesProdPlanTransferAllById(id,sourceType);
        if(selectPesProdPlanTransferAllByIds.size() > 0){
            List<MesTransferLineAll> lineAlls = new ArrayList<>();
            for(PesProdPlanTransferAll pesProdPlanTransferAll:selectPesProdPlanTransferAllByIds){
                pesProdPlanTransferAll.setCreateBy(SecurityUtils.getUsername());
                if(organizationId.equals(pesProdPlanTransferAll.getOrganizationId())&&inventoryItemId.equals(pesProdPlanTransferAll.getInventoryItemId())){
                    pesProdPlanTransferAll.setMaxSubcode(max_subcode);
                    pesProdPlanTransferAll.setMaxQuantity(max_quantity);
                }else {
                    pesProdPlanTransferAll.setMaxSubcode("0");
                    pesProdPlanTransferAll.setMaxQuantity(BigDecimal.ZERO);
                }
                List<PesProdPlanTransferAll> pesProdOnhandQuantitys = pesProdPlanTransferAllMapper.selectPesProdOnhandQuantitys(pesProdPlanTransferAll);
                if(pesProdOnhandQuantitys.size() > 0){
                    for(PesProdPlanTransferAll pesProdOnhandQuantity:pesProdOnhandQuantitys){
                        pesProdPlanTransferAll.setDiaoChuSubinventory(pesProdOnhandQuantity.getDiaoChuSubinventory());
                        pesProdPlanTransferAll.setDiaoChuQuantity(pesProdOnhandQuantity.getDiaoChuQuantity());
                        pesProdPlanTransferAll.setDiaoRuQuantity(pesProdPlanTransferAll.getDiaoChuQuantity());
                        if(pesProdOnhandQuantity.getDiaoChuSubinventory().equals(pesProdOnhandQuantity.getMaxSubinventoryCode())||pesProdOnhandQuantity.getDiaoChuSubinventory()==pesProdOnhandQuantity.getMaxSubinventoryCode()){
                            max_subcode = pesProdOnhandQuantity.getDiaoChuSubinventory();
                            max_quantity = pesProdOnhandQuantity.getDiaoChuQuantity();
                            inventoryItemId = pesProdOnhandQuantity.getInventoryItemId();
                            organizationId = pesProdOnhandQuantity.getOrganizationId();
                        }
                        //----新增 -----
                        pesProdPlanTransferAll.setSourceId(pesProdPlanTransferAll.getBeiLiaoId());
                        //----结束新增 -----

                        //创建调拨单
                        insert(pesProdPlanTransferAll,sourceType,TRANSFER_TYPE_BEI_LIAO,
                                INV_SOURCE_CODE_WORK_ORDER,lineAlls,"0",INV_SOURCE_TYPE_BEI_LIAO_OUT);
                        //根据发放调拨更新备料单数据
                        beiLiaoAllService.updateTransferStart(pesProdPlanTransferAll);

                    }
                }
            }
            if (lineAlls.size()>0) {
                //写入中间表
                insertMesTransfer(lineAlls);
            }

        }else {
            throw new CustomException("此备料单不需要生成调拨单，请核对备料单的数据！！！");
        }
        if (StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_ISSUE,sourceType)){
            return pesProdPlanTransferAllMapper.updateTransferFlag(id);
        }else  if (StringUtils.equals(INV_SOURCE_CATEGORY_OUTSIDE,sourceType)){
            return pesProdPlanTransferAllWWMapper.updateTransferFlag(id);
        }
        return 0;
    }

    @Transactional(rollbackFor = Exception.class)
    void insert(PesProdPlanTransferAll info, String sourceType,
                String sourceCategory, String sourceCode,List<MesTransferLineAll> lineAlls,
                String type,String invSourceCategory) {
        info.setType(type);
        info.setSourceCategory(sourceCategory);
        info.setSourceType(sourceType);
        info.setSourceCode(sourceCode);
        info.setSourceName(info.getWorkOrderNumber());
        info.setSourceReferenceId(info.getWorkOrderId());
        pesProdPlanTransferAllMapper.insertPesProdPlanTransferAll(info);
        //设置中间表信息
        setMesTransferInfo(info, type, sourceType, sourceCode, lineAlls,sourceCategory);

        //创建出库记录
        BigDecimal quantity = new BigDecimal(0);
        String subinventory = info.getDiaoChuSubinventory();
        if (StringUtils.equals(type, "0")){
//            备料调拨
            subinventory = info.getDiaoChuSubinventory();
            quantity =  info.getDiaoChuQuantity().multiply(new BigDecimal(-1));

        }else if (StringUtils.equals(type, "1")){
//            备料接收
            subinventory = info.getTurnoverSubinventory();
            quantity =  info.getDiaoChuQuantity().multiply(new BigDecimal(-1));

        }
        PesInvMaterialTxns inv = new PesInvMaterialTxns(info.getInventoryItemId(),info.getOrganizationId(),subinventory,
                INV_TYPE_OUT,invSourceCategory,sourceType,sourceCode,info.getWorkOrderNumber(),quantity,
                null,null,new Date(),info.getWorkOrderId(),null,null,
                info.getPlanTransferId(),new Date(),"1",null);
        inv.setCreateBy(info.getCreateBy());
        inv.setLastUpdateDate(new Date());
        inv.setLastUpdatedBy(info.getCreateBy());
        invMaterialTxnsService.insertPesInvMaterialTxns(inv);
    }

    private void setMesTransferInfo(PesProdPlanTransferAll info, String type, String sourceType,
                                    String sourceCode, List<MesTransferLineAll> lineAlls, String sourceCategory) {
        BigDecimal quantity = info.getDiaoChuQuantity();
        String chuSubinventory = info.getDiaoChuSubinventory();
        String ruSubinventory = info.getDiaoRuSubinventory();
        if (StringUtils.equals(type, "0")){
//            备料调拨
             chuSubinventory = info.getDiaoChuSubinventory();
             ruSubinventory = info.getTurnoverSubinventory();

        }else if (StringUtils.equals(type, "1")){
//            备料接收
             chuSubinventory = info.getTurnoverSubinventory();
             ruSubinventory = info.getDiaoRuSubinventory();

        }

        MesTransferLineAll lineAll = new MesTransferLineAll(info.getOrganizationId(),info.getInventoryItemId(),
                quantity,chuSubinventory,ruSubinventory,info.getBeiLiaoId(),type,sourceCategory,sourceType,sourceCode,
                info.getWorkOrderNumber(),info.getWorkOrderId(),info.getPlanTransferId(),null,new Date(),
                info.getCreateBy(),info.getCreateBy(),new Date());
        lineAlls.add(lineAll);
    }

    /**
     * 批量删除生产计划调拨单
     * 
     * @param planTransferIds 需要删除的生产计划调拨单ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesProdPlanTransferAllByIds(Long[] planTransferIds)
    {
        return pesProdPlanTransferAllMapper.deletePesProdPlanTransferAllByIds(planTransferIds);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertReceive(PesInvMaterialTxns o) {
        //根据来源id 获取调拨单
        PesProdPlanTransferAll transfer = new PesProdPlanTransferAll();
        transfer.setPlanTransferId(o.getTransactionSourceId());
        List<PesProdPlanTransferAll> transferInfoBefer = pesProdPlanTransferAllMapper
                .selectPesProdPlanTransferAllList(transfer);
        if (transferInfoBefer.size()<1){
            log.error("未找到调拨单："+o.toString());
            return false;
        }

        //创建调拨接收单
        PesProdPlanTransferAll info;
        info = transferInfoBefer.get(0);
        //更新调拨单状态
        updateFlag(info.getPlanTransferId(),"1");
        info.setCreateBy(o.getCreateBy());
        info.setCreateDate(new Date());
        info.setDiaoChuQuantity(o.getTransactionQuantity());
        info.setType("1");
        List<MesTransferLineAll> lineAlls = new ArrayList<>();


        insert(info,info.getSourceType(),info.getSourceCategory(),
                info.getSourceCode(),lineAlls,info.getType(),INV_SOURCE_TYPE_TRANSFER_IN);

        if (lineAlls.size()>0) {
            //写入中间表
            insertMesTransfer(lineAlls);
        }

        //回写到备料单 接收数量
        if (StringUtils.equals(info.getSourceCategory(),TRANSFER_TYPE_BEI_LIAO)){
            //备料
            beiLiaoAllService.updateReceiveQty(info.getSourceId(),o.getTransactionQuantity(),"0");
        }

        return true;
    }

    private void insertMesTransfer(List<MesTransferLineAll> lineAlls) {
        List<MesTransferHeaderAll> pushList = mesTransferHeaderAllService.insertAndLine(lineAlls);
        List<Long> pushIds = pushList.stream().map(MesTransferHeaderAll::getId).collect(Collectors.toList());
        //中间表数据写入mes（开启线程  切换数据源）
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        AtomicInteger flag = new AtomicInteger(-1);
        Thread t = new Thread(() -> {
            flag.set(mesApiCommonService.pushTransferOrder(pushList));
        });
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        Future future = executorService.submit(t);//子线程启动
        try {
            future.get();//需要捕获两种异常
        } catch (InterruptedException | ExecutionException e) {
            throw new CustomException("调拨单写入wms失败！！！");
        }
        if (flag.get() < 0) {
            throw new CustomException("调拨单写入wms失败！！！");
        }
        //标记中间表 已经更新
        String state = "1";
        mesTransferHeaderAllService.updateState(pushIds, state);
    }

    /**
     * @Author mingshen.wang
     * @Description 更新调拨单状态
     * @Date 17:22 2021/8/30
     * @Param [id, flag]
     * @return void
     **/
    private void updateFlag(Long id,String flag) {

        PesProdPlanTransferAll upInfo = new PesProdPlanTransferAll();
        upInfo.setPlanTransferId(id);
        upInfo.setTransferFlag(flag);
        pesProdPlanTransferAllMapper.updatePesProdPlanTransferAll(upInfo);
    }

    @Override
    public Boolean receive(PesInvMaterialTxns o) {
        //根据来源id 获取调拨单
        PesProdPlanTransferAll transfer = new PesProdPlanTransferAll();
        transfer.setPlanTransferId(o.getTransactionSourceId());
        List<PesProdPlanTransferAll> transferInfoBefer = pesProdPlanTransferAllMapper
                .selectPesProdPlanTransferAllList(transfer);
        if (transferInfoBefer.size()<1){
            log.error("未找到调拨单："+o.toString());
            return false;
        }
        PesProdPlanTransferAll info = transferInfoBefer.get(0);
        //更新调拨单状态
        updateFlag(info.getPlanTransferId(),"1");
        //回写到备料单 接收数量
        if (StringUtils.equals(info.getSourceCategory(),TRANSFER_TYPE_BEI_LIAO)){
            //备料单
            beiLiaoAllService.updateReceiveQty(info.getSourceId(),o.getTransactionQuantity(),"1");
        }
        return true;
    }
}
