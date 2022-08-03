package sinexcel.quartz.service;

import sinexcel.quartz.domain.MesSubinventoryTransferAllEO;

import java.util.List;

public interface IMesSubinventoryTransferAllService {
    /**
     * 查询调拨子库存转移列表
     *
     * @param mesSubinventoryTransferAll 调拨子库存转移
     * @return 调拨子库存转移集合
     */
    public List<MesSubinventoryTransferAllEO> selectMesSubinventoryTransferAllList(MesSubinventoryTransferAllEO mesSubinventoryTransferAll);
}
