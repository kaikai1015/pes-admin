package sinexcel.items.service.impl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.items.mapper.CuxWorkItemMoniMapper;
import sinexcel.items.domain.CuxWorkItemMoni;
import sinexcel.items.service.ICuxWorkItemMoniService;

/**
 * 模拟物料齐套Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-04-11
 */
@Service
public class CuxWorkItemMoniServiceImpl implements ICuxWorkItemMoniService 
{
    @Autowired
    private CuxWorkItemMoniMapper cuxWorkItemMoniMapper;

    /**
     * 查询模拟物料齐套列表
     * 
     * @param cuxWorkItemMoni 模拟物料齐套
     * @return 模拟物料齐套
     */
    @Override
    public List<CuxWorkItemMoni> selectCuxWorkItemMoniList(CuxWorkItemMoni cuxWorkItemMoni)
    {
        return cuxWorkItemMoniMapper.selectCuxWorkItemMoniList(cuxWorkItemMoni);
    }

    /**
     * 批量删除模拟物料齐套
     *
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCuxWorkItemMoniByIds()
    {
        return cuxWorkItemMoniMapper.deleteCuxWorkItemMoniByIds();
    }



    @Override
    @Transactional
    public int bomMoni(CuxWorkItemMoni cuxWorkItemMoni)
    {
        int i = 0;
        cuxWorkItemMoni.setCreateBy(SecurityUtils.getUsername());
        if(StringUtils.isNull(cuxWorkItemMoni.getQuantity())){
            cuxWorkItemMoni.setQuantity(BigDecimal.valueOf(1));
        }
        List<CuxWorkItemMoni> items =cuxWorkItemMoniMapper.selectItemTrees(cuxWorkItemMoni);
        if(items.size() > 0){

            int batchCount =173;//每批处理的条数
            int batchLastIndex = batchCount - 1;// 每批最后一个的下标
            for (int index = 0; index < items.size();) {
                if (batchLastIndex > (items.size() - 1)) {
                    batchLastIndex = items.size() - 1;
                    i = cuxWorkItemMoniMapper.batchCuxWorkItemMoni(items.subList(index, (batchLastIndex + 1)));
                    break;// 数据插入完毕,退出循环
                }else {
                    i = cuxWorkItemMoniMapper.batchCuxWorkItemMoni(items.subList(index, (batchLastIndex + 1)));
                    index = batchLastIndex + 1;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
            CuxWorkItemMoni items1=new CuxWorkItemMoni();
            for(CuxWorkItemMoni item:items){
                if("Y".equals(cuxWorkItemMoni.getIsWieFlag())?true:!(item.getItemType().equals("BCP")||item.getItemType().equals("WWBCP"))){
                    items1.setpItemNumber(item.getItemNumber());
                    items1.setOrganizationId(item.getOrganizationId());
                    items1.setQuantity(item.getQuantity());
                    items1.setLevel(item.getLevel());
                    bomMoni(items1);
                }
            }
        }
        return i;
    }
}
