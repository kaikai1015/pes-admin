package sinexcel.daysPlan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.daysPlan.domain.PesProdPlanBeiLiaoAll;
import sinexcel.daysPlan.domain.PesProdPlanBeiLiaoAllWW;
import sinexcel.daysPlan.domain.PesProdPlanTransferAll;
import sinexcel.daysPlan.mapper.PesProdPlanBeiLiaoAllOrderMapper;
import sinexcel.daysPlan.mapper.PesProdPlanBeiLiaoAllWWMapper;
import sinexcel.daysPlan.service.IPesProdPlanBeiLiaoAllService;
import sinexcel.utils.CommonStatic;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 生产计划备料单Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-06-16
 */
@Service
public class PesProdPlanBeiLiaoAllServiceImpl implements IPesProdPlanBeiLiaoAllService 
{
//    @Autowired
//    private PesProdPlanBeiLiaoAllMapper pesProdPlanBeiLiaoAllMapper;
    @Autowired
    private PesProdPlanBeiLiaoAllOrderMapper pesProdPlanBeiLiaoAllMapper;
    @Autowired
    private PesProdPlanBeiLiaoAllWWMapper pesProdPlanBeiLiaoAllWWMapper;



    /**
     * 查询生产计划备料单列表
     * 
     * @param pesProdPlanBeiLiaoAll 生产计划备料单
     * @return 生产计划备料单
     */
    @Override
    public List<PesProdPlanBeiLiaoAll> selectPesProdPlanBeiLiaoAllList(PesProdPlanBeiLiaoAll pesProdPlanBeiLiaoAll)
    {
        return pesProdPlanBeiLiaoAllMapper.selectPesProdPlanBeiLiaoAllList(pesProdPlanBeiLiaoAll);
    }

    /**
     * 批量删除生产计划备料单
     * 
     * @param id 需要删除的生产计划备料单ID
     * @return 结果
     */
    @Override
    @Transactional
    public synchronized int insertPesProdPlanBeiLiaoAll(Long id)
    {
        PesProdPlanBeiLiaoAll pesProdPlanBeiLiaoAll = new PesProdPlanBeiLiaoAll();
        pesProdPlanBeiLiaoAll.setId(id);
        pesProdPlanBeiLiaoAll.setCreateBy(SecurityUtils.getUsername());
        pesProdPlanBeiLiaoAllMapper.deletePesProdPlanBeiLiaoAllByIds(id);
        pesProdPlanBeiLiaoAllMapper.insertPesProdPlanBeiLiaoAll(pesProdPlanBeiLiaoAll);
        return pesProdPlanBeiLiaoAllMapper.updateResetDataFlag(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTransferStart(PesProdPlanTransferAll pesProdPlanTransferAll) {


        if (pesProdPlanTransferAll.getSourceId() == null){
            throw new CustomException("数据源id不可以为空！");
        }

        if (StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_ISSUE,pesProdPlanTransferAll.getSourceType())){
            PesProdPlanBeiLiaoAll info = new PesProdPlanBeiLiaoAll();
            PesProdPlanBeiLiaoAll oldInfo = new PesProdPlanBeiLiaoAll();
            oldInfo.setBeiLiaoId(pesProdPlanTransferAll.getSourceId());
            List<PesProdPlanBeiLiaoAll> oldInfoList = pesProdPlanBeiLiaoAllMapper.selectPesProdPlanBeiLiaoAllList(oldInfo);
            String chuSubInv = pesProdPlanTransferAll.getDiaoChuSubinventory() ;
            BigDecimal chuQty = pesProdPlanTransferAll.getDiaoChuQuantity();
            if (oldInfoList.size()>0){
                if (!StringUtils.isEmpty(oldInfoList.get(0).getDiaoChuSubinventory())){
                    chuSubInv = chuSubInv+","+oldInfoList.get(0).getDiaoChuSubinventory();
                    chuQty=chuQty.add(oldInfoList.get(0).getDiaoChuQuantity());
                }
            }
            info.setBeiLiaoId(pesProdPlanTransferAll.getSourceId());
            info.setDiaoChuQuantity(chuQty);
            info.setDiaoChuSubinventory(chuSubInv);
            info.setDiaoRuSubinventory(pesProdPlanTransferAll.getDiaoRuSubinventory());
            info.setTurnoverSubinventory(pesProdPlanTransferAll.getTurnoverSubinventory());
            info.setUpdateTime(new Date());
            info.setUpdateBy(pesProdPlanTransferAll.getCreateBy());
            info.setState("1");
            pesProdPlanBeiLiaoAllMapper.updateTransferStart(info);
        }else if (StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_OUTSIDE,pesProdPlanTransferAll.getSourceType())){
            PesProdPlanBeiLiaoAllWW info = new PesProdPlanBeiLiaoAllWW();
            PesProdPlanBeiLiaoAllWW oldInfo = new PesProdPlanBeiLiaoAllWW();
            oldInfo.setBeiLiaoId(pesProdPlanTransferAll.getSourceId());
            List<PesProdPlanBeiLiaoAllWW> oldInfoList = pesProdPlanBeiLiaoAllWWMapper.selectPesProdPlanBeiLiaoAllList(oldInfo);
            String chuSubInv = pesProdPlanTransferAll.getDiaoChuSubinventory() ;
            BigDecimal chuQty = pesProdPlanTransferAll.getDiaoChuQuantity();
            if (oldInfoList.size()>0){
                if (!StringUtils.isEmpty(oldInfoList.get(0).getDiaoChuSubinventory())){
                    chuSubInv = chuSubInv+","+oldInfoList.get(0).getDiaoChuSubinventory();
                    chuQty=chuQty.add(oldInfoList.get(0).getDiaoChuQuantity());
                }
            }
            info.setBeiLiaoId(pesProdPlanTransferAll.getSourceId());
            info.setDiaoChuQuantity(chuQty);
            info.setDiaoChuSubinventory(chuSubInv);
            info.setDiaoRuSubinventory(pesProdPlanTransferAll.getDiaoRuSubinventory());
            info.setTurnoverSubinventory(pesProdPlanTransferAll.getTurnoverSubinventory());
            info.setUpdateTime(new Date());
            info.setUpdateBy(pesProdPlanTransferAll.getCreateBy());
            info.setState("1");
            pesProdPlanBeiLiaoAllWWMapper.updateTransferStart(info);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateReceiveQty(Long id, BigDecimal qty, String type) {
        pesProdPlanBeiLiaoAllMapper.updateReceiveQty(id,qty,type);
    }
}
