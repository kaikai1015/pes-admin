package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.items.mapper.CuxWieProdLineListMapper;
import sinexcel.items.domain.CuxWieProdLineList;
import sinexcel.items.service.ICuxWieProdLineListService;

/**
 * 生产线管理Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-05-18
 */
@Service
public class CuxWieProdLineListServiceImpl implements ICuxWieProdLineListService 
{
    @Autowired
    private CuxWieProdLineListMapper cuxWieProdLineListMapper;


    /**
     * 查询生产线管理列表
     * 
     * @param cuxWieProdLineList 生产线管理
     * @return 生产线管理
     */
    @Override
    public List<CuxWieProdLineList> selectCuxWieProdLineListList(CuxWieProdLineList cuxWieProdLineList)
    {
        return cuxWieProdLineListMapper.selectCuxWieProdLineListList(cuxWieProdLineList);
    }

    /**
     * 新增生产线管理
     * 
     * @param cuxWieProdLineList 生产线管理
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCuxWieProdLineList(CuxWieProdLineList cuxWieProdLineList)
    {
        return cuxWieProdLineListMapper.insertCuxWieProdLineList(cuxWieProdLineList);
    }
}
