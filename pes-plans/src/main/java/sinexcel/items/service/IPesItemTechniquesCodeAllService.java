package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.PesItemTechniquesCodeAll;

/**
 * 编码工艺属性Service接口
 * 
 * @author Zhang Kai
 * @date 2021-06-24
 */
public interface IPesItemTechniquesCodeAllService 
{
    /**
     * 查询编码工艺属性
     * 
     * @param techniquesCodeId 编码工艺属性ID
     * @return 编码工艺属性
     */
    public PesItemTechniquesCodeAll selectPesItemTechniquesCodeAllById(Long techniquesCodeId);

    /**
     * 查询编码工艺属性列表
     * 
     * @param pesItemTechniquesCodeAll 编码工艺属性
     * @return 编码工艺属性集合
     */
    public List<PesItemTechniquesCodeAll> selectPesItemTechniquesCodeAllList(PesItemTechniquesCodeAll pesItemTechniquesCodeAll);

    /**
     * 新增编码工艺属性
     * 
     * @param pesItemTechniquesCodeAll 编码工艺属性
     * @return 结果
     */
    public int insertPesItemTechniquesCodeAll(PesItemTechniquesCodeAll pesItemTechniquesCodeAll);

    /**
     * 修改编码工艺属性
     * 
     * @param pesItemTechniquesCodeAll 编码工艺属性
     * @return 结果
     */
    public int updatePesItemTechniquesCodeAll(PesItemTechniquesCodeAll pesItemTechniquesCodeAll);

    /**
     * 批量删除编码工艺属性
     * 
     * @param techniquesCodeIds 需要删除的编码工艺属性ID
     * @return 结果
     */
    public int deletePesItemTechniquesCodeAllByIds(Long[] techniquesCodeIds);

    public String importData(List<PesItemTechniquesCodeAll> lists,String operName);
}
