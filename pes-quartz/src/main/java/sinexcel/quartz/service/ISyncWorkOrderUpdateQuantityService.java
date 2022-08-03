package sinexcel.quartz.service;

import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncPesWorkOrderUpdateMaterialQuantityEO;
import sinexcel.quartz.domain.SyncWorkOrderUpdateMaterialQuantityEO;
import sinexcel.quartz.domain.SyncWorkOrderUpdateQuantityEO;

import java.util.List;

@Service
public interface ISyncWorkOrderUpdateQuantityService {
    void batchSyncWorkOrderUpdateQuantityEO(List<SyncWorkOrderUpdateQuantityEO> list);

    void batchSyncWorkOrderUpdateMaterialQuantityEO(List<SyncWorkOrderUpdateMaterialQuantityEO> list);

    void batchSyncPesWorkOrderUpdateMaterialQuantityEO(List<SyncPesWorkOrderUpdateMaterialQuantityEO> list);
}
