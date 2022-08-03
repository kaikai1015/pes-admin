package sinexcel.items.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.domain.PesItemBomFanChaEO;
import sinexcel.items.mapper.PesItemBomFanChaMapper;
import sinexcel.items.service.IPesItemBomFanChaService;

import java.util.List;

@Service
public class PesItemBomFanChaServiceImpl implements IPesItemBomFanChaService {

    @Autowired
    private PesItemBomFanChaMapper pesItemBomFanChaMapper;


    @Override
    public List<PesItemBomFanChaEO> selectPesItemBomFanChaEOListAll(PesItemBomFanChaEO pesItemBomFanChaEO)
    {
        return pesItemBomFanChaMapper.selectPesItemBomFanChaEOListAll(pesItemBomFanChaEO);
    }

    @Override
    public List<PesItemBomFanChaEO> selectPesItemBomFanChaEOList(PesItemBomFanChaEO pesItemBomFanChaEO)
    {
        return pesItemBomFanChaMapper.selectPesItemBomFanChaEOList(pesItemBomFanChaEO);
    }
}
