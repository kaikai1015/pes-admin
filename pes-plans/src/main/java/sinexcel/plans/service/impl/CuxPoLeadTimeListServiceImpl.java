package sinexcel.plans.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.plans.mapper.CuxPoLeadTimeListMapper;
import sinexcel.plans.domain.CuxPoLeadTimeList;
import sinexcel.plans.service.ICuxPoLeadTimeListService;

/**
 * 采购提前期全表Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-11-27
 */
@Service
public class CuxPoLeadTimeListServiceImpl implements ICuxPoLeadTimeListService
{
    @Autowired
    private CuxPoLeadTimeListMapper cuxPoLeadTimeListMapper;


    /**
     * 查询采购提前期全表列表
     *
     * @param cuxPoLeadTimeList 采购提前期全表
     * @return 采购提前期全表
     */
    @Override
    public List<CuxPoLeadTimeList> selectCuxPoLeadTimeListList(CuxPoLeadTimeList cuxPoLeadTimeList)
    {
        return cuxPoLeadTimeListMapper.selectCuxPoLeadTimeListList(cuxPoLeadTimeList);
    }

    /**
     * 项目启动时，初始化提前期数据到缓存
     */
//    @PostConstruct
//    public void init()
//    {
//        CuxPoLeadTimeListUtils.clearCuxPoLeadTimeListCache();
//        List<CuxPoLeadTimeList> allCuxPoLeadTimeLists = cuxPoLeadTimeListMapper.selectCuxPoLeadTimeListAll();
//        for (CuxPoLeadTimeList allCuxPoLeadTimeList : allCuxPoLeadTimeLists)
//        {
//            CuxPoLeadTimeListUtils.setCuxPoLeadTimeListCache(String.valueOf(allCuxPoLeadTimeList.getOrganizationId()+allCuxPoLeadTimeList.getInventoryItemId()), allCuxPoLeadTimeList.getTotalDays());
//        }
//    }

    /**
     * 新增采购提前期全表
     *
     * @param cuxPoLeadTimeList 采购提前期全表
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCuxPoLeadTimeList(CuxPoLeadTimeList cuxPoLeadTimeList)
    {
        CuxPoLeadTimeList itemDescriptions = cuxPoLeadTimeListMapper.getItemDescriptions(cuxPoLeadTimeList);
        if (StringUtils.isNotNull(itemDescriptions)){
            if("MRP".equals(itemDescriptions.getMakeBuyerFlag())){
                List<CuxPoLeadTimeList> isnull = cuxPoLeadTimeListMapper.selectCuxPoLeadTimeListList(cuxPoLeadTimeList);
                if (isnull!=null&&!isnull.isEmpty()){
                    throw new CustomException("输入的料号已经存在，请核对！！！");
                }else{
                    cuxPoLeadTimeList.setInventoryItemId(itemDescriptions.getInventoryItemId());
                    cuxPoLeadTimeList.setItemNumber(itemDescriptions.getItemNumber());
                    cuxPoLeadTimeList.setItemDescription(itemDescriptions.getItemDescription());
                    cuxPoLeadTimeList.setUom(itemDescriptions.getUom());
                    cuxPoLeadTimeList.setProdType(itemDescriptions.getProdType());
                    cuxPoLeadTimeList.setItemType(itemDescriptions.getItemType());
                    cuxPoLeadTimeList.setLastUpdateBy(SecurityUtils.getUsername());
                }
            }else{
                throw new CustomException("输入的料号不是采购件，请核对！！！");
            }
        }else{
            throw new CustomException("没有找到相关料号，请核对！！！");
        }
        return cuxPoLeadTimeListMapper.insertCuxPoLeadTimeList(cuxPoLeadTimeList);
    }

}
