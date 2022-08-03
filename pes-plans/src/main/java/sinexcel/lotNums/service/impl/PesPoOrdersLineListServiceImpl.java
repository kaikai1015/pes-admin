package sinexcel.lotNums.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.lotNums.mapper.PesPoOrdersLineListMapper;
import sinexcel.lotNums.domain.PesPoOrdersLineList;
import sinexcel.lotNums.service.IPesPoOrdersLineListService;

/**
 * 订单采购计划行Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
@Service
public class PesPoOrdersLineListServiceImpl implements IPesPoOrdersLineListService 
{
    @Autowired
    private PesPoOrdersLineListMapper pesPoOrdersLineListMapper;


    /**
     * 查询订单采购计划行列表
     * 
     * @param pesPoOrdersLineList 订单采购计划行
     * @return 订单采购计划行
     */
    @Override
    public List<PesPoOrdersLineList> selectPesPoOrdersLineListList(PesPoOrdersLineList pesPoOrdersLineList)
    {
        return pesPoOrdersLineListMapper.selectPesPoOrdersLineListList(pesPoOrdersLineList);
    }

}
