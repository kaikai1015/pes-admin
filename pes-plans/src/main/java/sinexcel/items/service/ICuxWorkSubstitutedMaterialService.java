package sinexcel.items.service;

import java.util.List;

import sinexcel.common.core.domain.AjaxResult;
import sinexcel.items.domain.CuxWorkSubstitutedMaterial;

/**
 * 物料替代信息Service接口
 * 
 * @author Zhang Kai
 * @date 2021-05-14
 */
public interface ICuxWorkSubstitutedMaterialService 
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

    public void checkAddAllowed(CuxWorkSubstitutedMaterial cuxWorkSubstitutedMaterial);

    /**
     * 批量删除物料替代信息
     * 
     * @param workSubIds 需要删除的物料替代信息ID
     * @return 结果
     */
    public int deleteCuxWorkSubstitutedMaterialByIds(Long[] workSubIds);

    public String importData(List<CuxWorkSubstitutedMaterial> substitutes, String operName);

    AjaxResult inserBatchtCuxWorkSubstitutedMaterial(List<CuxWorkSubstitutedMaterial> infoList);
}
