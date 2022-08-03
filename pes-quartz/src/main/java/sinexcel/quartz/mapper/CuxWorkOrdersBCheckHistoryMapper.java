package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.CuxWorkOrdersBCheckHistoryEO;

import java.util.List;

public interface CuxWorkOrdersBCheckHistoryMapper {

    public int batchCuxWorkOrdersBCheckHistoryEO(List<CuxWorkOrdersBCheckHistoryEO> list);

    public List<CuxWorkOrdersBCheckHistoryEO> getCuxWorkOrdersBCheckHistoryList(String lotNum);

    public int delCuxWorkOrdersBCheckHistoryList(String lotNum);
}
