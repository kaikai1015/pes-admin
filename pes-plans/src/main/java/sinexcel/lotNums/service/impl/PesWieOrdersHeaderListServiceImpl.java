package sinexcel.lotNums.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.lotNums.mapper.PesWieOrdersHeaderListMapper;
import sinexcel.lotNums.domain.PesWieOrdersHeaderList;
import sinexcel.lotNums.service.IPesWieOrdersHeaderListService;

/**
 * 订单生产计划头Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
@Service
public class PesWieOrdersHeaderListServiceImpl implements IPesWieOrdersHeaderListService 
{
    @Autowired
    private PesWieOrdersHeaderListMapper pesWieOrdersHeaderListMapper;


    /**
     * 查询订单生产计划头列表
     * 
     * @param pesWieOrdersHeaderList 订单生产计划头
     * @return 订单生产计划头
     */
    @Override
    public List<PesWieOrdersHeaderList> selectPesWieOrdersHeaderListList(PesWieOrdersHeaderList pesWieOrdersHeaderList)
    {
        return pesWieOrdersHeaderListMapper.selectPesWieOrdersHeaderListList(pesWieOrdersHeaderList);
    }

    @Override
    @Transactional
    public int workOrdersHeader(Long planLotNum)
    {
        PesWieOrdersHeaderList getWorkOrdersHeader = pesWieOrdersHeaderListMapper.workOrdersHeader(planLotNum);
        getWorkOrdersHeader.setCreateBy(SecurityUtils.getUsername());
        //订单生产计划头信息
        pesWieOrdersHeaderListMapper.insertPesWorkOrdersHeaderList(getWorkOrdersHeader);
        //订单生产计划行信息
        pesWieOrdersHeaderListMapper.insertPesWorkOrderLineList(getWorkOrdersHeader);
        //失效
        return pesWieOrdersHeaderListMapper.updateActiveCode(planLotNum);
    }

}
