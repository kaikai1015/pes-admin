package sinexcel.quartz.domain;

import java.util.Date;

public class MesRmaOrderDeliverAllEO {

    /** 库存组织ID */
    private Long organizationId;

    /** 物料ID */
    private Long inventoryItemId;

    /** 物料编号 */
    private String itemNumber;

    /** 客户ID */
    private Long customerId;

    /** 业务单元ID */
    private Long buId;

    /** 操作人ID */
    private Long employeeId;

    /** 交易日期 */
    private Date transactionDate;

    /** 交易数量 */
    private Long transactionQuantity;

    /** 单位 */
    private String transactionUom;

    /** 仓库 */
    private String subinventoryCode;

    /** RMA订单 */
    private String rmaOrderNumber;

    /** RMA订单行号 */
    private Long rmaOrderLineNumber;

    /** ERP回传标识（0未回写，1回写成功，2回写失败） */
    private String erpFlag;

    /** erp回写时间 */
    private Date erpFlagDate;

    /** RMA主键 */
    private Long rmaId;

    /** MES主键 */
    private String remark;

    /** 最后同步时间 */
    private String startUpdateDate;

    /** 最后同步时间 */
    private String endUpdateDate;

    /** 最后同步时间 */
    private Date lastUpdateDate;

    private Integer lotControlCode;

    private Long shipmentHeaderId;
    private Long shipmentLineId;

    private String errorInfor;

    public String getErrorInfor() {
        return errorInfor;
    }

    public void setErrorInfor(String errorInfor) {
        this.errorInfor = errorInfor;
    }

    public Long getShipmentHeaderId() {
        return shipmentHeaderId;
    }

    public void setShipmentHeaderId(Long shipmentHeaderId) {
        this.shipmentHeaderId = shipmentHeaderId;
    }

    public Long getShipmentLineId() {
        return shipmentLineId;
    }

    public void setShipmentLineId(Long shipmentLineId) {
        this.shipmentLineId = shipmentLineId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(Long transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public String getTransactionUom() {
        return transactionUom;
    }

    public void setTransactionUom(String transactionUom) {
        this.transactionUom = transactionUom;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public String getRmaOrderNumber() {
        return rmaOrderNumber;
    }

    public void setRmaOrderNumber(String rmaOrderNumber) {
        this.rmaOrderNumber = rmaOrderNumber;
    }

    public Long getRmaOrderLineNumber() {
        return rmaOrderLineNumber;
    }

    public void setRmaOrderLineNumber(Long rmaOrderLineNumber) {
        this.rmaOrderLineNumber = rmaOrderLineNumber;
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

    public Long getRmaId() {
        return rmaId;
    }

    public void setRmaId(Long rmaId) {
        this.rmaId = rmaId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getLotControlCode() {
        return lotControlCode;
    }

    public void setLotControlCode(Integer lotControlCode) {
        this.lotControlCode = lotControlCode;
    }
}
