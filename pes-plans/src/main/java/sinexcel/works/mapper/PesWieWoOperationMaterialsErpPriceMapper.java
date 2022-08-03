package sinexcel.works.mapper;

import sinexcel.works.domain.PesWieWoOperationMaterialsPriceErp;

import java.util.List;

public interface PesWieWoOperationMaterialsErpPriceMapper {

    List<PesWieWoOperationMaterialsPriceErp> selectPesWieWoOperationMaterialsErpListByPriceImport(PesWieWoOperationMaterialsPriceErp pesWieWoOperationMaterialsErp);
}
