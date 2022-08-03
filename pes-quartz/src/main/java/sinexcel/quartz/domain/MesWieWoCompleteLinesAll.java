package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

/**
 * 工单单身扣料明细对象 mes_wie_wo_complete_lines_all
 *
 * @author Zhang Kai
 * @date 2021-08-26
 */
public class MesWieWoCompleteLinesAll
{

    /** 主键ID */
    @Excel(name = "主键ID", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private Long wieLineId;

    /** 工单ID */
    private Long workOrderId;

    /** 工单号 */
    @Excel(name = "工单号", width = 10,type = Excel.Type.EXPORT)
    private String workOrderNumber;

    @Excel(name = "计划开工数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal plannedStartQuantity;
    @Excel(name = "ERP已入库数", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal completedQuantity;
    @Excel(name = "本次入库数", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal workTransactionQuantity;

    /** 库存组织 */
    private Long organizationId;

    /** 单身物料 */
    @Excel(name = "单身物料", width = 10,type = Excel.Type.EXPORT)
    private String itemNumber;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** 单位用量 */
    @Excel(name = "单位用量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal quantityPerProduct;
    @Excel(name = "需求数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal requiredQuantity;
    @Excel(name = "已领数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal issuedQuantity;
    @Excel(name = "期初数据", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal qichuQuantity;
    @Excel(name = "已调拨数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal transferQuantity;
    @Excel(name = "超领数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal suohaoQuantity;
    /** 子库存 */
    @Excel(name = "子库存", width = 10,type = Excel.Type.EXPORT)
    private String subinventoryCode;
    /** 倒扣数量 */
    @Excel(name = "倒扣数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal transactionQuantity;
    @Excel(name = "当前库存", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal onhandQuantity;
    @Excel(name = "差异数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal chayiQuantity;
    @Excel(name = "扣账类型", width = 10,type = Excel.Type.EXPORT)
    private String basisType;
    @Excel(name = "工艺属性", width = 10,type = Excel.Type.EXPORT)
    private String itemWorkName;
    /** 单位 */
    @Excel(name = "单位", width = 10,type = Excel.Type.EXPORT)
    private String uomCode;
    @Excel(name = "MES主键", width = 20,type = Excel.Type.EXPORT)
    private String remark;

    /** ERP回传标识 */
    private String erpFlag;

    /** $column.columnComment */
    private Date erpFlagDate;

    /** 最后同步时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateDate;



    /** 错误日志 */
    private String errorInfor;
    private String headerErpFlag;

    public String getHeaderErpFlag() {
        return headerErpFlag;
    }

    public void setHeaderErpFlag(String headerErpFlag) {
        this.headerErpFlag = headerErpFlag;
    }


    public BigDecimal getSuohaoQuantity() {
        return suohaoQuantity;
    }

    public void setSuohaoQuantity(BigDecimal suohaoQuantity) {
        this.suohaoQuantity = suohaoQuantity;
    }

    public String getItemWorkName() {
        return itemWorkName;
    }

    public void setItemWorkName(String itemWorkName) {
        this.itemWorkName = itemWorkName;
    }

    public String getBasisType() {
        return basisType;
    }

    public void setBasisType(String basisType) {
        this.basisType = basisType;
    }

    public BigDecimal getQichuQuantity() {
        return qichuQuantity;
    }

    public void setQichuQuantity(BigDecimal qichuQuantity) {
        this.qichuQuantity = qichuQuantity;
    }

    public BigDecimal getTransferQuantity() {
        return transferQuantity;
    }

    public void setTransferQuantity(BigDecimal transferQuantity) {
        this.transferQuantity = transferQuantity;
    }

    public BigDecimal getChayiQuantity() {
        return chayiQuantity;
    }

    public void setChayiQuantity(BigDecimal chayiQuantity) {
        this.chayiQuantity = chayiQuantity;
    }

    public BigDecimal getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(BigDecimal requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(BigDecimal issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public BigDecimal getWorkTransactionQuantity() {
        return workTransactionQuantity;
    }

    public void setWorkTransactionQuantity(BigDecimal workTransactionQuantity) {
        this.workTransactionQuantity = workTransactionQuantity;
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
    public void setOrganizationId(Long organizationId)
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId()
    {
        return organizationId;
    }
    public void setItemNumber(String itemNumber)
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber()
    {
        return itemNumber;
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
    public void setErpFlag(String erpFlag)
    {
        this.erpFlag = erpFlag;
    }

    public String getErpFlag()
    {
        return erpFlag;
    }
    public void setErpFlagDate(Date erpFlagDate)
    {
        this.erpFlagDate = erpFlagDate;
    }

    public Date getErpFlagDate()
    {
        return erpFlagDate;
    }
    public void setLastUpdateDate(Date lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate()
    {
        return lastUpdateDate;
    }
    public void setWieLineId(Long wieLineId)
    {
        this.wieLineId = wieLineId;
    }

    public Long getWieLineId()
    {
        return wieLineId;
    }
    public void setUomCode(String uomCode)
    {
        this.uomCode = uomCode;
    }

    public String getUomCode()
    {
        return uomCode;
    }
    public void setSubinventoryCode(String subinventoryCode)
    {
        this.subinventoryCode = subinventoryCode;
    }

    public String getSubinventoryCode()
    {
        return subinventoryCode;
    }
    public void setTransactionQuantity(BigDecimal transactionQuantity)
    {
        this.transactionQuantity = transactionQuantity;
    }

    public BigDecimal getTransactionQuantity()
    {
        return transactionQuantity;
    }
    public void setErrorInfor(String errorInfor)
    {
        this.errorInfor = errorInfor;
    }

    public String getErrorInfor()
    {
        return errorInfor;
    }

}
