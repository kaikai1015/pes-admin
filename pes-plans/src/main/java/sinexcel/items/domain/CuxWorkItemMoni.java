package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

/**
 * 模拟物料齐套对象 cux_work_item_moni
 * 
 * @author Zhang Kai
 * @date 2021-04-11
 */
public class CuxWorkItemMoni
{
    private Long id;

    private Long pInventoryItemId;

    /** 库存组织 */
    private Long organizationId;

    /** 成品料号 */
    @Excel(name = "成品料号" ,width = 15)
    private String pItemNumber;

//    @Excel(name = "成品成本" ,width = 10,cellType = Excel.ColumnType.BigDecimal)
//    private BigDecimal pSumUnitCost;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "模拟日期" ,width = 10,dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 组件料号 */
    @Excel(name = "组件料号" ,width = 15)
    private String itemNumber;

//    @Excel(name = "组件成本" ,width = 10,cellType = Excel.ColumnType.BigDecimal)
//    private BigDecimal sumUnitCost;

    @Excel(name = "采购周期" ,width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal totalDays;

    /** 阶次 */
    @Excel(name = "阶次",width = 5,cellType = Excel.ColumnType.BigDecimal)
    private Integer level;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** 组件类型 */
    @Excel(name = "组件类型")
    private String itemType;

    /** 标准数量 */
    @Excel(name = "标准数量",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal componentQuantity;

    /** 组件数量 */
    @Excel(name = "组件数量",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal quantity;


    @Excel(name = "当前库存", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal onhandQuantity;
    @Excel(name = "预计生产", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal wieHQuantity;
    @Excel(name = "当前领用", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal currenctQuantity;
    @Excel(name = "预计领用", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal wieLQuantity;
    @Excel(name = "预计销售", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal soQuantity;
    @Excel(name = "预计进货", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal poQuantity;
    @Excel(name = "已请未购", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal prQuantity;

    /** 组件描述 */
    @Excel(name = "组件描述",width = 80)
    private String itemDescription;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    private String createBy;

    public String getIsWieFlag() {
        return isWieFlag;
    }

    public void setIsWieFlag(String isWieFlag) {
        this.isWieFlag = isWieFlag;
    }

    private String isWieFlag;

//    public BigDecimal getpSumUnitCost() {
//        return pSumUnitCost;
//    }
//
//    public void setpSumUnitCost(BigDecimal pSumUnitCost) {
//        this.pSumUnitCost = pSumUnitCost;
//    }
//
//    public BigDecimal getSumUnitCost() {
//        return sumUnitCost;
//    }
//
//    public void setSumUnitCost(BigDecimal sumUnitCost) {
//        this.sumUnitCost = sumUnitCost;
//    }

    public BigDecimal getCurrenctQuantity() {
        return currenctQuantity;
    }

    public void setCurrenctQuantity(BigDecimal currenctQuantity) {
        this.currenctQuantity = currenctQuantity;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public BigDecimal getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(BigDecimal totalDays) {
        this.totalDays = totalDays;
    }

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public BigDecimal getWieHQuantity() {
        return wieHQuantity;
    }

    public void setWieHQuantity(BigDecimal wieHQuantity) {
        this.wieHQuantity = wieHQuantity;
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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setpInventoryItemId(Long pInventoryItemId) 
    {
        this.pInventoryItemId = pInventoryItemId;
    }

    public Long getpInventoryItemId() 
    {
        return pInventoryItemId;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setpItemNumber(String pItemNumber) 
    {
        this.pItemNumber = pItemNumber;
    }

    public String getpItemNumber() 
    {
        return pItemNumber;
    }
    public void setItemDescription(String itemDescription) 
    {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() 
    {
        return itemDescription;
    }
    public void setLevel(Integer level) 
    {
        this.level = level;
    }

    public Integer getLevel() 
    {
        return level;
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
    public void setItemType(String itemType) 
    {
        this.itemType = itemType;
    }

    public String getItemType() 
    {
        return itemType;
    }
    public void setComponentQuantity(BigDecimal componentQuantity) 
    {
        this.componentQuantity = componentQuantity;
    }

    public BigDecimal getComponentQuantity() 
    {
        return componentQuantity;
    }
    public void setQuantity(BigDecimal quantity) 
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() 
    {
        return quantity;
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
