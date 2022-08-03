package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.CuxWieSupplyMaterialSumQuantityAllEO;

import java.util.List;

public interface CuxWieSupplyMaterialSumQuantityAllEOMapper {
    void deleteWieSupplySyncInvMaterialTxnsEO(List<CuxWieSupplyMaterialSumQuantityAllEO> cuxWieSupplyMaterialSumQuantityAllEOS);

    void batchWieSupplySyncInvMaterialTxnsEO(List<CuxWieSupplyMaterialSumQuantityAllEO> cuxWieSupplyMaterialSumQuantityAllEOS);
}
