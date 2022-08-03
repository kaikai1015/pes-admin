package sinexcel.items.mapper;

import java.util.List;
import sinexcel.items.domain.CuxWorkItemMoni;

/**
 * 模拟物料齐套Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-04-11
 */
public interface CuxWorkItemMoniMapper 
{

    /**
     * 查询模拟物料齐套列表
     * 
     * @param cuxWorkItemMoni 模拟物料齐套
     * @return 模拟物料齐套集合
     */
    public List<CuxWorkItemMoni> selectCuxWorkItemMoniList(CuxWorkItemMoni cuxWorkItemMoni);

    public int deleteCuxWorkItemMoniByIds();

    public List<CuxWorkItemMoni> selectItemTrees(CuxWorkItemMoni cuxWorkItemMoni);

    public int batchCuxWorkItemMoni(List<CuxWorkItemMoni> list);

}
