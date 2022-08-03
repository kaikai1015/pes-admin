package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncInvTransactionTypeTlEO;
import sinexcel.quartz.mapper.SyncInvTransactionTypeTlMapper;
import sinexcel.quartz.service.SyncInvTransactionTypeTlService;

import java.util.List;

@Service
public class SyncInvTransactionTypeTlServiceImpl implements SyncInvTransactionTypeTlService {

    @Autowired
    private SyncInvTransactionTypeTlMapper syncInvTransactionTypeTlMapper;

    @Override
    public List<SyncInvTransactionTypeTlEO> selectSyncInvTransactionTypeTlList(SyncInvTransactionTypeTlEO syncInvTransactionTypeTl)
    {
        return syncInvTransactionTypeTlMapper.selectSyncInvTransactionTypeTlList(syncInvTransactionTypeTl);
    }
}