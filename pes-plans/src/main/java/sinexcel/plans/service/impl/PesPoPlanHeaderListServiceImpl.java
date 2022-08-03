package sinexcel.plans.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.plans.mapper.PesPoPlanHeaderListMapper;
import sinexcel.plans.domain.PesPoPlanHeaderList;
import sinexcel.plans.service.IPesPoPlanHeaderListService;
import sinexcel.procument.mapper.PesProcumentPlanHeaderListMapper;
import sinexcel.procument.mapper.PesProcumentPlanLineListMapper;

/**
 * 采购计划头Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-11-25
 */
@Service
public class PesPoPlanHeaderListServiceImpl implements IPesPoPlanHeaderListService 
{
    @Autowired
    private PesPoPlanHeaderListMapper pesPoPlanHeaderListMapper;

    @Autowired
    private PesProcumentPlanHeaderListMapper pesProcumentPlanHeaderListMapper;

    @Autowired
    private PesProcumentPlanLineListMapper pesProcumentPlanLineListMapper;

    /**
     * 查询采购计划头列表
     * 
     * @param pesPoPlanHeaderList 采购计划头
     * @return 采购计划头
     */
    @Override
    public List<PesPoPlanHeaderList> selectPesPoPlanHeaderListList(PesPoPlanHeaderList pesPoPlanHeaderList)
    {
        return pesPoPlanHeaderListMapper.selectPesPoPlanHeaderListList(pesPoPlanHeaderList);
    }

    /**
     * 生成采购计划请购池
     *
     * @param ids 采购计划头
     * @return 结果
     */
    @Override
    @Transactional
    public int prPesPoPlanHeaderList(Integer ids)
    {
        PesPoPlanHeaderList poHeader = pesPoPlanHeaderListMapper.prPesPoPlanHeaderList(ids);
        poHeader.setCreateBy(SecurityUtils.getUsername());
        int ph = pesProcumentPlanHeaderListMapper.insertMrpHeaderList(poHeader);
        int pl = pesProcumentPlanLineListMapper.insertPesProcumentPlanLineList(poHeader);
        return pl;
    }

}
