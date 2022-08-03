package sinexcel.daysPlan.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 产品线日计划明细对象 pes_prod_line_days_line_all
 *
 * @author Zhang Kai
 * @date 2021-06-07
 */
public class PesProdLineDaysLineAllPrice extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    /** 线别 */
    private String xianBieFlag;

    @Excel(name = "线别名称",combo = {"PQ模块装配线","储能模块装配线","电池模块装配线","工业电源模块装配线","家庭小电源装配线","换电柜机柜装配线","充电桩机柜装配线","PQ机柜装配线","电池机柜装配线","储能机柜装配线","集装箱装配线","辅材包装线","充电桩模块","中试生产线","线缆加工线"},type = Excel.Type.ALL)
    private String xianBieFlagName;


    @Excel(name = "计划批号",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private Long lotNum;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date lotNumDate;

    @Excel(name = "排产顺序",width = 5, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private Long lineId;

    @Excel(name = "客户",width = 20,type = Excel.Type.EXPORT)
    private String partyName;

    @Excel(name = "BU产品线",width = 10,type = Excel.Type.ALL)
    private String chanPingXian;

    public String getChanPingXian() {
        return chanPingXian;
    }

    public void setChanPingXian(String chanPingXian) {
        this.chanPingXian = chanPingXian;
    }

    /** 订单号 */
    @Excel(name = "订单号",width = 10,type = Excel.Type.ALL)
    private String orderNumber;

    /** 物料编码 */
    @Excel(name = "物料编码", width = 15,type = Excel.Type.EXPORT)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述", width = 40,type = Excel.Type.EXPORT)
    private String itemDescription;

    @Excel(name = "单位成本",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal pSumUnitCost;

    public BigDecimal getpSumUnitCost() {
        return pSumUnitCost;
    }

    public void setpSumUnitCost(BigDecimal pSumUnitCost) {
        this.pSumUnitCost = pSumUnitCost;
    }

    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X",type = Excel.Type.EXPORT)
    private Long organizationId;

    @Excel(name = "库存组织", width = 15,combo = {"INV_SH_X","INV_HZ_X","INV_XA","INV_HZSH","INV_US","INV_ZHNY","INV_HZSH_FEE","INV_SHENZHEN_HZ_X"},type = Excel.Type.IMPORT)
    private String organizationCode;

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    /** 工单号 */
    @Excel(name = "工单号" ,width = 10,type = Excel.Type.ALL)
    private String workOrderNumber;

    public Integer getWorkOrderStatusId() {
        return workOrderStatusId;
    }

    public void setWorkOrderStatusId(Integer workOrderStatusId) {
        this.workOrderStatusId = workOrderStatusId;
    }

    @Excel(name = "工单状态",width = 10,readConverterExp="10000=已取消,10001=已关闭,10002=已完成,10003=暂挂,10004=已发放,10005=未发放,10006=已删除,10007=未生效")
    private Integer workOrderStatusId;

    /** 工单总数 */
    @Excel(name = "工单数量",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal planStartQuantity;
    @Excel(name = "计划生产数量",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal workPlanQuantity;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划完工日期", width = 15,prompt="日期格式：yyyy-MM-dd（2021-01-01）", dateFormat = "yyyy-MM-dd",type = Excel.Type.ALL)
    private Date plannedCompletionDate;

    @Excel(name = "工单完工数量" ,width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal completedQuantity;

    /** 工时 */
    @Excel(name = "工时" ,width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal workHours;
    /** 工单工时 */
    @Excel(name = "工单工时" ,width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal wieWorkHours;



    @Excel(name = "组装开始数量" ,width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal zuZhuangStartQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "组装开始日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date zuZhuangStartDate;

    @Excel(name = "组装采集数量" ,width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal zuZhuangCaiQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "组装采集日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date zuZhuangCaiDate;

    @Excel(name = "组装完成数量" ,width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal zuZhuangEndQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "组装完成日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date zuZhuangEndDate;

    @Excel(name = "老化完成数量" ,width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal laoHuaQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "老化完成日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date laoHuaDate;

    @Excel(name = "测试完成数量" ,width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal testQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "测试完成日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date testDate;

    @Excel(name = "包装完成数量" ,width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal baoZhuangQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "包装完成日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date baoZhuangDate;

    @Excel(name = "完工入库数量" ,width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal planCompleteQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完工入库日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date completeDate;
    @Excel(name = "扣账数量" ,width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal qeductionQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "扣账日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date qeductionDate;


    /** 批次号 */
    @Excel(name = "批次号")
    private String planLotsId;

    /** 是否齐料 */
    @Excel(name = "是否齐料",combo = {"是","否"},readConverterExp = "Y=是,N=否",type = Excel.Type.ALL)
    private String isFlag;

    @Excel(name = "备注",width = 20,type = Excel.Type.ALL)
    private String remark;

    private Boolean isProcess;

    /** 客户 */
    private Long partyId;

    /** $column.columnComment */
    private Long orderHeaderId;

    /** $column.columnComment */
    private Long lineNumberId;

    /** 订单行号 */
    private Integer lineNumber;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** $column.columnComment */
    private Long workOrderId;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */

    private String createBy;

    private Long buId;
    //    private String buName;
    private String customerPoNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date plannedStartDate;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String beginTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endTime;

    private String isWwFlag;

    public Boolean getProcess() {
        return isProcess;
    }

    public void setProcess(Boolean process) {
        isProcess = process;
    }

    public BigDecimal getZuZhuangStartQuantity() {
        return zuZhuangStartQuantity;
    }

    public void setZuZhuangStartQuantity(BigDecimal zuZhuangStartQuantity) {
        this.zuZhuangStartQuantity = zuZhuangStartQuantity;
    }

    public BigDecimal getZuZhuangCaiQuantity() {
        return zuZhuangCaiQuantity;
    }

    public void setZuZhuangCaiQuantity(BigDecimal zuZhuangCaiQuantity) {
        this.zuZhuangCaiQuantity = zuZhuangCaiQuantity;
    }

    public BigDecimal getZuZhuangEndQuantity() {
        return zuZhuangEndQuantity;
    }

    public void setZuZhuangEndQuantity(BigDecimal zuZhuangEndQuantity) {
        this.zuZhuangEndQuantity = zuZhuangEndQuantity;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getZuZhuangStartDate() {
        return zuZhuangStartDate;
    }

    public void setZuZhuangStartDate(Date zuZhuangStartDate) {
        this.zuZhuangStartDate = zuZhuangStartDate;
    }

    public Date getZuZhuangCaiDate() {
        return zuZhuangCaiDate;
    }

    public void setZuZhuangCaiDate(Date zuZhuangCaiDate) {
        this.zuZhuangCaiDate = zuZhuangCaiDate;
    }


    public Date getZuZhuangEndDate() {
        return zuZhuangEndDate;
    }

    public void setZuZhuangEndDate(Date zuZhuangEndDate) {
        this.zuZhuangEndDate = zuZhuangEndDate;
    }

    public BigDecimal getLaoHuaQuantity() {
        return laoHuaQuantity;
    }

    public void setLaoHuaQuantity(BigDecimal laoHuaQuantity) {
        this.laoHuaQuantity = laoHuaQuantity;
    }

    public Date getLaoHuaDate() {
        return laoHuaDate;
    }

    public void setLaoHuaDate(Date laoHuaDate) {
        this.laoHuaDate = laoHuaDate;
    }

    public BigDecimal getTestQuantity() {
        return testQuantity;
    }

    public void setTestQuantity(BigDecimal testQuantity) {
        this.testQuantity = testQuantity;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getIsWwFlag() {
        return isWwFlag;
    }

    public void setIsWwFlag(String isWwFlag) {
        this.isWwFlag = isWwFlag;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Long getBuId() {
        return buId;
    }

    public void setBuId(Long buId) {
        this.buId = buId;
    }

//    public String getBuName() {
//        return buName;
//    }
//
//    public void setBuName(String buName) {
//        this.buName = buName;
//    }

    public String getCustomerPoNumber() {
        return customerPoNumber;
    }

    public void setCustomerPoNumber(String customerPoNumber) {
        this.customerPoNumber = customerPoNumber;
    }

    public Date getLotNumDate() {
        return lotNumDate;
    }

    public void setLotNumDate(Date lotNumDate) {
        this.lotNumDate = lotNumDate;
    }


    public Long getLotNum() {
        return lotNum;
    }

    public void setLotNum(Long lotNum) {
        this.lotNum = lotNum;
    }

    public String getXianBieFlagName() {
        return xianBieFlagName;
    }

    public void setXianBieFlagName(String xianBieFlagName) {
        this.xianBieFlagName = xianBieFlagName;
    }

    public BigDecimal getBaoZhuangQuantity() {
        return baoZhuangQuantity;
    }

    public void setBaoZhuangQuantity(BigDecimal baoZhuangQuantity) {
        this.baoZhuangQuantity = baoZhuangQuantity;
    }

    public Date getBaoZhuangDate() {
        return baoZhuangDate;
    }

    public void setBaoZhuangDate(Date baoZhuangDate) {
        this.baoZhuangDate = baoZhuangDate;
    }

    public BigDecimal getWorkPlanQuantity() {
        return workPlanQuantity;
    }

    public void setWorkPlanQuantity(BigDecimal workPlanQuantity) {
        this.workPlanQuantity = workPlanQuantity;
    }

    public BigDecimal getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(BigDecimal completedQuantity) {
        this.completedQuantity = completedQuantity;
    }

    public Date getPlannedCompletionDate() {
        return plannedCompletionDate;
    }

    public void setPlannedCompletionDate(Date plannedCompletionDate) {
        this.plannedCompletionDate = plannedCompletionDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getPlanCompleteQuantity() {
        return planCompleteQuantity;
    }

    public void setPlanCompleteQuantity(BigDecimal planCompleteQuantity) {
        this.planCompleteQuantity = planCompleteQuantity;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public void setXianBieFlag(String xianBieFlag)
    {
        this.xianBieFlag = xianBieFlag;
    }

    public String getXianBieFlag()
    {
        return xianBieFlag;
    }
    public void setPartyId(Long partyId)
    {
        this.partyId = partyId;
    }

    public Long getPartyId()
    {
        return partyId;
    }
    public void setOrderHeaderId(Long orderHeaderId)
    {
        this.orderHeaderId = orderHeaderId;
    }

    public Long getOrderHeaderId()
    {
        return orderHeaderId;
    }
    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber()
    {
        return orderNumber;
    }
    public void setLineNumberId(Long lineNumberId)
    {
        this.lineNumberId = lineNumberId;
    }

    public Long getLineNumberId()
    {
        return lineNumberId;
    }
    public void setLineNumber(Integer lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    public Integer getLineNumber()
    {
        return lineNumber;
    }
    public void setInventoryItemId(Long inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId()
    {
        return inventoryItemId;
    }
    public void setItemNumber(String itemNumber)
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber()
    {
        return itemNumber;
    }
    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription()
    {
        return itemDescription;
    }
    public void setOrganizationId(Long organizationId)
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId()
    {
        return organizationId;
    }
    public void setWorkOrderId(Long workOrderId)
    {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId()
    {
        return workOrderId;
    }
    public void setWorkOrderNumber(String workOrderNumber)
    {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWorkOrderNumber()
    {
        return workOrderNumber;
    }
    public void setPlanStartQuantity(BigDecimal planStartQuantity)
    {
        this.planStartQuantity = planStartQuantity;
    }

    public BigDecimal getPlanStartQuantity()
    {
        return planStartQuantity;
    }
    public void setWorkHours(BigDecimal workHours)
    {
        this.workHours = workHours;
    }

    public BigDecimal getWorkHours()
    {
        return workHours;
    }
    public void setWieWorkHours(BigDecimal wieWorkHours)
    {
        this.wieWorkHours = wieWorkHours;
    }

    public BigDecimal getWieWorkHours()
    {
        return wieWorkHours;
    }
    public void setCompleteDate(Date completeDate)
    {
        this.completeDate = completeDate;
    }

    public Date getCompleteDate()
    {
        return completeDate;
    }
    public void setIsFlag(String isFlag)
    {
        this.isFlag = isFlag;
    }

    public String getIsFlag()
    {
        return isFlag;
    }
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
    }
    public void setLastUpdateDate(Date lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate()
    {
        return lastUpdateDate;
    }
    public void setLastUpdateBy(String lastUpdateBy)
    {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdateBy()
    {
        return lastUpdateBy;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setLineId(Long lineId)
    {
        this.lineId = lineId;
    }

    public Long getLineId()
    {
        return lineId;
    }
}
