package sinexcel.quartz.service;

import sinexcel.quartz.domain.SyncWieWoDemandVEO;

import java.util.List;

/**
 * 工单行信息Service接口
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
public interface ISyncWieWoDemandVService {
    /**
     * 查询工单行信息列表
     *
     * @param syncWieWoDemandV 工单行信息
     * @return 工单行信息集合
     */
    public List<SyncWieWoDemandVEO> selectSyncWieWoDemandVList(SyncWieWoDemandVEO syncWieWoDemandV);
}
