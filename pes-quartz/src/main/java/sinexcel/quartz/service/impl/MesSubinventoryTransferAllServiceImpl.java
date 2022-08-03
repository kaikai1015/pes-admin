package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.MesSubinventoryTransferAllEO;
import sinexcel.quartz.mapper.MesSubinventoryTransferAllMapper;
import sinexcel.quartz.service.IMesSubinventoryTransferAllService;

import java.util.List;

/**
 * 调拨子库存转移Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-07-22
 */
@Service
public class MesSubinventoryTransferAllServiceImpl implements IMesSubinventoryTransferAllService {

    @Autowired
    private MesSubinventoryTransferAllMapper mesSubinventoryTransferAllMapper;

    /**
     * 查询调拨子库存转移列表
     *
     * @param mesSubinventoryTransferAll 调拨子库存转移
     * @return 调拨子库存转移
     */
    @Override
    public List<MesSubinventoryTransferAllEO> selectMesSubinventoryTransferAllList(MesSubinventoryTransferAllEO mesSubinventoryTransferAll)
    {
        return mesSubinventoryTransferAllMapper.selectMesSubinventoryTransferAllList(mesSubinventoryTransferAll);
    }
}
