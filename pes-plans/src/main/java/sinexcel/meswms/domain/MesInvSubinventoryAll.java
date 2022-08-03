package sinexcel.meswms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * mes工单单身指定仓库对象 mes_inv_subinventory_all
 * 
 * @author Zhang Kai
 * @date 2021-03-10
 */
public class MesInvSubinventoryAll extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    /** 物料ID */
    private Long inventoryItemId;

    /** 库存组织ID */
    @Excel(name = "库存组织ID")
    private Long organizationId;

    /** 物料编号 */
    @Excel(name = "物料编号")
    private String itemNumber;

    /** 指定仓 */
    @Excel(name = "MES指定仓")
    private String subinventoryCode;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setInventoryItemId(Long inventoryItemId) 
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() 
    {
        return inventoryItemId;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setItemNumber(String itemNumber) 
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() 
    {
        return itemNumber;
    }
    public void setSubinventoryCode(String subinventoryCode) 
    {
        this.subinventoryCode = subinventoryCode;
    }

    public String getSubinventoryCode() 
    {
        return subinventoryCode;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setLastUpdateDate(Date lastUpdateDate) 
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() 
    {
        return lastUpdateDate;
    }
    public void setLastUpdateBy(String lastUpdateBy) 
    {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdateBy() 
    {
        return lastUpdateBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inventoryItemId", getInventoryItemId())
            .append("organizationId", getOrganizationId())
            .append("itemNumber", getItemNumber())
            .append("subinventoryCode", getSubinventoryCode())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .toString();
    }
}
