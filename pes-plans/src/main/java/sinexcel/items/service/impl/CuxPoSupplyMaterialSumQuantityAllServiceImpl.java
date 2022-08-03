package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.mapper.CuxPoSupplyMaterialSumQuantityAllMapper;
import sinexcel.items.domain.CuxPoSupplyMaterialSumQuantityAll;
import sinexcel.items.service.ICuxPoSupplyMaterialSumQuantityAllService;

/**
 * PO入库数据汇总Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2022-05-06
 */
@Service
public class CuxPoSupplyMaterialSumQuantityAllServiceImpl implements ICuxPoSupplyMaterialSumQuantityAllService 
{
    @Autowired
    private CuxPoSupplyMaterialSumQuantityAllMapper cuxPoSupplyMaterialSumQuantityAllMapper;

    /**
     * 查询PO入库数据汇总列表
     * 
     * @param cuxPoSupplyMaterialSumQuantityAll PO入库数据汇总
     * @return PO入库数据汇总
     */
    @Override
    public List<CuxPoSupplyMaterialSumQuantityAll> selectCuxPoSupplyMaterialSumQuantityAllList(CuxPoSupplyMaterialSumQuantityAll cuxPoSupplyMaterialSumQuantityAll)
    {
        return cuxPoSupplyMaterialSumQuantityAllMapper.selectCuxPoSupplyMaterialSumQuantityAllList(cuxPoSupplyMaterialSumQuantityAll);
    }

}
