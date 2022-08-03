package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.MesOrganizationTransferAllEO;

import java.util.List;

public interface MesOrganizationTransferAllMapper {
    /**
     * 杂入，杂出信息列表
     *
     * @param mesOrganizationTransferAll 入库信息
     * @return 杂入，杂出集合
     */
    public List<MesOrganizationTransferAllEO> getOrganizationTransferList(MesOrganizationTransferAllEO mesOrganizationTransferAll);

    public int updateErpFlag(MesOrganizationTransferAllEO mesOrganizationTransferAll);

}
