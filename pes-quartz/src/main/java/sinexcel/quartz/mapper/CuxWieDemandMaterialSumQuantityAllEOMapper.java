package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.CuxWieDemandMaterialSumQuantityAllEO;

import java.util.List;

public interface CuxWieDemandMaterialSumQuantityAllEOMapper {
    void deleteWieDemandSyncInvMaterialTxnsEO(List<CuxWieDemandMaterialSumQuantityAllEO> cuxWieDemandMaterialSumQuantityAllEOS);

    void batchWieDemandSyncInvMaterialTxnsEO(List<CuxWieDemandMaterialSumQuantityAllEO> cuxWieDemandMaterialSumQuantityAllEOS);
}
