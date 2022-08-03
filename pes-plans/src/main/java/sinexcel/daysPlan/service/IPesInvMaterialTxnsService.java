package sinexcel.daysPlan.service;

import sinexcel.common.core.domain.AjaxResult;
import sinexcel.daysPlan.domain.PesInvMaterialTxns;

import java.util.Date;
import java.util.List;

/**
 * 库存事务处理明细Service接口
 * 
 * @author Zhang Kai
 * @date 2021-08-28
 */
public interface IPesInvMaterialTxnsService 
{
    /**
     * 查询库存事务处理明细
     * 
     * @param id 库存事务处理明细ID
     * @return 库存事务处理明细
     */
    public PesInvMaterialTxns selectPesInvMaterialTxnsById(Long id);

    /**
     * 查询库存事务处理明细列表
     * 
     * @param pesInvMaterialTxns 库存事务处理明细
     * @return 库存事务处理明细集合
     */
    public List<PesInvMaterialTxns> selectPesInvMaterialTxnsList(PesInvMaterialTxns pesInvMaterialTxns);

    /**
     * 新增库存事务处理明细
     * 
     * @param pesInvMaterialTxns 库存事务处理明细
     * @return 结果
     */
    public int insertPesInvMaterialTxns(PesInvMaterialTxns pesInvMaterialTxns);

    /**
     * 修改库存事务处理明细
     * 
     * @param pesInvMaterialTxns 库存事务处理明细
     * @return 结果
     */
    public int updatePesInvMaterialTxns(PesInvMaterialTxns pesInvMaterialTxns);

    /**
     * 批量删除库存事务处理明细
     * 
     * @param ids 需要删除的库存事务处理明细ID
     * @return 结果
     */
    public int deletePesInvMaterialTxnsByIds(Long[] ids);

    /**
     * 删除库存事务处理明细信息
     * 
     * @param id 库存事务处理明细ID
     * @return 结果
     */
    public int deletePesInvMaterialTxnsById(Long id);

    /**
     * @Author mingshen.wang
     * @Description 同步数据中间数据
     * @Date 14:28 2021/8/28
     * @Param []
     * @return
     **/
    void  synData(Date sTime,Date eTime);

    /**
     * @Author mingshen.wang
     * @Description 处理入库的记录，并更新对应的接收数量
     * @Date 10:42 2021/8/29
     * @Param []
     * @return void
     **/
    void handleWarehousing();
    /**
     * @Author mingshen.wang
     * @Description 新增并处理汇总
     * @Date 14:27 2021/9/14
     * @Param [pesInvMaterialTxns]
     * @return boolean
     **/
    boolean insertHandle(PesInvMaterialTxns pesInvMaterialTxns);

    /**
     * @Author mingshen.wang
     * @Description 批量新增并校验数据
     * @Date 10:53 2021/9/15
     * @Param [infoList]
     * @return sinexcel.common.core.domain.AjaxResult
     **/
    AjaxResult insertBatchAndVerify(List<PesInvMaterialTxns> infoList);
    /**
     * @Author mingshen.wang
     * @Description 初始化riders库存事务处理明细key
     * @Date 10:31 2021/11/12
     * @Param []
     * @return int
     **/
    int intiKey();

}
