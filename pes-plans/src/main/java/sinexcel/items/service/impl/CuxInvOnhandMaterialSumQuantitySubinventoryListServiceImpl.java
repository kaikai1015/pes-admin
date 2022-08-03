package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.mapper.CuxInvOnhandMaterialSumQuantitySubinventoryListMapper;
import sinexcel.items.domain.CuxInvOnhandMaterialSumQuantitySubinventoryList;
import sinexcel.items.service.ICuxInvOnhandMaterialSumQuantitySubinventoryListService;

/**
 * 库存周波动汇总Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2022-05-28
 */
@Service
public class CuxInvOnhandMaterialSumQuantitySubinventoryListServiceImpl implements ICuxInvOnhandMaterialSumQuantitySubinventoryListService 
{
    @Autowired
    private CuxInvOnhandMaterialSumQuantitySubinventoryListMapper cuxInvOnhandMaterialSumQuantitySubinventoryListMapper;

    /**
     * 查询库存周波动汇总列表
     * 
     * @param cuxInvOnhandMaterialSumQuantitySubinventoryList 库存周波动汇总
     * @return 库存周波动汇总
     */
    @Override
    public List<CuxInvOnhandMaterialSumQuantitySubinventoryList> selectCuxInvOnhandMaterialSumQuantitySubinventoryListList(CuxInvOnhandMaterialSumQuantitySubinventoryList cuxInvOnhandMaterialSumQuantitySubinventoryList)
    {
        return cuxInvOnhandMaterialSumQuantitySubinventoryListMapper.selectCuxInvOnhandMaterialSumQuantitySubinventoryListList(cuxInvOnhandMaterialSumQuantitySubinventoryList);
    }
}
