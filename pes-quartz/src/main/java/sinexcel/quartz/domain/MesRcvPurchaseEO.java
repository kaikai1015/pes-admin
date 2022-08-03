package sinexcel.quartz.domain;

import sinexcel.common.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

public class MesRcvPurchaseEO{

    /** 库存组织ID */
    private Long organizationId;

    /** 供应商ID */
    private Long vendorId;

    /** 业务单元ID */
    private Long buId;

    /** 入库人ID */
    private Long employeeId;

    /** PO编号 */
    @Excel(name = "PO编号", width = 10)
    private String documentNumber;

    /** 采购订单ID */
    private Long documentId;

    /** 行号 */
    @Excel(name = "行号", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Integer documentLineNumber;

    @Excel(name = "行状态", width = 15)
    private String lineStatus;

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    /** 行ID */
    private Long documentLineId;

    /** 物料ID */
    private Long inventoryItemId;

    /** 物料编码 */
    @Excel(name = "物料编码", width = 15)
    private String itemNumber;

    public BigDecimal getLineQuantity() {
        return lineQuantity;
    }

    public void setLineQuantity(BigDecimal lineQuantity) {
        this.lineQuantity = lineQuantity;
    }

    public BigDecimal getDeliverQuantity() {
        return deliverQuantity;
    }

    public void setDeliverQuantity(BigDecimal deliverQuantity) {
        this.deliverQuantity = deliverQuantity;
    }

    @Excel(name = "PO行数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal lineQuantity;

    @Excel(name = "PO入库数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal deliverQuantity;

    /** 数量 */
    @Excel(name = "数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal quantity;

    /** 单位 */
    private String uomCode;

    /** 法人实体 */
    private Long legelEntiytyId;

    /** 仓库 */
    @Excel(name = "仓库", width = 15)
    private String subinventoryCode;

    /** ERP回传标识 */
    private String erpFlag;

    /** 主键ID */
    private Long rcvId;

    /** MES主键 */
    @Excel(name = "MES主键", width = 15)
    private String remart;

    /** 最后同步时间 */
    private String startUpdateDate;

    /** 最后同步时间 */
    private String endUpdateDate;

    /** 最后同步时间 */
    private Date lastUpdateDate;

    private Integer lotControlCode;

    private String errorInfor;

    private String erpFlagWork;
    @Excel(name = "工单号", width = 15)
    private String workOrderNumber;

    public String getbItemNumber() {
        return bItemNumber;
    }

    public void setbItemNumber(String bItemNumber) {
        this.bItemNumber = bItemNumber;
    }

    @Excel(name = "B料号", width = 15)
    private String bItemNumber;

    public String getErpFlagWork() {
        return erpFlagWork;
    }

    public void setErpFlagWork(String erpFlagWork) {
        this.erpFlagWork = erpFlagWork;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
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

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
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

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getBuId() {
        return buId;
    }

    public void setBuId(Long buId) {
        this.buId = buId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public Long getLegelEntiytyId() {
        return legelEntiytyId;
    }

    public void setLegelEntiytyId(Long legelEntiytyId) {
        this.legelEntiytyId = legelEntiytyId;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public String getErpFlag() {
        return erpFlag;
    }

    public void setErpFlag(String erpFlag) {
        this.erpFlag = erpFlag;
    }

    public Long getRcvId() {
        return rcvId;
    }

    public void setRcvId(Long rcvId) {
        this.rcvId = rcvId;
    }

    public String getRemart() {
        return remart;
    }

    public void setRemart(String remart) {
        this.remart = remart;
    }
}
