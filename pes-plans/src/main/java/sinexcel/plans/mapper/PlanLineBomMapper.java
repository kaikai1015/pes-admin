package sinexcel.plans.mapper;

import org.springframework.stereotype.Repository;
import sinexcel.plans.domain.PlanLineBom;

import java.util.List;


@Repository
public interface PlanLineBomMapper
{

	/**
	 * MRP计算之前判断批次是否有效
	 */
	public int checkPlotNumActive(Long planLotNum);

	public int selectPesPlanBomList(PlanLineBom items);

	public int mrpOrdersLists(PlanLineBom items);

	public int insertMrpOrdersLists(PlanLineBom items);


	public int insertData(PlanLineBom items);


	public int saveSumGrossQuantityList(Long planLotNum);

	public void deleSumGrossQuantityLists();

	public int saveSumGrossQuantityListLlc();

	public void deleOrdersSumGrossQuantityLists();

	public int saveOrdersSumGrossQuantityListLlc();

	public int saveOrdersSumGrossQuantityList(Long planLotNum);

	public void deleteSyncDemandListLists();

}
