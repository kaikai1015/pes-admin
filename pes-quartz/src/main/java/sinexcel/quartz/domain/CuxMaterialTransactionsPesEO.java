package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CuxMaterialTransactionsPesEO {

    private String organizationCode;

    /**
     * $column.columnComment
     */
    private String workOrderNumber;

    /**
     * 物料编码
     */
    private String itemNumber;

    /**
     * 需求数量
     */
    private BigDecimal quantity;

    /**
     * 已发数量
     */
    private BigDecimal issuedQuantity;

    /**
     * 可发数量
     */
    private BigDecimal tranctQty;

    /**
     * 库存数量
     */
    private BigDecimal onhandQuantity;

    /**
     * 单位
     */
    private String transactionUomCode;

    /**
     * 仓库
     */
    private String subinventoryCode;

    /**
     * 批次
     */
    private String lotNumber;

    /**
     * $column.columnComment
     */
    private Date lastUpdateDate;

    /**
     * 回写标识
     */
    private String countId;

    /**
     * 物料描述
     */
    private String description;

    /**
     * 工单号(数量)
     */
    private String workQuantity;

    /**
     * $column.columnComment
     */
    private Integer id;

    private BigDecimal planStartQuantity;

    public BigDecimal getPlanStartQuantity() {
        return planStartQuantity;
    }

    public void setPlanStartQuantity(BigDecimal planStartQuantity) {
        this.planStartQuantity = planStartQuantity;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
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

    public BigDecimal getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(BigDecimal issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public BigDecimal getTranctQty() {
        return tranctQty;
    }

    public void setTranctQty(BigDecimal tranctQty) {
        this.tranctQty = tranctQty;
    }

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public String getTransactionUomCode() {
        return transactionUomCode;
    }

    public void setTransactionUomCode(String transactionUomCode) {
        this.transactionUomCode = transactionUomCode;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getCountId() {
        return countId;
    }

    public void setCountId(String countId) {
        this.countId = countId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkQuantity() {
        return workQuantity;
    }

    public void setWorkQuantity(String workQuantity) {
        this.workQuantity = workQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
