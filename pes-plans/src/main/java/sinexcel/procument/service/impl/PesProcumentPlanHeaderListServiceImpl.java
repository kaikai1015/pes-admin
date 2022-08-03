package sinexcel.procument.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.procument.mapper.PesProcumentPlanHeaderListMapper;
import sinexcel.procument.domain.PesProcumentPlanHeaderList;
import sinexcel.procument.service.IPesProcumentPlanHeaderListService;

/**
 * 生成采购计划头信息Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-12-09
 */
@Service
public class PesProcumentPlanHeaderListServiceImpl implements IPesProcumentPlanHeaderListService 
{
    @Autowired
    private PesProcumentPlanHeaderListMapper pesProcumentPlanHeaderListMapper;

    /**
     * 查询生成采购计划头信息
     * 
     * @param planLotNum 生成采购计划头信息ID
     * @return 生成采购计划头信息
     */
    @Override
    public PesProcumentPlanHeaderList selectPesProcumentPlanHeaderListById(Long planLotNum)
    {
        return pesProcumentPlanHeaderListMapper.selectPesProcumentPlanHeaderListById(planLotNum);
    }

    /**
     * 查询生成采购计划头信息列表
     * 
     * @param pesProcumentPlanHeaderList 生成采购计划头信息
     * @return 生成采购计划头信息
     */
    @Override
    public List<PesProcumentPlanHeaderList> selectPesProcumentPlanHeaderListList(PesProcumentPlanHeaderList pesProcumentPlanHeaderList)
    {
        return pesProcumentPlanHeaderListMapper.selectPesProcumentPlanHeaderListList(pesProcumentPlanHeaderList);
    }
}
