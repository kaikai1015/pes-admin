package sinexcel.daysPlan.mapper;

import org.apache.ibatis.annotations.Param;
import sinexcel.daysPlan.domain.MesInvMaterialTxns;

import java.util.List;

/**
 * 库存出入库明细-中间Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-08-28
 */
public interface MesInvMaterialTxnsMapper 
{
    /**
     * 查询库存出入库明细-中间
     * 
     * @param id 库存出入库明细-中间ID
     * @return 库存出入库明细-中间
     */
    public MesInvMaterialTxns selectMesInvMaterialTxnsById(Long id);

    /**
     * 查询库存出入库明细-中间列表
     * 
     * @param mesInvMaterialTxns 库存出入库明细-中间
     * @return 库存出入库明细-中间集合
     */
    public List<MesInvMaterialTxns> selectMesInvMaterialTxnsList(MesInvMaterialTxns mesInvMaterialTxns);

    /**
     * 新增库存出入库明细-中间
     * 
     * @param mesInvMaterialTxns 库存出入库明细-中间
     * @return 结果
     */
    public int insertMesInvMaterialTxns(MesInvMaterialTxns mesInvMaterialTxns);

    /**
     * 修改库存出入库明细-中间
     * 
     * @param mesInvMaterialTxns 库存出入库明细-中间
     * @return 结果
     */
    public int updateMesInvMaterialTxns(MesInvMaterialTxns mesInvMaterialTxns);

    /**
     * 删除库存出入库明细-中间
     * 
     * @param id 库存出入库明细-中间ID
     * @return 结果
     */
    public int deleteMesInvMaterialTxnsById(Long id);

    /**
     * 批量删除库存出入库明细-中间
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMesInvMaterialTxnsByIds(Long[] ids);

    /**
     * @Author mingshen.wang
     * @Description 获取待同步数据
     * @Date 15:57 2021/8/28
     * @Param []
     * @return java.util.List<sinexcel.daysPlan.domain.MesInvMaterialTxns>
     **/
    List<MesInvMaterialTxns> getSynData();
    /**
     * @Author mingshen.wang
     * @Description 批量更新处理状态
     * @Date 16:12 2021/8/28
     * @Param [cfIds, state]
     * @return void
     **/
    void updateStates(@Param("ids") long[] cfIds, @Param("state") String state);
    /**
     * @Author mingshen.wang
     * @Description 插入同步数据
     * @Date 16:12 2021/8/28
     * @Param [cfIds, state]
     * @return void
     **/
    void insertSynData(@Param("ids") List<Long> inserIdList);
}
