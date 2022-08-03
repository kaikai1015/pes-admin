package sinexcel.items.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 物料编码和描述快码对象 sync_items_num_des_list
 *
 * @author Zhang Kai
 * @date 2021-12-21
 */
public class SyncItemsNumDesWieList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 组织ID */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    /** 物料ID */
    private Long inventoryItemId;

    /** 物料编码 */
    @Excel(name = "物料编码", width = 15)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述", width = 40)
    private String itemDescription;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

    /** 物料类型 */
    @Excel(name = "物料类型",width = 10)
    private String itemType;

    /** 自制外购 */
    private String planningMakeBuyCode;

    /** 单位 */
    private String primaryUomCode;
    private Long buyerId;
    private String buyerNumber;
    private String buyerName;

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerNumber() {
        return buyerNumber;
    }

    public void setBuyerNumber(String buyerNumber) {
        this.buyerNumber = buyerNumber;
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
    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }
    public void setItemType(String itemType)
    {
        this.itemType = itemType;
    }

    public String getItemType()
    {
        return itemType;
    }
    public void setPlanningMakeBuyCode(String planningMakeBuyCode)
    {
        this.planningMakeBuyCode = planningMakeBuyCode;
    }

    public String getPlanningMakeBuyCode()
    {
        return planningMakeBuyCode;
    }
    public void setPrimaryUomCode(String primaryUomCode)
    {
        this.primaryUomCode = primaryUomCode;
    }

    public String getPrimaryUomCode()
    {
        return primaryUomCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("organizationId", getOrganizationId())
                .append("inventoryItemId", getInventoryItemId())
                .append("itemNumber", getItemNumber())
                .append("itemDescription", getItemDescription())
                .append("creationDate", getCreationDate())
                .append("itemType", getItemType())
                .append("planningMakeBuyCode", getPlanningMakeBuyCode())
                .append("primaryUomCode", getPrimaryUomCode())
                .toString();
    }
}
