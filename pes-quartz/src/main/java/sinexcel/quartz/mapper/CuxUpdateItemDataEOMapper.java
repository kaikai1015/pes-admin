package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.CuxUpdateItemDataEO;

import java.util.List;

public interface CuxUpdateItemDataEOMapper {

    List<CuxUpdateItemDataEO> selectUpdateItemDataList();


    List<CuxUpdateItemDataEO> selectUpdateItemDataBuyerList(CuxUpdateItemDataEO rcvPurchaseEO);

    List<CuxUpdateItemDataEO> selectUpdateItemDataAttributeList(CuxUpdateItemDataEO rcvPurchaseEO);

    List<CuxUpdateItemDataEO> selectUpdateItemDataStatusList();
}
