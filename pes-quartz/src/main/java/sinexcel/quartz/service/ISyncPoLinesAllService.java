package sinexcel.quartz.service;


import sinexcel.quartz.domain.SyncPoLinesAllEO;

import java.util.List;

/**
 * PO行信息Service接口
 *
 * @author Zhang Kai
 * @date 2020-12-21
 */
public interface ISyncPoLinesAllService {

    /**
     * 查询PO行信息列表
     *
     * @param syncPoLinesAll PO行信息
     * @return PO行信息集合
     */
    public List<SyncPoLinesAllEO> selectSyncPoLinesAllList(SyncPoLinesAllEO syncPoLinesAll);
}
