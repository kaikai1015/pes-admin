package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.CuxPlaItemBomList;

/**
 * BOM选配平台模型Service接口
 * 
 * @author Zhang Kai
 * @date 2020-12-27
 */
public interface ICuxPlaItemBomListService 
{

    /**
     * 查询BOM选配平台模型列表
     * 
     * @param cuxPlaItemBomList BOM选配平台模型
     * @return BOM选配平台模型集合
     */
    public List<CuxPlaItemBomList> selectCuxPlaItemBomListList(CuxPlaItemBomList cuxPlaItemBomList);

    public CuxPlaItemBomList selectCuxPlaItemBomListListByIds(CuxPlaItemBomList cuxPlaItemBomList);

    List<CuxPlaItemBomList> selectCuxPlaItemBomListListByPla(CuxPlaItemBomList cuxPlaItemBomList);
}
