package sinexcel.plans.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.plans.domain.PlanLineBom;
import sinexcel.plans.mapper.PlanLineBomMapper;
import sinexcel.plans.service.IPlanLineBomService;

import javax.annotation.Resource;
import java.util.*;

@Service
public class PlanLineBomServiceImpl implements IPlanLineBomService {

	@Resource
	PlanLineBomMapper planLineMapper;


	@Override
	public void deleteSyncDemandListLists()
	{
		planLineMapper.deleteSyncDemandListLists();
	}

	/**
	 * MRP计算之前判断批次是否有效
	 */
	@Override
	public void checkPlotNumActive(Long planLotNum)
	{
		if (planLineMapper.checkPlotNumActive(planLotNum) > 0 ? true : false)
		{
			throw new CustomException("批次已经失效，不能进行计算");
		}
	}

	/**
	 * MRP计算相依需求
	 */
	@Override
	@Transactional
	public int selectPesPlanLineListById(Long planLotNum)
	{ int i = 0,level = 0;
		PlanLineBom items = new PlanLineBom();
		items.setPlanLotNum(planLotNum);
		items.setCreateBy(SecurityUtils.getUsername());
		System.out.println("----------BOM展开计算开始----------");
		if(planLotNum.longValue()>2101010000L){
			//插入O阶次数据
			i = planLineMapper.mrpOrdersLists(items);
			while (i > 0)
			{
				//循环插入低阶次数据
				items.setLevel(level);
				i = planLineMapper.insertMrpOrdersLists(items);
				System.out.println("----------第"+items.getLevel()+"阶次计算结束："+i+"----------");
				level ++ ;
			}
		}else {
			//插入O阶次数据
			i = planLineMapper.selectPesPlanBomList(items);
			while (i > 0)
			{
				//循环插入低阶次数据
				items.setLevel(level);
				i = planLineMapper.insertData(items);
				System.out.println("----------第"+items.getLevel()+"阶次计算结束："+i+"----------");
				level ++ ;
			}
		}
		System.out.println("----------BOM展开计算结束----------");
		//MRP相依需求计算完毕后计算积累需求数量
		level = saveSumGrossQuantityList(planLotNum);
		return level;
	}

	@Transactional
	public int saveSumGrossQuantityList(Long planLotNum) {
		int s = 0;
		System.out.println("----------LLC累计需求计算开始----------");
		System.out.println(new Date());
		if(planLotNum.longValue()>2101010000L){
			planLineMapper.deleOrdersSumGrossQuantityLists();
			planLineMapper.saveOrdersSumGrossQuantityListLlc();
			s = planLineMapper.saveOrdersSumGrossQuantityList(planLotNum);
		}else {
			planLineMapper.deleSumGrossQuantityLists();
			planLineMapper.saveSumGrossQuantityListLlc();
			s = planLineMapper.saveSumGrossQuantityList(planLotNum);
		}
		System.out.println("----------LLC累计需求计算结束----------");
		System.out.println(new Date());
		return s;
	}
}
