package sinexcel.plans.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 采购提前期全表对象 cux_po_lead_time_list
 * 
 * @author Zhang Kai
 * @date 2020-11-27
 */
public class CuxPoLeadTimeList
{
    /** ID */
    private Integer id;

    /** 组织ID */
    private Long organizationId;

    /** 库存组织 */
    @Excel(name = "库存组织")
    private String organizationCode;

    /** 物料ID */
    private Long inventoryItemId;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述")
    private String itemDescription;

    /** 产品类别 */
    @Excel(name = "产品类别")
    private String prodType;

    /** 物料类别 */
    @Excel(name = "物料类别")
    private String itemType;

    /** 单位 */
    @Excel(name = "单位")
    private String uom;

    /** 采购/计划员 */
    @Excel(name = "采购/计划员")
    private String buyer;

    @Excel(name = "安全库存")
    private BigDecimal safetyStock;
    @Excel(name = "补货点")
    private BigDecimal buHuoDian;

    /** 请购时间 */
    @Excel(name = "请购时间")
    private BigDecimal prDate;

    /** 单据处理时间 */
    @Excel(name = "单据处理时间")
    private BigDecimal poDate;

    /** 标准生产天数 */
    @Excel(name = "标准生产天数")
    private BigDecimal supplierDate;

    /** 物流时间 */
    @Excel(name = "物流时间")
    private BigDecimal logistDate;

    /** 检验入库时间 */
    @Excel(name = "检验入库时间")
    private BigDecimal rcvDate;

    /** 加急生产天数 */
    @Excel(name = "加急生产天数")
    private BigDecimal expProdDate;

    /** 备货方式 */
    @Excel(name = "备货方式")
    private String stockMethod;

    @Excel(name = "交付指令")
    private String deliveryType;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    private String createBy;

    private BigDecimal totalDays;
    private String makeBuyerFlag;

    public String getMakeBuyerFlag() {
        return makeBuyerFlag;
    }

    public void setMakeBuyerFlag(String makeBuyerFlag) {
        this.makeBuyerFlag = makeBuyerFlag;
    }

    public BigDecimal getBuHuoDian() {
        return buHuoDian;
    }

    public void setBuHuoDian(BigDecimal buHuoDian) {
        this.buHuoDian = buHuoDian;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public BigDecimal getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(BigDecimal safetyStock) {
        this.safetyStock = safetyStock;
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

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setOrganizationCode(String organizationCode) 
    {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationCode() 
    {
        return organizationCode;
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
    public void setProdType(String prodType) 
    {
        this.prodType = prodType;
    }

    public String getProdType() 
    {
        return prodType;
    }
    public void setItemType(String itemType) 
    {
        this.itemType = itemType;
    }

    public String getItemType() 
    {
        return itemType;
    }
    public void setUom(String uom) 
    {
        this.uom = uom;
    }

    public String getUom() 
    {
        return uom;
    }
    public void setBuyer(String buyer) 
    {
        this.buyer = buyer;
    }

    public String getBuyer() 
    {
        return buyer;
    }
    public void setPrDate(BigDecimal prDate) 
    {
        this.prDate = prDate;
    }

    public BigDecimal getPrDate() 
    {
        return prDate;
    }
    public void setPoDate(BigDecimal poDate) 
    {
        this.poDate = poDate;
    }

    public BigDecimal getPoDate() 
    {
        return poDate;
    }
    public void setSupplierDate(BigDecimal supplierDate) 
    {
        this.supplierDate = supplierDate;
    }

    public BigDecimal getSupplierDate() 
    {
        return supplierDate;
    }
    public void setLogistDate(BigDecimal logistDate) 
    {
        this.logistDate = logistDate;
    }

    public BigDecimal getLogistDate() 
    {
        return logistDate;
    }
    public void setRcvDate(BigDecimal rcvDate) 
    {
        this.rcvDate = rcvDate;
    }

    public BigDecimal getRcvDate() 
    {
        return rcvDate;
    }
    public void setStockMethod(String stockMethod) 
    {
        this.stockMethod = stockMethod;
    }

    public String getStockMethod() 
    {
        return stockMethod;
    }
    public void setExpProdDate(BigDecimal expProdDate) 
    {
        this.expProdDate = expProdDate;
    }

    public BigDecimal getExpProdDate() 
    {
        return expProdDate;
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
