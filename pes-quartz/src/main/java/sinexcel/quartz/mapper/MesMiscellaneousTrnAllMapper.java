package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.MesMiscellaneousTrnAllEO;

import java.util.List;

public interface MesMiscellaneousTrnAllMapper {
    /**
     * 杂入，杂出信息列表
     *
     * @param mesMiscellaneousTrnAll 入库信息
     * @return 杂入，杂出集合
     */
    public List<MesMiscellaneousTrnAllEO> getMiscellaneousTrnList(MesMiscellaneousTrnAllEO mesMiscellaneousTrnAll);

    public int updateErpFlag(MesMiscellaneousTrnAllEO mesMiscellaneousTrnAll);

    public MesMiscellaneousTrnAllEO selectTransactionSourceId(Long organizationId);

    public List<MesMiscellaneousTrnAllEO> selectMesMiscellaneousTrnAllList(MesMiscellaneousTrnAllEO mesMiscellaneousTrnAll);
}
