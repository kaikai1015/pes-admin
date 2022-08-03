package sinexcel.weeks.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.annotation.DataScope;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.StringUtils;
import sinexcel.weeks.mapper.CuxWorkOrdersBCheckWMapper;
import sinexcel.weeks.domain.CuxWorkOrdersBCheckW;
import sinexcel.weeks.service.ICuxWorkOrdersBCheckWService;

/**
 * 周计划导入Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-03-11
 */
@Service
public class CuxWorkOrdersBCheckWServiceImpl implements ICuxWorkOrdersBCheckWService 
{
    private static final Logger log = LoggerFactory.getLogger(CuxWorkOrdersBCheckWServiceImpl.class);

    @Autowired
    private CuxWorkOrdersBCheckWMapper cuxWorkOrdersBCheckWMapper;

    SimpleDateFormat sdf11 = new SimpleDateFormat("yyyyMMddHHmmss");
    /**
     * 查询周计划导入列表
     * 
     * @param cuxWorkOrdersBCheckW 周计划导入
     * @return 周计划导入
     */
    @Override
    @DataScope(userAlias = "u")
    public List<CuxWorkOrdersBCheckW> selectCuxWorkOrdersBCheckWList(CuxWorkOrdersBCheckW cuxWorkOrdersBCheckW)
    {
        return cuxWorkOrdersBCheckWMapper.selectCuxWorkOrdersBCheckWList(cuxWorkOrdersBCheckW);
    }

    /**
     * 导入数据
     *
     * @param weeksLists 数据列表
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importData(List<CuxWorkOrdersBCheckW> weeksLists, String operName)
    {
        Date Num = new Date();
        if (StringUtils.isNull(weeksLists) || weeksLists.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<CuxWorkOrdersBCheckW> list = new ArrayList<CuxWorkOrdersBCheckW>();
        for (CuxWorkOrdersBCheckW weeksList : weeksLists)
        {
            try
            {
                // 验证是否存这条数据
                weeksList.setLotNum(sdf11.format(Num));
                CuxWorkOrdersBCheckW count = cuxWorkOrdersBCheckWMapper.selectCount(weeksList);
                if (StringUtils.isNull(count))
                {
                    weeksList.setCreateBy(operName);
                    list.add(weeksList);
                    successNum++;
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、工单 " + weeksList.getWorkOrderNumber()+"、成品料号 " + weeksList.getItemNumber() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、工单 " + weeksList.getWorkOrderNumber()+"、成品料号 " + weeksList.getItemNumber() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        this.insertCuxWorkOrdersBCheckW(list);
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

    /**
     *
     * @return 结果
     */
    @Transactional
    public int insertCuxWorkOrdersBCheckW(List<CuxWorkOrdersBCheckW> list)
    {
        int rows = 0;
        if (list.size() > 0) {
            int batchCount =130;//每批处理的条数
            int batchLastIndex = batchCount - 1;// 每批最后一个的下标
            for (int index = 0; index < list.size();) {
                if (batchLastIndex > (list.size() - 1)) {
                    batchLastIndex = list.size() - 1;
                    rows = cuxWorkOrdersBCheckWMapper.insertCuxWorkOrdersBCheckW(list.subList(index, (batchLastIndex + 1)));
                    break;// 数据插入完毕,退出循环
                }else {
                    rows = cuxWorkOrdersBCheckWMapper.insertCuxWorkOrdersBCheckW(list.subList(index, (batchLastIndex + 1)));
                    index = batchLastIndex + 1;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
        }
        return rows;
    }
}
