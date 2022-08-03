package sinexcel.items.mapper;

import java.util.List;
import sinexcel.items.domain.CuxWorkSubstitutedMaterial;

/**
 * 物料替代信息Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-05-14
 */
public interface CuxWorkSubstitutedMaterialMapper 
{

    /**
     * 查询物料替代信息列表
     * 
     * @param cuxWorkSubstitutedMaterial 物料替代信息
     * @return 物料替代信息集合
     */
    public List<CuxWorkSubstitutedMaterial> selectCuxWorkSubstitutedMaterialList(CuxWorkSubstitutedMaterial cuxWorkSubstitutedMaterial);

    /**
     * 新增物料替代信息
     * 
     * @param cuxWorkSubstitutedMaterial 物料替代信息
     * @return 结果
     */
    public int insertCuxWorkSubstitutedMaterial(CuxWorkSubstitutedMaterial cuxWorkSubstitutedMaterial);

    public int checkAddAllowed(CuxWorkSubstitutedMaterial cuxWorkSubstitutedMaterial);

    public CuxWorkSubstitutedMaterial getCuxWorkSubstitutedMaterialIds(CuxWorkSubstitutedMaterial cuxWorkSubstitutedMaterial);

    public CuxWorkSubstitutedMaterial getOrgIds(String organizationCode);

    /**
     * 批量删除物料替代信息
     * 
     * @param workSubIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCuxWorkSubstitutedMaterialByIds(Long[] workSubIds);
}
