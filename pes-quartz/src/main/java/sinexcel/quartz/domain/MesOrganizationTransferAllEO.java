package sinexcel.quartz.domain;

import java.util.Date;

public class MesOrganizationTransferAllEO {
    /** 物料ID */
    private Long inventoryItemId;

    /** 物料编码 */
    private String itemNumber;

    /** 库存组织ID */
    private Long organizationId;

    /** 交易数量 */
    private Long transactionQuantity;

    /** 单位 */
    private String transactionUom;

    /** 交易日期 */
    private Date transactionDate;

    /** 仓库 */
    private String subinventoryCode;

    /** 交易类型组织间转移 */
    private Long transactionTypeId;

    /** 是否当前成本 */
    private String useCurrentCost;

    /** 转移仓库 */
    private String transferSubinventory;

    /** 转移组织ID */
    private Long transferOganizationId;

    /** 最后同步时间 */
    private Date lastUpdateDate;

    /** ERP回传标识（0未回写，1回写成功，2回写失败） */
    private String erpFlag;

    /** erp回写时间 */
    private Date erpFlagDate;

    /** 组织间转移ID */
    private Long orgTransferId;

    /** 最后同步时间 */
    private String startUpdateDate;

    /** 最后同步时间 */
    private String endUpdateDate;

    private Integer lotControlCode;

    private String remark;

    private String errorInfor;

    public String getErrorInfor() {
        return errorInfor;
    }

    public void setErrorInfor(String errorInfor) {
        this.errorInfor = errorInfor;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getUseCurrentCost() {
        return useCurrentCost;
    }

    public void setUseCurrentCost(String useCurrentCost) {
        this.useCurrentCost = useCurrentCost;
    }

    public String getTransferSubinventory() {
        return transferSubinventory;
    }

    public void setTransferSubinventory(String transferSubinventory) {
        this.transferSubinventory = transferSubinventory;
    }

    public Long getTransferOganizationId() {
        return transferOganizationId;
    }

    public void setTransferOganizationId(Long transferOganizationId) {
        this.transferOganizationId = transferOganizationId;
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

    public Long getOrgTransferId() {
        return orgTransferId;
    }

    public void setOrgTransferId(Long orgTransferId) {
        this.orgTransferId = orgTransferId;
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

    public Integer getLotControlCode() {
        return lotControlCode;
    }

    public void setLotControlCode(Integer lotControlCode) {
        this.lotControlCode = lotControlCode;
    }
}
