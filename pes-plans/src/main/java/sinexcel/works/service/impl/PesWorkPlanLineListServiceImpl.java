package sinexcel.works.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.works.mapper.PesWorkPlanLineListMapper;
import sinexcel.works.domain.PesWorkPlanLineList;
import sinexcel.works.service.IPesWorkPlanLineListService;

/**
 * 生产计划池行信息Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-04-16
 */
@Service
public class PesWorkPlanLineListServiceImpl implements IPesWorkPlanLineListService 
{
    @Autowired
    private PesWorkPlanLineListMapper pesWorkPlanLineListMapper;

    /**
     * 查询生产计划池行信息列表
     * 
     * @param pesWorkPlanLineList 生产计划池行信息
     * @return 生产计划池行信息
     */
    @Override
    public List<PesWorkPlanLineList> selectPesWorkPlanLineListList(PesWorkPlanLineList pesWorkPlanLineList)
    {
        return pesWorkPlanLineListMapper.selectPesWorkPlanLineListList(pesWorkPlanLineList);
    }

    /**
     * 生产计划池行信息
     * 
     * @param lineNums 需要删除的生产计划池行信息ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int wieWorkPlanLineListByIds(Long[] lineNums)
    {
        return pesWorkPlanLineListMapper.wieWorkPlanLineListByIds(lineNums, SecurityUtils.getUsername());
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deleteWorksLines(Long[] lineNums)
    {
        return pesWorkPlanLineListMapper.deleteWorksLines(lineNums,SecurityUtils.getUsername());
    }
}
