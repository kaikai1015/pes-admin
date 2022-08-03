package sinexcel.quartz.domain;

import sinexcel.common.annotation.Excel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MesSubinventoryTransferAllEO implements Serializable {

    @Excel(name = "主键ID", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private Long transferId;

    /** 粗库组织ID */
    private Long fromOrganizationId;
    private Long toOrganizationId;

    /** 物料ID */
    private Long inventoryItemId;

    /** 物料编码 */
    @Excel(name = "物料编码", width = 10,type = Excel.Type.EXPORT)
    private String itemNumber;

    /** 原仓库 */
    @Excel(name = "原仓库", width = 10,type = Excel.Type.EXPORT)
    private String subinventoryCode;

    /** 调拨数量 */
    @Excel(name = "调拨数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal quantity;

    @Excel(name = "当前库存", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal onhandQuantity;
    @Excel(name = "差异数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal chayiQuantity;

    /** 调拨日期 */
    private Date transactionDate;

    /** 调拨转移仓库 */
    @Excel(name = "调拨转移仓库", width = 10,type = Excel.Type.EXPORT)
    private String transferSubinventoryCode;

    /** 单位 */
    @Excel(name = "单位", width = 10,type = Excel.Type.EXPORT)
    private String uomCode;

    @Excel(name = "MES主键", width = 30,type = Excel.Type.EXPORT)
    private String remart;

    /** 类型 */
    private Integer transactionTypeId;

    /** erp回写标识(0未开始，1成功，2失败) */
    private String erpFlag;

    /** erp回写时间 */
    private Date erpFlagDate;

    /** 最后同步时间 */
    private Date lastUpdateDate;

    /** 最后同步时间 */
    private String startUpdateDate;

    /** 最后同步时间 */
    private String endUpdateDate;

    private Integer lotControlCode;

    private String errorInfor;
    private String workOrderNumber;
    private Long workOrderId;
    private String organizationCode;
    private BigDecimal overQuantity;

    private BigDecimal transferedQuantity;

    private String sourceHeaderReference;
    private String transactionType;

    public String getSourceHeaderReference() {
        return sourceHeaderReference;
    }

    public void setSourceHeaderReference(String sourceHeaderReference) {
        this.sourceHeaderReference = sourceHeaderReference;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getOverQuantity() {
        return overQuantity;
    }

    public void setOverQuantity(BigDecimal overQuantity) {
        this.overQuantity = overQuantity;
    }

    public BigDecimal getTransferedQuantity() {
        return transferedQuantity;
    }

    public void setTransferedQuantity(BigDecimal transferedQuantity) {
        this.transferedQuantity = transferedQuantity;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
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

    public BigDecimal getChayiQuantity() {
        return chayiQuantity;
    }

    public void setChayiQuantity(BigDecimal chayiQuantity) {
        this.chayiQuantity = chayiQuantity;
    }

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public String getErrorInfor() {
        return errorInfor;
    }

    public void setErrorInfor(String errorInfor) {
        this.errorInfor = errorInfor;
    }

    public Integer getLotControlCode() {
        return lotControlCode;
    }

    public void setLotControlCode(Integer lotControlCode) {
        this.lotControlCode = lotControlCode;
    }

    public String getRemart() {
        return remart;
    }

    public void setRemart(String remart) {
        this.remart = remart;
    }

    public Long getFromOrganizationId() {
        return fromOrganizationId;
    }

    public void setFromOrganizationId(Long fromOrganizationId) {
        this.fromOrganizationId = fromOrganizationId;
    }

    public Long getToOrganizationId() {
        return toOrganizationId;
    }

    public void setToOrganizationId(Long toOrganizationId) {
        this.toOrganizationId = toOrganizationId;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransferSubinventoryCode() {
        return transferSubinventoryCode;
    }

    public void setTransferSubinventoryCode(String transferSubinventoryCode) {
        this.transferSubinventoryCode = transferSubinventoryCode;
    }

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getErpFlag() {
        return erpFlag;
    }

    public void setErpFlag(String erpFlag) {
        this.erpFlag = erpFlag;
    }

    public Date getErpFlagDate() {
        return erpFlagDate;
    }

    public void setErpFlagDate(Date erpFlagDate) {
        this.erpFlagDate = erpFlagDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public String getStartUpdateDate() {
        return startUpdateDate;
    }

    public void setStartUpdateDate(String startUpdateDate) {
        this.startUpdateDate = startUpdateDate;
    }

    public String getEndUpdateDate() {
        return endUpdateDate;
    }

    public void setEndUpdateDate(String endUpdateDate) {
        this.endUpdateDate = endUpdateDate;
    }
}
