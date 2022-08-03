package sinexcel.lotNums.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.lotNums.mapper.PesPoOrdersHeaderListMapper;
import sinexcel.lotNums.domain.PesPoOrdersHeaderList;
import sinexcel.lotNums.service.IPesPoOrdersHeaderListService;

/**
 * 订单采购计划头Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
@Service
public class PesPoOrdersHeaderListServiceImpl implements IPesPoOrdersHeaderListService 
{
    @Autowired
    private PesPoOrdersHeaderListMapper pesPoOrdersHeaderListMapper;

    /**
     * 查询订单采购计划头列表
     * 
     * @param pesPoOrdersHeaderList 订单采购计划头
     * @return 订单采购计划头
     */
    @Override
    public List<PesPoOrdersHeaderList> selectPesPoOrdersHeaderListList(PesPoOrdersHeaderList pesPoOrdersHeaderList)
    {
        return pesPoOrdersHeaderListMapper.selectPesPoOrdersHeaderListList(pesPoOrdersHeaderList);
    }
}
