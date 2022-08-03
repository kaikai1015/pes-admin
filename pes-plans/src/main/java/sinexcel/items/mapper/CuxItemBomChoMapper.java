package sinexcel.items.mapper;

import java.util.List;
import sinexcel.items.domain.CuxItemBomCho;

/**
 * BOM选配物料结构Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-12-27
 */
public interface CuxItemBomChoMapper 
{
    /**
     * 查询BOM选配物料结构
     * 
     * @param choId BOM选配物料结构ID
     * @return BOM选配物料结构
     */
    public CuxItemBomCho selectCuxItemBomChoById(Long choId);

    /**
     * 查询BOM选配物料结构列表
     * 
     * @param cuxItemBomCho BOM选配物料结构
     * @return BOM选配物料结构集合
     */
    public List<CuxItemBomCho> selectCuxItemBomChoList(CuxItemBomCho cuxItemBomCho);

    /**
     * 新增BOM选配物料结构
     * 
     * @param cuxItemBomCho BOM选配物料结构
     * @return 结果
     */
    public int insertCuxItemBomCho(CuxItemBomCho cuxItemBomCho);

    /**
     * 修改BOM选配物料结构
     * 
     * @param cuxItemBomCho BOM选配物料结构
     * @return 结果
     */
    public int updateCuxItemBomCho(CuxItemBomCho cuxItemBomCho);


    /**
     * 批量删除BOM选配物料结构
     * 
     * @param choIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCuxItemBomChoByIds(Long choIds);

    /**
     *展开BOM选配物料结构
     *
     * @param cuxItemBomCho 需要删除的数据ID
     * @return 结果
     */
    public List<CuxItemBomCho> selectItemTrees(CuxItemBomCho cuxItemBomCho);

    public List<CuxItemBomCho> selectIdTrees(Long choId);

    public CuxItemBomCho getSubItemInfor(CuxItemBomCho cuxItemBomCho);

    /**
     * 校验组件编码是否唯一
     *
     * @param cuxItemBomCho
     * @return 结果
     */
    public int checkSubItemNumberUnique(CuxItemBomCho cuxItemBomCho);

    public CuxItemBomCho getHeaderList(CuxItemBomCho cuxItemBomCho);

    public int inertErrorInfor(CuxItemBomCho cuxItemBomCho);

    public int updateErpFlag(CuxItemBomCho cuxItemBomCho);
}
