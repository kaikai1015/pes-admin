package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.CuxOrderDemandMaterialSumQuantityAllEO;

import java.util.List;

public interface CuxOrderDemandMaterialSumQuantityAllEOMapper {
    void deleteOrderDemandSyncInvMaterialTxnsEO(List<CuxOrderDemandMaterialSumQuantityAllEO> cuxOrderDemandMaterialSumQuantityAllEOS);

    void batchOrderDemandSyncInvMaterialTxnsEO(List<CuxOrderDemandMaterialSumQuantityAllEO> cuxOrderDemandMaterialSumQuantityAllEOS);
}
