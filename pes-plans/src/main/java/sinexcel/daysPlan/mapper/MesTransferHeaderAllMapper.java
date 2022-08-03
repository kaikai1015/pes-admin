package sinexcel.daysPlan.mapper;

import org.apache.ibatis.annotations.Param;
import sinexcel.daysPlan.domain.MesTransferHeaderAll;

import java.util.List;

/**
 * <p>
 * 生产日计划调拨明细单 Mapper 接口
 * </p>
 *
 * @author mingshen.wang
 * @since 2021-08-27
 */
public interface MesTransferHeaderAllMapper  {
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
     * 删除生产日计划调拨明细单
     *
     * @param id 生产日计划调拨明细单ID
     * @return 结果
     */
    public int deleteMesTransferHeaderAllById(Long id);

    /**
     * 批量删除生产日计划调拨明细单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMesTransferHeaderAllByIds(Long[] ids);

    /**
     * @Author mingshen.wang
     * @Description 批量更新状态
     * @Date 10:41 2021/9/7
     * @Param [ids, state]
     * @return void
     **/
    void updateState(@Param("ids") List<Long> ids,@Param("state") String state);
}
