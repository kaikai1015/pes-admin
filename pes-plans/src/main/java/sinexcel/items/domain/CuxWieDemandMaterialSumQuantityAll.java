package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 工单发料数据汇总对象 cux_wie_demand_material_sum_quantity_all
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
public class CuxWieDemandMaterialSumQuantityAll extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    /** 物料编码 */
    @Excel(name = "物料编码", width = 15)
    private String itemNumber;
    @Excel(name = "物料描述", width = 40)
    private String itemDescription;
    private Long inventoryItemId;

    /** 年份 */
    @Excel(name = "年份", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Integer transactionYear;

    @Excel(name = "单位成本", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sumUnitCost;

    /** 一月工单发料 */
    @Excel(name = "一月工单发料", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal janQuantity;

    /** 二月工单发料 */
    @Excel(name = "二月工单发料", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal febQuantity;

    /** 三月工单发料 */
    @Excel(name = "三月工单发料", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal marQuantity;

    /** 四月工单发料 */
    @Excel(name = "四月工单发料", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal aprQuantity;

    /** 五月工单发料 */
    @Excel(name = "五月工单发料", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal mayQuantity;

    /** 六月工单发料 */
    @Excel(name = "六月工单发料", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal junQuantity;

    /** 七月工单发料 */
    @Excel(name = "七月工单发料", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal julQuantity;

    /** 八月工单发料 */
    @Excel(name = "八月工单发料", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal augQuantity;

    /** 九月工单发料 */
    @Excel(name = "九月工单发料", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sepQuantity;

    /** 十月工单发料 */
    @Excel(name = "十月工单发料", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal octQuantity;

    /** 十一月工单发料 */
    @Excel(name = "十一月工单发料", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal novQuantity;

    /** 十二月工单发料 */
    @Excel(name = "十二月工单发料", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal decQuantity;

    /** $column.columnComment */
    private Date lastUpdateDate;

    public BigDecimal getSumUnitCost() {
        return sumUnitCost;
    }

    public void setSumUnitCost(BigDecimal sumUnitCost) {
        this.sumUnitCost = sumUnitCost;
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
    public void setJanQuantity(BigDecimal janQuantity)
    {
        this.janQuantity = janQuantity;
    }

    public BigDecimal getJanQuantity()
    {
        return janQuantity;
    }
    public void setFebQuantity(BigDecimal febQuantity)
    {
        this.febQuantity = febQuantity;
    }

    public BigDecimal getFebQuantity()
    {
        return febQuantity;
    }
    public void setMarQuantity(BigDecimal marQuantity)
    {
        this.marQuantity = marQuantity;
    }

    public BigDecimal getMarQuantity()
    {
        return marQuantity;
    }
    public void setAprQuantity(BigDecimal aprQuantity)
    {
        this.aprQuantity = aprQuantity;
    }

    public BigDecimal getAprQuantity()
    {
        return aprQuantity;
    }
    public void setMayQuantity(BigDecimal mayQuantity)
    {
        this.mayQuantity = mayQuantity;
    }

    public BigDecimal getMayQuantity()
    {
        return mayQuantity;
    }
    public void setJunQuantity(BigDecimal junQuantity)
    {
        this.junQuantity = junQuantity;
    }

    public BigDecimal getJunQuantity()
    {
        return junQuantity;
    }
    public void setJulQuantity(BigDecimal julQuantity)
    {
        this.julQuantity = julQuantity;
    }

    public BigDecimal getJulQuantity()
    {
        return julQuantity;
    }
    public void setAugQuantity(BigDecimal augQuantity)
    {
        this.augQuantity = augQuantity;
    }

    public BigDecimal getAugQuantity()
    {
        return augQuantity;
    }
    public void setSepQuantity(BigDecimal sepQuantity)
    {
        this.sepQuantity = sepQuantity;
    }

    public BigDecimal getSepQuantity()
    {
        return sepQuantity;
    }
    public void setOctQuantity(BigDecimal octQuantity)
    {
        this.octQuantity = octQuantity;
    }

    public BigDecimal getOctQuantity()
    {
        return octQuantity;
    }
    public void setNovQuantity(BigDecimal novQuantity)
    {
        this.novQuantity = novQuantity;
    }

    public BigDecimal getNovQuantity()
    {
        return novQuantity;
    }
    public void setDecQuantity(BigDecimal decQuantity)
    {
        this.decQuantity = decQuantity;
    }

    public BigDecimal getDecQuantity()
    {
        return decQuantity;
    }
    public void setLastUpdateDate(Date lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate()
    {
        return lastUpdateDate;
    }
    public void setTransactionYear(Integer transactionYear)
    {
        this.transactionYear = transactionYear;
    }

    public Integer getTransactionYear()
    {
        return transactionYear;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("organizationId", getOrganizationId())
                .append("inventoryItemId", getInventoryItemId())
                .append("janQuantity", getJanQuantity())
                .append("febQuantity", getFebQuantity())
                .append("marQuantity", getMarQuantity())
                .append("aprQuantity", getAprQuantity())
                .append("mayQuantity", getMayQuantity())
                .append("junQuantity", getJunQuantity())
                .append("julQuantity", getJulQuantity())
                .append("augQuantity", getAugQuantity())
                .append("sepQuantity", getSepQuantity())
                .append("octQuantity", getOctQuantity())
                .append("novQuantity", getNovQuantity())
                .append("decQuantity", getDecQuantity())
                .append("lastUpdateDate", getLastUpdateDate())
                .append("transactionYear", getTransactionYear())
                .toString();
    }
}
