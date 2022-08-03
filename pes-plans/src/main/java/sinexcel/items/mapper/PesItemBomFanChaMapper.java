package sinexcel.items.mapper;

import sinexcel.items.domain.PesItemBomFanChaEO;

import java.util.List;

public interface PesItemBomFanChaMapper {
    List<PesItemBomFanChaEO> selectPesItemBomFanChaEOListAll(PesItemBomFanChaEO pesItemBomFanChaEO);

    List<PesItemBomFanChaEO> selectPesItemBomFanChaEOList(PesItemBomFanChaEO pesItemBomFanChaEO);
}
