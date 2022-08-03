package sinexcel.works.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;

/**
 * PES工单管理对象 pes_wie_work_orders_b_erp
 * 
 * @author Zhang Kai
 * @date 2021-11-24
 */
public class PesWieWorkOrdersBErp
{

    @Excel(name = "工作中心", width = 15,readConverterExp = "1=仓库工作中心,2=委外工作中心,3=惠州电源工作中心,4=内部代加工工作中心")
    private Integer workCenterCode;

    /** 客户 */
    @Excel(name = "客户",width = 20)
    private String customerName;

    /** 订单号 */
    @Excel(name = "订单号",width = 10)
    private String orderNumber;

    /** 计划员 */
    @Excel(name = "计划员", width = 10)
    private String planName;

    /** 工单号 */
    @Excel(name = "工单号", width = 15)
    private String workOrderNumber;

    /** 工单状态 */
    @Excel(name = "工单状态",width = 10,readConverterExp="10000=已取消,10001=已关闭,10002=已完成,10003=暂挂,10004=已发放,10005=未发放,10006=已删除,10007=未生效")
    private Integer workOrderStatusId;

    /** 成品料号 */
    @Excel(name = "成品料号",width = 10)
    private String pItemNumber;

    /** 成品描述 */
    @Excel(name = "成品描述",width = 30)
    private String pItemDescription;

    /** $column.columnComment */
    private Long workOrderId;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** 计划开工数量 */
    @Excel(name = "计划开工数量",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal plannedStartQuantity;

    /** 计划开工日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划开工日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date plannedStartDate;

    /** 计划完工日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划完工日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date plannedCompletionDate;

    /** 单位 */
    @Excel(name = "单位", width = 5)
    private String uomCode;

    /** 已完工数量 */
    @Excel(name = "已完工数量",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal completedQuantity;

    /** 已完工仓库 */
    @Excel(name = "已完工仓库",width = 10)
    private String completedSubinventoryCode;

    /** 工单类型 */
    @Excel(name = "工单类型",width = 10)
    private String workOrderType;

    /** 合同号 */
    @Excel(name = "合同号",width = 15)
    private String contractNumber;

    /** 工单版本 */
//    @Excel(name = "工单版本")
    private Integer workVersionNumber;

    /** 成品版本 */
//    @Excel(name = "成品版本")
    private Integer pItemVersionNumber;

    /** 阶次 */
    @Excel(name = "阶次",width = 5,cellType = Excel.ColumnType.BigDecimal)
    private Integer workItemLevel;

    /** 行 */
//    @Excel(name = "行")
    private Integer orderNumberLine;

    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    /** 计划批次行号 */
    @Excel(name = "计划批次行号",width = 20)
    @JsonSerialize(using= ToStringSerializer.class)
    private Long sourceLineNum;

    /** 来源树状码 */
    @Excel(name = "来源树状码",width = 20)
    private String levelTreeCode;

    /** 上阶树状码 */
    @Excel(name = "上阶树状码",width = 20)
    private String parentLevelTreeCode;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** PES工单ID */
//    @Excel(name = "PES工单ID")
    private Long pesWorkOrderId;
    private String createBy;
    private String remark;
    private Integer erpType;
    private String erpFlag;
    private Date erpSubmitDate;
    private String linesLotsFlag;
    private String workOrderTypeId;
    private String bomDataFlag;
    private String createType;
    private Long workCenterId;
    private String lotNumFlag;
    private String isWwFlag;
    private String supplySubinventory;
    private Long woOperationMaterialId;
    private Integer lotControlCode;

    private String workOrderStatusIdAll;

    public String getWorkOrderStatusIdAll() {
        return workOrderStatusIdAll;
    }

    public void setWorkOrderStatusIdAll(String workOrderStatusIdAll) {
        this.workOrderStatusIdAll = workOrderStatusIdAll;
    }


    public Integer getLotControlCode() {
        return lotControlCode;
    }

    public void setLotControlCode(Integer lotControlCode) {
        this.lotControlCode = lotControlCode;
    }

    public Long getWoOperationMaterialId() {
        return woOperationMaterialId;
    }

    public void setWoOperationMaterialId(Long woOperationMaterialId) {
        this.woOperationMaterialId = woOperationMaterialId;
    }

    public String getSupplySubinventory() {
        return supplySubinventory;
    }

    public void setSupplySubinventory(String supplySubinventory) {
        this.supplySubinventory = supplySubinventory;
    }

    public String getIsWwFlag() {
        return isWwFlag;
    }

    public void setIsWwFlag(String isWwFlag) {
        this.isWwFlag = isWwFlag;
    }

    public Integer getWorkCenterCode() {
        return workCenterCode;
    }

    public void setWorkCenterCode(Integer workCenterCode) {
        this.workCenterCode = workCenterCode;
    }

    public String getLotNumFlag() {
        return lotNumFlag;
    }

    public void setLotNumFlag(String lotNumFlag) {
        this.lotNumFlag = lotNumFlag;
    }

    public Long getWorkCenterId() {
        return workCenterId;
    }

    public void setWorkCenterId(Long workCenterId) {
        this.workCenterId = workCenterId;
    }

    public String getBomDataFlag() {
        return bomDataFlag;
    }

    public void setBomDataFlag(String bomDataFlag) {
        this.bomDataFlag = bomDataFlag;
    }

    public String getCreateType() {
        return createType;
    }

    public void setCreateType(String createType) {
        this.createType = createType;
    }

    public String getWorkOrderTypeId() {
        return workOrderTypeId;
    }

    public void setWorkOrderTypeId(String workOrderTypeId) {
        this.workOrderTypeId = workOrderTypeId;
    }

    public String getLinesLotsFlag() {
        return linesLotsFlag;
    }

    public void setLinesLotsFlag(String linesLotsFlag) {
        this.linesLotsFlag = linesLotsFlag;
    }

    public Date getErpSubmitDate() {
        return erpSubmitDate;
    }

    public void setErpSubmitDate(Date erpSubmitDate) {
        this.erpSubmitDate = erpSubmitDate;
    }

    public String getErpFlag() {
        return erpFlag;
    }

    public void setErpFlag(String erpFlag) {
        this.erpFlag = erpFlag;
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

    public Integer getErpType() {
        return erpType;
    }

    public void setErpType(Integer erpType) {
        this.erpType = erpType;
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
    public void setInventoryItemId(Long inventoryItemId) 
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() 
    {
        return inventoryItemId;
    }
    public void setWorkOrderStatusId(Integer workOrderStatusId) 
    {
        this.workOrderStatusId = workOrderStatusId;
    }

    public Integer getWorkOrderStatusId() 
    {
        return workOrderStatusId;
    }
    public void setPlannedStartQuantity(BigDecimal plannedStartQuantity) 
    {
        this.plannedStartQuantity = plannedStartQuantity;
    }

    public BigDecimal getPlannedStartQuantity() 
    {
        return plannedStartQuantity;
    }
    public void setPlannedStartDate(Date plannedStartDate) 
    {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedStartDate() 
    {
        return plannedStartDate;
    }
    public void setPlannedCompletionDate(Date plannedCompletionDate) 
    {
        this.plannedCompletionDate = plannedCompletionDate;
    }

    public Date getPlannedCompletionDate() 
    {
        return plannedCompletionDate;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setWorkOrderType(String workOrderType) 
    {
        this.workOrderType = workOrderType;
    }

    public String getWorkOrderType() 
    {
        return workOrderType;
    }
    public void setContractNumber(String contractNumber) 
    {
        this.contractNumber = contractNumber;
    }

    public String getContractNumber() 
    {
        return contractNumber;
    }
    public void setpItemNumber(String pItemNumber) 
    {
        this.pItemNumber = pItemNumber;
    }

    public String getpItemNumber() 
    {
        return pItemNumber;
    }
    public void setpItemDescription(String pItemDescription) 
    {
        this.pItemDescription = pItemDescription;
    }

    public String getpItemDescription() 
    {
        return pItemDescription;
    }
    public void setUomCode(String uomCode) 
    {
        this.uomCode = uomCode;
    }

    public String getUomCode() 
    {
        return uomCode;
    }
    public void setCompletedQuantity(BigDecimal completedQuantity) 
    {
        this.completedQuantity = completedQuantity;
    }

    public BigDecimal getCompletedQuantity() 
    {
        return completedQuantity;
    }
    public void setCompletedSubinventoryCode(String completedSubinventoryCode) 
    {
        this.completedSubinventoryCode = completedSubinventoryCode;
    }

    public String getCompletedSubinventoryCode() 
    {
        return completedSubinventoryCode;
    }
    public void setWorkVersionNumber(Integer workVersionNumber) 
    {
        this.workVersionNumber = workVersionNumber;
    }

    public Integer getWorkVersionNumber() 
    {
        return workVersionNumber;
    }
    public void setpItemVersionNumber(Integer pItemVersionNumber) 
    {
        this.pItemVersionNumber = pItemVersionNumber;
    }

    public Integer getpItemVersionNumber() 
    {
        return pItemVersionNumber;
    }
    public void setWorkItemLevel(Integer workItemLevel) 
    {
        this.workItemLevel = workItemLevel;
    }

    public Integer getWorkItemLevel() 
    {
        return workItemLevel;
    }
    public void setPlanName(String planName) 
    {
        this.planName = planName;
    }

    public String getPlanName() 
    {
        return planName;
    }
    public void setOrderNumberLine(Integer orderNumberLine) 
    {
        this.orderNumberLine = orderNumberLine;
    }

    public Integer getOrderNumberLine() 
    {
        return orderNumberLine;
    }
    public void setSourceLineNum(Long sourceLineNum) 
    {
        this.sourceLineNum = sourceLineNum;
    }

    public Long getSourceLineNum() 
    {
        return sourceLineNum;
    }
    public void setLevelTreeCode(String levelTreeCode) 
    {
        this.levelTreeCode = levelTreeCode;
    }

    public String getLevelTreeCode() 
    {
        return levelTreeCode;
    }
    public void setParentLevelTreeCode(String parentLevelTreeCode) 
    {
        this.parentLevelTreeCode = parentLevelTreeCode;
    }

    public String getParentLevelTreeCode() 
    {
        return parentLevelTreeCode;
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
    public void setPesWorkOrderId(Long pesWorkOrderId) 
    {
        this.pesWorkOrderId = pesWorkOrderId;
    }

    public Long getPesWorkOrderId() 
    {
        return pesWorkOrderId;
    }
}
