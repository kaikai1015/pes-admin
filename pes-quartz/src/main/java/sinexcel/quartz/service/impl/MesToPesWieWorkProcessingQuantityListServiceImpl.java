package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.annotation.DataSource;
import sinexcel.common.enums.DataSourceType;
import sinexcel.quartz.domain.MesToPesWieWorkProcessingQuantityListEO;
import sinexcel.quartz.mapper.MesToPesWieWorkProcessingQuantityListMapper;
import sinexcel.quartz.service.IMesToPesWieWorkProcessingQuantityListService;

import java.util.List;


@Service
public class MesToPesWieWorkProcessingQuantityListServiceImpl implements IMesToPesWieWorkProcessingQuantityListService {

    @Autowired
    private MesToPesWieWorkProcessingQuantityListMapper mesToPesWieWorkProcessingQuantityListMapper;

    @Override
    @DataSource(DataSourceType.SLAVE)
    public List<MesToPesWieWorkProcessingQuantityListEO> selectMesWieWorkProcessingQuantityListList()
    {
        return mesToPesWieWorkProcessingQuantityListMapper.selectMesWieWorkProcessingQuantityListList();
    }

    @Override
    @DataSource(DataSourceType.MASTER)
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void insertMesWieWorkProcessingQuantityList(List<MesToPesWieWorkProcessingQuantityListEO> list)
    {
        mesToPesWieWorkProcessingQuantityListMapper.deleteMesWieWorkProcessingQuantityListTemp();
        int batchCount =115;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                mesToPesWieWorkProcessingQuantityListMapper.insertMesWieWorkProcessingQuantityListTemp(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                mesToPesWieWorkProcessingQuantityListMapper.insertMesWieWorkProcessingQuantityListTemp(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }
}
