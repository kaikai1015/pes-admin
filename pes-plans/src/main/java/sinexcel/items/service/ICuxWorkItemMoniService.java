package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.CuxWorkItemMoni;

/**
 * 模拟物料齐套Service接口
 * 
 * @author Zhang Kai
 * @date 2021-04-11
 */
public interface ICuxWorkItemMoniService 
{

    /**
     * 查询模拟物料齐套列表
     * 
     * @param cuxWorkItemMoni 模拟物料齐套
     * @return 模拟物料齐套集合
     */
    public List<CuxWorkItemMoni> selectCuxWorkItemMoniList(CuxWorkItemMoni cuxWorkItemMoni);

    public int deleteCuxWorkItemMoniByIds();

    public int bomMoni(CuxWorkItemMoni cuxWorkItemMoni);

}
