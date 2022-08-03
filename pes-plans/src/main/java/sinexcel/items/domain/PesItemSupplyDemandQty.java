package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 供应和需求汇总对象 pes_item_supply_demand_qty
 * 
 * @author Zhang Kai
 * @date 2021-04-19
 */
public class PesItemSupplyDemandQty
{

    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    /** 物料编码 */
    private Long inventoryItemId;

    @Excel(name = "物料编码", width = 15)
    private String itemNumber;
    @Excel(name = "物料编码", width = 60)
    private String itemDescription;

//    @Excel(name = "18年期初库存", width = 10, cellType = Excel.ColumnType.BigDecimal)
//    private BigDecimal augYears;
//    @Excel(name = "19年期初库存", width = 10, cellType = Excel.ColumnType.BigDecimal)
//    private BigDecimal segYears;
//    @Excel(name = "20年期初库存", width = 10, cellType = Excel.ColumnType.BigDecimal)
//    private BigDecimal zeroYears;
//    @Excel(name = "21年期初库存", width = 10, cellType = Excel.ColumnType.BigDecimal)
//    private BigDecimal janYears;
//    @Excel(name = "22年期初库存", width = 10, cellType = Excel.ColumnType.BigDecimal)
//    private BigDecimal febYears;
//
//    public BigDecimal getAugYears() {
//        return augYears;
//    }
//
//    public void setAugYears(BigDecimal augYears) {
//        this.augYears = augYears;
//    }
//
//    public BigDecimal getSegYears() {
//        return segYears;
//    }
//
//    public void setSegYears(BigDecimal segYears) {
//        this.segYears = segYears;
//    }
//
//    public BigDecimal getZeroYears() {
//        return zeroYears;
//    }
//
//    public void setZeroYears(BigDecimal zeroYears) {
//        this.zeroYears = zeroYears;
//    }
//
//    public BigDecimal getJanYears() {
//        return janYears;
//    }
//
//    public void setJanYears(BigDecimal janYears) {
//        this.janYears = janYears;
//    }
//
//    public BigDecimal getFebYears() {
//        return febYears;
//    }
//
//    public void setFebYears(BigDecimal febYears) {
//        this.febYears = febYears;
//    }

    @Excel(name = "提前期", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fixedLeadTime;
    @Excel(name = "最小订购量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal minimumOrderQuantity;

    @Excel(name = "库存数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal quantity;

    /** 工单供应 */
    @Excel(name = "工单供应", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal wieS;

    /** 工单需求 */
    @Excel(name = "工单需求", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal wieD;

    /** 订单需求 */
    @Excel(name = "订单需求", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal dooD;

    /** PR供应 */
    @Excel(name = "PR供应", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal prS;

    /** PO供应 */
    @Excel(name = "PO供应", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal poS;

    @Excel(name = "MES正在送货", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal deliveryingQuantity;
    @Excel(name = "MES已点收未确认", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal checkedUnconfirmedQuantity;
    @Excel(name = "MES收货确认", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal receiptConfirmedQuantity;
    @Excel(name = "MES已上架未入库", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal unrcvQuantity;
    @Excel(name = "MES已入库数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal rcvQuantity;

    public BigDecimal getFixedLeadTime() {
        return fixedLeadTime;
    }

    public void setFixedLeadTime(BigDecimal fixedLeadTime) {
        this.fixedLeadTime = fixedLeadTime;
    }

    public BigDecimal getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(BigDecimal minimumOrderQuantity) {
        this.minimumOrderQuantity = minimumOrderQuantity;
    }

    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getDeliveryingQuantity() {
        return deliveryingQuantity;
    }

    public void setDeliveryingQuantity(BigDecimal deliveryingQuantity) {
        this.deliveryingQuantity = deliveryingQuantity;
    }

    public BigDecimal getCheckedUnconfirmedQuantity() {
        return checkedUnconfirmedQuantity;
    }

    public void setCheckedUnconfirmedQuantity(BigDecimal checkedUnconfirmedQuantity) {
        this.checkedUnconfirmedQuantity = checkedUnconfirmedQuantity;
    }

    public BigDecimal getReceiptConfirmedQuantity() {
        return receiptConfirmedQuantity;
    }

    public void setReceiptConfirmedQuantity(BigDecimal receiptConfirmedQuantity) {
        this.receiptConfirmedQuantity = receiptConfirmedQuantity;
    }

    public BigDecimal getUnrcvQuantity() {
        return unrcvQuantity;
    }

    public void setUnrcvQuantity(BigDecimal unrcvQuantity) {
        this.unrcvQuantity = unrcvQuantity;
    }

    public BigDecimal getRcvQuantity() {
        return rcvQuantity;
    }

    public void setRcvQuantity(BigDecimal rcvQuantity) {
        this.rcvQuantity = rcvQuantity;
    }

    /** $column.columnComment */
    private Date lastUpdateDate;


    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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
    public void setWieS(BigDecimal wieS) 
    {
        this.wieS = wieS;
    }

    public BigDecimal getWieS() 
    {
        return wieS;
    }
    public void setWieD(BigDecimal wieD) 
    {
        this.wieD = wieD;
    }

    public BigDecimal getWieD() 
    {
        return wieD;
    }
    public void setPrS(BigDecimal prS) 
    {
        this.prS = prS;
    }

    public BigDecimal getPrS() 
    {
        return prS;
    }
    public void setPoS(BigDecimal poS) 
    {
        this.poS = poS;
    }

    public BigDecimal getPoS() 
    {
        return poS;
    }
    public void setDooD(BigDecimal dooD) 
    {
        this.dooD = dooD;
    }

    public BigDecimal getDooD() 
    {
        return dooD;
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
