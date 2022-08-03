package sinexcel.procument.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.procument.mapper.PesProcumentPlanLineListMapper;
import sinexcel.procument.domain.PesProcumentPlanLineList;
import sinexcel.procument.service.IPesProcumentPlanLineListService;

/**
 * 生成采购计划行信息Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-12-09
 */
@Service
public class PesProcumentPlanLineListServiceImpl implements IPesProcumentPlanLineListService 
{
    @Autowired
    private PesProcumentPlanLineListMapper pesProcumentPlanLineListMapper;


    /**
     * 查询生成采购计划行信息列表
     * 
     * @param pesProcumentPlanLineList 生成采购计划行信息
     * @return 生成采购计划行信息
     */
    @Override
    public List<PesProcumentPlanLineList> selectPesProcumentPlanLineListList(PesProcumentPlanLineList pesProcumentPlanLineList)
    {
        return pesProcumentPlanLineListMapper.selectPesProcumentPlanLineListList(pesProcumentPlanLineList);
    }

    @Override
    public List<PesProcumentPlanLineList> selectBuyer(PesProcumentPlanLineList pesProcumentPlanLineList)
    {
        return pesProcumentPlanLineListMapper.selectBuyer(pesProcumentPlanLineList);
    }

}
