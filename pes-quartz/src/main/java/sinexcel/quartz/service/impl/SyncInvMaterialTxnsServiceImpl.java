package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.quartz.domain.*;
import sinexcel.quartz.mapper.*;
import sinexcel.quartz.service.ISyncInvMaterialTxnsService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 库存事务处理明细Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-31
 */
@Service
public class SyncInvMaterialTxnsServiceImpl implements ISyncInvMaterialTxnsService {
    @Autowired
    private SyncInvMaterialTxnsMapper syncInvMaterialTxnsMapper;

    @Autowired
    private CuxOrderDemandMaterialSumQuantityAllEOMapper cuxOrderDemandMaterialSumQuantityAllMapper;

    @Autowired
    private CuxWieSupplyMaterialSumQuantityAllEOMapper cuxWieSupplyMaterialSumQuantityAllMapper;

    @Autowired
    private CuxWieDemandMaterialSumQuantityAllEOMapper cuxWieDemandMaterialSumQuantityAllMapper;

    @Autowired
    private CuxPoSupplyMaterialSumQuantityAllEOMapper cuxPoSupplyMaterialSumQuantityAllMapper;

    @Autowired
    private CuxOtherSupplyMaterialSumQuantityAllEOMapper cuxOtherSupplyMaterialSumQuantityAllMapper;

    @Autowired
    private invOnhandMaterialSumQuantitySubinventoryListMapper invOnhandMaterialSumQuantitySubinventoryListMapper;

    /**
     * 查询库存事务处理明细列表
     *
     * @param syncInvMaterialTxns 库存事务处理明细
     * @return 库存事务处理明细
     */
    @Override
    public List<SyncInvMaterialTxnsEO> selectSyncInvMaterialTxnsList(SyncInvMaterialTxnsEO syncInvMaterialTxns)
    {
        return syncInvMaterialTxnsMapper.selectSyncInvMaterialTxnsList(syncInvMaterialTxns);
    }

    @Override
    public List<SyncInvMaterialTxnsEO> selectSyncInvMaterialTxnsListErp(SyncInvMaterialTxnsEO syncInvMaterialTxns)
    {
        return syncInvMaterialTxnsMapper.selectSyncInvMaterialTxnsListErp(syncInvMaterialTxns);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchInsertDeleteSyncInvMaterialTxnsEO(List<SyncInvMaterialTxnsEO> list)
    {
        int batchCount =35;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                syncInvMaterialTxnsMapper.deleteSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                syncInvMaterialTxnsMapper.batchSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                syncInvMaterialTxnsMapper.deleteSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                syncInvMaterialTxnsMapper.batchSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

    //周库存计算
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int weekInsertDeleteSyncInvMaterialTxnsEO(List<invOnhandMaterialSumQuantitySubinventoryList> lists)
    {
        //去重复
        List<invOnhandMaterialSumQuantitySubinventoryList> list = lists.stream().distinct().collect(Collectors.toList());

        int batchCount =500;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                invOnhandMaterialSumQuantitySubinventoryListMapper.deleteWeekInsertDeleteSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                invOnhandMaterialSumQuantitySubinventoryListMapper.batchWeekInsertDeleteSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                invOnhandMaterialSumQuantitySubinventoryListMapper.deleteWeekInsertDeleteSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                invOnhandMaterialSumQuantitySubinventoryListMapper.batchWeekInsertDeleteSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
        return invOnhandMaterialSumQuantitySubinventoryListMapper.deleteWeekInsertDeleteSyncInvMaterialTxnsByZerio();
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchInsertDeleteWieSupplySyncInvMaterialTxnsEO(List<CuxWieSupplyMaterialSumQuantityAllEO> list)
    {
        int batchCount =138;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                cuxWieSupplyMaterialSumQuantityAllMapper.deleteWieSupplySyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                cuxWieSupplyMaterialSumQuantityAllMapper.batchWieSupplySyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                cuxWieSupplyMaterialSumQuantityAllMapper.deleteWieSupplySyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                cuxWieSupplyMaterialSumQuantityAllMapper.batchWieSupplySyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchInsertDeleteWieDemandSyncInvMaterialTxnsEO(List<CuxWieDemandMaterialSumQuantityAllEO> list)
    {
        int batchCount =138;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                cuxWieDemandMaterialSumQuantityAllMapper.deleteWieDemandSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                cuxWieDemandMaterialSumQuantityAllMapper.batchWieDemandSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                cuxWieDemandMaterialSumQuantityAllMapper.deleteWieDemandSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                cuxWieDemandMaterialSumQuantityAllMapper.batchWieDemandSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchInsertDeleteOrderDemandSyncInvMaterialTxnsEO(List<CuxOrderDemandMaterialSumQuantityAllEO> list)
    {
        int batchCount =138;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                cuxOrderDemandMaterialSumQuantityAllMapper.deleteOrderDemandSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                cuxOrderDemandMaterialSumQuantityAllMapper.batchOrderDemandSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                cuxOrderDemandMaterialSumQuantityAllMapper.deleteOrderDemandSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                cuxOrderDemandMaterialSumQuantityAllMapper.batchOrderDemandSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchInsertDeletePoSupplySyncInvMaterialTxnsEO(List<CuxPoSupplyMaterialSumQuantityAllEO> list)
    {
        int batchCount =138;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                cuxPoSupplyMaterialSumQuantityAllMapper.deletePoSupplySyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                cuxPoSupplyMaterialSumQuantityAllMapper.batchPoSupplySyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                cuxPoSupplyMaterialSumQuantityAllMapper.deletePoSupplySyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                cuxPoSupplyMaterialSumQuantityAllMapper.batchPoSupplySyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchInsertDeleteOtherSupplySyncInvMaterialTxnsEO(List<CuxOtherSupplyMaterialSumQuantityAllEO> list)
    {
        int batchCount =138;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                cuxOtherSupplyMaterialSumQuantityAllMapper.deleteOtherSupplyDemandSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                cuxOtherSupplyMaterialSumQuantityAllMapper.batchOtherSupplyDemandSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                cuxOtherSupplyMaterialSumQuantityAllMapper.deleteOtherSupplyDemandSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                cuxOtherSupplyMaterialSumQuantityAllMapper.batchOtherSupplyDemandSyncInvMaterialTxnsEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

}
