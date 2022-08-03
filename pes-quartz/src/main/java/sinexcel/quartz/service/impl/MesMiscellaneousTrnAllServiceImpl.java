package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.MesMiscellaneousTrnAllEO;
import sinexcel.quartz.mapper.MesMiscellaneousTrnAllMapper;
import sinexcel.quartz.service.IMesMiscellaneousTrnAllService;

import java.util.List;

/**
 * 杂入，杂出Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-07-22
 */
@Service
public class MesMiscellaneousTrnAllServiceImpl implements IMesMiscellaneousTrnAllService {

    @Autowired
    private MesMiscellaneousTrnAllMapper mesMiscellaneousTrnAllMapper;

    /**
     * 查询杂入，杂出列表
     *
     * @param mesMiscellaneousTrnAll 杂入，杂出
     * @return 杂入，杂出
     */
    @Override
    public List<MesMiscellaneousTrnAllEO> selectMesMiscellaneousTrnAllList(MesMiscellaneousTrnAllEO mesMiscellaneousTrnAll)
    {
        return mesMiscellaneousTrnAllMapper.selectMesMiscellaneousTrnAllList(mesMiscellaneousTrnAll);
    }
}
