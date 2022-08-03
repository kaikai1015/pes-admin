package sinexcel.works.mapper;

import sinexcel.works.domain.PesWieWorkOrderOperationResourceErp;

import java.util.List;

public interface PesWieWorkOrderOperationResourceErpMapper {

    int insertResourcePesWieWorkOrderOperationErpByOperationId(PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp);

    PesWieWorkOrderOperationResourceErp selectPesWieWorkOrderOperationResourceErpById(Long pesWorkOrderId);

    List<PesWieWorkOrderOperationResourceErp> handleSubmitErpPesOperationMaterialResourceByIds(Long pesWorkOrderOperationId);

    int updatePesWieWorkOrdersResourceErpByWorkOrderId(PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp);

    int insertPesWieWorkOrdersResourceErpByWorkOrderId(PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp);

    List<PesWieWorkOrderOperationResourceErp> handleSubmitErpPesWieWorkOrdersBErpByIdsJob();

    List<PesWieWorkOrderOperationResourceErp> updateSubmitErpPesWieWorkOrdersBErpByIdsJob();

    PesWieWorkOrderOperationResourceErp selectPesWieWorkOrderOperationResourceErpByIds(Long pesWorkOrderOperationResourceId);

    int updatePesWieWorkOrderOperationResourceErp(PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp);

    PesWieWorkOrderOperationResourceErp selectPesWieWorkOrderStatusIdByIds(Long pesWorkOrderId);

    PesWieWorkOrderOperationResourceErp selectResourcePesWieWorkOrderOperationErpByOperationId(Long pesWorkOrderOperationId);

    List<PesWieWorkOrderOperationResourceErp> getHandleSubmitErpPesOperationMaterialResourceByIds(Long pesWorkOrderOperationId);
}
