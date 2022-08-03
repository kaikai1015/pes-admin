package sinexcel.weeks.mapper;

import sinexcel.weeks.domain.PesPoInbound;

import java.util.List;

public interface PesPoInboundMapper {

    public List<PesPoInbound> selectPesPoInboundList(PesPoInbound pesPoInbound);
}
