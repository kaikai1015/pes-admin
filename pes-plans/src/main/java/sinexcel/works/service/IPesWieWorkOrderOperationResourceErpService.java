package sinexcel.works.service;

import sinexcel.works.domain.PesWieWorkOrderOperationResourceErp;

import java.util.List;

public interface IPesWieWorkOrderOperationResourceErpService {
    int insertResourcePesWieWorkOrderOperationErpByOperationId(Long pesWorkOrderId, Long pesWorkOrderOperationId);

    int handleSubmitErpPesOperationMaterialResourceByIds(Long pesWorkOrderOperationId, String endName);

    int handleSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName);

    int updateSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName);

    List<PesWieWorkOrderOperationResourceErp> selectPesWieWorkOrderOperationResourceErpById(Long pesWorkOrderOperationId);

    PesWieWorkOrderOperationResourceErp selectPesWieWorkOrderOperationResourceErpByIds(Long pesWorkOrderOperationResourceId);

    /**
     * 修改PES工单资源工时
     *
     * @param pesWieWorkOrderOperationResourceErp PES工单资源工时
     * @return 结果
     */
    public int updatePesWieWorkOrderOperationResourceErp(PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp);

    int insertPesWieWorkOrderOperationResourceErp(PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp);
}
