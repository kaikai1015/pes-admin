package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * BOM选配物料结构对象 cux_item_bom_cho
 * 
 * @author Zhang Kai
 * @date 2020-12-27
 */
public class CuxItemBomCho extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long choId;

    /** $column.columnComment */
    private Long pInventoryItemId;

    /** $column.columnComment */
    private Long organizationId;

    /** 父项料号 */
    private String pItemNumber;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** 组件料号 */
    private String itemNumber;

    /** 组件类型 */
    private String itemType;

    /** 组件数量 */
    private BigDecimal componentQuantity;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String errorInfor;

    /** $column.columnComment */
    private Long delFlag;

    /** 组件描述 */
    private String itemDescription;

    private Long orgItemId;

    public Integer getErpFlag() {
        return erpFlag;
    }

    public void setErpFlag(Integer erpFlag) {
        this.erpFlag = erpFlag;
    }

    private Integer erpFlag;

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    private String organizationCode;

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    private Long rootId;

    public Long getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(Long orgItemId) {
        this.orgItemId = orgItemId;
    }

    public void setChoId(Long choId) 
    {
        this.choId = choId;
    }

    public Long getChoId() 
    {
        return choId;
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
    public void setErrorInfor(String errorInfor) 
    {
        this.errorInfor = errorInfor;
    }

    public String getErrorInfor() 
    {
        return errorInfor;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }
    public void setItemDescription(String itemDescription) 
    {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() 
    {
        return itemDescription;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("choId", getChoId())
            .append("pInventoryItemId", getpInventoryItemId())
            .append("organizationId", getOrganizationId())
            .append("pItemNumber", getpItemNumber())
            .append("inventoryItemId", getInventoryItemId())
            .append("itemNumber", getItemNumber())
            .append("itemType", getItemType())
            .append("componentQuantity", getComponentQuantity())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("errorInfor", getErrorInfor())
            .append("delFlag", getDelFlag())
            .append("itemDescription", getItemDescription())
            .toString();
    }
}
