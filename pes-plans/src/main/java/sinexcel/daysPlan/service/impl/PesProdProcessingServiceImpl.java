package sinexcel.daysPlan.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.daysPlan.domain.PesInvMaterialTxns;
import sinexcel.daysPlan.domain.PesProdProcessing;
import sinexcel.daysPlan.mapper.PesProdPlanBeiLiaoAllOrderMapper;
import sinexcel.daysPlan.mapper.PesProdProcessingMapper;
import sinexcel.daysPlan.service.IPesProdPlanBeiLiaoAllService;
import sinexcel.daysPlan.service.IPesProdProcessingService;
import sinexcel.utils.CommonStatic;

/**
 * 发料进度Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-09-08
 */
@Service
public class PesProdProcessingServiceImpl implements IPesProdProcessingService
{
    @Autowired
    private PesProdProcessingMapper pesProdProcessingMapper;
    @Autowired
    private PesProdPlanBeiLiaoAllOrderMapper beiLiaoAllOrderMapper;

    /**
     * 查询发料进度
     * 
     * @param organizationId 发料进度ID
     * @return 发料进度
     */
    @Override
    public PesProdProcessing selectPesProdProcessingById(Long organizationId)
    {
        return pesProdProcessingMapper.selectPesProdProcessingById(organizationId);
    }

    /**
     * 查询发料进度列表
     * 
     * @param pesProdProcessing 发料进度
     * @return 发料进度
     */
    @Override
    public List<PesProdProcessing> selectPesProdProcessingList(PesProdProcessing pesProdProcessing)
    {
        return pesProdProcessingMapper.selectPesProdProcessingList(pesProdProcessing);
    }

    @Override
    public List<PesProdProcessing> selectPesProdProcessingListWw(PesProdProcessing pesProdProcessing)
    {
        return pesProdProcessingMapper.selectPesProdProcessingListWw(pesProdProcessing);
    }

    /**
     * 新增发料进度
     * 
     * @param pesProdProcessing 发料进度
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertPesProdProcessing(PesProdProcessing pesProdProcessing)
    {
        return pesProdProcessingMapper.insertPesProdProcessing(pesProdProcessing);
    }

    /**
     * 修改发料进度
     * 
     * @param pesProdProcessing 发料进度
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updatePesProdProcessing(PesProdProcessing pesProdProcessing)
    {
        return pesProdProcessingMapper.updatePesProdProcessing(pesProdProcessing);
    }

    /**
     * 批量删除发料进度
     * 
     * @param organizationIds 需要删除的发料进度ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deletePesProdProcessingByIds(Long[] organizationIds)
    {
        return pesProdProcessingMapper.deletePesProdProcessingByIds(organizationIds);
    }

    /**
     * 删除发料进度信息
     * 
     * @param organizationId 发料进度ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deletePesProdProcessingById(Long organizationId)
    {
        return pesProdProcessingMapper.deletePesProdProcessingById(organizationId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void insertInit(Long pId,String isWw) {
        beiLiaoAllOrderMapper.deletePesProdPlanBeiLiaoAllByIds(pId);
        pesProdProcessingMapper.insertInit(pId, SecurityUtils.getUsername(),isWw);
        //初始化汇总数值
        pesProdProcessingMapper.updateInit(pId,isWw);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sumByInv(PesInvMaterialTxns pesInvMaterialTxns) {

        if ((StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_WIP_BACKFLUSH
                ,pesInvMaterialTxns.getTransactionSourceCategory())
            ||StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY__OUTSIDE_WIP_BACKFLUSH
                ,pesInvMaterialTxns.getTransactionSourceCategory())
            )&& StringUtils.equals(CommonStatic.INV_TYPE_OUT,pesInvMaterialTxns.getTransactionType())
                && StringUtils.equals("PES",pesInvMaterialTxns.getSourceCode())
        ){
            //扣账 汇总计算
            pesProdProcessingMapper.sumQty(pesInvMaterialTxns.getTransactionQuantity()
                    ,pesInvMaterialTxns.getTransactionSourceType(),pesInvMaterialTxns.getTransactionSourceCategory()
                    ,pesInvMaterialTxns.getSourceLineId(),pesInvMaterialTxns.getSubinventoryCode());
        }else if (isaFaLiao(pesInvMaterialTxns)||isaBack(pesInvMaterialTxns)||isaExceed(pesInvMaterialTxns)){
            //判断是否是委外 并判断仓库是否符合
            List<PesProdProcessing> isInvList = pesProdProcessingMapper.isTrueInv(pesInvMaterialTxns.getSourceLineId());
            if (isInvList.size()>0) {
                if (StringUtils.equals(isInvList.get(0).getIsWwFlag(),"Y")&&
                        !StringUtils.equals(isInvList.get(0).getSubinventoryCode()
                                ,pesInvMaterialTxns.getSubinventoryCode())){
                    return;
                }
                //发料调拨接收 //退料调拨接收  //超领调拨接收
                pesProdProcessingMapper.sumQty(pesInvMaterialTxns.getTransactionQuantity()
                        , pesInvMaterialTxns.getTransactionSourceType(), pesInvMaterialTxns.getTransactionSourceCategory()
                        , pesInvMaterialTxns.getSourceLineId(), pesInvMaterialTxns.getSubinventoryCode());
            }
        }
    }

    private boolean isaBack(PesInvMaterialTxns pesInvMaterialTxns) {
        return (StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_ISSUE_BACK
        ,pesInvMaterialTxns.getTransactionSourceType()) ||
        StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_OUTSIDE_BACK
        ,pesInvMaterialTxns.getTransactionSourceType()))
        && StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_BACK_OUT
        ,pesInvMaterialTxns.getTransactionSourceCategory())
        && StringUtils.equals(CommonStatic.INV_TYPE_OUT,pesInvMaterialTxns.getTransactionType())
//        && StringUtils.equals(CommonStatic.INV_CODE_XBC,pesInvMaterialTxns.getSubinventoryCode())
                ;
    }

    private boolean isaFaLiao(PesInvMaterialTxns pesInvMaterialTxns) {
        return (StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_ISSUE
        ,pesInvMaterialTxns.getTransactionSourceType()) ||
        StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_OUTSIDE
                ,pesInvMaterialTxns.getTransactionSourceType()))
        && StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_TRANSFER_IN
        ,pesInvMaterialTxns.getTransactionSourceCategory())
        && StringUtils.equals(CommonStatic.INV_TYPE_IN,pesInvMaterialTxns.getTransactionType())
//        && StringUtils.equals(CommonStatic.INV_CODE_XBC,pesInvMaterialTxns.getSubinventoryCode())
                ;
    }

    private boolean isaExceed(PesInvMaterialTxns pesInvMaterialTxns) {
        return (StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_ISSUE_EXCEED
        ,pesInvMaterialTxns.getTransactionSourceType()) ||
        StringUtils.equals(CommonStatic.INV_SOURCE_TYPE_OUTSIDE_EXCEED
                ,pesInvMaterialTxns.getTransactionSourceType()))
        && StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_EXCEED_OUT
        ,pesInvMaterialTxns.getTransactionSourceCategory())
//        && StringUtils.equals(CommonStatic.INV_SOURCE_CATEGORY_TRANSFER_IN
//        ,pesInvMaterialTxns.getTransactionSourceCategory())
        && StringUtils.equals(CommonStatic.INV_TYPE_OUT,pesInvMaterialTxns.getTransactionType())
//        && StringUtils.equals(CommonStatic.INV_CODE_XBC,pesInvMaterialTxns.getSubinventoryCode())
                ;
    }
}
