package sinexcel.quartz.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 工单信息数据对象 sync_wie_work_orders_b
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
public class SyncWieWorkOrdersBEO extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X,300000001811006=SH_ITEM_MASTER,300000001811015=SH_INV,300000001811024=HZ_INV,300000045984813=INV_DYKJ")
    private Long organizationId;
    private Long workOrderId;
    @Excel(name = "工单号", width = 15)
    private String workOrderNumber;
    @Excel(name = "物料编码", width = 15)
    private String itemNumber;
    @Excel(name = "物料描述", width = 40)
    private String itemDescription;
    private String workOrderType;
    @Excel(name = "工单状态", width = 10, readConverterExp = "10000=已取消,10001=已关闭,10002=已完成,10003=暂挂,10004=已发放,10005=未发放")
    private Long workOrderStatusId;
    private Long inventoryItemId;
    @Excel(name = "计划开工数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal plannedStartQuantity;
    @Excel(name = "完工数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal completedQuantity;
    @Excel(name = "工作定义", width = 10)
    private String workDefName;
    @Excel(name = "工作定义描述", width = 20)
    private String workDefNameDescription;
    private String uomCode;
    private String complSubinventoryCode;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date plannedStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date plannedCompletionDate;
    private String workOrderDescription;
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate;
    private String lastUpdatedBy;
    private Long workDefinitionId;
    private String workOrderPriority;
    private String xianBieFlag;

    public String getXianBieFlag() {
        return xianBieFlag;
    }

    public void setXianBieFlag(String xianBieFlag) {
        this.xianBieFlag = xianBieFlag;
    }

    public String getWorkOrderPriority() {
        return workOrderPriority;
    }

    public void setWorkOrderPriority(String workOrderPriority) {
        this.workOrderPriority = workOrderPriority;
    }

    public String getWorkDefName() {
        return workDefName;
    }

    public void setWorkDefName(String workDefName) {
        this.workDefName = workDefName;
    }

    public String getWorkDefNameDescription() {
        return workDefNameDescription;
    }

    public void setWorkDefNameDescription(String workDefNameDescription) {
        this.workDefNameDescription = workDefNameDescription;
    }

    public Long getWorkDefinitionId() {
        return workDefinitionId;
    }

    public void setWorkDefinitionId(Long workDefinitionId) {
        this.workDefinitionId = workDefinitionId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(String workOrderType) {
        this.workOrderType = workOrderType;
    }

    public Long getWorkOrderStatusId() {
        return workOrderStatusId;
    }

    public void setWorkOrderStatusId(Long workOrderStatusId) {
        this.workOrderStatusId = workOrderStatusId;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public BigDecimal getPlannedStartQuantity() {
        return plannedStartQuantity;
    }

    public void setPlannedStartQuantity(BigDecimal plannedStartQuantity) {
        this.plannedStartQuantity = plannedStartQuantity;
    }

    public BigDecimal getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(BigDecimal completedQuantity) {
        this.completedQuantity = completedQuantity;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public String getComplSubinventoryCode() {
        return complSubinventoryCode;
    }

    public void setComplSubinventoryCode(String complSubinventoryCode) {
        this.complSubinventoryCode = complSubinventoryCode;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedCompletionDate() {
        return plannedCompletionDate;
    }

    public void setPlannedCompletionDate(Date plannedCompletionDate) {
        this.plannedCompletionDate = plannedCompletionDate;
    }

    public String getWorkOrderDescription() {
        return workOrderDescription;
    }

    public void setWorkOrderDescription(String workOrderDescription) {
        this.workOrderDescription = workOrderDescription;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
