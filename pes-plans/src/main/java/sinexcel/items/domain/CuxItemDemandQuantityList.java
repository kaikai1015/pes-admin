package sinexcel.items.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 物料需求平均备货数量对象 cux_item_demand_quantity_list
 * 
 * @author Zhang Kai
 * @date 2021-10-27
 */
public class CuxItemDemandQuantityList
{
    private Long inventoryItemId;

    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    /** 物料编码 */
    @Excel(name = "物料编码",width = 15)
    private String itemNumber;
    @Excel(name = "物料描述",width = 30)
    private String itemDescription;
    @Excel(name = "当前库存", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal onhandQuantity;
    /** 数量 */
    @Excel(name = "平均备货数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal quantity;
    @Excel(name = "属性",width = 10)
    private String itemType;
    @Excel(name = "采购成本", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal maxUnitPrice;
    @Excel(name = "库存金额", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal onhandQuantityAmount;
    @Excel(name = "消耗天数", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal days;

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

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public BigDecimal getMaxUnitPrice() {
        return maxUnitPrice;
    }

    public void setMaxUnitPrice(BigDecimal maxUnitPrice) {
        this.maxUnitPrice = maxUnitPrice;
    }

    public BigDecimal getOnhandQuantityAmount() {
        return onhandQuantityAmount;
    }

    public void setOnhandQuantityAmount(BigDecimal onhandQuantityAmount) {
        this.onhandQuantityAmount = onhandQuantityAmount;
    }

    public BigDecimal getDays() {
        return days;
    }

    public void setDays(BigDecimal days) {
        this.days = days;
    }
}
