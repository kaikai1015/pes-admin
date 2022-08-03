package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.CuxPoSupplyMaterialSumQuantityAllEO;

import java.util.List;

public interface CuxPoSupplyMaterialSumQuantityAllEOMapper {
    void deletePoSupplySyncInvMaterialTxnsEO(List<CuxPoSupplyMaterialSumQuantityAllEO> cuxPoSupplyMaterialSumQuantityAllEOS);

    void batchPoSupplySyncInvMaterialTxnsEO(List<CuxPoSupplyMaterialSumQuantityAllEO> cuxPoSupplyMaterialSumQuantityAllEOS);
}
