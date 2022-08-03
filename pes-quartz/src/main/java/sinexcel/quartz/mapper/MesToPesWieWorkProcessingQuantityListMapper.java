package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.MesToPesWieWorkProcessingQuantityListEO;

import java.util.List;

public interface MesToPesWieWorkProcessingQuantityListMapper {

    List<MesToPesWieWorkProcessingQuantityListEO> selectMesWieWorkProcessingQuantityListList();

    void insertMesWieWorkProcessingQuantityListTemp(List<MesToPesWieWorkProcessingQuantityListEO> mesToPesWieWorkProcessingQuantityListEOS);

    void deleteMesWieWorkProcessingQuantityListTemp();
}
