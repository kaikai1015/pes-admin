package sinexcel.quartz.service;

import sinexcel.quartz.domain.SyncHzPartiesEO;

import java.util.List;

/**
 * 供应商信息Service接口
 *
 * @author Zhang Kai
 * @date 2020-12-15
 */
public interface ISyncHzPartiesService {
    /**
     * 查询供应商信息列表
     *
     * @param syncHzParties 供应商信息
     * @return 供应商信息集合
     */
    public List<SyncHzPartiesEO> selectSyncHzPartiesList(SyncHzPartiesEO syncHzParties);
}
