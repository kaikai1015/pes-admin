package sinexcel.quartz.service;

import sinexcel.quartz.domain.MesToPesWieWorkProcessingQuantityListEO;

import java.util.List;

public interface IMesToPesWieWorkProcessingQuantityListService {

    public List<MesToPesWieWorkProcessingQuantityListEO> selectMesWieWorkProcessingQuantityListList();

    void insertMesWieWorkProcessingQuantityList(List<MesToPesWieWorkProcessingQuantityListEO> lists);
}
