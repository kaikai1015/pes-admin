package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.CuxOtherSupplyMaterialSumQuantityAllEO;

import java.util.List;

public interface CuxOtherSupplyMaterialSumQuantityAllEOMapper {
    void deleteOtherSupplyDemandSyncInvMaterialTxnsEO(List<CuxOtherSupplyMaterialSumQuantityAllEO> cuxOtherSupplyMaterialSumQuantityAllEOS);

    void batchOtherSupplyDemandSyncInvMaterialTxnsEO(List<CuxOtherSupplyMaterialSumQuantityAllEO> cuxOtherSupplyMaterialSumQuantityAllEOS);
}
