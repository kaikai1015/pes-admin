package sinexcel.items.service.impl;

import java.util.List;

import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.DateUtils;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.items.mapper.SyncItemsNumDesBuyerListMapper;
import sinexcel.items.domain.SyncItemsNumDesBuyerList;
import sinexcel.items.service.ISyncItemsNumDesBuyerListService;

/**
 * 物料编码和描述快码Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-12-21
 */
@Service
public class SyncItemsNumDesBuyerListServiceImpl implements ISyncItemsNumDesBuyerListService 
{
    @Autowired
    private SyncItemsNumDesBuyerListMapper syncItemsNumDesBuyerListMapper;

    /**
     * 查询物料编码和描述快码
     * 
     * @param organizationId 物料编码和描述快码ID
     * @return 物料编码和描述快码
     */
    @Override
    public SyncItemsNumDesBuyerList selectSyncItemsNumDesBuyerListById(Long organizationId,Long inventoryItemId)
    {
        return syncItemsNumDesBuyerListMapper.selectSyncItemsNumDesBuyerListById(organizationId,inventoryItemId);
    }

    /**
     * 查询物料编码和描述快码列表
     * 
     * @param syncItemsNumDesBuyerList 物料编码和描述快码
     * @return 物料编码和描述快码
     */
    @Override
    public List<SyncItemsNumDesBuyerList> selectSyncItemsNumDesBuyerListList(SyncItemsNumDesBuyerList syncItemsNumDesBuyerList)
    {
        return syncItemsNumDesBuyerListMapper.selectSyncItemsNumDesBuyerListList(syncItemsNumDesBuyerList);
    }


    /**
     * 修改物料编码和描述快码
     * 
     * @param syncItemsNumDesBuyerList 物料编码和描述快码
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int updateSyncItemsNumDesBuyerList(SyncItemsNumDesBuyerList syncItemsNumDesBuyerList)
    {
        syncItemsNumDesBuyerList.setCreationDate(DateUtils.getNowDate());
        syncItemsNumDesBuyerList.setCreateBy(SecurityUtils.getUsername());
        SyncItemsNumDesBuyerList getBuyerName = syncItemsNumDesBuyerListMapper.getBuyerNameByBuyerNumber(syncItemsNumDesBuyerList.getBuyerNumber());
        if(StringUtils.isNotNull(getBuyerName) ){
            if(syncItemsNumDesBuyerList.getBuyerId().longValue() >0){
                syncItemsNumDesBuyerList.setBuyerId(getBuyerName.getBuyerId());
                syncItemsNumDesBuyerList.setBuyerNumber(getBuyerName.getBuyerNumber());
                syncItemsNumDesBuyerList.setBuyerName(getBuyerName.getBuyerName());
                syncItemsNumDesBuyerListMapper.updateSyncItemsNumDesBuyerList(syncItemsNumDesBuyerList);
            }else {
                syncItemsNumDesBuyerList.setBuyerId(getBuyerName.getBuyerId());
                syncItemsNumDesBuyerList.setBuyerNumber(getBuyerName.getBuyerNumber());
                syncItemsNumDesBuyerList.setBuyerName(getBuyerName.getBuyerName());
                syncItemsNumDesBuyerListMapper.insertSyncItemsNumDesBuyerList(syncItemsNumDesBuyerList);
            }

        }else {
            throw new CustomException("找不到采购员信息，请核对输入的工号信息！！！");
    }
        return 1;
    }

}
