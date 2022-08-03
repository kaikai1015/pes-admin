package sinexcel.plans.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.plans.mapper.PesWiePlanHeaderListMapper;
import sinexcel.plans.domain.PesWiePlanHeaderList;
import sinexcel.plans.service.IPesWiePlanHeaderListService;

/**
 * 生产计划头Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-11-25
 */
@Service
public class PesWiePlanHeaderListServiceImpl implements IPesWiePlanHeaderListService 
{
    @Autowired
    private PesWiePlanHeaderListMapper pesWiePlanHeaderListMapper;

    /**
     * 查询生产计划头列表
     * 
     * @param pesWiePlanHeaderList 生产计划头
     * @return 生产计划头
     */
    @Override
    public List<PesWiePlanHeaderList> selectPesWiePlanHeaderListList(PesWiePlanHeaderList pesWiePlanHeaderList)
    {
        return pesWiePlanHeaderListMapper.selectPesWiePlanHeaderListList(pesWiePlanHeaderList);
    }
}
