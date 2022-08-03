package sinexcel.daysPlan.service;

import sinexcel.daysPlan.domain.MesInvMaterialTxns;

import java.util.List;

/**
 * 库存出入库明细-中间Service接口
 * 
 * @author Zhang Kai
 * @date 2021-08-28
 */
public interface IMesInvMaterialTxnsService 
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
     * 批量删除库存出入库明细-中间
     * 
     * @param ids 需要删除的库存出入库明细-中间ID
     * @return 结果
     */
    public int deleteMesInvMaterialTxnsByIds(Long[] ids);

    /**
     * 删除库存出入库明细-中间信息
     * 
     * @param id 库存出入库明细-中间ID
     * @return 结果
     */
    public int deleteMesInvMaterialTxnsById(Long id);

    /**
     * @Author mingshen.wang
     * @Description 获取未同步的数据
     * @Date 16:01 2021/8/28
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
    void updateState(long[] cfIds, String state);

    /**
     * @Author mingshen.wang
     * @Description 插入同步数据
     * @Date 17:38 2021/8/28
     * @Param [inserIdList]
     * @return void
     **/
    void insertSynData(List<Long> inserIdList);
}
