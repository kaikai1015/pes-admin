package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

/**
 * 物料替代信息对象 cux_work_substituted_material
 * 
 * @author Zhang Kai
 * @date 2021-05-14
 */
public class CuxWorkSubstitutedMaterial
{

    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X",type = Excel.Type.EXPORT)
    private Long organizationId;


    @Excel(name = "库存组织",type = Excel.Type.IMPORT)
    private String organizationCode;

    /** $column.columnComment */
    private Long pInventoryItemId;

    /** 主件编码 */
    @Excel(name = "主件编码", width = 15,type = Excel.Type.ALL)
    private String pItemNumber;

    /** 主件描述 */
    @Excel(name = "主件描述", width = 40,type = Excel.Type.EXPORT)
    private String pItemDescription;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** 被替代料编码 */
    @Excel(name = "被替代料编码", width = 15,type = Excel.Type.ALL)
    private String itemNumber;

    /** 被替代料描述 */
    @Excel(name = "被替代料描述", width = 40,type = Excel.Type.EXPORT)
    private String itemDescription;

    /** $column.columnComment */
    private Long newInventoryItemId;

    /** 替代料编码 */
    @Excel(name = "替代料编码", width = 15,type = Excel.Type.ALL)
    private String newItemNumber;

    /** 替代料描述 */
    @Excel(name = "替代料描述", width = 40,type = Excel.Type.EXPORT)
    private String newItemDescription;

    /** 替代比例 */
    @Excel(name = "替代比例",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal newPercentQuantity;

    @Excel(name = "替代顺序",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private Integer priorityNum;

    @Excel(name = "当前库存",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal onhandQuantity;

    /** 单位 */
    @Excel(name = "单位", width = 10,type = Excel.Type.EXPORT)
    private String uom;

    /** 生效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生效日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.ALL)
    private Date effectiveStartDate;

    /** 失效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "失效日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.ALL)
    private Date effectiveEndDate;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Long workSubId;

    private String createBy;

    private Long oaRequestId;

    public Long getOaRequestId() {
        return oaRequestId;
    }

    public void setOaRequestId(Long oaRequestId) {
        this.oaRequestId = oaRequestId;
    }

    public Integer getPriorityNum() {
        return priorityNum;
    }

    public void setPriorityNum(Integer priorityNum) {
        this.priorityNum = priorityNum;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setpInventoryItemId(Long pInventoryItemId) 
    {
        this.pInventoryItemId = pInventoryItemId;
    }

    public Long getpInventoryItemId() 
    {
        return pInventoryItemId;
    }
    public void setpItemNumber(String pItemNumber) 
    {
        this.pItemNumber = pItemNumber;
    }

    public String getpItemNumber() 
    {
        return pItemNumber;
    }
    public void setpItemDescription(String pItemDescription) 
    {
        this.pItemDescription = pItemDescription;
    }

    public String getpItemDescription() 
    {
        return pItemDescription;
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
    public void setNewInventoryItemId(Long newInventoryItemId) 
    {
        this.newInventoryItemId = newInventoryItemId;
    }

    public Long getNewInventoryItemId() 
    {
        return newInventoryItemId;
    }
    public void setNewItemNumber(String newItemNumber) 
    {
        this.newItemNumber = newItemNumber;
    }

    public String getNewItemNumber() 
    {
        return newItemNumber;
    }
    public void setNewItemDescription(String newItemDescription) 
    {
        this.newItemDescription = newItemDescription;
    }

    public String getNewItemDescription() 
    {
        return newItemDescription;
    }
    public void setNewPercentQuantity(BigDecimal newPercentQuantity) 
    {
        this.newPercentQuantity = newPercentQuantity;
    }

    public BigDecimal getNewPercentQuantity() 
    {
        return newPercentQuantity;
    }
    public void setUom(String uom) 
    {
        this.uom = uom;
    }

    public String getUom() 
    {
        return uom;
    }
    public void setEffectiveStartDate(Date effectiveStartDate) 
    {
        this.effectiveStartDate = effectiveStartDate;
    }

    public Date getEffectiveStartDate() 
    {
        return effectiveStartDate;
    }
    public void setEffectiveEndDate(Date effectiveEndDate) 
    {
        this.effectiveEndDate = effectiveEndDate;
    }

    public Date getEffectiveEndDate() 
    {
        return effectiveEndDate;
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
    public void setWorkSubId(Long workSubId) 
    {
        this.workSubId = workSubId;
    }

    public Long getWorkSubId() 
    {
        return workSubId;
    }

}
