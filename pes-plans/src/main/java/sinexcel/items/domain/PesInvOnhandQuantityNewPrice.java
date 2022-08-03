package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

/**
 * ERP库存现有量对象 sync_inv_onhand_quantity_new
 * 
 * @author Zhang Kai
 * @date 2021-06-28
 */
public class PesInvOnhandQuantityNewPrice
{
    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;
    /** 物料编码 */
    @Excel(name = "物料编码", width = 15)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述", width = 40)
    private String itemDescription;
    @Excel(name = "采购员", width = 10)
    private String buyerName;
    @Excel(name = "产品类别", width = 30)
    private String productCatalog;
    @Excel(name = "物料类别", width = 30)
    private String itemCatalog;
    private Long inventoryItemId;
    @Excel(name = "可用量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal avaliableQuantity;

    /** 数量 */
    @Excel(name = "现有量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal quantity;

    @Excel(name = "待入库数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal receiveQuantity;

    @Excel(name = "在途数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal inboundQuantity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "最近交易时间", width = 10, dateFormat = "yyyy-MM-dd HH:mm:ss",type = Excel.Type.ALL)
    private Date maxTransactionDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "首次入库时间", width = 10, dateFormat = "yyyy-MM-dd HH:mm:ss",type = Excel.Type.ALL)
    private Date minTransactionDate;
    @Excel(name = "呆滞天数", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal dateDiffDays;
    @Excel(name = "呆滞月数", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal monthDiffDays;

    public BigDecimal getMonthDiffDays() {
        return monthDiffDays;
    }

    public void setMonthDiffDays(BigDecimal monthDiffDays) {
        this.monthDiffDays = monthDiffDays;
    }

    private BigDecimal subQuantity;
    @Excel(name = "子库", width = 10)
    private String subinventoryCode;
    private String subinventoryDescription;

    @Excel(name = "单位成本", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sumUnitCost;

    @Excel(name = "金额", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sumUnitCostAmount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成本日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.ALL)
    private Date snapshotDate;

    private String isWieFlag;

    public Date getMinTransactionDate() {
        return minTransactionDate;
    }

    public void setMinTransactionDate(Date minTransactionDate) {
        this.minTransactionDate = minTransactionDate;
    }

    public BigDecimal getSumUnitCostAmount() {
        return sumUnitCostAmount;
    }

    public void setSumUnitCostAmount(BigDecimal sumUnitCostAmount) {
        this.sumUnitCostAmount = sumUnitCostAmount;
    }

    public BigDecimal getReceiveQuantity() {
        return receiveQuantity;
    }

    public void setReceiveQuantity(BigDecimal receiveQuantity) {
        this.receiveQuantity = receiveQuantity;
    }

    public BigDecimal getInboundQuantity() {
        return inboundQuantity;
    }

    public void setInboundQuantity(BigDecimal inboundQuantity) {
        this.inboundQuantity = inboundQuantity;
    }

    public String getIsWieFlag() {
        return isWieFlag;
    }

    public void setIsWieFlag(String isWieFlag) {
        this.isWieFlag = isWieFlag;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public BigDecimal getDateDiffDays() {
        return dateDiffDays;
    }

    public void setDateDiffDays(BigDecimal dateDiffDays) {
        this.dateDiffDays = dateDiffDays;
    }

    public String getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(String productCatalog) {
        this.productCatalog = productCatalog;
    }

    public String getItemCatalog() {
        return itemCatalog;
    }

    public void setItemCatalog(String itemCatalog) {
        this.itemCatalog = itemCatalog;
    }

    public BigDecimal getSumUnitCost() {
        return sumUnitCost;
    }

    public void setSumUnitCost(BigDecimal sumUnitCost) {
        this.sumUnitCost = sumUnitCost;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public BigDecimal getAvaliableQuantity() {
        return avaliableQuantity;
    }

    public void setAvaliableQuantity(BigDecimal avaliableQuantity) {
        this.avaliableQuantity = avaliableQuantity;
    }

    public String getSubinventoryDescription() {
        return subinventoryDescription;
    }

    public void setSubinventoryDescription(String subinventoryDescription) {
        this.subinventoryDescription = subinventoryDescription;
    }

    public BigDecimal getSubQuantity() {
        return subQuantity;
    }

    public void setSubQuantity(BigDecimal subQuantity) {
        this.subQuantity = subQuantity;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public Date getMaxTransactionDate() {
        return maxTransactionDate;
    }

    public void setMaxTransactionDate(Date maxTransactionDate) {
        this.maxTransactionDate = maxTransactionDate;
    }

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

    public void setInventoryItemId(Long inventoryItemId) 
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() 
    {
        return inventoryItemId;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setQuantity(BigDecimal quantity) 
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() 
    {
        return quantity;
    }
}
