package sinexcel.items.service;

import sinexcel.items.domain.PesItemBomFanChaEO;

import java.util.List;

public interface IPesItemBomFanChaService {

    List<PesItemBomFanChaEO> selectPesItemBomFanChaEOList(PesItemBomFanChaEO pesItemBomFanChaEO);

    List<PesItemBomFanChaEO> selectPesItemBomFanChaEOListAll(PesItemBomFanChaEO pesItemBomFanChaEO);
}
