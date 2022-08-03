package sinexcel.works.mapper;

import java.util.List;
import sinexcel.works.domain.PesWieWorkMaterialsLines;

/**
 * 工单替代料数据Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-08-03
 */
public interface PesWieWorkMaterialsLinesMapper 
{
    /**
     * 查询工单替代料数据
     * 
     * @param woOperationMaterialId 工单替代料数据ID
     * @return 工单替代料数据
     */
    public PesWieWorkMaterialsLines selectPesWieWorkMaterialsLinesById(Long woOperationMaterialId);

    /**
     * 查询工单替代料数据列表
     * 
     * @param pesWieWorkMaterialsLines 工单替代料数据
     * @return 工单替代料数据集合
     */
    public List<PesWieWorkMaterialsLines> selectPesWieWorkMaterialsLinesList(PesWieWorkMaterialsLines pesWieWorkMaterialsLines);

    /**
     * 新增工单替代料数据
     * 
     * @param pesWieWorkMaterialsLines 工单替代料数据
     * @return 结果
     */
    public int insertPesWieWorkMaterialsLines(PesWieWorkMaterialsLines pesWieWorkMaterialsLines);

    /**
     * 修改工单替代料数据
     * 
     * @param pesWieWorkMaterialsLines 工单替代料数据
     * @return 结果
     */
    public int updatePesWieWorkMaterialsLines(PesWieWorkMaterialsLines pesWieWorkMaterialsLines);

    public int checkUpdateAllowed(Long woOperationMaterialIds);

    /**
     * 批量删除工单替代料数据
     * 
     * @param woOperationMaterialIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePesWieWorkMaterialsLinesByIds(Long[] woOperationMaterialIds);

    public List<PesWieWorkMaterialsLines> submiPesWieMaterialAll(Long[] woOperationMaterialIds);

    public int updateErpFlag(Long woOperationMaterialIds);

    public int addWorkLinresErp(PesWieWorkMaterialsLines pesWieWorkMaterialsLines);
}
