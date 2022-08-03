package sinexcel.works.service;

import java.util.List;
import sinexcel.works.domain.PesWieWoOperationMaterialsErp;
import sinexcel.works.domain.PesWieWoOperationMaterialsPriceErp;

/**
 * pes自定义工单单身数据Service接口
 * 
 * @author Zhang Kai
 * @date 2021-11-26
 */
public interface IPesWieWoOperationMaterialsErpService 
{
    /**
     * 查询pes自定义工单单身数据
     * 
     * @param pesWorkOrderMaterialId pes自定义工单单身数据ID
     * @return pes自定义工单单身数据
     */
    public PesWieWoOperationMaterialsErp selectPesWieWoOperationMaterialsErpById(Long pesWorkOrderMaterialId);

    /**
     * 查询pes自定义工单单身数据列表
     * 
     * @param pesWieWoOperationMaterialsErp pes自定义工单单身数据
     * @return pes自定义工单单身数据集合
     */
    public List<PesWieWoOperationMaterialsErp> selectPesWieWoOperationMaterialsErpList(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    public List<PesWieWoOperationMaterialsErp> selectPesWieWoOperationMaterialsErpListByExport(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    /**
     * 新增pes自定义工单单身数据
     * 
     * @param pesWorkOrderOperationId pes自定义工单单身数据
     * @return 结果
     */
    public int insertPesWieWoOperationMaterialsErp(Long pesWorkOrderOperationId,Integer workCenterCode);

    public int insertPesWieWoOperationMaterialsErpAdd(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    /**
     * 修改pes自定义工单单身数据
     * 
     * @param pesWieWoOperationMaterialsErp pes自定义工单单身数据
     * @return 结果
     */
    public int updatePesWieWoOperationMaterialsErp(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    public int handleSubmitErpPesOperationMaterialByIds(Long pesWorkOrderId,String endName);

    public int handleMaterialUpdateSubmitErp(Long pesWorkOrderId);
    /**
     * 批量删除pes自定义工单单身数据
     *
     * @param pesWorkOrderMaterialIds 需要删除的pes自定义工单单身数据ID
     * @return 结果
     */
    public int deletePesWieWoOperationMaterialsErpByIds(Long workOrderStatusIds,Long pesWorkOrderIds);

    public int updateSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName);

    public int handleSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName);

    public String importData(List<PesWieWoOperationMaterialsErp> materialLists,String operName,Long pesWorkOrderId,Integer workOrderStatusId);

    public List<PesWieWoOperationMaterialsErp> selectPesWiegetSubNewItemList(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    public int addPesWieWoOperationMaterialsErpByIds(Long workSubId,Long pInventoryItemId,Long organizationId,Long pesWorkOrderId,String subItemFlag);

    List<PesWieWoOperationMaterialsErp> selectPesWieWoOperationMaterialsErpListByImport(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    int handleMaterialUpdateSubmitErpId(Long pesWorkOrderIds);

    int handleSubmitErpFcl(Long[] pesWorkOrderMaterialIds,String materialType);

    int handleSubmitErpPesWieWorkOrdersBErpByIdsFCLJob(String materialIssue);

    int handleSubmitErpPesWieWorkOrdersBErpByIdsIssuedJob(String materialIssue);

    int handleSubmitErpPesWieWorkOrdersBErpByIdsDLCJob(String materialIssue);

    List<PesWieWoOperationMaterialsPriceErp> selectPesWieWoOperationMaterialsErpListByPriceImport(PesWieWoOperationMaterialsPriceErp pesWieWoOperationMaterialsErp);
}
