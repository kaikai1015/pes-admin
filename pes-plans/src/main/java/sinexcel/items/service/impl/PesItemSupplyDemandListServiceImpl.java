package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.mapper.PesItemSupplyDemandListMapper;
import sinexcel.items.domain.PesItemSupplyDemandList;
import sinexcel.items.service.IPesItemSupplyDemandListService;

/**
 * 复核项供应和需求Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-12-03
 */
@Service
public class PesItemSupplyDemandListServiceImpl implements IPesItemSupplyDemandListService 
{
    @Autowired
    private PesItemSupplyDemandListMapper pesItemSupplyDemandListMapper;

    /**
     * 查询复核项供应和需求列表
     * 
     * @param pesItemSupplyDemandList 复核项供应和需求
     * @return 复核项供应和需求
     */
    @Override
    public List<PesItemSupplyDemandList> selectPesItemSupplyDemandListList(PesItemSupplyDemandList pesItemSupplyDemandList)
    {
        return pesItemSupplyDemandListMapper.selectPesItemSupplyDemandListList(pesItemSupplyDemandList);
    }

    /**
     * 查询复核项供应和需求明细
     *
     * @param pesItemSupplyDemandList 复核项供应和需求明细ID
     * @return 复核项供应和需求明细
     */
    @Override
    public PesItemSupplyDemandList selectPesItemSupplyDemandListById(PesItemSupplyDemandList pesItemSupplyDemandList)
    {
        return pesItemSupplyDemandListMapper.selectPesItemSupplyDemandListById(pesItemSupplyDemandList);
    }


    @Override
    public List<PesItemSupplyDemandList> selectPesItemSupplyDemandList(PesItemSupplyDemandList pesItemSupplyDemandList)
    {
        return pesItemSupplyDemandListMapper.selectPesItemSupplyDemandList(pesItemSupplyDemandList);
    }

    /**
     * 清空缓存数据
     */
}
