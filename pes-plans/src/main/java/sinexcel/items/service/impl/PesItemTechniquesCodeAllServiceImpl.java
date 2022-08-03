package sinexcel.items.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.items.mapper.PesItemTechniquesCodeAllMapper;
import sinexcel.items.domain.PesItemTechniquesCodeAll;
import sinexcel.items.service.IPesItemTechniquesCodeAllService;

/**
 * 编码工艺属性Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-06-24
 */
@Service
public class PesItemTechniquesCodeAllServiceImpl implements IPesItemTechniquesCodeAllService
{
    @Autowired
    private PesItemTechniquesCodeAllMapper pesItemTechniquesCodeAllMapper;

    /**
     * 查询编码工艺属性
     *
     * @param techniquesCodeId 编码工艺属性ID
     * @return 编码工艺属性
     */
    @Override
    public PesItemTechniquesCodeAll selectPesItemTechniquesCodeAllById(Long techniquesCodeId)
    {
        return pesItemTechniquesCodeAllMapper.selectPesItemTechniquesCodeAllById(techniquesCodeId);
    }

    /**
     * 查询编码工艺属性列表
     *
     * @param pesItemTechniquesCodeAll 编码工艺属性
     * @return 编码工艺属性
     */
    @Override
    public List<PesItemTechniquesCodeAll> selectPesItemTechniquesCodeAllList(PesItemTechniquesCodeAll pesItemTechniquesCodeAll)
    {
        return pesItemTechniquesCodeAllMapper.selectPesItemTechniquesCodeAllList(pesItemTechniquesCodeAll);
    }

    /**
     * 新增编码工艺属性
     *
     * @param pesItemTechniquesCodeAll 编码工艺属性
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPesItemTechniquesCodeAll(PesItemTechniquesCodeAll pesItemTechniquesCodeAll)
    {
        checkAddAllowed(pesItemTechniquesCodeAll);
        PesItemTechniquesCodeAll itemDescriptionInfor = pesItemTechniquesCodeAllMapper.selectItemDescriptionInfor(pesItemTechniquesCodeAll);
        if (StringUtils.isNotNull(itemDescriptionInfor)){
            pesItemTechniquesCodeAll.setCreateBy(SecurityUtils.getUsername());
            pesItemTechniquesCodeAll.setInventoryItemId(itemDescriptionInfor.getInventoryItemId());
            pesItemTechniquesCodeAll.setItemDescription(itemDescriptionInfor.getItemDescription());
            pesItemTechniquesCodeAll.setItemType(itemDescriptionInfor.getItemType());
        }else {
            throw new CustomException("输入的料号没有找到，请检查后在输入！！！");
        }
        return pesItemTechniquesCodeAllMapper.insertPesItemTechniquesCodeAll(pesItemTechniquesCodeAll);
    }

    public void checkAddAllowed(PesItemTechniquesCodeAll pesItemTechniquesCodeAll)
    {
        if (pesItemTechniquesCodeAllMapper.checkAddAllowed(pesItemTechniquesCodeAll) > 0 ? true : false)
        {
            throw new CustomException("数据已经存在，请核对！！！");
        }
    }

    /**
     * 修改编码工艺属性
     *
     * @param pesItemTechniquesCodeAll 编码工艺属性
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesItemTechniquesCodeAll(PesItemTechniquesCodeAll pesItemTechniquesCodeAll)
    {
        pesItemTechniquesCodeAll.setCreateBy(SecurityUtils.getUsername());
        return pesItemTechniquesCodeAllMapper.updatePesItemTechniquesCodeAll(pesItemTechniquesCodeAll);
    }

    /**
     * 批量删除编码工艺属性
     *
     * @param techniquesCodeIds 需要删除的编码工艺属性ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesItemTechniquesCodeAllByIds(Long[] techniquesCodeIds)
    {
        return pesItemTechniquesCodeAllMapper.deletePesItemTechniquesCodeAllByIds(techniquesCodeIds);
    }

    /**
     * 导入数据
     *
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importData(List<PesItemTechniquesCodeAll> lists, String operName)
    {
        if (StringUtils.isNull(lists) || lists.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<PesItemTechniquesCodeAll> list = new ArrayList<PesItemTechniquesCodeAll>();
        for (PesItemTechniquesCodeAll ls : lists)
        {
            try
            {
                PesItemTechniquesCodeAll orgCodeNameId = pesItemTechniquesCodeAllMapper.selectOrgCodeNameId(ls.getOrganizationCode());
                ls.setOrganizationId(orgCodeNameId.getOrganizationId());
                if (pesItemTechniquesCodeAllMapper.checkAddAllowed(ls) > 0 ? false : true){
                    PesItemTechniquesCodeAll itemDescriptionInfor = pesItemTechniquesCodeAllMapper.selectItemDescriptionInfor(ls);
                    if (StringUtils.isNotNull(itemDescriptionInfor)){
                        ls.setCreateBy(operName);
                        ls.setInventoryItemId(itemDescriptionInfor.getInventoryItemId());
                        ls.setItemDescription(itemDescriptionInfor.getItemDescription());
                        ls.setItemType(itemDescriptionInfor.getItemType());
                        list.add(ls);
                        successNum++;
                    }else {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "物料编码："+ls.getItemNumber()+"不存在，请核对！！！ " );
                    }
                }else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "物料编码："+ls.getItemNumber()+"已经存在，请核对！！！ " );
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、物料编码：" + ls.getItemNumber()+" 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        this.insertPesItemTechniquesCodeAllLists(list);
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

    @Transactional
    public int insertPesItemTechniquesCodeAllLists(List<PesItemTechniquesCodeAll> list)
    {
        int rows = 0;
        if (list.size() > 0) {
            int batchCount =190;//每批处理的条数
            int batchLastIndex = batchCount - 1;// 每批最后一个的下标
            for (int index = 0; index < list.size();) {
                if (batchLastIndex > (list.size() - 1)) {
                    batchLastIndex = list.size() - 1;
                    rows = pesItemTechniquesCodeAllMapper.batchPesItemTechniquesCodeAll(list.subList(index, (batchLastIndex + 1)));
                    break;// 数据插入完毕,退出循环
                }else {
                    rows = pesItemTechniquesCodeAllMapper.batchPesItemTechniquesCodeAll(list.subList(index, (batchLastIndex + 1)));
                    index = batchLastIndex + 1;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
        }
        return rows;
    }
}
