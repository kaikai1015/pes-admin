package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.CuxItemBomCho;

/**
 * BOM选配物料结构Service接口
 * 
 * @author Zhang Kai
 * @date 2020-12-27
 */
public interface ICuxItemBomChoService 
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
     * 修改BOM选配物料结构
     * 
     * @param cuxItemBomCho BOM选配物料结构
     * @return 结果
     */
    public int updateCuxItemBomCho(CuxItemBomCho cuxItemBomCho);

    /**
     * 批量删除BOM选配物料结构
     * 
     * @param choIds 需要删除的BOM选配物料结构ID
     * @return 结果
     */
    public int deleteCuxItemBomChoByIds(Long choIds);

    /**
     * 查询BOM选配物料结构列表
     * 
     * @param cuxItemBomCho BOM选配物料结构ID
     * @return 结果
     */
    public int getValue(CuxItemBomCho cuxItemBomCho);

    /**
     * 添加OM选配组件物料
     *
     * @param cuxItemBomCho BOM选配物料结构
     * @return 结果
     */
    public int insertCuxSubItemBomCho(CuxItemBomCho cuxItemBomCho);

    /**
     * 校验组件编码是否唯一
     *
     * @param cuxItemBomCho
     * @return 结果
     */
    public String checkSubItemNumberUnique(CuxItemBomCho cuxItemBomCho);

    /**
     * 提交ERP按钮操作
     *
     * @param cuxItemBomCho 提交ERP按钮操作
     * @return 结果
     */
    public int submitErp(CuxItemBomCho cuxItemBomCho);
}
