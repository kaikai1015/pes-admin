package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;

/**
 * 战略备货-采购件对象 cux_po_strategic_stock_list
 * 
 * @author Zhang Kai
 * @date 2021-05-18
 */
public class CuxPoStrategicStockList
{

    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** 物料编码 */
    @Excel(name = "物料编码", width = 15)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述", width = 40)
    private String itemDescription;

    /** $column.columnComment */
    private Long newInventoryItemId;

    /** 替代料编码 */
    @Excel(name = "替代料编码", width = 15)
    private String newItemNumber;

    /** 替代料描述 */
    @Excel(name = "替代料描述", width = 40)
    private String newItemDescription;
    @Excel(name = "当前库存", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal onhandQuantity;
    @Excel(name = "预计领用", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal wieLQuantity;
    @Excel(name = "预计销售", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal soQuantity;
    @Excel(name = "预计进货", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal poQuantity;
    @Excel(name = "已请未购", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal prQuantity;
    @Excel(name = "计划采购", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal parentPlanPoQuantity;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public BigDecimal getWieLQuantity() {
        return wieLQuantity;
    }

    public void setWieLQuantity(BigDecimal wieLQuantity) {
        this.wieLQuantity = wieLQuantity;
    }

    public BigDecimal getSoQuantity() {
        return soQuantity;
    }

    public void setSoQuantity(BigDecimal soQuantity) {
        this.soQuantity = soQuantity;
    }

    public BigDecimal getPoQuantity() {
        return poQuantity;
    }

    public void setPoQuantity(BigDecimal poQuantity) {
        this.poQuantity = poQuantity;
    }

    public BigDecimal getPrQuantity() {
        return prQuantity;
    }

    public void setPrQuantity(BigDecimal prQuantity) {
        this.prQuantity = prQuantity;
    }

    public BigDecimal getParentPlanPoQuantity() {
        return parentPlanPoQuantity;
    }

    public void setParentPlanPoQuantity(BigDecimal parentPlanPoQuantity) {
        this.parentPlanPoQuantity = parentPlanPoQuantity;
    }

    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setInventoryItemId(Long inventoryItemId) 
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() 
    {
        return inventoryItemId;
    }
    public void setItemNumber(String itemNumber) 
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() 
    {
        return itemNumber;
    }
    public void setItemDescription(String itemDescription) 
    {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() 
    {
        return itemDescription;
    }
    public void setNewInventoryItemId(Long newInventoryItemId) 
    {
        this.newInventoryItemId = newInventoryItemId;
    }

    public Long getNewInventoryItemId() 
    {
        return newInventoryItemId;
    }
    public void setNewItemNumber(String newItemNumber) 
    {
        this.newItemNumber = newItemNumber;
    }

    public String getNewItemNumber() 
    {
        return newItemNumber;
    }
    public void setNewItemDescription(String newItemDescription) 
    {
        this.newItemDescription = newItemDescription;
    }

    public String getNewItemDescription() 
    {
        return newItemDescription;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setLastUpdateBy(String lastUpdateBy) 
    {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdateBy() 
    {
        return lastUpdateBy;
    }
    public void setLastUpdateDate(Date lastUpdateDate) 
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() 
    {
        return lastUpdateDate;
    }
}
