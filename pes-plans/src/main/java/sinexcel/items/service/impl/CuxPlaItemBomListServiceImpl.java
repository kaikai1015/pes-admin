package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.mapper.CuxPlaItemBomListMapper;
import sinexcel.items.domain.CuxPlaItemBomList;
import sinexcel.items.service.ICuxPlaItemBomListService;

/**
 * BOM选配平台模型Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-12-27
 */
@Service
public class CuxPlaItemBomListServiceImpl implements ICuxPlaItemBomListService 
{
    @Autowired
    private CuxPlaItemBomListMapper cuxPlaItemBomListMapper;

    /**
     * 查询BOM选配平台模型列表
     * 
     * @param cuxPlaItemBomList BOM选配平台模型
     * @return BOM选配平台模型
     */
    @Override
    public List<CuxPlaItemBomList> selectCuxPlaItemBomListList(CuxPlaItemBomList cuxPlaItemBomList)
    {
        return cuxPlaItemBomListMapper.selectCuxPlaItemBomListList(cuxPlaItemBomList);
    }

    @Override
    public CuxPlaItemBomList selectCuxPlaItemBomListListByIds(CuxPlaItemBomList cuxPlaItemBomList)
    {
        return cuxPlaItemBomListMapper.selectCuxPlaItemBomListListByIds(cuxPlaItemBomList);
    }

    @Override
    public List<CuxPlaItemBomList> selectCuxPlaItemBomListListByPla(CuxPlaItemBomList cuxPlaItemBomList)
    {
        return cuxPlaItemBomListMapper.selectCuxPlaItemBomListListByPla(cuxPlaItemBomList);
    }

}
