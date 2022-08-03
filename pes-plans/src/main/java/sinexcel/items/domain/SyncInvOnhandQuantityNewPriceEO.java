package sinexcel.items.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

public class SyncInvOnhandQuantityNewPriceEO {

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

    /** 数量 */
    @Excel(name = "现有量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal quantity;

    @Excel(name = "子库", width = 10)
    private String subinventoryCode;

    @Excel(name = "呆滞天数", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal dateDiffDays;
    @Excel(name = "呆滞月数", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal monthDiffDays;

    @Excel(name = "单位成本", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sumUnitCost;

    @Excel(name = "金额", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sumUnitCostAmount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成本日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.ALL)
    private Date snapshotDate;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    private String beginTime;

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
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

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDateDiffDays() {
        return dateDiffDays;
    }

    public void setDateDiffDays(BigDecimal dateDiffDays) {
        this.dateDiffDays = dateDiffDays;
    }

    public BigDecimal getMonthDiffDays() {
        return monthDiffDays;
    }

    public void setMonthDiffDays(BigDecimal monthDiffDays) {
        this.monthDiffDays = monthDiffDays;
    }

    public BigDecimal getSumUnitCost() {
        return sumUnitCost;
    }

    public void setSumUnitCost(BigDecimal sumUnitCost) {
        this.sumUnitCost = sumUnitCost;
    }

    public BigDecimal getSumUnitCostAmount() {
        return sumUnitCostAmount;
    }

    public void setSumUnitCostAmount(BigDecimal sumUnitCostAmount) {
        this.sumUnitCostAmount = sumUnitCostAmount;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }
}
