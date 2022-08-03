package sinexcel.items.service.impl;

import java.util.List;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.DateUtils;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.items.mapper.CuxWorkSubstitutedMaterialMapper;
import sinexcel.items.domain.CuxWorkSubstitutedMaterial;
import sinexcel.items.service.ICuxWorkSubstitutedMaterialService;

/**
 * 物料替代信息Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-05-14
 */
@Service
public class CuxWorkSubstitutedMaterialServiceImpl implements ICuxWorkSubstitutedMaterialService 
{
    @Autowired
    private CuxWorkSubstitutedMaterialMapper cuxWorkSubstitutedMaterialMapper;

    /**
     * 查询物料替代信息列表
     * 
     * @param cuxWorkSubstitutedMaterial 物料替代信息
     * @return 物料替代信息
     */
    @Override
    public List<CuxWorkSubstitutedMaterial> selectCuxWorkSubstitutedMaterialList(CuxWorkSubstitutedMaterial cuxWorkSubstitutedMaterial)
    {
        return cuxWorkSubstitutedMaterialMapper.selectCuxWorkSubstitutedMaterialList(cuxWorkSubstitutedMaterial);
    }

    /**
     * 新增物料替代信息
     * 
     * @param cuxWorkSubstitutedMaterial 物料替代信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCuxWorkSubstitutedMaterial(CuxWorkSubstitutedMaterial cuxWorkSubstitutedMaterial)
    {
        //获取物料ID
        CuxWorkSubstitutedMaterial itemIds = cuxWorkSubstitutedMaterialMapper.getCuxWorkSubstitutedMaterialIds(cuxWorkSubstitutedMaterial);

        cuxWorkSubstitutedMaterial.setpInventoryItemId(itemIds.getpInventoryItemId());
        cuxWorkSubstitutedMaterial.setpItemDescription(itemIds.getpItemDescription());

        cuxWorkSubstitutedMaterial.setInventoryItemId(itemIds.getInventoryItemId());
        cuxWorkSubstitutedMaterial.setItemDescription(itemIds.getItemDescription());

        cuxWorkSubstitutedMaterial.setNewInventoryItemId(itemIds.getNewInventoryItemId());
        cuxWorkSubstitutedMaterial.setNewItemDescription(itemIds.getNewItemDescription());
        cuxWorkSubstitutedMaterial.setUom(itemIds.getUom());

        cuxWorkSubstitutedMaterial.setEffectiveStartDate(DateUtils.getNowDate());
        cuxWorkSubstitutedMaterial.setEffectiveEndDate(DateUtils.getNowDate());

        return cuxWorkSubstitutedMaterialMapper.insertCuxWorkSubstitutedMaterial(cuxWorkSubstitutedMaterial);
    }

    //判断添加的替代关系是否唯一
    @Override
    public void checkAddAllowed(CuxWorkSubstitutedMaterial cuxWorkSubstitutedMaterial)
    {
        if (cuxWorkSubstitutedMaterialMapper.checkAddAllowed(cuxWorkSubstitutedMaterial) > 0 ? true : false)
        {
            throw new CustomException("替代关系具有唯一性，请重新输入！"+cuxWorkSubstitutedMaterial.getpItemNumber());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public AjaxResult inserBatchtCuxWorkSubstitutedMaterial(List<CuxWorkSubstitutedMaterial> infoList)
    {
        if(infoList.size()==0){
            throw new CustomException("数据为空！");
        }
        System.out.println("OA推送："+JSONUtil.toJsonStr(infoList));
        infoList.forEach(o -> {
            if(cuxWorkSubstitutedMaterialMapper.checkAddAllowed(o) == 0 ){
                o.setCreateBy("OA");
                o.setPriorityNum(1);
                insertCuxWorkSubstitutedMaterial(o);
            }
        });
        return AjaxResult.success("插入PES系统成功");
    }

    /**
     * 批量删除物料替代信息
     * 
     * @param workSubIds 需要删除的物料替代信息ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCuxWorkSubstitutedMaterialByIds(Long[] workSubIds)
    {
        return cuxWorkSubstitutedMaterialMapper.deleteCuxWorkSubstitutedMaterialByIds(workSubIds);
    }

    /**
     * 导入数据
     *
     * @param substitutes 数据列表
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importData(List<CuxWorkSubstitutedMaterial> substitutes, String operName)
    {
        if (StringUtils.isNull(substitutes) || substitutes.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CuxWorkSubstitutedMaterial substitute : substitutes)
        {
            try
            {
                CuxWorkSubstitutedMaterial getOrgIds = cuxWorkSubstitutedMaterialMapper.getOrgIds(substitute.getOrganizationCode());
                substitute.setOrganizationId(getOrgIds.getOrganizationId());
                substitute.setCreateBy(operName);
                // 验证是否存这条数据
                int count = cuxWorkSubstitutedMaterialMapper.checkAddAllowed(substitute);
                if (count > 0)
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、主键编码 " + substitute.getpItemNumber()+ "、被替代料编码 " + substitute.getItemNumber()+"、替代料编码 " + substitute.getNewItemNumber() + " 已存在");
                }
                else
                { successNum++;
                this.insertCuxWorkSubstitutedMaterial(substitute);
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、主键编码 " + substitute.getpItemNumber()+ "、被替代料编码 " + substitute.getItemNumber()+"、替代料编码 " + substitute.getNewItemNumber() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条");
        }
        return successMsg.toString();
    }
}
