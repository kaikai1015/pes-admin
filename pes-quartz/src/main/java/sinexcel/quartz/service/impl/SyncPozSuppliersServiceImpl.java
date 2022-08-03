package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncPozSuppliersEO;
import sinexcel.quartz.mapper.SyncPozSuppliersMapper;
import sinexcel.quartz.service.ISyncPozSuppliersService;

import java.util.List;

/**
 * 供应商信息Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-15
 */
@Service
public class SyncPozSuppliersServiceImpl implements ISyncPozSuppliersService
{
    @Autowired
    private SyncPozSuppliersMapper syncPozSuppliersMapper;
    /**
     * 查询供应商信息列表
     *
     * @param syncPozSuppliers 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<SyncPozSuppliersEO> selectSyncPozSuppliersList(SyncPozSuppliersEO syncPozSuppliers)
    {
        return syncPozSuppliersMapper.selectSyncPozSuppliersList(syncPozSuppliers);
    }
}
