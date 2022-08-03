package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.invOnhandMaterialSumQuantitySubinventoryList;

import java.util.List;

public interface invOnhandMaterialSumQuantitySubinventoryListMapper {

    void deleteWeekInsertDeleteSyncInvMaterialTxnsEO(List<invOnhandMaterialSumQuantitySubinventoryList> syncInvMaterialTxnsEOS);

    void batchWeekInsertDeleteSyncInvMaterialTxnsEO(List<invOnhandMaterialSumQuantitySubinventoryList> syncInvMaterialTxnsEOS);

    int deleteWeekInsertDeleteSyncInvMaterialTxnsByZerio();
}
