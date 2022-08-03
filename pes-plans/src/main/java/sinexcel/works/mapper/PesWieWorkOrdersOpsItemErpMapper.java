package sinexcel.works.mapper;

import java.util.List;
import sinexcel.works.domain.PesWieWorkOrdersOpsItemErp;

/**
 * 工单外协物料对照Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-12-13
 */
public interface PesWieWorkOrdersOpsItemErpMapper 
{

    /**
     * 查询工单外协物料对照列表
     * 
     * @param pesWorkOrderId 工单外协物料对照
     * @return 工单外协物料对照集合
     */
    public List<PesWieWorkOrdersOpsItemErp> selectPesWieWorkOrdersOpsItemErpList(Long pesWorkOrderId);

    public PesWieWorkOrdersOpsItemErp selectPesWieWorkOrdersOpsItemErpById(Long wieOpsItemId);

    public int updatePesWieWorkOrderOperationErp(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp);

    public int insertPesWieWorkOrdersBErpByWorkOrderId(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp);

    PesWieWorkOrdersOpsItemErp selectPesWieWorkOrdersOpsItemErpByPesWorkOrderId(Long pesWorkOrderId);

    List<PesWieWorkOrdersOpsItemErp> getSelectPesWieWorkOrdersOpsItemErpList(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp);

    int updatePesWieWorkOrdersOpsItemErp(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp);

    int updatePesWieWorkOrdersOpsItemErpById(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp);

    PesWieWorkOrdersOpsItemErp selectGetOspSupplierList(Long supplierId);

    PesWieWorkOrdersOpsItemErp selectGetOspItemDescriptionList(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp);

    int insertPesWieWorkOrdersOpsItemErp(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp);

    PesWieWorkOrdersOpsItemErp selectGetPItemDescriptionList(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp);

    int deletePesWieWorkOrdersOpsItemErpById(Long wieOpsItemId);

    PesWieWorkOrdersOpsItemErp selectWieWorkCenterId(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp);

    PesWieWorkOrdersOpsItemErp selectOrganizationIdByPesWorkOrderIds(Long pesWorkOrderId);

    int selectPesWieWorkByIds(Long pesWorkOrderId);

    List<PesWieWorkOrdersOpsItemErp> selectPesWieWorkOrdersOpsItemErpListExport();
}
