package sinexcel.meswms.service;

import java.util.List;
import sinexcel.meswms.domain.MesInvSubinventoryAll;

/**
 * mes工单单身指定仓库Service接口
 *
 * @author Zhang Kai
 * @date 2021-03-10
 */
public interface IMesInvSubinventoryAllService 
{
    /**
     * 查询mes工单单身指定仓库
     * 
     * @param id mes工单单身指定仓库ID
     * @return mes工单单身指定仓库
     */
    public MesInvSubinventoryAll selectMesInvSubinventoryAllById(Long id);

    /**
     * 查询mes工单单身指定仓库列表
     * 
     * @param mesInvSubinventoryAll mes工单单身指定仓库
     * @return mes工单单身指定仓库集合
     */
    public List<MesInvSubinventoryAll> selectMesInvSubinventoryAllList(MesInvSubinventoryAll mesInvSubinventoryAll);

    /**
     * 新增mes工单单身指定仓库
     * 
     * @param mesInvSubinventoryAll mes工单单身指定仓库
     * @return 结果
     */
    public int insertMesInvSubinventoryAll(MesInvSubinventoryAll mesInvSubinventoryAll);

    /**
     * 修改mes工单单身指定仓库
     * 
     * @param mesInvSubinventoryAll mes工单单身指定仓库
     * @return 结果
     */
    public int updateMesInvSubinventoryAll(MesInvSubinventoryAll mesInvSubinventoryAll);


    /**
     * 校验是否唯一
     *
     * @return 结果
     */
    public String checkUnique(MesInvSubinventoryAll mesInvSubinventoryAll);

    /**
     * 导入数据
     *
     * @param mesInvSubinventoryAllLists 用户数据列表
     * @param operName 操作用户
     * @return 结果
     */
    public String importData(List<MesInvSubinventoryAll> mesInvSubinventoryAllLists, String operName);

}
