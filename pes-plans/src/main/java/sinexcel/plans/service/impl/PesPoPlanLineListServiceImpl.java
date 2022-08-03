package sinexcel.plans.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.plans.mapper.PesPoPlanLineListMapper;
import sinexcel.plans.domain.PesPoPlanLineList;
import sinexcel.plans.service.IPesPoPlanLineListService;

/**
 * 采购计划行Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-11-26
 */
@Service
public class PesPoPlanLineListServiceImpl implements IPesPoPlanLineListService
{
    @Autowired
    private PesPoPlanLineListMapper pesPoPlanLineListMapper;

    /**
     * 查询采购计划行列表
     *
     * @param pesPoPlanLineList 采购计划行
     * @return 采购计划行
     */
    @Override
    public List<PesPoPlanLineList> selectPesPoPlanLineListList(PesPoPlanLineList pesPoPlanLineList)
    {
        return pesPoPlanLineListMapper.selectPesPoPlanLineListList(pesPoPlanLineList);
    }

    /**
     * 查询采购计划行
     *
     * @param lineNum 采购计划行ID
     * @return 采购计划行
     */
    @Override
    public PesPoPlanLineList selectPesPoPlanLineListById(Long lineNum)
    {
        return pesPoPlanLineListMapper.selectPesPoPlanLineListById(lineNum);
    }

    /**
     * 修改采购计划行
     *
     * @param pesPoPlanLineList 采购计划行
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesPoPlanLineList(PesPoPlanLineList pesPoPlanLineList)
    {
        return pesPoPlanLineListMapper.updatePesPoPlanLineList(pesPoPlanLineList);
    }

}
