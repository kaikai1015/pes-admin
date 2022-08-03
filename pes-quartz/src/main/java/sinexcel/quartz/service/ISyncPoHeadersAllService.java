package sinexcel.quartz.service;

import sinexcel.quartz.domain.SyncPoHeadersAllEO;

import java.util.List;

/**
 * PO头信息Service接口
 *
 * @author Zhang Kai
 * @date 2020-12-21
 */
public interface ISyncPoHeadersAllService {
    /**
     * 查询PO头信息列表
     *
     * @param syncPoHeadersAll PO头信息
     * @return PO头信息集合
     */
    public List<SyncPoHeadersAllEO> selectSyncPoHeadersAllList(SyncPoHeadersAllEO syncPoHeadersAll);
}
