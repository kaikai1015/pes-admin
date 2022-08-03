package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.MesWorkMaterialAllEO;

import java.util.List;

public interface MesWorkMaterialAllMapper {
    /**
     * 工单超耗信息列表
     *
     * @param workMaterialAllEO 工单超耗信息
     * @return 工单超耗集合
     */
    public List<MesWorkMaterialAllEO> getWorkMaterialList(MesWorkMaterialAllEO workMaterialAllEO);

    public int updateErpFlag(MesWorkMaterialAllEO workMaterialAllEO);

    public MesWorkMaterialAllEO selectOrgnazationCode(Long organizationId);
}
