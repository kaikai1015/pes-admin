package sinexcel.plans.service;

public interface IPlanLineBomService {

	public void deleteSyncDemandListLists();

	/**
	 * MRP计算相依需求
	 */
	public int selectPesPlanLineListById(Long planLotNum);

	public void checkPlotNumActive(Long planLotNum);
}
