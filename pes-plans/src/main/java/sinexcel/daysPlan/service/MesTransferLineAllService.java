package sinexcel.daysPlan.service;

import sinexcel.daysPlan.domain.MesTransferLineAll;

import java.util.List;

/**
 * <p>
 * 生产日计划调拨明细单 服务类
 * </p>
 *
 * @author mingshen.wang
 * @since 2021-08-27
 */
public interface MesTransferLineAllService  {
    /**
     * 查询调拨中间明细单
     *
     * @param id 调拨中间明细单ID
     * @return 调拨中间明细单
     */
    public MesTransferLineAll selectMesTransferLineAllById(Long id);

    /**
     * 查询调拨中间明细单列表
     *
     * @param mesTransferLineAll 调拨中间明细单
     * @return 调拨中间明细单集合
     */
    public List<MesTransferLineAll> selectMesTransferLineAllList(MesTransferLineAll mesTransferLineAll);

    /**
     * 新增调拨中间明细单
     *
     * @param mesTransferLineAll 调拨中间明细单
     * @return 结果
     */
    public int insertMesTransferLineAll(MesTransferLineAll mesTransferLineAll);

    /**
     * 修改调拨中间明细单
     *
     * @param mesTransferLineAll 调拨中间明细单
     * @return 结果
     */
    public int updateMesTransferLineAll(MesTransferLineAll mesTransferLineAll);

    /**
     * 批量删除调拨中间明细单
     *
     * @param ids 需要删除的调拨中间明细单ID
     * @return 结果
     */
    public int deleteMesTransferLineAllByIds(Long[] ids);

    /**
     * 删除调拨中间明细单信息
     *
     * @param id 调拨中间明细单ID
     * @return 结果
     */
    public int deleteMesTransferLineAllById(Long id);

    /**
     * @Author mingshen.wang
     * @Description 判断是否重复 否则插入
     * @Date 14:54 2021/8/28
     * @Param [o]
     * @return void
     **/
    Boolean insertAnddistinct(MesTransferLineAll o);
}
