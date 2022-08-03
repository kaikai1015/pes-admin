package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.mapper.CuxOtherSupplyMaterialSumQuantityAllMapper;
import sinexcel.items.domain.CuxOtherSupplyMaterialSumQuantityAll;
import sinexcel.items.service.ICuxOtherSupplyMaterialSumQuantityAllService;

/**
 * 其它出入数据汇总Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
@Service
public class CuxOtherSupplyMaterialSumQuantityAllServiceImpl implements ICuxOtherSupplyMaterialSumQuantityAllService 
{
    @Autowired
    private CuxOtherSupplyMaterialSumQuantityAllMapper cuxOtherSupplyMaterialSumQuantityAllMapper;


    /**
     * 查询其它出入数据汇总列表
     * 
     * @param cuxOtherSupplyMaterialSumQuantityAll 其它出入数据汇总
     * @return 其它出入数据汇总
     */
    @Override
    public List<CuxOtherSupplyMaterialSumQuantityAll> selectCuxOtherSupplyMaterialSumQuantityAllList(CuxOtherSupplyMaterialSumQuantityAll cuxOtherSupplyMaterialSumQuantityAll)
    {
        return cuxOtherSupplyMaterialSumQuantityAllMapper.selectCuxOtherSupplyMaterialSumQuantityAllList(cuxOtherSupplyMaterialSumQuantityAll);
    }

}
