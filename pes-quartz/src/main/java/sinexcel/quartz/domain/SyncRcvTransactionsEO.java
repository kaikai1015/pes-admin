package sinexcel.quartz.domain;

import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PO交易明细对象 sync_rcv_transactions
 *
 * @author Zhang Kai
 * @date 2021-01-05
 */
public class SyncRcvTransactionsEO extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long transactionId;
    private Date lastUpdateDate;
    private String lastUpdatedBy;
    private Date creationDate;
    private String createdBy;
    private String transactionType;
    private Date transactionDate;
    private BigDecimal quantity;
    private String uomCode;
    private Long shipmentHeaderId;
    private Long shipmentLineId;
    private String destinationTypeCode;
    private BigDecimal primaryQuantity;
    private String primaryUomCode;
    private Long employeeId;
    private Long parentTransactionId;
    private Long poHeaderId;
    private Long poLineId;
    private Long poLineLocationId;
    private Long poDistributionId;
    private Long poRevisionNum;
    private BigDecimal poUnitPrice;
    private String currencyCode;
    private String currencyConversionType;
    private BigDecimal currencyConversionRate;
    private Date currencyConversionDate;
    private Long routingHeaderId;
    private Long deliverToPersonId;
    private Long deliverToLocationId;
    private Long vendorId;
    private Long vendorSiteId;
    private Long organizationId;
    private String subinventory;
    private String comments;
    private BigDecimal quantityBilled;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
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

    public String getDestinationTypeCode() {
        return destinationTypeCode;
    }

    public void setDestinationTypeCode(String destinationTypeCode) {
        this.destinationTypeCode = destinationTypeCode;
    }

    public BigDecimal getPrimaryQuantity() {
        return primaryQuantity;
    }

    public void setPrimaryQuantity(BigDecimal primaryQuantity) {
        this.primaryQuantity = primaryQuantity;
    }

    public String getPrimaryUomCode() {
        return primaryUomCode;
    }

    public void setPrimaryUomCode(String primaryUomCode) {
        this.primaryUomCode = primaryUomCode;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getParentTransactionId() {
        return parentTransactionId;
    }

    public void setParentTransactionId(Long parentTransactionId) {
        this.parentTransactionId = parentTransactionId;
    }

    public Long getPoHeaderId() {
        return poHeaderId;
    }

    public void setPoHeaderId(Long poHeaderId) {
        this.poHeaderId = poHeaderId;
    }

    public Long getPoLineId() {
        return poLineId;
    }

    public void setPoLineId(Long poLineId) {
        this.poLineId = poLineId;
    }

    public Long getPoLineLocationId() {
        return poLineLocationId;
    }

    public void setPoLineLocationId(Long poLineLocationId) {
        this.poLineLocationId = poLineLocationId;
    }

    public Long getPoDistributionId() {
        return poDistributionId;
    }

    public void setPoDistributionId(Long poDistributionId) {
        this.poDistributionId = poDistributionId;
    }

    public Long getPoRevisionNum() {
        return poRevisionNum;
    }

    public void setPoRevisionNum(Long poRevisionNum) {
        this.poRevisionNum = poRevisionNum;
    }

    public BigDecimal getPoUnitPrice() {
        return poUnitPrice;
    }

    public void setPoUnitPrice(BigDecimal poUnitPrice) {
        this.poUnitPrice = poUnitPrice;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyConversionType() {
        return currencyConversionType;
    }

    public void setCurrencyConversionType(String currencyConversionType) {
        this.currencyConversionType = currencyConversionType;
    }

    public BigDecimal getCurrencyConversionRate() {
        return currencyConversionRate;
    }

    public void setCurrencyConversionRate(BigDecimal currencyConversionRate) {
        this.currencyConversionRate = currencyConversionRate;
    }

    public Date getCurrencyConversionDate() {
        return currencyConversionDate;
    }

    public void setCurrencyConversionDate(Date currencyConversionDate) {
        this.currencyConversionDate = currencyConversionDate;
    }

    public Long getRoutingHeaderId() {
        return routingHeaderId;
    }

    public void setRoutingHeaderId(Long routingHeaderId) {
        this.routingHeaderId = routingHeaderId;
    }

    public Long getDeliverToPersonId() {
        return deliverToPersonId;
    }

    public void setDeliverToPersonId(Long deliverToPersonId) {
        this.deliverToPersonId = deliverToPersonId;
    }

    public Long getDeliverToLocationId() {
        return deliverToLocationId;
    }

    public void setDeliverToLocationId(Long deliverToLocationId) {
        this.deliverToLocationId = deliverToLocationId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getVendorSiteId() {
        return vendorSiteId;
    }

    public void setVendorSiteId(Long vendorSiteId) {
        this.vendorSiteId = vendorSiteId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getSubinventory() {
        return subinventory;
    }

    public void setSubinventory(String subinventory) {
        this.subinventory = subinventory;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigDecimal getQuantityBilled() {
        return quantityBilled;
    }

    public void setQuantityBilled(BigDecimal quantityBilled) {
        this.quantityBilled = quantityBilled;
    }
}
