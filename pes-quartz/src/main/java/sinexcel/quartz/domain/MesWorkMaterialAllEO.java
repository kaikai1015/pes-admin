package sinexcel.quartz.domain;


import java.math.BigDecimal;
import java.util.Date;

public class MesWorkMaterialAllEO {
    /** 工单ID */
    private Long workOrderId;

    /** 工单号 */
    private String workOrderNumber;

    /** 工序号（默认10） */
    private Integer operationSequence;

    /** 类型 */
    private String transactionType;

    /** 物料编码 */
    private String itemNumber;

    /** 物料ID */
    private Long inventoryItemId;

    /** 组织ID */
    private Long organizationId;

    /** 组织 */
    private String organizationCode;

    /** 交易数量 */
    private BigDecimal transactionQuantity;

    /** 交易日期 */
    private Date transactionDate;

    /** 仓库 */
    private String subinventoryCode;

    /** 最后同步日期 */
    private Date lastUpdateDate;

    /** ERP回传标识（0未回写，1回写成功，2回写失败） */
    private String erpFlag;

    /** erp回写时间 */
    private Date erpFlagDate;

    /** 工单超耗ID */
    private Long materialId;

    /** 最后同步时间 */
    private String startUpdateDate;

    /** 最后同步时间 */
    private String endUpdateDate;

    private String uomCode;

    private String remark;

    private Integer lotControlCode;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
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

    public Integer getOperationSequence() {
        return operationSequence;
    }

    public void setOperationSequence(Integer operationSequence) {
        this.operationSequence = operationSequence;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public BigDecimal getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(BigDecimal transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
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

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
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
