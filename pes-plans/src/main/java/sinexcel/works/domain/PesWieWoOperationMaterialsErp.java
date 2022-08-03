package sinexcel.works.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

/**
 * pes自定义工单单身数据对象 pes_wie_wo_operation_materials_erp
 * 
 * @author Zhang Kai
 * @date 2021-11-26
 */
public class PesWieWoOperationMaterialsErp
{

    /** $column.columnComment */
    private Long pesWorkOrderId;

    /** $column.columnComment */
    private Long pesWorkOrderOperationId;

    /** $column.columnComment */
    private Long workOrderId;

    /** 库存组织 */
    private Long organizationId;

    /** $column.columnComment */
    private Long workOrderOperationMaterialId;

    @Excel(name = "客户", width = 20,type = Excel.Type.EXPORT)
    private String customerName;
    @Excel(name = "BU产品线", width = 10,type = Excel.Type.EXPORT)
    private String chanPingXian;
    @Excel(name = "订单号", width = 10,type = Excel.Type.EXPORT)
    private String orderNumber;
    @Excel(name = "订单行号",width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private Integer orderNumberLine;
    @Excel(name = "合同号", width = 20,type = Excel.Type.EXPORT)
    private String contractNumber;
    @Excel(name = "工作中心",width = 10,readConverterExp="1=仓库工作中心,2=委外工作中心,3=惠州电源工作中心,4=内部代加工工作中心",type = Excel.Type.EXPORT)
    private Integer workCenterCode;
    @Excel(name = "工单号", width = 15,type = Excel.Type.EXPORT)
    private String workOrderNumber;
    @Excel(name = "工单状态",width = 10,readConverterExp="10000=已取消,10001=已关闭,10002=已完成,10003=暂挂,10004=已发放,10005=未发放,10006=已删除,10007=未生效",type = Excel.Type.EXPORT)
    private Integer workOrderStatusId;

    public Date getStatusChangeDate() {
        return statusChangeDate;
    }

    public void setStatusChangeDate(Date statusChangeDate) {
        this.statusChangeDate = statusChangeDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "状态时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss",type = Excel.Type.EXPORT)
    private Date statusChangeDate;
    @Excel(name = "成品编码", width = 10,type = Excel.Type.EXPORT)
    private String pItemNumber;
    @Excel(name = "成品描述", width = 30,type = Excel.Type.EXPORT)
    private String pItemDescription;
//    @Excel(name = "成品单位成本",width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
//    private BigDecimal pSumUnitCost;
    @Excel(name = "开工数量",width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal plannedStartQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开工日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date plannedStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完工日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date plannedCompletionDate;
    @Excel(name = "计划员", width = 10,type = Excel.Type.EXPORT)
    private String planName;

    /** 序号 */
    @Excel(name = "序号",width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private Integer materialSequenceNumber;

    /** 元件编码 */
    @Excel(name = "元件编码", width = 10,type = Excel.Type.ALL)
    private String itemNumber;

    /** 元件描述 */
    @Excel(name = "元件描述", width = 30,type = Excel.Type.EXPORT)
    private String itemDescription;

//    @Excel(name = "组件单位成本",width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
//    private BigDecimal subSumUnitCost;

    /** 需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date requiredDate;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** BOM用量 */
    @Excel(name = "用量",width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal quantityPerProduct;

    /** 需求数量 */
    @Excel(name = "需求数量",width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal requiredQuantity;

    @Excel(name = "已调拨数量",width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal transferedQuantity;

    /** 已发数量 */
    @Excel(name = "已扣数量",width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal issuedQuantity;

    @Excel(name = "超领数量",width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal overQuantity;

    /** 损耗数量 */
    @Excel(name = "损耗数量",width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal sunHaoQuantity;

    /** 单位 */
    @Excel(name = "单位", width = 10,type = Excel.Type.EXPORT)
    private String uomCode;

    /** 物料类型 */
    @Excel(name = "物料类型",width = 10,type = Excel.Type.EXPORT)
    private String itemType;

    /** 基准 */
    @Excel(name = "基准", width = 10,readConverterExp = "1=变动,2=固定",type = Excel.Type.EXPORT)
    private String basisType;


    /** 供应类型 */
    @Excel(name = "供应类型", width = 10,type = Excel.Type.EXPORT)
    private String supplyType;

    /** $column.columnComment */
    private Long workOrderOperationId;


    /** 工艺属性 */
    @Excel(name = "工艺属性",width = 10,type = Excel.Type.EXPORT,readConverterExp = "1=贴片,2=插件,3=装配,4=辅料,5=SMT,6=DIP,7=发料,8=备品,9=线材,10=机柜")
    private String techniquesCode;

    /** $column.columnComment */
    private Long newInventoryItemId;

    /** 替代物料 */
    @Excel(name = "替代物料", width = 10,type = Excel.Type.EXPORT)
    private String newItemNumber;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */

    private Integer level;
    private Integer erpType;
    private String createBy;
    @Excel(name = "供应仓", width = 10,type = Excel.Type.EXPORT)
    private String subinventoryCode;
    @Excel(name = "备注", width = 20,type = Excel.Type.EXPORT)
    private String remark;
    private String erpFlag;
    private Integer countFlag;
    private String activeCode;
    private Long pInventoryItemId;
    private Long workSubId;
    private BigDecimal newPercentQuantity;
    private String newItemDescription;
    private Integer maxMaterialSequenceNumber;
    private BigDecimal onhandQuantity;
    private String gongSubinventoryCode;
    private String organizationCode;
    private Integer lotControlCode;
    private BigDecimal diffQuantity;
    private BigDecimal issuedDiffQuantity;
    private String plannedStartDateMonths;
    @Excel(name = "行ID",width = 10,cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private Long pesWorkOrderMaterialId;

    public String getChanPingXian() {
        return chanPingXian;
    }

    public void setChanPingXian(String chanPingXian) {
        this.chanPingXian = chanPingXian;
    }

    public String getPlannedStartDateMonths() {
        return plannedStartDateMonths;
    }

    public void setPlannedStartDateMonths(String plannedStartDateMonths) {
        this.plannedStartDateMonths = plannedStartDateMonths;
    }

    public BigDecimal getIssuedDiffQuantity() {
        return issuedDiffQuantity;
    }

    public void setIssuedDiffQuantity(BigDecimal issuedDiffQuantity) {
        this.issuedDiffQuantity = issuedDiffQuantity;
    }

    public BigDecimal getOverQuantity() {
        return overQuantity;
    }

    public void setOverQuantity(BigDecimal overQuantity) {
        this.overQuantity = overQuantity;
    }

    public BigDecimal getDiffQuantity() {
        return diffQuantity;
    }

    public void setDiffQuantity(BigDecimal diffQuantity) {
        this.diffQuantity = diffQuantity;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public Integer getLotControlCode() {
        return lotControlCode;
    }

    public void setLotControlCode(Integer lotControlCode) {
        this.lotControlCode = lotControlCode;
    }
    public Date getPlannedCompletionDate() {
        return plannedCompletionDate;
    }

    public void setPlannedCompletionDate(Date plannedCompletionDate) {
        this.plannedCompletionDate = plannedCompletionDate;
    }

    public String getGongSubinventoryCode() {
        return gongSubinventoryCode;
    }

    public void setGongSubinventoryCode(String gongSubinventoryCode) {
        this.gongSubinventoryCode = gongSubinventoryCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderNumberLine() {
        return orderNumberLine;
    }

    public void setOrderNumberLine(Integer orderNumberLine) {
        this.orderNumberLine = orderNumberLine;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public String getpItemNumber() {
        return pItemNumber;
    }

    public void setpItemNumber(String pItemNumber) {
        this.pItemNumber = pItemNumber;
    }

    public String getpItemDescription() {
        return pItemDescription;
    }

    public void setpItemDescription(String pItemDescription) {
        this.pItemDescription = pItemDescription;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public BigDecimal getPlannedStartQuantity() {
        return plannedStartQuantity;
    }

    public void setPlannedStartQuantity(BigDecimal plannedStartQuantity) {
        this.plannedStartQuantity = plannedStartQuantity;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }


    public Integer getWorkCenterCode() {
        return workCenterCode;
    }

    public void setWorkCenterCode(Integer workCenterCode) {
        this.workCenterCode = workCenterCode;
    }

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public Integer getMaxMaterialSequenceNumber() {
        return maxMaterialSequenceNumber;
    }

    public void setMaxMaterialSequenceNumber(Integer maxMaterialSequenceNumber) {
        this.maxMaterialSequenceNumber = maxMaterialSequenceNumber;
    }

    public Long getWorkSubId() {
        return workSubId;
    }

    public void setWorkSubId(Long workSubId) {
        this.workSubId = workSubId;
    }

    public BigDecimal getNewPercentQuantity() {
        return newPercentQuantity;
    }

    public void setNewPercentQuantity(BigDecimal newPercentQuantity) {
        this.newPercentQuantity = newPercentQuantity;
    }

    public String getNewItemDescription() {
        return newItemDescription;
    }

    public void setNewItemDescription(String newItemDescription) {
        this.newItemDescription = newItemDescription;
    }

    public Long getpInventoryItemId() {
        return pInventoryItemId;
    }

    public void setpInventoryItemId(Long pInventoryItemId) {
        this.pInventoryItemId = pInventoryItemId;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public Integer getWorkOrderStatusId() {
        return workOrderStatusId;
    }

    public void setWorkOrderStatusId(Integer workOrderStatusId) {
        this.workOrderStatusId = workOrderStatusId;
    }

    public Integer getCountFlag() {
        return countFlag;
    }

    public void setCountFlag(Integer countFlag) {
        this.countFlag = countFlag;
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

    public BigDecimal getTransferedQuantity() {
        return transferedQuantity;
    }

    public void setTransferedQuantity(BigDecimal transferedQuantity) {
        this.transferedQuantity = transferedQuantity;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setPesWorkOrderId(Long pesWorkOrderId) 
    {
        this.pesWorkOrderId = pesWorkOrderId;
    }

    public Long getPesWorkOrderId() 
    {
        return pesWorkOrderId;
    }
    public void setPesWorkOrderOperationId(Long pesWorkOrderOperationId) 
    {
        this.pesWorkOrderOperationId = pesWorkOrderOperationId;
    }

    public Long getPesWorkOrderOperationId() 
    {
        return pesWorkOrderOperationId;
    }
    public void setWorkOrderId(Long workOrderId) 
    {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId() 
    {
        return workOrderId;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public Long getWorkOrderOperationMaterialId() {
        return workOrderOperationMaterialId;
    }

    public void setWorkOrderOperationMaterialId(Long workOrderOperationMaterialId) {
        this.workOrderOperationMaterialId = workOrderOperationMaterialId;
    }
    public void setMaterialSequenceNumber(Integer materialSequenceNumber) 
    {
        this.materialSequenceNumber = materialSequenceNumber;
    }

    public Integer getMaterialSequenceNumber() 
    {
        return materialSequenceNumber;
    }
    public void setRequiredDate(Date requiredDate) 
    {
        this.requiredDate = requiredDate;
    }

    public Date getRequiredDate() 
    {
        return requiredDate;
    }
    public void setInventoryItemId(Long inventoryItemId) 
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() 
    {
        return inventoryItemId;
    }
    public void setQuantityPerProduct(BigDecimal quantityPerProduct) 
    {
        this.quantityPerProduct = quantityPerProduct;
    }

    public BigDecimal getQuantityPerProduct() 
    {
        return quantityPerProduct;
    }
    public void setItemType(String itemType) 
    {
        this.itemType = itemType;
    }

    public String getItemType() 
    {
        return itemType;
    }
    public void setBasisType(String basisType)
    {
        this.basisType = basisType;
    }

    public String getBasisType()
    {
        return basisType;
    }
    public void setSupplyType(String supplyType) 
    {
        this.supplyType = supplyType;
    }

    public String getSupplyType() 
    {
        return supplyType;
    }
    public void setWorkOrderOperationId(Long workOrderOperationId) 
    {
        this.workOrderOperationId = workOrderOperationId;
    }

    public Long getWorkOrderOperationId() 
    {
        return workOrderOperationId;
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
    public void setRequiredQuantity(BigDecimal requiredQuantity) 
    {
        this.requiredQuantity = requiredQuantity;
    }

    public BigDecimal getRequiredQuantity() 
    {
        return requiredQuantity;
    }
    public void setUomCode(String uomCode) 
    {
        this.uomCode = uomCode;
    }

    public String getUomCode() 
    {
        return uomCode;
    }
    public void setIssuedQuantity(BigDecimal issuedQuantity) 
    {
        this.issuedQuantity = issuedQuantity;
    }

    public BigDecimal getIssuedQuantity() 
    {
        return issuedQuantity;
    }
    public void setSunHaoQuantity(BigDecimal sunHaoQuantity) 
    {
        this.sunHaoQuantity = sunHaoQuantity;
    }

    public BigDecimal getSunHaoQuantity() 
    {
        return sunHaoQuantity;
    }
    public void setTechniquesCode(String techniquesCode) 
    {
        this.techniquesCode = techniquesCode;
    }

    public String getTechniquesCode() 
    {
        return techniquesCode;
    }
    public void setNewInventoryItemId(Long newInventoryItemId) 
    {
        this.newInventoryItemId = newInventoryItemId;
    }

    public Long getNewInventoryItemId() 
    {
        return newInventoryItemId;
    }
    public void setNewItemNumber(String newItemNumber) 
    {
        this.newItemNumber = newItemNumber;
    }

    public String getNewItemNumber() 
    {
        return newItemNumber;
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
    public void setPesWorkOrderMaterialId(Long pesWorkOrderMaterialId) 
    {
        this.pesWorkOrderMaterialId = pesWorkOrderMaterialId;
    }

    public Long getPesWorkOrderMaterialId() 
    {
        return pesWorkOrderMaterialId;
    }

}
