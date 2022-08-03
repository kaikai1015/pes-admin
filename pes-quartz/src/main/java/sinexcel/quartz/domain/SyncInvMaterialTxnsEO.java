package sinexcel.quartz.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class SyncInvMaterialTxnsEO extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @Excel(name = "库存组织",width = 15, align = Excel.Align.LEFT,dictType = "sys_org_coe_list")
    private Long organizationId;
    @Excel(name = "事务处理ID",width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long transactionId;
    //    @Excel(name = "物料编码ID",width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long inventoryItemId;
    @Excel(name = "物料编码",width = 15)
    private String itemNumber;
    @Excel(name = "物料描述",width = 40,align = Excel.Align.LEFT)
    private String itemDescription;
    @Excel(name = "原子库",width = 10)
    private String subinventoryCode;
    @Excel(name = "转移子库存",width = 10)
    private String transferSubinventory;
    @Excel(name = "事务处理类型",width = 15, align = Excel.Align.LEFT,dictType = "sync_inv_transaction_types_tl")
    private Long transactionTypeId;
    @Excel(name = "事务处理来源类型",width = 15, align = Excel.Align.LEFT,dictType = "sync_inv_txn_source_types_tl")
    private Long transactionSourceTypeId;
    private Long transactionSourceId;
    @Excel(name = "事务处理来源",width = 15)
    private String transactionSourceName;
    @Excel(name = "交易数量",width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal transactionQuantity;
    @Excel(name = "交易单位",width = 10)
    private String transactionUom;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "交易日期", width = 20, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date transactionDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate;
    private String lastUpdatedBy;
    private String transactionActionId;
    private BigDecimal primaryQuantity;
    @Excel(name = "交易参考",width = 40,align = Excel.Align.LEFT)
    private String transactionReference;
    private Long distributionAccountId;
    private String costedFlag;
    private String currencyCode;
    private BigDecimal currencyConversionRate;
    private String currencyConversionType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date currencyConversionDate;
    private Long pickingLineId;
    private Long trxSourceLineId;
    private Long trxSourceDeliveryId;
    private Long rmaLineId;
    private Long transferTransactionId;
    @Excel(name = "事务处理集",width = 15,cellType = Excel.ColumnType.BigDecimal)
    private Long transactionSetId;
    private Long rcvTransactionId;
    private String sourceCode;
    private Long sourceLineId;
    private Long transferOrganizationId;
    private String shipmentNumber;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;
    private String attribute8;
    private String attribute9;
    private String attribute10;
    private Long owningOrganizationId;
    private Long owningTpType;
    private Long xfrOwningOrganizationId;
    private Long transferOwningTpType;
    private Long planningOrganizationId;
    private Long planningTpType;
    private Long xfrPlanningOrganizationId;
    private Long transferPlanningTpType;
    private Long shipToLocationId;
    private Long transactionMode;
    private Long transactionBatchId;
    private Long originalTransactionTempId;
    private String productType;
    private String taxClassificationCode;
    private Long shipFromLocationId;

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

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

    public String getTransactionActionId() {
        return transactionActionId;
    }

    public void setTransactionActionId(String transactionActionId) {
        this.transactionActionId = transactionActionId;
    }

    public Long getTransactionSourceTypeId() {
        return transactionSourceTypeId;
    }

    public void setTransactionSourceTypeId(Long transactionSourceTypeId) {
        this.transactionSourceTypeId = transactionSourceTypeId;
    }

    public Long getTransactionSourceId() {
        return transactionSourceId;
    }

    public void setTransactionSourceId(Long transactionSourceId) {
        this.transactionSourceId = transactionSourceId;
    }

    public String getTransactionSourceName() {
        return transactionSourceName;
    }

    public void setTransactionSourceName(String transactionSourceName) {
        this.transactionSourceName = transactionSourceName;
    }

    public BigDecimal getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(BigDecimal transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public String getTransactionUom() {
        return transactionUom;
    }

    public void setTransactionUom(String transactionUom) {
        this.transactionUom = transactionUom;
    }

    public BigDecimal getPrimaryQuantity() {
        return primaryQuantity;
    }

    public void setPrimaryQuantity(BigDecimal primaryQuantity) {
        this.primaryQuantity = primaryQuantity;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public Long getDistributionAccountId() {
        return distributionAccountId;
    }

    public void setDistributionAccountId(Long distributionAccountId) {
        this.distributionAccountId = distributionAccountId;
    }

    public String getCostedFlag() {
        return costedFlag;
    }

    public void setCostedFlag(String costedFlag) {
        this.costedFlag = costedFlag;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getCurrencyConversionRate() {
        return currencyConversionRate;
    }

    public void setCurrencyConversionRate(BigDecimal currencyConversionRate) {
        this.currencyConversionRate = currencyConversionRate;
    }

    public String getCurrencyConversionType() {
        return currencyConversionType;
    }

    public void setCurrencyConversionType(String currencyConversionType) {
        this.currencyConversionType = currencyConversionType;
    }

    public Date getCurrencyConversionDate() {
        return currencyConversionDate;
    }

    public void setCurrencyConversionDate(Date currencyConversionDate) {
        this.currencyConversionDate = currencyConversionDate;
    }

    public Long getPickingLineId() {
        return pickingLineId;
    }

    public void setPickingLineId(Long pickingLineId) {
        this.pickingLineId = pickingLineId;
    }

    public Long getTrxSourceLineId() {
        return trxSourceLineId;
    }

    public void setTrxSourceLineId(Long trxSourceLineId) {
        this.trxSourceLineId = trxSourceLineId;
    }

    public Long getTrxSourceDeliveryId() {
        return trxSourceDeliveryId;
    }

    public void setTrxSourceDeliveryId(Long trxSourceDeliveryId) {
        this.trxSourceDeliveryId = trxSourceDeliveryId;
    }

    public Long getRmaLineId() {
        return rmaLineId;
    }

    public void setRmaLineId(Long rmaLineId) {
        this.rmaLineId = rmaLineId;
    }

    public Long getTransferTransactionId() {
        return transferTransactionId;
    }

    public void setTransferTransactionId(Long transferTransactionId) {
        this.transferTransactionId = transferTransactionId;
    }

    public Long getTransactionSetId() {
        return transactionSetId;
    }

    public void setTransactionSetId(Long transactionSetId) {
        this.transactionSetId = transactionSetId;
    }

    public Long getRcvTransactionId() {
        return rcvTransactionId;
    }

    public void setRcvTransactionId(Long rcvTransactionId) {
        this.rcvTransactionId = rcvTransactionId;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Long getSourceLineId() {
        return sourceLineId;
    }

    public void setSourceLineId(Long sourceLineId) {
        this.sourceLineId = sourceLineId;
    }

    public Long getTransferOrganizationId() {
        return transferOrganizationId;
    }

    public void setTransferOrganizationId(Long transferOrganizationId) {
        this.transferOrganizationId = transferOrganizationId;
    }

    public String getTransferSubinventory() {
        return transferSubinventory;
    }

    public void setTransferSubinventory(String transferSubinventory) {
        this.transferSubinventory = transferSubinventory;
    }

    public String getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(String shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public Long getOwningOrganizationId() {
        return owningOrganizationId;
    }

    public void setOwningOrganizationId(Long owningOrganizationId) {
        this.owningOrganizationId = owningOrganizationId;
    }

    public Long getOwningTpType() {
        return owningTpType;
    }

    public void setOwningTpType(Long owningTpType) {
        this.owningTpType = owningTpType;
    }

    public Long getXfrOwningOrganizationId() {
        return xfrOwningOrganizationId;
    }

    public void setXfrOwningOrganizationId(Long xfrOwningOrganizationId) {
        this.xfrOwningOrganizationId = xfrOwningOrganizationId;
    }

    public Long getTransferOwningTpType() {
        return transferOwningTpType;
    }

    public void setTransferOwningTpType(Long transferOwningTpType) {
        this.transferOwningTpType = transferOwningTpType;
    }

    public Long getPlanningOrganizationId() {
        return planningOrganizationId;
    }

    public void setPlanningOrganizationId(Long planningOrganizationId) {
        this.planningOrganizationId = planningOrganizationId;
    }

    public Long getPlanningTpType() {
        return planningTpType;
    }

    public void setPlanningTpType(Long planningTpType) {
        this.planningTpType = planningTpType;
    }

    public Long getXfrPlanningOrganizationId() {
        return xfrPlanningOrganizationId;
    }

    public void setXfrPlanningOrganizationId(Long xfrPlanningOrganizationId) {
        this.xfrPlanningOrganizationId = xfrPlanningOrganizationId;
    }

    public Long getTransferPlanningTpType() {
        return transferPlanningTpType;
    }

    public void setTransferPlanningTpType(Long transferPlanningTpType) {
        this.transferPlanningTpType = transferPlanningTpType;
    }

    public Long getShipToLocationId() {
        return shipToLocationId;
    }

    public void setShipToLocationId(Long shipToLocationId) {
        this.shipToLocationId = shipToLocationId;
    }

    public Long getTransactionMode() {
        return transactionMode;
    }

    public void setTransactionMode(Long transactionMode) {
        this.transactionMode = transactionMode;
    }

    public Long getTransactionBatchId() {
        return transactionBatchId;
    }

    public void setTransactionBatchId(Long transactionBatchId) {
        this.transactionBatchId = transactionBatchId;
    }

    public Long getOriginalTransactionTempId() {
        return originalTransactionTempId;
    }

    public void setOriginalTransactionTempId(Long originalTransactionTempId) {
        this.originalTransactionTempId = originalTransactionTempId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTaxClassificationCode() {
        return taxClassificationCode;
    }

    public void setTaxClassificationCode(String taxClassificationCode) {
        this.taxClassificationCode = taxClassificationCode;
    }

    public Long getShipFromLocationId() {
        return shipFromLocationId;
    }

    public void setShipFromLocationId(Long shipFromLocationId) {
        this.shipFromLocationId = shipFromLocationId;
    }
}
