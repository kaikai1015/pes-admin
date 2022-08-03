package sinexcel.daysPlan.service;

import sinexcel.daysPlan.domain.MesTransferHeaderAll;
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
public interface MesTransferHeaderAllService {
    /**
     * 查询生产日计划调拨明细单
     *
     * @param id 生产日计划调拨明细单ID
     * @return 生产日计划调拨明细单
     */
    public MesTransferHeaderAll selectMesTransferHeaderAllById(Long id);

    /**
     * 查询生产日计划调拨明细单列表
     *
     * @param mesTransferHeaderAll 生产日计划调拨明细单
     * @return 生产日计划调拨明细单集合
     */
    public List<MesTransferHeaderAll> selectMesTransferHeaderAllList(MesTransferHeaderAll mesTransferHeaderAll);

    /**
     * 新增生产日计划调拨明细单
     *
     * @param mesTransferHeaderAll 生产日计划调拨明细单
     * @return 结果
     */
    public int insertMesTransferHeaderAll(MesTransferHeaderAll mesTransferHeaderAll);

    /**
     * 修改生产日计划调拨明细单
     *
     * @param mesTransferHeaderAll 生产日计划调拨明细单
     * @return 结果
     */
    public int updateMesTransferHeaderAll(MesTransferHeaderAll mesTransferHeaderAll);

    /**
     * 批量删除生产日计划调拨明细单
     *
     * @param ids 需要删除的生产日计划调拨明细单ID
     * @return 结果
     */
    public int deleteMesTransferHeaderAllByIds(Long[] ids);

    /**
     * 删除生产日计划调拨明细单信息
     *
     * @param id 生产日计划调拨明细单ID
     * @return 结果
     */
    public int deleteMesTransferHeaderAllById(Long id);
    /**
     * @Author mingshen.wang
     * @Description //根据行创建 头后行数据
     * @Date 11:24 2021/8/28
     * @Param [lineAlls]
     * @return void
     **/
    List<MesTransferHeaderAll> insertAndLine(List<MesTransferLineAll> lineAlls);

    /**
     * @Author mingshen.wang
     * @Description 批量更新状态
     * @Date 10:36 2021/9/7
     * @Param [ids, state]
     * @return void
     **/
    void updateState(List<Long> ids, String state);
}
