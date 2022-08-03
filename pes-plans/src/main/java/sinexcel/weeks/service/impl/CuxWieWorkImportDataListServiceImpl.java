package sinexcel.weeks.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.StringUtils;
import sinexcel.weeks.mapper.CuxWieWorkImportDataListMapper;
import sinexcel.weeks.domain.CuxWieWorkImportDataList;
import sinexcel.weeks.service.ICuxWieWorkImportDataListService;

/**
 * 排程欠料导入数据Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-11-05
 */
@Service
public class CuxWieWorkImportDataListServiceImpl implements ICuxWieWorkImportDataListService
{
    @Autowired
    private CuxWieWorkImportDataListMapper cuxWieWorkImportDataListMapper;

    /**
     * 查询排程欠料导入数据列表
     *
     * @param cuxWieWorkImportDataList 排程欠料导入数据
     * @return 排程欠料导入数据
     */
    @Override
    public List<CuxWieWorkImportDataList> selectCuxWieWorkImportDataListList(CuxWieWorkImportDataList cuxWieWorkImportDataList)
    {
        return cuxWieWorkImportDataListMapper.selectCuxWieWorkImportDataListList(cuxWieWorkImportDataList);
    }

    /**
     * 导入数据
     *
     * @param weeksLists 数据列表
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public String importData(List<CuxWieWorkImportDataList> weeksLists, String operName,Long lotNumber)
    {
        if (cuxWieWorkImportDataListMapper.getCuxWieWorkImportDataListById(lotNumber) > 0)
        {
            throw new CustomException("欠料数据已经产生，不允许导入！");
        }
        if (StringUtils.isNull(weeksLists) || weeksLists.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        List<CuxWieWorkImportDataList> list = new ArrayList<CuxWieWorkImportDataList>();
        for (CuxWieWorkImportDataList weeksList : weeksLists)
        {
            weeksList.setLotNumber(lotNumber);
            list.add(weeksList);
        }
        //插入之前删除批次下面的数据，防止第一次导入失败，再次导入产生脏数据
        cuxWieWorkImportDataListMapper.deleteCuxWieWorkImportDataListById(lotNumber);
        //删除临时表
        cuxWieWorkImportDataListMapper.deleteCuxWieWorkImportDataListByIds(lotNumber);
        return insertCuxWieWorkImportDataList(list,operName,lotNumber);
    }

    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public String insertCuxWieWorkImportDataList(List<CuxWieWorkImportDataList> list,String operName,Long lotNumber)
    {
        if (list.size() > 0) {
            int batchCount =348;//每批处理的条数
            int batchLastIndex = batchCount - 1;// 每批最后一个的下标
            for (int index = 0; index < list.size();) {
                if (batchLastIndex > (list.size() - 1)) {
                    batchLastIndex = list.size() - 1;
                    cuxWieWorkImportDataListMapper.addBatchInsertCuxWieWorkImportDataList(list.subList(index, (batchLastIndex + 1)));
                    break;// 数据插入完毕,退出循环
                }else {
                    cuxWieWorkImportDataListMapper.addBatchInsertCuxWieWorkImportDataList(list.subList(index, (batchLastIndex + 1)));
                    index = batchLastIndex + 1;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
        }
        //插入排程导入表里面
        list.get(0).setCreateBy(operName);
        list.get(0).setLotNumber(lotNumber);
        int rows = cuxWieWorkImportDataListMapper.insertCuxWieWorkImportDataList(list.get(0));
        //删除临时表
        cuxWieWorkImportDataListMapper.deleteCuxWieWorkImportDataListByIds(lotNumber);

        StringBuilder successMsg = new StringBuilder();

        if (list.size() == rows)
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + list.size() + " 条");
        }
        else
        {
            successMsg.insert(0, "很抱歉，导入失败！共 " + (list.size() - rows) + " 条数据格式不正确，请检查导入数据无误后重新导入！！！");
        }

        return successMsg.toString();
    }
}
