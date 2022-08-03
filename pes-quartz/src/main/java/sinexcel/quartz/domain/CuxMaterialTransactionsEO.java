package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 工单发料对象 cux_material_transactions
 *
 * @author Zhang Kai
 * @date 2021-03-12
 */
public class CuxMaterialTransactionsEO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 库存组织
     */
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

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setIssuedQuantity(BigDecimal issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public BigDecimal getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setTranctQty(BigDecimal tranctQty) {
        this.tranctQty = tranctQty;
    }

    public BigDecimal getTranctQty() {
        return tranctQty;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setTransactionUomCode(String transactionUomCode) {
        this.transactionUomCode = transactionUomCode;
    }

    public String getTransactionUomCode() {
        return transactionUomCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setCountId(String countId) {
        this.countId = countId;
    }

    public String getCountId() {
        return countId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setWorkQuantity(String workQuantity) {
        this.workQuantity = workQuantity;
    }

    public String getWorkQuantity() {
        return workQuantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("organizationCode", getOrganizationCode())
                .append("workOrderNumber", getWorkOrderNumber())
                .append("itemNumber", getItemNumber())
                .append("quantity", getQuantity())
                .append("issuedQuantity", getIssuedQuantity())
                .append("tranctQty", getTranctQty())
                .append("onhandQuantity", getOnhandQuantity())
                .append("transactionUomCode", getTransactionUomCode())
                .append("subinventoryCode", getSubinventoryCode())
                .append("lotNumber", getLotNumber())
                .append("lastUpdateDate", getLastUpdateDate())
                .append("countId", getCountId())
                .append("description", getDescription())
                .append("workQuantity", getWorkQuantity())
                .append("id", getId())
                .toString();
    }
}