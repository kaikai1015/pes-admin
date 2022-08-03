package sinexcel.lotNums.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.lotNums.mapper.PesOrdersHeaderListMapper;
import sinexcel.lotNums.domain.PesOrdersHeaderList;
import sinexcel.lotNums.service.IPesOrdersHeaderListService;

/**
 * 订单批次计划Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
@Service
public class PesOrdersHeaderListServiceImpl implements IPesOrdersHeaderListService 
{
    @Autowired
    private PesOrdersHeaderListMapper pesOrdersHeaderListMapper;


    /**
     * 查询订单批次计划列表
     * 
     * @param pesOrdersHeaderList 订单批次计划
     * @return 订单批次计划
     */
    @Override
    public List<PesOrdersHeaderList> selectPesOrdersHeaderListList(PesOrdersHeaderList pesOrdersHeaderList)
    {
        return pesOrdersHeaderListMapper.selectPesOrdersHeaderListList(pesOrdersHeaderList);
    }

}
