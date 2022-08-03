package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;

/**
 * 生产提前期对象 cux_wie_lead_time_list
 * 
 * @author Zhang Kai
 * @date 2020-11-30
 */
public class CuxWieLeadTimeList
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

    /** 物流类别 */
    @Excel(name = "物流类别")
    private String itemType;

    /** 单位 */
    @Excel(name = "单位")
    private String uom;

    /** 计划员 */
    @Excel(name = "计划员")
    private String buyer;

    @Excel(name = "安全库存")
    private BigDecimal safetyStock;

    @Excel(name = "补货点")
    private BigDecimal buHuoDian;

    /** 备料时间 */
    @Excel(name = "备料时间")
    private BigDecimal preDate;

    /** 单据处理时间 */
    @Excel(name = "单据处理时间")
    private BigDecimal wieDate;

    /** 标准生产天数 */
    @Excel(name = "标准生产天数")
    private BigDecimal standardWieDate;

    /** 标准生产数量 */
    @Excel(name = "标准生产数量")
    private BigDecimal standardWieQuantity;

    /** 检验入库时间 */
    @Excel(name = "检验入库时间")
    private BigDecimal rcvDate;

    /** 加急生产天数 */
    @Excel(name = "加急生产天数")
    private BigDecimal expProdDate;

    /** 备货方式 */
    @Excel(name = "备货方式")
    private String stockMethod;

    @Excel(name = "工作中心")
    private String workCenter;
    @Excel(name = "总工时")
    private String totalTime;
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

    public String getWorkCenter() {
        return workCenter;
    }

    public void setWorkCenter(String workCenter) {
        this.workCenter = workCenter;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    public BigDecimal getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(BigDecimal safetyStock) {
        this.safetyStock = safetyStock;
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
    public void setPreDate(BigDecimal preDate) 
    {
        this.preDate = preDate;
    }

    public BigDecimal getPreDate() 
    {
        return preDate;
    }
    public void setWieDate(BigDecimal wieDate) 
    {
        this.wieDate = wieDate;
    }

    public BigDecimal getWieDate() 
    {
        return wieDate;
    }
    public void setStandardWieDate(BigDecimal standardWieDate) 
    {
        this.standardWieDate = standardWieDate;
    }

    public BigDecimal getStandardWieDate() 
    {
        return standardWieDate;
    }
    public void setStandardWieQuantity(BigDecimal standardWieQuantity) 
    {
        this.standardWieQuantity = standardWieQuantity;
    }

    public BigDecimal getStandardWieQuantity() 
    {
        return standardWieQuantity;
    }
    public void setRcvDate(BigDecimal rcvDate) 
    {
        this.rcvDate = rcvDate;
    }

    public BigDecimal getRcvDate() 
    {
        return rcvDate;
    }
    public void setExpProdDate(BigDecimal expProdDate) 
    {
        this.expProdDate = expProdDate;
    }

    public BigDecimal getExpProdDate() 
    {
        return expProdDate;
    }
    public void setStockMethod(String stockMethod) 
    {
        this.stockMethod = stockMethod;
    }

    public String getStockMethod() 
    {
        return stockMethod;
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
