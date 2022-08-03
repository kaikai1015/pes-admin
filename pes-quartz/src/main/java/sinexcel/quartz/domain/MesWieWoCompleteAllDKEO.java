package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class MesWieWoCompleteAllDKEO {
    /** 库存组织ID */
    private Long organizationId;

    /** 完工数量 */
    private BigDecimal transactionQuantity;

    /** 日期 */
    private Date transactionDate;

    /** 完工仓库 */
    private String subinventoryCode;

    /** 工单ID */
    private Long workOrderId;

    /** 工单编码 */
    private String workOrderNumber;

    /** 最后同步时间 */
    private Date lastUpdateDate;

    /** ERP回传标识（0未回写，1回写成功，2回写失败） */
    private String erpFlag;

    /** erp回写时间 */
    private Date erpFlagDate;

    /** 报工完工主键ID */
    private Long woCompleteId;

    private String remark;

    /** 最后同步时间 */
    private String startUpdateDate;

    /** 最后同步时间 */
    private String endUpdateDate;

    /** 组织 */
    private String organizationCode;

    private Integer woOperationSequenceNumber;

    private Integer lotControlCode;

    /** 单位 */
    private String uomCode;

    private String itemNumber;

    private Long inventoryItemId;

    private String errorInfor;

    private Long wieLineId;

    private BigDecimal completedQuantity;
    private BigDecimal issuedQuantity;
    private BigDecimal requiredQuantity;
    private String itemWorkNameFlag;
    private String basisType;
    private BigDecimal plannedStartQuantity;
    private BigDecimal chayiQuantity;

    public BigDecimal getChayiQuantity() {
        return chayiQuantity;
    }

    public void setChayiQuantity(BigDecimal chayiQuantity) {
        this.chayiQuantity = chayiQuantity;
    }

    public BigDecimal getPlannedStartQuantity() {
        return plannedStartQuantity;
    }

    public void setPlannedStartQuantity(BigDecimal plannedStartQuantity) {
        this.plannedStartQuantity = plannedStartQuantity;
    }

    public String getBasisType() {
        return basisType;
    }

    public void setBasisType(String basisType) {
        this.basisType = basisType;
    }

    public String getItemWorkNameFlag() {
        return itemWorkNameFlag;
    }

    public void setItemWorkNameFlag(String itemWorkNameFlag) {
        this.itemWorkNameFlag = itemWorkNameFlag;
    }

    public BigDecimal getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(BigDecimal requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }


    public BigDecimal getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(BigDecimal completedQuantity) {
        this.completedQuantity = completedQuantity;
    }

    public BigDecimal getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(BigDecimal issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public Long getWieLineId() {
        return wieLineId;
    }

    public void setWieLineId(Long wieLineId) {
        this.wieLineId = wieLineId;
    }

    public String getErrorInfor() {
        return errorInfor;
    }

    public void setErrorInfor(String errorInfor) {
        this.errorInfor = errorInfor;
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

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public Integer getLotControlCode() {
        return lotControlCode;
    }

    public void setLotControlCode(Integer lotControlCode) {
        this.lotControlCode = lotControlCode;
    }

    public Integer getWoOperationSequenceNumber() {
        return woOperationSequenceNumber;
    }

    public void setWoOperationSequenceNumber(Integer woOperationSequenceNumber) {
        this.woOperationSequenceNumber = woOperationSequenceNumber;
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


    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
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

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getWoCompleteId() {
        return woCompleteId;
    }

    public void setWoCompleteId(Long woCompleteId) {
        this.woCompleteId = woCompleteId;
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
}
