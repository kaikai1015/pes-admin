package sinexcel.meswms.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.constant.UserConstants;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.StringUtils;
import sinexcel.meswms.mapper.MesInvSubinventoryAllMapper;
import sinexcel.meswms.domain.MesInvSubinventoryAll;
import sinexcel.meswms.service.IMesInvSubinventoryAllService;

/**
 * mes工单单身指定仓库Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-03-10
 */
@Service
public class MesInvSubinventoryAllServiceImpl implements IMesInvSubinventoryAllService 
{
    @Autowired
    private MesInvSubinventoryAllMapper mesInvSubinventoryAllMapper;

    /**
     * 查询mes工单单身指定仓库
     * 
     * @param id mes工单单身指定仓库ID
     * @return mes工单单身指定仓库
     */
    @Override
    public MesInvSubinventoryAll selectMesInvSubinventoryAllById(Long id)
    {
        return mesInvSubinventoryAllMapper.selectMesInvSubinventoryAllById(id);
    }

    /**
     * 查询mes工单单身指定仓库列表
     * 
     * @param mesInvSubinventoryAll mes工单单身指定仓库
     * @return mes工单单身指定仓库
     */
    @Override
    public List<MesInvSubinventoryAll> selectMesInvSubinventoryAllList(MesInvSubinventoryAll mesInvSubinventoryAll)
    {
        return mesInvSubinventoryAllMapper.selectMesInvSubinventoryAllList(mesInvSubinventoryAll);
    }

    /**
     * 新增mes工单单身指定仓库
     * 
     * @param mesInvSubinventoryAll mes工单单身指定仓库
     * @return 结果
     */
    @Override
    @Transactional
    public int insertMesInvSubinventoryAll(MesInvSubinventoryAll mesInvSubinventoryAll)
    {
        MesInvSubinventoryAll getItemNumberId = mesInvSubinventoryAllMapper.getItemNumberId(mesInvSubinventoryAll);
        mesInvSubinventoryAll.setInventoryItemId(getItemNumberId.getInventoryItemId());
        return mesInvSubinventoryAllMapper.insertMesInvSubinventoryAll(mesInvSubinventoryAll);
    }

    /**
     * 修改mes工单单身指定仓库
     * 
     * @param mesInvSubinventoryAll mes工单单身指定仓库
     * @return 结果
     */
    @Override
    @Transactional
    public int updateMesInvSubinventoryAll(MesInvSubinventoryAll mesInvSubinventoryAll)
    {
        return mesInvSubinventoryAllMapper.updateMesInvSubinventoryAll(mesInvSubinventoryAll);
    }

    /**
     * 校验物料编码是否唯一
     *
     * @param mesInvSubinventoryAll
     * @return 结果
     */
    @Override
    public String checkUnique(MesInvSubinventoryAll mesInvSubinventoryAll)
    {
        int count = mesInvSubinventoryAllMapper.checkUnique(mesInvSubinventoryAll);
        if (count > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 导入数据
     *
     * @param mesInvSubinventoryAllLists 数据列表
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importData(List<MesInvSubinventoryAll> mesInvSubinventoryAllLists, String operName)
    {
        if (StringUtils.isNull(mesInvSubinventoryAllLists) || mesInvSubinventoryAllLists.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        int count = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (MesInvSubinventoryAll mesInvSubinventoryAllList : mesInvSubinventoryAllLists)
        {
            try
            {
                // 验证是否存这条数据
                count = mesInvSubinventoryAllMapper.checkUnique(mesInvSubinventoryAllList);
                if (count==0)
                {
                    mesInvSubinventoryAllList.setCreateBy(operName);
                    successNum++;
                    this.insertMesInvSubinventoryAll(mesInvSubinventoryAllList);
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、料号 " + mesInvSubinventoryAllList.getItemNumber()+"、MES指定仓 " + mesInvSubinventoryAllList.getSubinventoryCode() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、料号 " + mesInvSubinventoryAllList.getItemNumber()+"、MES指定仓 " + mesInvSubinventoryAllList.getSubinventoryCode() + " 导入失败：";
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
