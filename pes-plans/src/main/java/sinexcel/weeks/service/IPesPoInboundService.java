package sinexcel.weeks.service;

import sinexcel.weeks.domain.PesPoInbound;

import java.util.List;

public interface IPesPoInboundService {
    public List<PesPoInbound> selectPesPoInboundList(PesPoInbound pesPoInbound);
}
