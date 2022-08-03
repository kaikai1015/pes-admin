package sinexcel.daysPlan.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.json.JSONUtil;
import org.redisson.api.RBloomFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.utils.StringUtils;
import sinexcel.daysPlan.domain.PesInvMaterialTxns;
import sinexcel.daysPlan.domain.PesWieWorkProcessingLine;
import sinexcel.daysPlan.mapper.PesWieWorkProcessingLineMapper;
import sinexcel.daysPlan.mapper.PesWieWorkProcessingMapper;
import sinexcel.daysPlan.service.IPesWieWorkProcessingLineService;
import sinexcel.utils.BloomFilterUtils;
import sinexcel.utils.CommonStatic;

/**
 * 工单生产进度明细Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-11-03
 */
@Service
public class PesWieWorkProcessingLineServiceImpl implements IPesWieWorkProcessingLineService
{
    @Autowired
    private PesWieWorkProcessingLineMapper pesWieWorkProcessingLineMapper;
    @Autowired
    private PesWieWorkProcessingMapper processingMapper;
    @Autowired
    private IPesWieWorkProcessingLineService processingLineService;

    Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 查询工单生产进度明细
     * 
     * @param workOrderId 工单生产进度明细ID
     * @return 工单生产进度明细
     */
    @Override
    public PesWieWorkProcessingLine selectPesWieWorkProcessingLineById(Long workOrderId)
    {
        return pesWieWorkProcessingLineMapper.selectPesWieWorkProcessingLineById(workOrderId);
    }

    /**
     * 查询工单生产进度明细列表
     * 
     * @param pesWieWorkProcessingLine 工单生产进度明细
     * @return 工单生产进度明细
     */
    @Override
    public List<PesWieWorkProcessingLine> selectPesWieWorkProcessingLineList(PesWieWorkProcessingLine pesWieWorkProcessingLine)
    {
        return pesWieWorkProcessingLineMapper.selectPesWieWorkProcessingLineList(pesWieWorkProcessingLine);
    }

    /**
     * 新增工单生产进度明细
     * 
     * @param pesWieWorkProcessingLine 工单生产进度明细
     * @return 结果
     */
    @Override
    public int insertPesWieWorkProcessingLine(PesWieWorkProcessingLine pesWieWorkProcessingLine)
    {
        return pesWieWorkProcessingLineMapper.insertPesWieWorkProcessingLine(pesWieWorkProcessingLine);
    }

    /**
     * 修改工单生产进度明细
     * 
     * @param pesWieWorkProcessingLine 工单生产进度明细
     * @return 结果
     */
    @Override
    public int updatePesWieWorkProcessingLine(PesWieWorkProcessingLine pesWieWorkProcessingLine)
    {
        return pesWieWorkProcessingLineMapper.updatePesWieWorkProcessingLine(pesWieWorkProcessingLine);
    }

    /**
     * 批量删除工单生产进度明细
     * 
     * @param workOrderIds 需要删除的工单生产进度明细ID
     * @return 结果
     */
    @Override
    public int deletePesWieWorkProcessingLineByIds(Long[] workOrderIds)
    {
        return pesWieWorkProcessingLineMapper.deletePesWieWorkProcessingLineByIds(workOrderIds);
    }

    /**
     * 删除工单生产进度明细信息
     * 
     * @param workOrderId 工单生产进度明细ID
     * @return 结果
     */
    @Override
    public int deletePesWieWorkProcessingLineById(Long workOrderId)
    {
        return pesWieWorkProcessingLineMapper.deletePesWieWorkProcessingLineById(workOrderId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public void insertHandle(PesWieWorkProcessingLine info) {
        //插入数据
        pesWieWorkProcessingLineMapper.insertPesWieWorkProcessingLine(info);
        //处理更新汇总数据
        processingMapper.sumQuantity(info.getWorkOrderId(),info.getOrganizationId(),info.getQuantity(),info.getType());

    }
    public boolean verifyKey(PesWieWorkProcessingLine info) {
        RBloomFilter<String> bloomList = BloomFilterUtils.getBloomFilter("processKeyList");
        if (bloomList.contains(info.getType()+info.getMesId())){
            //true 存在 误差
            PesWieWorkProcessingLine newInfo = new PesWieWorkProcessingLine();
            newInfo.setType(info.getType());
            newInfo.setMesId(info.getMesId());
            List<PesWieWorkProcessingLine> list = pesWieWorkProcessingLineMapper.selectPesWieWorkProcessingLineList(newInfo);
            if (list.size()>0){
                return true;
            }
        }
        bloomList.add(info.getType()+info.getMesId());
        return false;
    }
    @Override
    public int intiKey() {
        RBloomFilter<String> bloomList = BloomFilterUtils.getBloomFilter("processKeyList");
        bloomList.delete();
        bloomList.tryInit(100000000L,0.01);
        List<PesWieWorkProcessingLine> list =  pesWieWorkProcessingLineMapper.selectPesWieWorkProcessingLineList(null);
        list.forEach(o->{
            bloomList.add(o.getType()+o.getMesId());
        });
        return 1;
    }

    @Override
    public AjaxResult insertBatchAndVerify(List<PesWieWorkProcessingLine> infoList) {
            //根据单据类型验证数据的必填项
            List<Map<String,String>> err = new ArrayList<>();
            logger.info("WieWorkProcessingInsertBatchAndVerify:"+ JSONUtil.toJsonStr(infoList));
            infoList.forEach(o->{
                boolean flag = verify(err,o);
                if (flag){
                    try {
                        //判断是否重复
                        if (this.verifyKey(o)){
                            Map<String,String> er = new HashMap<>();
                            er.put("id",o.getMesId()+"");
                            er.put("code","408");
                            er.put("msg","记录已经存在请不要重复推送");
                            err.add(er);
                        }else {
                            processingLineService.insertHandle(o);
                        }

                    }catch (Exception e){
                        Map<String,String> er = new HashMap<>();
                        er.put("id",o.getMesId()+"");
                        er.put("code","500");
                        er.put("msg",e.getMessage());
                        err.add(er);
                    }
                }
            });
            if (err.size()>0){
                logger.info("WieWorkProcessingInsertBatchAndVerify  err:"+JSONUtil.toJsonStr(err));
                return new AjaxResult(502,"存在"+err.size()+"条记录插入失败",err);
            }else {
                return AjaxResult.success();
            }

        }

    private static boolean verify(List<Map<String, String>> err, PesWieWorkProcessingLine o) {
        Boolean flag = true;
        Map<String,String> er = new HashMap<>();
        er.put("id",o.getMesId()+"");
        er.put("code","401");
        //检验类型的正确性
        if (!isType(o)){
            er.put("msg","字段[type]不存在 “"+o.getType()+"“ 类型！请参考：\n" +
                    "COMPLETE-完工入库（产品入库）；AGEING-老化开始；AGEING_END-老化结束；TEST-测试开始；TEST_END-测试结束；PACKING-包装采集开始；PACKING_END-包装采集结束；FEEDING-投料(组装开始)；ASSEMBLING_COMPLETE:装配（组装完成）；COLLECTION：组装采集；REPAIR-维修；\n");
            err.add(er);
            return false;
        }

        //公共必填
        flag = verifyNull("workOrderId,organizationId,workOrderNumber,createDate," +
                "type,mesId,quantity",o,er,flag);

        if (!flag){
            er.put("msg",er.get("msg")+"]不可以为空！");
            err.add(er);
        }
        return flag;
    }

    private static boolean isType(PesWieWorkProcessingLine o) {
        return StringUtils.equals(CommonStatic.WORK_PROCESS_COMPLETE,o.getType())
                ||StringUtils.equals(CommonStatic.WORK_PROCESS_AGEING,o.getType())
                ||StringUtils.equals(CommonStatic.WORK_PROCESS_ASSEMBLING_COMPLETE,o.getType())
                ||StringUtils.equals(CommonStatic.WORK_PROCESS_FEEDING,o.getType())
                ||StringUtils.equals(CommonStatic.WORK_PROCESS_PACKING,o.getType())
                ||StringUtils.equals(CommonStatic.WORK_PROCESS_AGEING_END,o.getType())
                ||StringUtils.equals(CommonStatic.WORK_PROCESS_PACKING_END,o.getType())
                ||StringUtils.equals(CommonStatic.WORK_PROCESS_REPAIR,o.getType())
                ||StringUtils.equals(CommonStatic.WORK_PROCESS_TEST_END,o.getType())
                ||StringUtils.equals(CommonStatic.WORK_PROCESS_COLLECTION,o.getType())
                ||StringUtils.equals(CommonStatic.WORK_PROCESS_TEST,o.getType());
    }

    private static Boolean verifyNull(String s, PesWieWorkProcessingLine o, Map<String, String> er, Boolean flag) {
        String[] fields = s.split(",");
        Class<?> aClass = o.getClass();
        for (int i = 0; i < fields.length; i++) {
            //得到属性
            Field field;
            try {
                field = aClass.getDeclaredField(fields[i]);
                //打开私有访问
                field.setAccessible(true);
                //获取属性值
                Object subjectType =  field.get(o);
                Type fieldType =field.getGenericType();
                if (subjectType == null){
                    if (er.containsKey("msg")){
                        er.put("msg",er.get("msg")+","+fields[i]);
                    }else {
                        er.put("msg","字段["+fields[i]);
                    }
                    flag=false;
                    continue;
                }
                if (String.class == fieldType  ){
                    if (StringUtils.isEmpty(subjectType.toString())){
                        if (er.containsKey("msg")){
                            er.put("msg",er.get("msg")+","+fields[i]);
                        }else {
                            er.put("msg","字段["+fields[i]);
                        }
                        flag=false;
                        continue;
                    }
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
