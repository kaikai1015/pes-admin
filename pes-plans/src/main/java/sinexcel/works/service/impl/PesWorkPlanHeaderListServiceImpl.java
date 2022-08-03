package sinexcel.works.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.works.mapper.PesWorkPlanHeaderListMapper;
import sinexcel.works.domain.PesWorkPlanHeaderList;
import sinexcel.works.service.IPesWorkPlanHeaderListService;

/**
 * 生产计划池Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-04-16
 */
@Service
public class PesWorkPlanHeaderListServiceImpl implements IPesWorkPlanHeaderListService 
{
    @Autowired
    private PesWorkPlanHeaderListMapper pesWorkPlanHeaderListMapper;

    /**
     * 查询生产计划池列表
     * 
     * @param pesWorkPlanHeaderList 生产计划池
     * @return 生产计划池
     */
    @Override
    public List<PesWorkPlanHeaderList> selectPesWorkPlanHeaderListList(PesWorkPlanHeaderList pesWorkPlanHeaderList)
    {
        return pesWorkPlanHeaderListMapper.selectPesWorkPlanHeaderListList(pesWorkPlanHeaderList);
    }

    @Override
    @Transactional
    public int getWorkWieHeader(Long planLotNum)
    {
        PesWorkPlanHeaderList getWorkPlanHeader = pesWorkPlanHeaderListMapper.workPlanHeader(planLotNum);
        getWorkPlanHeader.setCreateBy(SecurityUtils.getUsername());
        //订单生产计划头信息
        pesWorkPlanHeaderListMapper.insertPesWorkPlanHeaderList(getWorkPlanHeader);
        //订单生产计划行信息
        pesWorkPlanHeaderListMapper.insertPesWorkPlanLineList(getWorkPlanHeader);
        //失效
        return pesWorkPlanHeaderListMapper.updateActiveCode(planLotNum);
    }
}
