package sinexcel.weeks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.weeks.domain.PesPoInbound;
import sinexcel.weeks.mapper.PesPoInboundMapper;
import sinexcel.weeks.service.IPesPoInboundService;

import java.util.List;

@Service
public class PesPoInboundServiceImpl implements IPesPoInboundService {

    @Autowired
    private PesPoInboundMapper pesPoInboundMapper;

    @Override
    public List<PesPoInbound> selectPesPoInboundList(PesPoInbound pesPoInbound)
    {
        return pesPoInboundMapper.selectPesPoInboundList(pesPoInbound);
    }
}
