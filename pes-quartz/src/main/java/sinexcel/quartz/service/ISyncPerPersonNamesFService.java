package sinexcel.quartz.service;


import sinexcel.quartz.domain.SyncPerPersonNamesFEO;

import java.util.List;

/**
 * 人员姓名Service接口
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
public interface ISyncPerPersonNamesFService {

    /**
     * 查询人员姓名列表
     *
     * @param syncPerPersonNamesF 人员姓名
     * @return 人员姓名集合
     */
    public List<SyncPerPersonNamesFEO> selectSyncPerPersonNamesFList(SyncPerPersonNamesFEO syncPerPersonNamesF);
}
