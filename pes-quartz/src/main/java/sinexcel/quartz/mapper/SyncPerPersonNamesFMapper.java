package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncPerPersonNamesFEO;

import java.util.List;

public interface SyncPerPersonNamesFMapper {
    public int batchSyncPerPersonNamesFEO(List<SyncPerPersonNamesFEO> list);

    public int deleteSyncPerPersonNamesFEO(List<SyncPerPersonNamesFEO> list);

    /**
     * 查询人员姓名列表
     *
     * @param syncPerPersonNamesF 人员姓名
     * @return 人员姓名集合
     */
    public List<SyncPerPersonNamesFEO> selectSyncPerPersonNamesFList(SyncPerPersonNamesFEO syncPerPersonNamesF);
}
