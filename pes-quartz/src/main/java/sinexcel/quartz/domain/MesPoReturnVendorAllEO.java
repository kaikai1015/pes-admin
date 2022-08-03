package sinexcel.quartz.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

public class MesPoReturnVendorAllEO {

    /** 主键ID */
    @Excel(name = "主键ID", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long returnVendorId;
    /** 入库事务处理ID（DELIVER） */
    @Excel(name = "PO入库ID", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long parentTransactionId;

    /** PO编号 */
    @Excel(name = "PO编号", width = 10)
    private String documentNumber;

    /** 采购订单ID */
    private Long documentId;

    /** 行号 */
    @Excel(name = "行号", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Integer documentLineNumber;

    /** 物料编码 */
    @Excel(name = "物料编码", width = 10)
    private String itemNumber;

    /** 行ID */
    private Long documentLineId;

    /** 库存组织ID */
    private Long organizationId;

    /** 交易数量 */
    @Excel(name = "交易数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal quantity;

    /** 单位 */
    @Excel(name = "单位", width = 10)
    private String unitOfMeasure;

    /** 交易日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "交易日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date transactionDate;

    /** 物料ID */
    private Long inventoryItemId;

    /** 最后同步时间 */
    private Date lastUpdateDate;

    /** ERP回传标识（0未回写，1回写成功，2回写失败） */
    private String erpFlag;

    /** ERP回写时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date erpFlagDate;

    /** 最后同步时间 */
    private String startUpdateDate;

    /** 最后同步时间 */
    private String endUpdateDate;

    private String organizationCode;
    private String erpFlagWork;

    @Excel(name = "MES主键", width = 10)
    private String remark;
    private Integer woOperationSequenceNumber;
    @Excel(name = "工单号", width = 10)
    private String WorkOrderNumber;

    private String subinventoryCode;
    private Integer lotControlCode;

    @Excel(name = "异常信息", width = 20)
    private String errorInfor;

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

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public String getWorkOrderNumber() {
        return WorkOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        WorkOrderNumber = workOrderNumber;
    }

    public Integer getWoOperationSequenceNumber() {
        return woOperationSequenceNumber;
    }

    public void setWoOperationSequenceNumber(Integer woOperationSequenceNumber) {
        this.woOperationSequenceNumber = woOperationSequenceNumber;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getErpFlagWork() {
        return erpFlagWork;
    }

    public void setErpFlagWork(String erpFlagWork) {
        this.erpFlagWork = erpFlagWork;
    }

    public Long getParentTransactionId() {
        return parentTransactionId;
    }

    public void setParentTransactionId(Long parentTransactionId) {
        this.parentTransactionId = parentTransactionId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Integer getDocumentLineNumber() {
        return documentLineNumber;
    }

    public void setDocumentLineNumber(Integer documentLineNumber) {
        this.documentLineNumber = documentLineNumber;
    }

    public Long getDocumentLineId() {
        return documentLineId;
    }

    public void setDocumentLineId(Long documentLineId) {
        this.documentLineId = documentLineId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
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

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
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

    public Long getReturnVendorId() {
        return returnVendorId;
    }

    public void setReturnVendorId(Long returnVendorId) {
        this.returnVendorId = returnVendorId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
