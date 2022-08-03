package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.CuxMaterialTransactionsPesEO;

import java.util.List;

public interface CuxMaterialTransactionsPesMapper {
    public int batchCuxMaterialTransactionsPesEO(List<CuxMaterialTransactionsPesEO> list);

    public int deleteCuxMaterialTransactionsPesEO(List<CuxMaterialTransactionsPesEO> list);

    public List<CuxMaterialTransactionsPesEO> selectCuxMaterialTransactionsPesList(CuxMaterialTransactionsPesEO cuxMaterialTransactions);

    public CuxMaterialTransactionsPesEO selectCuxMaterialTransactionsByPesId(Integer id);

    /**
     * 修改工单发料
     *
     * @param cuxMaterialTransactionsPes 工单发料
     * @return 结果
     */
    public int updateCuxMaterialTransactionsPes(CuxMaterialTransactionsPesEO cuxMaterialTransactionsPes);

    public int selectCuxMaterialTransactionsByIds(CuxMaterialTransactionsPesEO cuxMaterialTransactionsPes);

    public int updatePesCountId(CuxMaterialTransactionsPesEO cuxMaterialTransactions);

}
