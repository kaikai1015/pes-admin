package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.items.mapper.CuxWieLeadTimeListMapper;
import sinexcel.items.domain.CuxWieLeadTimeList;
import sinexcel.items.service.ICuxWieLeadTimeListService;

/**
 * 生产提前期Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-11-30
 */
@Service
public class CuxWieLeadTimeListServiceImpl implements ICuxWieLeadTimeListService 
{
    @Autowired
    private CuxWieLeadTimeListMapper cuxWieLeadTimeListMapper;

    /**
     * 查询生产提前期列表
     * 
     * @param cuxWieLeadTimeList 生产提前期
     * @return 生产提前期
     */
    @Override
    public List<CuxWieLeadTimeList> selectCuxWieLeadTimeListList(CuxWieLeadTimeList cuxWieLeadTimeList)
    {
        return cuxWieLeadTimeListMapper.selectCuxWieLeadTimeListList(cuxWieLeadTimeList);
    }

    /**
     * 新增生产提前期
     *
     * @param cuxWieLeadTimeList 生产提前期
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCuxWieLeadTimeList(CuxWieLeadTimeList cuxWieLeadTimeList)
    {
            CuxWieLeadTimeList itemDescriptions = cuxWieLeadTimeListMapper.getItemDescriptions(cuxWieLeadTimeList);
            if (StringUtils.isNotNull(itemDescriptions)){
                if("MPS".equals(itemDescriptions.getMakeBuyerFlag())){
                    List<CuxWieLeadTimeList> isnull = cuxWieLeadTimeListMapper.selectCuxWieLeadTimeListList(cuxWieLeadTimeList);
                    if (isnull!=null&&!isnull.isEmpty()){
                        throw new CustomException("输入的料号已经存在，请核对！！！");
                    }else{
                        cuxWieLeadTimeList.setInventoryItemId(itemDescriptions.getInventoryItemId());
                        cuxWieLeadTimeList.setItemNumber(itemDescriptions.getItemNumber());
                        cuxWieLeadTimeList.setItemDescription(itemDescriptions.getItemDescription());
                        cuxWieLeadTimeList.setUom(itemDescriptions.getUom());
                        cuxWieLeadTimeList.setProdType(itemDescriptions.getProdType());
                        cuxWieLeadTimeList.setItemType(itemDescriptions.getItemType());
                        cuxWieLeadTimeList.setLastUpdateBy(SecurityUtils.getUsername());
                    }
                }else{
                    throw new CustomException("输入的料号不是生产件，请核对！！！");
                }
            }else{
                throw new CustomException("没有找到相关料号，请核对！！！");
            }
        return cuxWieLeadTimeListMapper.insertCuxWieLeadTimeList(cuxWieLeadTimeList);
    }
}
