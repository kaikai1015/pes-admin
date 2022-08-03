package sinexcel.daysPlan.service.impl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.annotation.DataScope;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.daysPlan.mapper.PesProdPlanTransferAllWWMapper;
import sinexcel.daysPlan.domain.PesProdPlanTransferAllWW;
import sinexcel.daysPlan.service.IPesProdPlanTransferAllWWService;

/**
 * 生产计划调拨单Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-07-01
 */
@Service
public class PesProdPlanTransferAllWWServiceImpl implements IPesProdPlanTransferAllWWService
{
    @Autowired
    private PesProdPlanTransferAllWWMapper pesProdPlanTransferAllMapper;

    /**
     * 查询生产计划调拨单列表
     *
     * @param pesProdPlanTransferAll 生产计划调拨单
     * @return 生产计划调拨单
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<PesProdPlanTransferAllWW> selectPesProdPlanTransferAllList(PesProdPlanTransferAllWW pesProdPlanTransferAll)
    {
        return pesProdPlanTransferAllMapper.selectPesProdPlanTransferAllList(pesProdPlanTransferAll);
    }

    /**
     * 新增生产计划调拨单
     *
     * @param id 生产计划调拨单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertPesProdPlanTransferAll(Long id)
    {
        String max_subcode = "0";
        BigDecimal max_quantity = BigDecimal.ZERO;
        Long inventoryItemId = 0L;
        Long organizationId = 0L;
        List<PesProdPlanTransferAllWW> selectPesProdPlanTransferAllByIds = pesProdPlanTransferAllMapper.selectPesProdPlanTransferAllById(id);
        if(selectPesProdPlanTransferAllByIds.size() > 0){
            for(PesProdPlanTransferAllWW pesProdPlanTransferAll:selectPesProdPlanTransferAllByIds){
                pesProdPlanTransferAll.setCreateBy(SecurityUtils.getUsername());
                if(organizationId.equals(pesProdPlanTransferAll.getOrganizationId())&&inventoryItemId.equals(pesProdPlanTransferAll.getInventoryItemId())){
                    pesProdPlanTransferAll.setMaxSubcode(max_subcode);
                    pesProdPlanTransferAll.setMaxQuantity(max_quantity);
                }else {
                    pesProdPlanTransferAll.setMaxSubcode("0");
                    pesProdPlanTransferAll.setMaxQuantity(BigDecimal.ZERO);
                }
                List<PesProdPlanTransferAllWW> pesProdOnhandQuantitys = pesProdPlanTransferAllMapper.selectPesProdOnhandQuantitys(pesProdPlanTransferAll);
                if(pesProdOnhandQuantitys.size() > 0){
                    for(PesProdPlanTransferAllWW pesProdOnhandQuantity:pesProdOnhandQuantitys){
                        pesProdPlanTransferAll.setDiaoChuSubinventory(pesProdOnhandQuantity.getDiaoChuSubinventory());
                        pesProdPlanTransferAll.setDiaoChuQuantity(pesProdOnhandQuantity.getDiaoChuQuantity());
//                        pesProdPlanTransferAll.setDiaoRuSubinventory("XBC");
                        pesProdPlanTransferAll.setDiaoRuQuantity(pesProdPlanTransferAll.getDiaoChuQuantity());
                        if(pesProdOnhandQuantity.getDiaoChuSubinventory().equals(pesProdOnhandQuantity.getMaxSubinventoryCode())||pesProdOnhandQuantity.getDiaoChuSubinventory()==pesProdOnhandQuantity.getMaxSubinventoryCode()){
                            max_subcode = pesProdOnhandQuantity.getDiaoChuSubinventory();
                            max_quantity = pesProdOnhandQuantity.getDiaoChuQuantity();
                            inventoryItemId = pesProdOnhandQuantity.getInventoryItemId();
                            organizationId = pesProdOnhandQuantity.getOrganizationId();
                        }
                        pesProdPlanTransferAllMapper.insertPesProdPlanTransferAll(pesProdPlanTransferAll);
//                    list.add(pesProdPlanTransferAll);
//                    System.out.println("备料ID:"+pesProdPlanTransferAll.getBeiLiaoId()+",物料ID:"+pesProdPlanTransferAll.getInventoryItemId()+",备料数量:"+pesProdPlanTransferAll.getBeiLiaoQuantity()+",调出子库"+pesProdPlanTransferAll.getDiaoChuSubinventory()+",调出数量"+pesProdPlanTransferAll.getDiaoChuQuantity());
                    }
                }
            }
        }else {
            throw new CustomException("此备料单不需要生成调拨单，请核对备料单的数据！！！");
        }
//        if (list.size() > 0) {
//            int batchCount =190;//每批处理的条数
//            int batchLastIndex = batchCount - 1;// 每批最后一个的下标
//            for (int index = 0; index < list.size();) {
//                if (batchLastIndex > (list.size() - 1)) {
//                    batchLastIndex = list.size() - 1;
//                    rows = pesProdPlanTransferAllMapper.insertPesProdPlanTransferAll(list.subList(index, (batchLastIndex + 1)));
//                    break;// 数据插入完毕,退出循环
//                }else {
//                    rows = pesProdPlanTransferAllMapper.insertPesProdPlanTransferAll(list.subList(index, (batchLastIndex + 1)));
//                    index = batchLastIndex + 1;// 设置下一批下标
//                    batchLastIndex = index + (batchCount - 1);
//                }
//            }
//        }else {
//            throw new CustomException("此备料单不需要生成调拨单，请核对备料单的数据！！！");
//        }
        return pesProdPlanTransferAllMapper.updateTransferFlag(id);
    }

    /**
     * 批量删除生产计划调拨单
     *
     * @param planTransferIds 需要删除的生产计划调拨单ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesProdPlanTransferAllByIds(Long[] planTransferIds)
    {
        return pesProdPlanTransferAllMapper.deletePesProdPlanTransferAllByIds(planTransferIds);
    }
}
