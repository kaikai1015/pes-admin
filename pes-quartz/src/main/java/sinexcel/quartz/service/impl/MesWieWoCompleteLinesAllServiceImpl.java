package sinexcel.quartz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.mapper.MesWieWoCompleteLinesAllMapper;
import sinexcel.quartz.domain.MesWieWoCompleteLinesAll;
import sinexcel.quartz.service.IMesWieWoCompleteLinesAllService;

/**
 * 工单单身扣料明细Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-08-26
 */
@Service
public class MesWieWoCompleteLinesAllServiceImpl implements IMesWieWoCompleteLinesAllService 
{
    @Autowired
    private MesWieWoCompleteLinesAllMapper mesWieWoCompleteLinesAllMapper;

    /**
     * 查询工单单身扣料明细列表
     * 
     * @param mesWieWoCompleteLinesAll 工单单身扣料明细
     * @return 工单单身扣料明细
     */
    @Override
    public List<MesWieWoCompleteLinesAll> selectMesWieWoCompleteLinesAllList(MesWieWoCompleteLinesAll mesWieWoCompleteLinesAll)
    {
        return mesWieWoCompleteLinesAllMapper.selectMesWieWoCompleteLinesAllList(mesWieWoCompleteLinesAll);
    }
}
