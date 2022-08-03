package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.CuxWorkOrdersQtDetailsQlHistoryEO;

import java.util.List;

public interface CuxWorkOrdersQtDetailsQlHistoryMapper {

    public int batchCuxWorkOrdersQtDetailsQlHistoryEO(List<CuxWorkOrdersQtDetailsQlHistoryEO> list);

    public List<CuxWorkOrdersQtDetailsQlHistoryEO> getCuxWorkOrdersQtDetailsQlHistoryList(String lotNum);

    public int delCuxWorkOrdersQtDetailsQlHistoryList(String lotNum);
}
