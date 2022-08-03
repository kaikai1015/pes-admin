package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.CuxWieProdLineList;

/**
 * 生产线管理Service接口
 * 
 * @author Zhang Kai
 * @date 2021-05-18
 */
public interface ICuxWieProdLineListService 
{
    /**
     * 查询生产线管理列表
     * 
     * @param cuxWieProdLineList 生产线管理
     * @return 生产线管理集合
     */
    public List<CuxWieProdLineList> selectCuxWieProdLineListList(CuxWieProdLineList cuxWieProdLineList);

    /**
     * 新增生产线管理
     * 
     * @param cuxWieProdLineList 生产线管理
     * @return 结果
     */
    public int insertCuxWieProdLineList(CuxWieProdLineList cuxWieProdLineList);

}
