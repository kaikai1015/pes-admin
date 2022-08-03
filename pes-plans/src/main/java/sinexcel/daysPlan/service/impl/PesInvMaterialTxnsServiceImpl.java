package sinexcel.daysPlan.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.mchange.lang.LongUtils;
import org.redisson.api.RBloomFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.utils.StringUtils;
import sinexcel.daysPlan.domain.MesInvMaterialTxns;
import sinexcel.daysPlan.domain.PesInvMaterialTxns;
import sinexcel.daysPlan.mapper.PesInvMaterialTxnsMapper;
import sinexcel.daysPlan.service.IMesInvMaterialTxnsService;
import sinexcel.daysPlan.service.IPesInvMaterialTxnsService;
import sinexcel.daysPlan.service.IPesProdPlanTransferAllService;
import sinexcel.daysPlan.service.IPesProdProcessingService;
import sinexcel.utils.BloomFilterUtils;
import sinexcel.utils.CommonStatic;

/**
 * 库存事务处理明细Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-08-28
 */
@Service
public class PesInvMaterialTxnsServiceImpl implements IPesInvMaterialTxnsService
{
    @Autowired
    private PesInvMaterialTxnsMapper pesInvMaterialTxnsMapper;
    @Autowired
    IMesInvMaterialTxnsService mesInvMaterialTxnsService;
    @Autowired
    IPesProdPlanTransferAllService transferAllService;
    @Autowired
    IPesProdProcessingService processingService;
    @Autowired
    IPesInvMaterialTxnsService invMaterialTxnsService;

    Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 查询库存事务处理明细
     *
     * @param id 库存事务处理明细ID
     * @return 库存事务处理明细
     */
    @Override
    public PesInvMaterialTxns selectPesInvMaterialTxnsById(Long id)
    {
        return pesInvMaterialTxnsMapper.selectPesInvMaterialTxnsById(id);
    }

    /**
     * 查询库存事务处理明细列表
     *
     * @param pesInvMaterialTxns 库存事务处理明细
     * @return 库存事务处理明细
     */
    @Override
    public List<PesInvMaterialTxns> selectPesInvMaterialTxnsList(PesInvMaterialTxns pesInvMaterialTxns)
    {
        return pesInvMaterialTxnsMapper.selectPesInvMaterialTxnsList(pesInvMaterialTxns);
    }

    /**
     * 新增库存事务处理明细
     *
     * @param pesInvMaterialTxns 库存事务处理明细
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public int insertPesInvMaterialTxns(PesInvMaterialTxns pesInvMaterialTxns)
    {
        return pesInvMaterialTxnsMapper.insertPesInvMaterialTxns(pesInvMaterialTxns);
    }

    /**
     * 修改库存事务处理明细
     *
     * @param pesInvMaterialTxns 库存事务处理明细
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public int updatePesInvMaterialTxns(PesInvMaterialTxns pesInvMaterialTxns)
    {
        return pesInvMaterialTxnsMapper.updatePesInvMaterialTxns(pesInvMaterialTxns);
    }

    /**
     * 批量删除库存事务处理明细
     *
     * @param ids 需要删除的库存事务处理明细ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public int deletePesInvMaterialTxnsByIds(Long[] ids)
    {
        return pesInvMaterialTxnsMapper.deletePesInvMaterialTxnsByIds(ids);
    }

    /**
     * 删除库存事务处理明细信息
     *
     * @param id 库存事务处理明细ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public int deletePesInvMaterialTxnsById(Long id)
    {
        return pesInvMaterialTxnsMapper.deletePesInvMaterialTxnsById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public synchronized void synData(Date sTime, Date eTime) {
        //获取未同步的数据
        List<MesInvMaterialTxns> synList =  mesInvMaterialTxnsService.getSynData();
        if (synList.size()<1){
            return;
        }
        //判断重复数据
        long[] mesInvIds = synList.stream().mapToLong(MesInvMaterialTxns::getMesTransferId).toArray();
        List<PesInvMaterialTxns> cfList = pesInvMaterialTxnsMapper.getListByMesIds(mesInvIds);
//        //更新重复数据状态
//        if (cfList.size()>0){
//            long[] cfIds = cfList.stream().mapToLong(PesInvMaterialTxns::getMesTransferId).toArray();
//            String state = "4";
//            mesInvMaterialTxnsService.updateState(cfIds,state);
//        }
//        //通过sql 插入数据
//        List<Long> inserIdList =  new ArrayList<>();
//        List<Long> mesInvIdList = synList.stream().map(MesInvMaterialTxns::getMesTransferId).collect(Collectors.toList());
//        if (cfList.size()>0){
//
//            List<Long> cfIdsList = cfList.stream().map(PesInvMaterialTxns::getMesTransferId).collect(Collectors.toList());
//            List<Long> finalInserIdList = inserIdList;
//            mesInvIdList.forEach(o->{
//                if (!cfIdsList.contains(o)){
//                    finalInserIdList.add(o);
//                }
//            });
//        }else {
//            inserIdList = mesInvIdList;
//        }
//        if (inserIdList.size()<1){
//            return;
//        }
//        mesInvMaterialTxnsService.insertSynData(inserIdList);
//        //更新结果状态
//        long[] nIds = inserIdList.stream().mapToLong(o -> o).toArray();
//        mesInvMaterialTxnsService.updateState(nIds,"2");
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public synchronized void  handleWarehousing() {
        //获取需要处理的入库数据
        List<PesInvMaterialTxns> pList =  this.getPendingList();
        //判断类型是否发起 调拨接收单
        final Boolean[] flag = {true};
        pList.forEach(o->{
            if (StringUtils.equals(o.getTransactionSourceCategory(), CommonStatic.INV_SOURCE_TYPE_BEI_LIAO_OUT)&&
                    StringUtils.equals(o.getTransactionSourceType(),CommonStatic.INV_SOURCE_CATEGORY_ISSUE)){
                //厂内备料调拨
                //发起接收单 并回写接收数量 回写调拨单状态
                flag[0] = transferAllService.insertReceive(o);

            }else if (StringUtils.equals(o.getTransactionSourceCategory(), CommonStatic.INV_SOURCE_TYPE_TRANSFER_IN)&&
                    StringUtils.equals(o.getTransactionSourceType(),CommonStatic.INV_SOURCE_CATEGORY_ISSUE)){
                //厂内调拨接收
                //回写接收数量 回写调拨单状态
                flag[0] = transferAllService.receive(o);
            }
            //更新处理状态
            PesInvMaterialTxns updateInfo =new PesInvMaterialTxns();
            updateInfo.setId(o.getId());
            updateInfo.setCheckResult((flag[0] ?"1":"2"));
            pesInvMaterialTxnsMapper.updatePesInvMaterialTxns(updateInfo);
        });

    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public boolean insertHandle(PesInvMaterialTxns pesInvMaterialTxns) {
        if (StringUtils.equals(CommonStatic.INV_TYPE_OUT,pesInvMaterialTxns.getTransactionType())
                && pesInvMaterialTxns.getTransactionQuantity().compareTo(new BigDecimal(0)) > 0
        ){ //出库转负数
            pesInvMaterialTxns.setTransactionQuantity(pesInvMaterialTxns.getTransactionQuantity()
                    .multiply(new BigDecimal(-1)));
        }
        //插入数据
        pesInvMaterialTxnsMapper.insertPesInvMaterialTxns(pesInvMaterialTxns);
        //处理更新汇总数据
        processingService.sumByInv(pesInvMaterialTxns);

        return true;
    }


    @Override
    public AjaxResult insertBatchAndVerify(List<PesInvMaterialTxns> infoList) {
        //根据单据类型验证数据的必填项
        List<Map<String,String>> err = new ArrayList<>();
        logger.info("insertBatchAndVerify:"+JSONUtil.toJsonStr(infoList));
        infoList.forEach(o->{
            boolean flag = verify(err,o);
            if (flag){
                try {
//                    判断是否重复
                   if (this.verifyKey(o)){
                       Map<String,String> er = new HashMap<>();
                       er.put("id",o.getMesTransferId()+"");
                       er.put("code","408");
                       er.put("msg","记录已经存在请不要重复推送");
                       err.add(er);
                   }else {
                       invMaterialTxnsService.insertHandle(o);
                   }

                }catch (Exception e){
                    Map<String,String> er = new HashMap<>();
                    er.put("id",o.getMesTransferId()+"");
                    er.put("code","500");
                    er.put("msg",e.getMessage());
                    err.add(er);
                }
            }
        });
        if (err.size()>0){
            logger.info("insertBatchAndVerify  err:"+JSONUtil.toJsonStr(err));
            return new AjaxResult(502,"存在"+err.size()+"条记录插入失败",err);
        }else {
            return AjaxResult.success();
        }

    }

    public boolean verifyKey(PesInvMaterialTxns info) {
        RBloomFilter<String> bloomList = BloomFilterUtils.getBloomFilter("invKeyList");
        if (bloomList.contains(info.getTransactionType()+info.getTransactionSourceCategory()
                +info.getTransactionSourceType()+info.getMesTransferId())){
            //true 存在 误差
            PesInvMaterialTxns newInfo = new PesInvMaterialTxns();
            newInfo.setTransactionSourceType(info.getTransactionSourceType());
            newInfo.setTransactionType(info.getTransactionType());
            newInfo.setTransactionSourceCategory(info.getTransactionSourceCategory());
            newInfo.setMesTransferId(info.getMesTransferId());
            List<PesInvMaterialTxns> list = pesInvMaterialTxnsMapper.selectPesInvMaterialTxnsList(newInfo);
            if (list.size()>0){
                return true;
            }
        }
        //不存在则加入rides
        bloomList.add(info.getTransactionType()+info.getTransactionSourceCategory()
                +info.getTransactionSourceType()+info.getMesTransferId());
        return false;
    }
    @Override
    public int intiKey() {
        RBloomFilter<String> bloomList = BloomFilterUtils.getBloomFilter("invKeyList");
        bloomList.delete();
        bloomList.tryInit(100000000L,0.01);
        List<PesInvMaterialTxns> list =  pesInvMaterialTxnsMapper.getKey();
        list.forEach(o->{
            bloomList.add(o.getMesKey());
        });
        return 1;
    }

    private static boolean verify(List<Map<String, String>> err, PesInvMaterialTxns o) {
        Boolean flag = true;
        Map<String,String> er = new HashMap<>();
        er.put("id",o.getMesTransferId()+"");
        er.put("code","401");
        //检验类型的正确性
        if (!isCategory(o)){
            er.put("msg","字段[transactionSourceCategory]不存在 “"+o.getTransactionSourceCategory()+"“ 类型！请参考：\n" +
                    "出入库类别(\n" +
                    "PURCHASE_IN:采购入库；PURCHASE_BACK:采购退货；WORK_IN:工单入库；WIP Backflush：工单扣料;BEI_LIAO_OUT:备料调拨;TRANSFER_IN:调拨接收;\n" +
                    "BACK_OUT:退料调拨；EXCEED_OUT:超料调拨;SALE_OUT:销售出库；SALE_BACK:销售退货；INV_OUT:调拨出库；INV_IN:调拨入库；INV_SUNDRY_OUT:杂出；INV_SUNDRY_IN:杂入；\n" +
                    ")");
            err.add(er);
            return false;
        }
        if (!isType(o)){
            er.put("msg","字段[transactionSourceType]不存在 “"+o.getTransactionSourceType()+"“ 类型！请参考：\n" +
                    "出入库种类(ISSUE:厂内工单发料调拨;OUTSIDE:委外工单领料调拨;PURCHASE_IN:采购入库；WIP Backflush：" +
                    "工单扣料；WIP Backflush EXCEED：工单超领扣料；PURCHASE_BACK:采购退货；ISSUE_WORK:厂内工单；OUTSIDE_WORK:委外工单；ISSUE_EXCEED:厂内超料调拨；OUTSIDE_EXCEED:委外超料调拨；ISSUE_BACK:厂内退料调拨；OUTSIDE_BACK:委外退料调拨；SALE_OUT:销售出库；SALE_BACK:销售退货；INV:库存调拨；INV_SUNDRY_OUT:杂出；INV_SUNDRY_IN:杂入；)");
            err.add(er);
            return false;
        }
        //公共必填
        flag = verifyNull("transactionSourceType,lastUpdateDate,lastUpdatedBy,inventoryItemId," +
                "organizationId,subinventoryCode,transactionType,transactionSourceCategory,transactionQuantity," +
                "transactionDate,createBy,createDate,sourceCode",o,er,flag);
        if (StringUtils.equals("WMS",o.getSourceCode())){
            flag = verifyNull("mesTransferId",o,er,flag);
        }

        if (StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_PURCHASE_IN,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_PURCHASE_BACK,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_BEI_LIAO_OUT,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_TRANSFER_IN,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_BACK_OUT,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_EXCEED_OUT,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_SALE_OUT,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_SALE_BACK,o.getTransactionSourceCategory())
        ){
            //采购入库、采购出库、发料调拨、超料调拨、退料调拨、销售出库、销售退货
            flag = verifyNull("transactionSourceCode,transactionSourceName,transactionSourceReferenceId",o,er,flag);
        }else if (StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_WORK_IN,o.getTransactionSourceCategory())){
            //工单入库
            flag = verifyNull("transactionSourceCode,transactionSourceName,transactionSourceReferenceId," +
                    "sourceLineId",o,er,flag);
        }else if (StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_INV_SUNDRY_IN,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_INV_SUNDRY_OUT,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_INV_IN,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_INV_OUT,o.getTransactionSourceCategory())
        ){
            //库存调拨、杂出、杂入
//            flag = verifyNull("transactionSourceCode,transactionSourceName" +
//                    "",o,er,flag);
        }
        if (!flag){
            er.put("msg",er.get("msg")+"]不可以为空！");
            err.add(er);
        }
        return flag;
    }

    private static boolean isType(PesInvMaterialTxns o) {
        return StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_ISSUE,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_OUTSIDE,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_PURCHASE_IN,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_WIP_BACKFLUSH,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_WIP_BACKFLUSH_XCEED,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_PURCHASE_BACK,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_ISSUE_WORK,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_OUTSIDE_WORK,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_ISSUE_EXCEED,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_OUTSIDE_EXCEED,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_ISSUE_BACK,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_OUTSIDE_BACK,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_SALE_OUT,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_INV,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_INV_SUNDRY_OUT,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_INV_SUNDRY_IN,o.getTransactionSourceType())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_SALE_BACK,o.getTransactionSourceType());
    }

    private static boolean isCategory(PesInvMaterialTxns o) {
        return StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_PURCHASE_IN,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_PURCHASE_BACK,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_WORK_IN,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_WIP_BACKFLUSH,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY__OUTSIDE_WIP_BACKFLUSH,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_BEI_LIAO_OUT,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_TRANSFER_IN,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_BACK_OUT,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_EXCEED_OUT,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_SALE_OUT,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_INV_OUT,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_INV_IN,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_INV_SUNDRY_IN,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_INV_SUNDRY_OUT,o.getTransactionSourceCategory())
                ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_SALE_BACK,o.getTransactionSourceCategory());
    }

    private static Boolean verifyNull(String s, PesInvMaterialTxns o, Map<String, String> er, Boolean flag) {
        String[] fields = s.split(",");
        Class<?> aClass = o.getClass();
        for (int i = 0; i < fields.length; i++) {
            //得到属性
            Field field;
            try {
                field = aClass.getDeclaredField(fields[i]);
                //打开私有访问
                field.setAccessible(true);
                //获取属性值
                Object subjectType =  field.get(o);
                Type fieldType =field.getGenericType();
                if (subjectType == null){
                    if (er.containsKey("msg")){
                        er.put("msg",er.get("msg")+","+fields[i]);
                    }else {
                        er.put("msg","字段["+fields[i]);
                    }
                    flag=false;
                    continue;
                }
                if (String.class == fieldType  ){
                    if (StringUtils.isEmpty(subjectType.toString())){
                        if (er.containsKey("msg")){
                            er.put("msg",er.get("msg")+","+fields[i]);
                        }else {
                            er.put("msg","字段["+fields[i]);
                        }
                        flag=false;
                        continue;
                    }
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        PesInvMaterialTxns o = new PesInvMaterialTxns();
        o.setLastUpdatedBy("hz0022");
        o.setLastUpdateDate(new Date());
        o.setCreateBy("hz0022");
        o.setCreateDate(new Date());
        o.setInventoryItemCode("A20070027");
        o.setInventoryItemDescribe("端子配件—端板 D-URTK-ROHS");
        o.setInventoryItemId(100000000500585L);
        o.setMesTransferId("PDI100001TBS");
        o.setOrganizationId(300000004669869L);
        o.setSourceCode("WMS");
        o.setSourceLineId(300000064328547L);
        o.setSubinventoryCode("XBC");
        o.setTransactionDate(new Date());
        o.setTransactionQuantity(new BigDecimal(25));
        o.setTransactionSourceCategory(CommonStatic.INV_SOURCE_TYPE_TRANSFER_IN);
        o.setTransactionSourceCode("WORK_ORDER");
//        o.setTransactionSourceId();
        o.setTransactionSourceName("47796");
        o.setTransactionSourceReferenceId(300000064328530L);
        o.setTransactionSourceType(CommonStatic.INV_SOURCE_CATEGORY_ISSUE);
        o.setTransactionType(CommonStatic.INV_TYPE_IN);
        o.setTransactionUom("PCS");


        Boolean flag =true;
        Map<String,String> er = new HashMap<>();
        er.put("id",o.getMesTransferId()+"");
        er.put("code","401");
        List<Map<String, String>> erra = new ArrayList<>();
        flag = verify(erra,o);
        System.out.println(flag);
        System.out.println(erra.toString());
        System.out.println(JSONUtil.toJsonStr(o));
    }
    /**
     * @Author mingshen.wang
     * @Description 获取需要处理的入库数据
     * @Date 11:09 2021/8/29
     * @Param []
     * @return java.util.List<sinexcel.daysPlan.domain.PesInvMaterialTxns>
     **/
    private List<PesInvMaterialTxns> getPendingList() {

        return pesInvMaterialTxnsMapper.getPendingList();
    }
}
