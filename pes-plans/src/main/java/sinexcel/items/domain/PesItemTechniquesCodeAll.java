package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

/**
 * 编码工艺属性对象 pes_item_techniques_code_all
 * 
 * @author Zhang Kai
 * @date 2021-06-24
 */
public class PesItemTechniquesCodeAll
{
    /** $column.columnComment */
    private Long inventoryItemId;

    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X",type = Excel.Type.EXPORT)
    private Long organizationId;

    @Excel(name = "库存组织",width = 15,type = Excel.Type.IMPORT)
    private String organizationCode;

    /** 物料编码 */
    @Excel(name = "物料编码",width = 15,type = Excel.Type.ALL)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述",width = 40,type = Excel.Type.EXPORT)
    private String itemDescription;

    /** 物料类型 */
    @Excel(name = "物料类型",width = 10,type = Excel.Type.EXPORT)
    private String itemType;

    /** 工艺属性 */
    @Excel(name = "工艺属性",width = 10,type = Excel.Type.ALL,readConverterExp = "1=贴片,2=插件,3=装配,4=辅料,5=SMT,6=DIP")
    private String itemWorkNameFlag;

    /** 固定损耗 */
    @Excel(name = "固定损耗", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal fixedSuoHaoQuantiy;

    /** $column.columnComment */
    private Date createDate;

    private String createBy;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateDate;

    /** $column.columnComment */
    private Long techniquesCodeId;

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
    public void setItemDescription(String itemDescription) 
    {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() 
    {
        return itemDescription;
    }
    public void setItemType(String itemType) 
    {
        this.itemType = itemType;
    }

    public String getItemType() 
    {
        return itemType;
    }
    public void setItemWorkNameFlag(String itemWorkNameFlag) 
    {
        this.itemWorkNameFlag = itemWorkNameFlag;
    }

    public String getItemWorkNameFlag() 
    {
        return itemWorkNameFlag;
    }
    public void setFixedSuoHaoQuantiy(BigDecimal fixedSuoHaoQuantiy) 
    {
        this.fixedSuoHaoQuantiy = fixedSuoHaoQuantiy;
    }

    public BigDecimal getFixedSuoHaoQuantiy() 
    {
        return fixedSuoHaoQuantiy;
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
    public void setTechniquesCodeId(Long techniquesCodeId) 
    {
        this.techniquesCodeId = techniquesCodeId;
    }

    public Long getTechniquesCodeId() 
    {
        return techniquesCodeId;
    }

}
