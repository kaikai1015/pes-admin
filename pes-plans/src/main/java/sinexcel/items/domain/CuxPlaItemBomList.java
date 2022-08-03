package sinexcel.items.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * BOM选配平台模型对象 cux_pla_item_bom_list
 * 
 * @author Zhang Kai
 * @date 2020-12-27
 */
public class CuxPlaItemBomList
{

    public Long getpInventoryItemId() {
        return pInventoryItemId;
    }

    public void setpInventoryItemId(Long pInventoryItemId) {
        this.pInventoryItemId = pInventoryItemId;
    }

    /** $column.columnComment */
    private Long pInventoryItemId;

    private Long inventoryItemId;

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    /** 库存组织 */
    private Long organizationId;

    @Excel(name = "P料号编码", width = 10,type = Excel.Type.EXPORT)
    private String pItemNumber;
    @Excel(name = "P料号描述", width = 50,type = Excel.Type.EXPORT)
    private String pDescription;

    @Excel(name = "创建人", width = 10,type = Excel.Type.EXPORT)
    private String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 20, dateFormat = "yyyy-MM-dd HH:mm:ss",type = Excel.Type.EXPORT)
    private Date createTime;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Long orgItemId;

    /** 物料编码 */
    @Excel(name = "C料号编码", width = 10,type = Excel.Type.EXPORT)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "C料号描述", width = 50,type = Excel.Type.EXPORT)
    private String description;

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public Long getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(Long orgItemId) {
        this.orgItemId = orgItemId;
    }

    public String getpItemNumber() {
        return pItemNumber;
    }

    public void setpItemNumber(String pItemNumber) {
        this.pItemNumber = pItemNumber;
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
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

}
