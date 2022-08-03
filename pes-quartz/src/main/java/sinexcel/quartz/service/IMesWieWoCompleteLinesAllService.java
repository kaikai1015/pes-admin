package sinexcel.quartz.service;

import java.util.List;
import sinexcel.quartz.domain.MesWieWoCompleteLinesAll;

/**
 * 工单单身扣料明细Service接口
 * 
 * @author Zhang Kai
 * @date 2021-08-26
 */
public interface IMesWieWoCompleteLinesAllService 
{
    /**
     * 查询工单单身扣料明细列表
     * 
     * @param mesWieWoCompleteLinesAll 工单单身扣料明细
     * @return 工单单身扣料明细集合
     */
    public List<MesWieWoCompleteLinesAll> selectMesWieWoCompleteLinesAllList(MesWieWoCompleteLinesAll mesWieWoCompleteLinesAll);
}
