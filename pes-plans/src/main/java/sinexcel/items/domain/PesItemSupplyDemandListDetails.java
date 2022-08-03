package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

/**
 * 复核项供应和需求明细对象 pes_item_supply_demand_list
 *
 * @author Zhang Kai
 * @date 2021-05-07
 */
public class PesItemSupplyDemandListDetails
{

    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    /** 物料编码 */
    @Excel(name = "物料编码",width = 15)
    private String itemNumber;
    @Excel(name = "物料描述", width = 40)
    private String itemDescription;

    @Excel(name = "产品类别", width = 30)
    private String productCatalog;
    @Excel(name = "物料类别", width = 30)
    private String itemCatalog;

    private Long inventoryItemId;

    /** 预计库存 */
    @Excel(name = "当前库存", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal onhandQuantity;

    /** 类型 */
    @Excel(name = "类型",width = 10,readConverterExp = "WIE_S=工单头供应,WIE_D=工单行需求,PO_S=PO供应,DOO_D=订单需求,ON_HAND=现有量,PR_S=PR供应")
    private String type;

    /** 供需数量 */
    @Excel(name = "供需数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal quantity;

    /** 供需日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "供需日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 单号 */
    @Excel(name = "单号",width = 15)
    private String documentNumber;

    /** 单位 */
    @Excel(name = "单位",width = 10)
    private String uom;

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
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity()
    {
        return quantity;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }

    public Date getDate()
    {
        return date;
    }
    public void setDocumentNumber(String documentNumber)
    {
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber()
    {
        return documentNumber;
    }
    public void setOnhandQuantity(BigDecimal onhandQuantity)
    {
        this.onhandQuantity = onhandQuantity;
    }

    public BigDecimal getOnhandQuantity()
    {
        return onhandQuantity;
    }
    public void setUom(String uom)
    {
        this.uom = uom;
    }

    public String getUom()
    {
        return uom;
    }
}
