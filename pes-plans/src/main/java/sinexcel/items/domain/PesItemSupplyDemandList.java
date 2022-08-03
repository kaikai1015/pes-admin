package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 复核项供应和需求对象 pes_item_supply_demand_list
 * 
 * @author Zhang Kai
 * @date 2020-12-03
 */
public class PesItemSupplyDemandList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 组织ID */
    private Long organizationId;

    /** 物料ID */
    private Long inventoryItemId;

    /** 库存组织 */
    @Excel(name = "库存组织")
    private String organizationCode;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述")
    private String description;

    /** 供需类型 */
    @Excel(name = "供需类型")
    private String type;

    /** 供需数量 */
    @Excel(name = "供需数量")
    private BigDecimal quantity;

    /** 供需日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "供需日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 单号 */
    @Excel(name = "单号")
    private String documentNumber;

    /** 预计库存数量 */
    @Excel(name = "预计库存数量")
    private BigDecimal onhandQuantity;

    /** 单位 */
    @Excel(name = "单位")
    private String uom;

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
    public void setOrganizationCode(String organizationCode) 
    {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationCode() 
    {
        return organizationCode;
    }
    public void setItemNumber(String itemNumber) 
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() 
    {
        return itemNumber;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("organizationId", getOrganizationId())
            .append("inventoryItemId", getInventoryItemId())
            .append("organizationCode", getOrganizationCode())
            .append("itemNumber", getItemNumber())
            .append("description", getDescription())
            .append("type", getType())
            .append("quantity", getQuantity())
            .append("date", getDate())
            .append("documentNumber", getDocumentNumber())
            .append("onhandQuantity", getOnhandQuantity())
            .append("uom", getUom())
            .append("createBy", getCreateBy())
            .toString();
    }
}
