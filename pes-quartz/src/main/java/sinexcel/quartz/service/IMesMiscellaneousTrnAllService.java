package sinexcel.quartz.service;

import sinexcel.quartz.domain.MesMiscellaneousTrnAllEO;

import java.util.List;

public interface IMesMiscellaneousTrnAllService {
    /**
     * 查询杂入，杂出列表
     *
     * @param mesMiscellaneousTrnAll 杂入，杂出
     * @return 杂入，杂出集合
     */
    public List<MesMiscellaneousTrnAllEO> selectMesMiscellaneousTrnAllList(MesMiscellaneousTrnAllEO mesMiscellaneousTrnAll);
}
