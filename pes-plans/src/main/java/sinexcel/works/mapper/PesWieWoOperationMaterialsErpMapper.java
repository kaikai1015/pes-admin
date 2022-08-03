package sinexcel.works.mapper;

import java.util.List;
import sinexcel.works.domain.PesWieWoOperationMaterialsErp;

/**
 * pes自定义工单单身数据Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-11-26
 */
public interface PesWieWoOperationMaterialsErpMapper 
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

    /**
     * 新增pes自定义工单单身数据
     * 
     * @param pesWieWoOperationMaterialsErp pes自定义工单单身数据
     * @return 结果
     */

    public int insertPesWieWoOperationMaterialsHeaderErp(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);
    public int insertPesWieWoOperationMaterialsLinesErp(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    /**
     * 修改pes自定义工单单身数据
     * 
     * @param pesWieWoOperationMaterialsErp pes自定义工单单身数据
     * @return 结果
     */
    public int updatePesWieWoOperationMaterialsErp(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    /**
     * 删除pes自定义工单单身数据
     * 
     * @param pesWorkOrderOperationId pes自定义工单单身数据ID
     * @return 结果
     */
    public int deletePesWieWoOperationTempErp(Long pesWorkOrderOperationId);

    /**
     * 批量删除pes自定义工单单身数据
     * 
     * @param pesWorkOrderId 需要删除的数据ID
     * @return 结果
     */
    public List<PesWieWoOperationMaterialsErp> selectSubmitErpPesOperationMaterialByIds(Long pesWorkOrderId);

    public int updatePesWieWorkOrdersBErpByWorkOrderId(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    public int insertPesWieWorkOrdersBErpByWorkOrderId(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    public int insertPesWieWoOperationMaterialsErp(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    public PesWieWoOperationMaterialsErp getPesWieWoOperationMaterialsErpByItemNumber(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    public PesWieWoOperationMaterialsErp getPesWieWoOperationMaterialsErpById(Long pesWorkOrderId);

    public List<PesWieWoOperationMaterialsErp> selectUpdateSubmitErpPesOperationMaterialByIds(Long pesWorkOrderId);

    /**
     * 批量删除pes自定义工单单身数据
     *
     * @param pesWorkOrderMaterialIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePesWieWoOperationMaterialsErpByIds(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    public List<PesWieWoOperationMaterialsErp> updateSubmitErpPesWieWorkOrdersBErpByIdsJob();

    public List<PesWieWoOperationMaterialsErp> handleSubmitErpPesWieWorkOrdersBErpByIdsJob();

    public List<PesWieWoOperationMaterialsErp> getWieOperationMaterialListById(Long pesWorkOrderId);

    public List<PesWieWoOperationMaterialsErp> selectPesWiegetSubNewItemList(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    public PesWieWoOperationMaterialsErp getPesWieWoOperationMaterialsErpByNewItemNumber(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    public int updateSubWieWoOperationMaterialsErp(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    public int updateInsertPesWieWoOperationMaterialsErp(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    PesWieWoOperationMaterialsErp selectPesWieWoOperationMaterialsErpByIds(Long pesWorkOrderIds);

    int updatePesWieWoOperationMaterialsErpByIds(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    List<PesWieWoOperationMaterialsErp> selectNewPesWieWoOperationMaterialsErpList(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    int deleteUpdatePesWieWoOperationMaterialsErpByIds(Long pesWorkOrderMaterialId);

    int updatePesWieWoOperationMaterialsErpByMaterialNum(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    int deleteOthersPesWieWoOperationMaterialsErpByIds(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    PesWieWoOperationMaterialsErp selectPesWiegetSubNewItemListReturn(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    List<PesWieWoOperationMaterialsErp> selectPesWieWoOperationMaterialsErpListByExport(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    PesWieWoOperationMaterialsErp selectPesWieWoOperationSupplierById(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    List<PesWieWoOperationMaterialsErp> selectPesWieWoOperationMaterialsErpListByImport(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    void handleMaterialUpdateSubmitErpId(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    PesWieWoOperationMaterialsErp getWieMaterialSupplySubinvtoryByPesWorkId(Long pesWorkOrderId);

    List<PesWieWoOperationMaterialsErp> handleSubmitErpFcl(Long[] pesWorkOrderMaterialIds);

    PesWieWoOperationMaterialsErp getItemNumberLotControalById(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    int updatePesWieWorkOrdersBErpByPesMaterialId(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);

    List<PesWieWoOperationMaterialsErp> handleSubmitReturnErpFcl(Long[] pesWorkOrderMaterialIds);

    List<PesWieWoOperationMaterialsErp> handleSubmitErpPesWieWorkOrdersBErpByIdsFCLJob();

    List<PesWieWoOperationMaterialsErp> handleSubmitErpPesWieWorkOrdersBErpByIdsIssuedJob();

    int updateDLCWorkMaterils();

    List<PesWieWoOperationMaterialsErp> handleSubmitErpPesWieWorkOrdersBErpByIdsDLCJob();

    int updatePesWieWorkOrdersBErpByPesMaterialIdReturn(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp);
}
