package sinexcel.daysPlan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.daysPlan.domain.PesProdLineDaysLineAllPrice;
import sinexcel.daysPlan.mapper.PesProdLineDaysLineAllMapper;
import sinexcel.daysPlan.domain.PesProdLineDaysLineAll;
import sinexcel.daysPlan.mapper.PesProdLineDaysLineAllPriceMapper;
import sinexcel.daysPlan.service.IPesProdLineDaysLineAllService;
import sinexcel.daysPlan.service.IPesProdProcessingService;
import sinexcel.daysPlan.service.IPesWieWorkProcessingService;

/**
 * 产品线日计划明细Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-06-07
 */
@Service
public class PesProdLineDaysLineAllServiceImpl implements IPesProdLineDaysLineAllService
{
    @Autowired
    private PesProdLineDaysLineAllMapper pesProdLineDaysLineAllMapper;

    @Autowired
    private PesProdLineDaysLineAllPriceMapper pesProdLineDaysLineAllPriceMapper;

    @Autowired
    private IPesWieWorkProcessingService processingService;
    @Autowired
    private IPesProdProcessingService prodProcessingService;

    /**
     * 查询产品线日计划明细
     *
     * @param lineId 产品线日计划明细ID
     * @return 产品线日计划明细
     */
    @Override
    public PesProdLineDaysLineAll selectPesProdLineDaysLineAllById(Long lineId)
    {
        return pesProdLineDaysLineAllMapper.selectPesProdLineDaysLineAllById(lineId);
    }

    /**
     * 查询产品线日计划明细列表
     *
     * @param pesProdLineDaysLineAll 产品线日计划明细
     * @return 产品线日计划明细
     */
    @Override
    public List<PesProdLineDaysLineAll> selectPesProdLineDaysLineAllList(PesProdLineDaysLineAll pesProdLineDaysLineAll)
    {
        return pesProdLineDaysLineAllMapper.selectPesProdLineDaysLineAllList(pesProdLineDaysLineAll);
    }

    /**
     * 新增产品线日计划明细
     *
     * @param pesProdLineDaysLineAll 产品线日计划明细
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPesProdLineDaysLineAll(PesProdLineDaysLineAll pesProdLineDaysLineAll)
    {
        return pesProdLineDaysLineAllMapper.insertPesProdLineDaysLineAll(getPesProdLineDaysLineAll(pesProdLineDaysLineAll));
    }

    /**
     * 修改产品线日计划明细
     *
     * @param pesProdLineDaysLineAll 产品线日计划明细
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesProdLineDaysLineAll(PesProdLineDaysLineAll pesProdLineDaysLineAll)
    {
        pesProdLineDaysLineAll.setCreateBy(SecurityUtils.getUsername());
        return pesProdLineDaysLineAllMapper.updatePesProdLineDaysLineAll(pesProdLineDaysLineAll);
    }

    public PesProdLineDaysLineAll getPesProdLineDaysLineAll(PesProdLineDaysLineAll pesProdLineDaysLineAll)
    {
        pesProdLineDaysLineAll.setCreateBy(SecurityUtils.getUsername());
        if(pesProdLineDaysLineAll.getOrderNumber()!=null&&pesProdLineDaysLineAll.getOrderNumber().length()!=0){
            PesProdLineDaysLineAll orderInfor = pesProdLineDaysLineAllMapper.getOrderInfor(pesProdLineDaysLineAll);
            if(StringUtils.isNotNull(orderInfor)){
                pesProdLineDaysLineAll.setPartyId(orderInfor.getPartyId());
                pesProdLineDaysLineAll.setOrderHeaderId(orderInfor.getOrderHeaderId());
                pesProdLineDaysLineAll.setLineNumberId(orderInfor.getLineNumberId());
                pesProdLineDaysLineAll.setBuId(orderInfor.getBuId());
                pesProdLineDaysLineAll.setCustomerPoNumber(orderInfor.getCustomerPoNumber());
                PesProdLineDaysLineAll worksInfor = pesProdLineDaysLineAllMapper.getWorksInfor(pesProdLineDaysLineAll);
                if(StringUtils.isNotNull(worksInfor)){
                    pesProdLineDaysLineAll.setWorkOrderId(worksInfor.getWorkOrderId());
                    pesProdLineDaysLineAll.setPlanStartQuantity(worksInfor.getPlanStartQuantity());
                    pesProdLineDaysLineAll.setPlannedStartDate(worksInfor.getPlannedStartDate());
                    pesProdLineDaysLineAll.setWorkPlanQuantity(worksInfor.getPlanStartQuantity());
                    pesProdLineDaysLineAll.setCompletedQuantity(worksInfor.getCompletedQuantity());
                    pesProdLineDaysLineAll.setInventoryItemId(worksInfor.getInventoryItemId());
                    pesProdLineDaysLineAll.setOrganizationId(worksInfor.getOrganizationId());
                    pesProdLineDaysLineAll.setItemNumber(worksInfor.getItemNumber());
                    pesProdLineDaysLineAll.setItemDescription(worksInfor.getItemDescription());
                }else {
                    throw new CustomException("输入的工单号有误，未查询到数据，请核对！！！");
                }
            }else {
                throw new CustomException("输入的订单有误，未查询到数据，请核对！！！");
            }
        }else {
            PesProdLineDaysLineAll worksInfor = pesProdLineDaysLineAllMapper.getWorksInfor(pesProdLineDaysLineAll);
            if(StringUtils.isNotNull(worksInfor)){
                pesProdLineDaysLineAll.setWorkOrderId(worksInfor.getWorkOrderId());
                pesProdLineDaysLineAll.setPlanStartQuantity(worksInfor.getPlanStartQuantity());
                pesProdLineDaysLineAll.setPlannedStartDate(worksInfor.getPlannedStartDate());
                pesProdLineDaysLineAll.setWorkPlanQuantity(worksInfor.getPlanStartQuantity());
                pesProdLineDaysLineAll.setCompletedQuantity(worksInfor.getCompletedQuantity());
                pesProdLineDaysLineAll.setOrganizationId(worksInfor.getOrganizationId());
                pesProdLineDaysLineAll.setInventoryItemId(worksInfor.getInventoryItemId());
                pesProdLineDaysLineAll.setItemNumber(worksInfor.getItemNumber());
                pesProdLineDaysLineAll.setItemDescription(worksInfor.getItemDescription());
            }else {
                throw new CustomException("输入的工单号有误，未查询到数据，请核对！！！");
            }
        }

        return pesProdLineDaysLineAll;
    }

    /**
     * 批量删除产品线日计划明细
     *
     * @param lineIds 需要删除的产品线日计划明细ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesProdLineDaysLineAllByIds(Long lineIds)
    {
        return pesProdLineDaysLineAllMapper.deletePesProdLineDaysLineAllByIds(lineIds);
    }

    /**
     * 导入数据
     *
     * @param id 数据列表
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importData(List<PesProdLineDaysLineAll> lists, Long id, String operName,String isWwFlag)
    {
        if (StringUtils.isNull(lists) || lists.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (PesProdLineDaysLineAll ls : lists)
        {
            try
            {
                PesProdLineDaysLineAll orgCode = pesProdLineDaysLineAllMapper.getOrgCode(ls.getOrganizationCode());
                ls.setOrderHeaderId(orgCode.getOrganizationId());
                ls.setOrganizationId(orgCode.getOrganizationId());
                // 验证线别输入是否正确
                PesProdLineDaysLineAll xianbieflag = pesProdLineDaysLineAllMapper.selectXianbieflag(ls.getXianBieFlagName());
                if (StringUtils.isNotNull(xianbieflag))
                {//获取组织ID和物料ID
                    ls.setXianBieFlag(xianbieflag.getXianBieFlag());
                    ls.setCreateBy(operName);
                    ls.setId(id);
                    ls.setIsWwFlag(isWwFlag);
                    insertPesProdLineDaysLineAll(ls);
                    successNum++;
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "导入的线别："+ls.getXianBieFlagName()+"错误，请核对！！！ " );
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、线别：" + ls.getXianBieFlagName()+"、订单号 " + ls.getOrderNumber() + "、工单号 " + ls.getWorkOrderNumber()+" 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条");
        }
        return successMsg.toString();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updatedaysProdLines(Long id)
    {
        //生成生产进度基础数据
//        processingService.insertInit(id,"N");
        //生成发料进度基础数据
//        prodProcessingService.insertInit(id,"N");

        return pesProdLineDaysLineAllMapper.updatedaysProdLines(id);
    }

    @Override
    public List<PesProdLineDaysLineAllPrice> selectPesProdLineDaysLineAllListPrice(PesProdLineDaysLineAllPrice pesProdLineDaysLineAll)
    {
        return pesProdLineDaysLineAllPriceMapper.selectPesProdLineDaysLineAllListPrice(pesProdLineDaysLineAll);
    }

}
