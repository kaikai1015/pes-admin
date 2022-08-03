package sinexcel.daysPlan.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.annotation.DataScope;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.daysPlan.domain.PesProdPlanBeiLiaoAll;
import sinexcel.daysPlan.domain.PesProdPlanTransferAll;
import sinexcel.daysPlan.mapper.PesProdPlanBeiLiaoAllWWMapper;
import sinexcel.daysPlan.domain.PesProdPlanBeiLiaoAllWW;
import sinexcel.daysPlan.service.IPesProdPlanBeiLiaoAllWWService;

/**
 * 生产计划备料单Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-06-16
 */
@Service
public class PesProdPlanBeiLiaoAllWWServiceImpl implements IPesProdPlanBeiLiaoAllWWService
{
    @Autowired
    private PesProdPlanBeiLiaoAllWWMapper pesProdPlanBeiLiaoAllMapper;


    /**
     * 查询生产计划备料单列表
     *
     * @param pesProdPlanBeiLiaoAll 生产计划备料单
     * @return 生产计划备料单
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<PesProdPlanBeiLiaoAllWW> selectPesProdPlanBeiLiaoAllList(PesProdPlanBeiLiaoAllWW pesProdPlanBeiLiaoAll)
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
    public int insertPesProdPlanBeiLiaoAll(Long id)
    {
        PesProdPlanBeiLiaoAllWW pesProdPlanBeiLiaoAll = new PesProdPlanBeiLiaoAllWW();
        pesProdPlanBeiLiaoAll.setId(id);
        pesProdPlanBeiLiaoAll.setCreateBy(SecurityUtils.getUsername());
        pesProdPlanBeiLiaoAllMapper.deletePesProdPlanBeiLiaoAllByIds(id);
        pesProdPlanBeiLiaoAllMapper.insertPesProdPlanBeiLiaoAll(pesProdPlanBeiLiaoAll);
        return pesProdPlanBeiLiaoAllMapper.updateResetDataFlag(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTransferStart(PesProdPlanTransferAll pesProdPlanTransferAll) {

        PesProdPlanBeiLiaoAllWW info = new PesProdPlanBeiLiaoAllWW();
        if (pesProdPlanTransferAll.getSourceId() == null){
            throw new CustomException("数据源id不可以为空！");
        }
        PesProdPlanBeiLiaoAllWW oldInfo = new PesProdPlanBeiLiaoAllWW();
        oldInfo.setBeiLiaoId(pesProdPlanTransferAll.getSourceId());
        List<PesProdPlanBeiLiaoAllWW> oldInfoList = pesProdPlanBeiLiaoAllMapper.selectPesProdPlanBeiLiaoAllList(oldInfo);
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
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateReceiveQty(Long id, BigDecimal qty, String type) {
        pesProdPlanBeiLiaoAllMapper.updateReceiveQty(id,qty,type);
    }
}
