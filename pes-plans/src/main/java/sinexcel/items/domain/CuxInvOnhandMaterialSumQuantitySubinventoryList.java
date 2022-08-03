package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 库存周波动汇总对象 cux_inv_onhand_material_sum_quantity_subinventory_list
 * 
 * @author Zhang Kai
 * @date 2022-05-28
 */
public class CuxInvOnhandMaterialSumQuantitySubinventoryList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;
    @Excel(name = "物料编码", width = 15)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述", width = 40)
    private String itemDescription;

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

    @Excel(name = "年份", width = 5,cellType = Excel.ColumnType.BigDecimal)
    private Integer transactionYear;

    /** 物料编码 */
    private Long inventoryItemId;

    /** 子库 */
    @Excel(name = "子库", width = 10)
    private String subinventoryCode;

    /** 第一周 */
    @Excel(name = "第一周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal oneQuantity;

    /** 第二周 */
    @Excel(name = "第二周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal twoQuantity;

    /** 第三周 */
    @Excel(name = "第三周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal threeQuantity;

    /** 第四周 */
    @Excel(name = "第四周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fourQuantity;

    /** 第五周 */
    @Excel(name = "第五周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fiveQuantity;

    /** 第六周 */
    @Excel(name = "第六周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sixQuantity;

    /** 第七周 */
    @Excel(name = "第七周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sevenQuantity;

    /** 第八周 */
    @Excel(name = "第八周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal eightQuantity;

    /** 第九周 */
    @Excel(name = "第九周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal nineQuantity;

    /** 第十周 */
    @Excel(name = "第十周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal tenQuantity;

    /** 第十一周 */
    @Excel(name = "第十一周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal elevenQuantity;

    /** 第十二周 */
    @Excel(name = "第十二周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal twelveQuantity;

    /** 第十三周 */
    @Excel(name = "第十三周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal thirteenQuantity;

    /** 第十四周 */
    @Excel(name = "第十四周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fourteenQuantity;

    /** 第十五周 */
    @Excel(name = "第十五周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fifteenQuantity;

    /** 第十六周 */
    @Excel(name = "第十六周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sixteenQuantity;

    /** 第十七周 */
    @Excel(name = "第十七周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal seventeenQuantity;

    /** 第十八周 */
    @Excel(name = "第十八周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal eighteenQuantity;

    /** 第十九周 */
    @Excel(name = "第十九周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal nineteenQuantity;

    /** 第二十周 */
    @Excel(name = "第二十周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal twentyQuantity;

    /** 第二十一周 */
    @Excel(name = "第二十一周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal twentyOneQuantity;

    /** 第二十二周 */
    @Excel(name = "第二十二周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal twentyTwoQuantity;

    /** 第二十三周 */
    @Excel(name = "第二十三周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal twentyThreeQuantity;

    /** 第二十四周 */
    @Excel(name = "第二十四周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal twentyFourQuantity;

    /** 第二十五周 */
    @Excel(name = "第二十五周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal twentyFiveQuantity;

    /** 第二十六周 */
    @Excel(name = "第二十六周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal twentySixQuantity;

    /** 第二十七周 */
    @Excel(name = "第二十七周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal twentySevenQuantity;

    /** 第二十八周 */
    @Excel(name = "第二十八周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal twentyEightQuantity;

    /** 第二十九周 */
    @Excel(name = "第二十九周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal twentyNineQuantity;

    /** 第三十周 */
    @Excel(name = "第三十周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal thirtyQuantity;

    /** 第三十一周 */
    @Excel(name = "第三十一周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal thirtyOneQuantity;

    /** 第三十二周 */
    @Excel(name = "第三十二周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal thirtyTwoQuantity;

    /** 第三十三周 */
    @Excel(name = "第三十三周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal thirtyThreeQuantity;

    /** 第三十四周 */
    @Excel(name = "第三十四周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal thirtyFourQuantity;

    /** 第三十五周 */
    @Excel(name = "第三十五周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal thirtyFiveQuantity;

    /** 第三十六周 */
    @Excel(name = "第三十六周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal thirtySixQuantity;

    /** 第三十七周 */
    @Excel(name = "第三十七周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal thirtySevenQuantity;

    /** 第三十八周 */
    @Excel(name = "第三十八周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal thirtyEightQuantity;

    /** 第三十九周 */
    @Excel(name = "第三十九周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal thirtyNineQuantity;

    /** 第四十周 */
    @Excel(name = "第四十周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fortyQuantity;

    /** 第四十一周 */
    @Excel(name = "第四十一周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fortyOneQuantity;

    /** 第四十二周 */
    @Excel(name = "第四十二周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fortyTwoQuantity;

    /** 第四十三周 */
    @Excel(name = "第四十三周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fortyThreeQuantity;

    /** 第四十四周 */
    @Excel(name = "第四十四周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fortyFourQuantity;

    /** 第四十五周 */
    @Excel(name = "第四十五周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fortyFiveQuantity;

    /** 第四十六周 */
    @Excel(name = "第四十六周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fortySixQuantity;

    /** 第四十七周 */
    @Excel(name = "第四十七周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fortySevenQuantity;

    /** 第四十八周 */
    @Excel(name = "第四十八周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fortyEightQuantity;

    /** 第四十九周 */
    @Excel(name = "第四十九周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fortyNineQuantity;

    /** 第五十周 */
    @Excel(name = "第五十周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fiftyQuantity;

    /** 第五十一周 */
    @Excel(name = "第五十一周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fiftyOneQuantity;

    /** 第五十二周 */
    @Excel(name = "第五十二周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fiftyTwoQuantity;

    /** 第五十三周 */
    @Excel(name = "第五十三周",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal fiftyThreeQuantity;

    /** $column.columnComment */
    private Date lastUpdateDate;

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
    public void setTransactionYear(Integer transactionYear) 
    {
        this.transactionYear = transactionYear;
    }

    public Integer getTransactionYear() 
    {
        return transactionYear;
    }
    public void setSubinventoryCode(String subinventoryCode) 
    {
        this.subinventoryCode = subinventoryCode;
    }

    public String getSubinventoryCode() 
    {
        return subinventoryCode;
    }
    public void setOneQuantity(BigDecimal oneQuantity) 
    {
        this.oneQuantity = oneQuantity;
    }

    public BigDecimal getOneQuantity() 
    {
        return oneQuantity;
    }
    public void setTwoQuantity(BigDecimal twoQuantity) 
    {
        this.twoQuantity = twoQuantity;
    }

    public BigDecimal getTwoQuantity() 
    {
        return twoQuantity;
    }
    public void setThreeQuantity(BigDecimal threeQuantity) 
    {
        this.threeQuantity = threeQuantity;
    }

    public BigDecimal getThreeQuantity() 
    {
        return threeQuantity;
    }
    public void setFourQuantity(BigDecimal fourQuantity) 
    {
        this.fourQuantity = fourQuantity;
    }

    public BigDecimal getFourQuantity() 
    {
        return fourQuantity;
    }
    public void setFiveQuantity(BigDecimal fiveQuantity) 
    {
        this.fiveQuantity = fiveQuantity;
    }

    public BigDecimal getFiveQuantity() 
    {
        return fiveQuantity;
    }
    public void setSixQuantity(BigDecimal sixQuantity) 
    {
        this.sixQuantity = sixQuantity;
    }

    public BigDecimal getSixQuantity() 
    {
        return sixQuantity;
    }
    public void setSevenQuantity(BigDecimal sevenQuantity) 
    {
        this.sevenQuantity = sevenQuantity;
    }

    public BigDecimal getSevenQuantity() 
    {
        return sevenQuantity;
    }
    public void setEightQuantity(BigDecimal eightQuantity) 
    {
        this.eightQuantity = eightQuantity;
    }

    public BigDecimal getEightQuantity() 
    {
        return eightQuantity;
    }
    public void setNineQuantity(BigDecimal nineQuantity) 
    {
        this.nineQuantity = nineQuantity;
    }

    public BigDecimal getNineQuantity() 
    {
        return nineQuantity;
    }
    public void setTenQuantity(BigDecimal tenQuantity) 
    {
        this.tenQuantity = tenQuantity;
    }

    public BigDecimal getTenQuantity() 
    {
        return tenQuantity;
    }
    public void setElevenQuantity(BigDecimal elevenQuantity) 
    {
        this.elevenQuantity = elevenQuantity;
    }

    public BigDecimal getElevenQuantity() 
    {
        return elevenQuantity;
    }
    public void setTwelveQuantity(BigDecimal twelveQuantity) 
    {
        this.twelveQuantity = twelveQuantity;
    }

    public BigDecimal getTwelveQuantity() 
    {
        return twelveQuantity;
    }
    public void setThirteenQuantity(BigDecimal thirteenQuantity) 
    {
        this.thirteenQuantity = thirteenQuantity;
    }

    public BigDecimal getThirteenQuantity() 
    {
        return thirteenQuantity;
    }
    public void setFourteenQuantity(BigDecimal fourteenQuantity) 
    {
        this.fourteenQuantity = fourteenQuantity;
    }

    public BigDecimal getFourteenQuantity() 
    {
        return fourteenQuantity;
    }
    public void setFifteenQuantity(BigDecimal fifteenQuantity) 
    {
        this.fifteenQuantity = fifteenQuantity;
    }

    public BigDecimal getFifteenQuantity() 
    {
        return fifteenQuantity;
    }
    public void setSixteenQuantity(BigDecimal sixteenQuantity) 
    {
        this.sixteenQuantity = sixteenQuantity;
    }

    public BigDecimal getSixteenQuantity() 
    {
        return sixteenQuantity;
    }
    public void setSeventeenQuantity(BigDecimal seventeenQuantity) 
    {
        this.seventeenQuantity = seventeenQuantity;
    }

    public BigDecimal getSeventeenQuantity() 
    {
        return seventeenQuantity;
    }
    public void setEighteenQuantity(BigDecimal eighteenQuantity) 
    {
        this.eighteenQuantity = eighteenQuantity;
    }

    public BigDecimal getEighteenQuantity() 
    {
        return eighteenQuantity;
    }
    public void setNineteenQuantity(BigDecimal nineteenQuantity) 
    {
        this.nineteenQuantity = nineteenQuantity;
    }

    public BigDecimal getNineteenQuantity() 
    {
        return nineteenQuantity;
    }
    public void setTwentyQuantity(BigDecimal twentyQuantity) 
    {
        this.twentyQuantity = twentyQuantity;
    }

    public BigDecimal getTwentyQuantity() 
    {
        return twentyQuantity;
    }
    public void setTwentyOneQuantity(BigDecimal twentyOneQuantity) 
    {
        this.twentyOneQuantity = twentyOneQuantity;
    }

    public BigDecimal getTwentyOneQuantity() 
    {
        return twentyOneQuantity;
    }
    public void setTwentyTwoQuantity(BigDecimal twentyTwoQuantity) 
    {
        this.twentyTwoQuantity = twentyTwoQuantity;
    }

    public BigDecimal getTwentyTwoQuantity() 
    {
        return twentyTwoQuantity;
    }
    public void setTwentyThreeQuantity(BigDecimal twentyThreeQuantity) 
    {
        this.twentyThreeQuantity = twentyThreeQuantity;
    }

    public BigDecimal getTwentyThreeQuantity() 
    {
        return twentyThreeQuantity;
    }
    public void setTwentyFourQuantity(BigDecimal twentyFourQuantity) 
    {
        this.twentyFourQuantity = twentyFourQuantity;
    }

    public BigDecimal getTwentyFourQuantity() 
    {
        return twentyFourQuantity;
    }
    public void setTwentyFiveQuantity(BigDecimal twentyFiveQuantity) 
    {
        this.twentyFiveQuantity = twentyFiveQuantity;
    }

    public BigDecimal getTwentyFiveQuantity() 
    {
        return twentyFiveQuantity;
    }
    public void setTwentySixQuantity(BigDecimal twentySixQuantity) 
    {
        this.twentySixQuantity = twentySixQuantity;
    }

    public BigDecimal getTwentySixQuantity() 
    {
        return twentySixQuantity;
    }
    public void setTwentySevenQuantity(BigDecimal twentySevenQuantity) 
    {
        this.twentySevenQuantity = twentySevenQuantity;
    }

    public BigDecimal getTwentySevenQuantity() 
    {
        return twentySevenQuantity;
    }
    public void setTwentyEightQuantity(BigDecimal twentyEightQuantity) 
    {
        this.twentyEightQuantity = twentyEightQuantity;
    }

    public BigDecimal getTwentyEightQuantity() 
    {
        return twentyEightQuantity;
    }
    public void setTwentyNineQuantity(BigDecimal twentyNineQuantity) 
    {
        this.twentyNineQuantity = twentyNineQuantity;
    }

    public BigDecimal getTwentyNineQuantity() 
    {
        return twentyNineQuantity;
    }
    public void setThirtyQuantity(BigDecimal thirtyQuantity) 
    {
        this.thirtyQuantity = thirtyQuantity;
    }

    public BigDecimal getThirtyQuantity() 
    {
        return thirtyQuantity;
    }
    public void setThirtyOneQuantity(BigDecimal thirtyOneQuantity) 
    {
        this.thirtyOneQuantity = thirtyOneQuantity;
    }

    public BigDecimal getThirtyOneQuantity() 
    {
        return thirtyOneQuantity;
    }
    public void setThirtyTwoQuantity(BigDecimal thirtyTwoQuantity) 
    {
        this.thirtyTwoQuantity = thirtyTwoQuantity;
    }

    public BigDecimal getThirtyTwoQuantity() 
    {
        return thirtyTwoQuantity;
    }
    public void setThirtyThreeQuantity(BigDecimal thirtyThreeQuantity) 
    {
        this.thirtyThreeQuantity = thirtyThreeQuantity;
    }

    public BigDecimal getThirtyThreeQuantity() 
    {
        return thirtyThreeQuantity;
    }
    public void setThirtyFourQuantity(BigDecimal thirtyFourQuantity) 
    {
        this.thirtyFourQuantity = thirtyFourQuantity;
    }

    public BigDecimal getThirtyFourQuantity() 
    {
        return thirtyFourQuantity;
    }
    public void setThirtyFiveQuantity(BigDecimal thirtyFiveQuantity) 
    {
        this.thirtyFiveQuantity = thirtyFiveQuantity;
    }

    public BigDecimal getThirtyFiveQuantity() 
    {
        return thirtyFiveQuantity;
    }
    public void setThirtySixQuantity(BigDecimal thirtySixQuantity) 
    {
        this.thirtySixQuantity = thirtySixQuantity;
    }

    public BigDecimal getThirtySixQuantity() 
    {
        return thirtySixQuantity;
    }
    public void setThirtySevenQuantity(BigDecimal thirtySevenQuantity) 
    {
        this.thirtySevenQuantity = thirtySevenQuantity;
    }

    public BigDecimal getThirtySevenQuantity() 
    {
        return thirtySevenQuantity;
    }
    public void setThirtyEightQuantity(BigDecimal thirtyEightQuantity) 
    {
        this.thirtyEightQuantity = thirtyEightQuantity;
    }

    public BigDecimal getThirtyEightQuantity() 
    {
        return thirtyEightQuantity;
    }
    public void setThirtyNineQuantity(BigDecimal thirtyNineQuantity) 
    {
        this.thirtyNineQuantity = thirtyNineQuantity;
    }

    public BigDecimal getThirtyNineQuantity() 
    {
        return thirtyNineQuantity;
    }
    public void setFortyQuantity(BigDecimal fortyQuantity) 
    {
        this.fortyQuantity = fortyQuantity;
    }

    public BigDecimal getFortyQuantity() 
    {
        return fortyQuantity;
    }
    public void setFortyOneQuantity(BigDecimal fortyOneQuantity) 
    {
        this.fortyOneQuantity = fortyOneQuantity;
    }

    public BigDecimal getFortyOneQuantity() 
    {
        return fortyOneQuantity;
    }
    public void setFortyTwoQuantity(BigDecimal fortyTwoQuantity) 
    {
        this.fortyTwoQuantity = fortyTwoQuantity;
    }

    public BigDecimal getFortyTwoQuantity() 
    {
        return fortyTwoQuantity;
    }
    public void setFortyThreeQuantity(BigDecimal fortyThreeQuantity) 
    {
        this.fortyThreeQuantity = fortyThreeQuantity;
    }

    public BigDecimal getFortyThreeQuantity() 
    {
        return fortyThreeQuantity;
    }
    public void setFortyFourQuantity(BigDecimal fortyFourQuantity) 
    {
        this.fortyFourQuantity = fortyFourQuantity;
    }

    public BigDecimal getFortyFourQuantity() 
    {
        return fortyFourQuantity;
    }
    public void setFortyFiveQuantity(BigDecimal fortyFiveQuantity) 
    {
        this.fortyFiveQuantity = fortyFiveQuantity;
    }

    public BigDecimal getFortyFiveQuantity() 
    {
        return fortyFiveQuantity;
    }
    public void setFortySixQuantity(BigDecimal fortySixQuantity) 
    {
        this.fortySixQuantity = fortySixQuantity;
    }

    public BigDecimal getFortySixQuantity() 
    {
        return fortySixQuantity;
    }
    public void setFortySevenQuantity(BigDecimal fortySevenQuantity) 
    {
        this.fortySevenQuantity = fortySevenQuantity;
    }

    public BigDecimal getFortySevenQuantity() 
    {
        return fortySevenQuantity;
    }
    public void setFortyEightQuantity(BigDecimal fortyEightQuantity) 
    {
        this.fortyEightQuantity = fortyEightQuantity;
    }

    public BigDecimal getFortyEightQuantity() 
    {
        return fortyEightQuantity;
    }
    public void setFortyNineQuantity(BigDecimal fortyNineQuantity) 
    {
        this.fortyNineQuantity = fortyNineQuantity;
    }

    public BigDecimal getFortyNineQuantity() 
    {
        return fortyNineQuantity;
    }
    public void setFiftyQuantity(BigDecimal fiftyQuantity) 
    {
        this.fiftyQuantity = fiftyQuantity;
    }

    public BigDecimal getFiftyQuantity() 
    {
        return fiftyQuantity;
    }
    public void setFiftyOneQuantity(BigDecimal fiftyOneQuantity) 
    {
        this.fiftyOneQuantity = fiftyOneQuantity;
    }

    public BigDecimal getFiftyOneQuantity() 
    {
        return fiftyOneQuantity;
    }
    public void setFiftyTwoQuantity(BigDecimal fiftyTwoQuantity) 
    {
        this.fiftyTwoQuantity = fiftyTwoQuantity;
    }

    public BigDecimal getFiftyTwoQuantity() 
    {
        return fiftyTwoQuantity;
    }
    public void setFiftyThreeQuantity(BigDecimal fiftyThreeQuantity) 
    {
        this.fiftyThreeQuantity = fiftyThreeQuantity;
    }

    public BigDecimal getFiftyThreeQuantity() 
    {
        return fiftyThreeQuantity;
    }
    public void setLastUpdateDate(Date lastUpdateDate) 
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() 
    {
        return lastUpdateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("organizationId", getOrganizationId())
            .append("inventoryItemId", getInventoryItemId())
            .append("transactionYear", getTransactionYear())
            .append("subinventoryCode", getSubinventoryCode())
            .append("oneQuantity", getOneQuantity())
            .append("twoQuantity", getTwoQuantity())
            .append("threeQuantity", getThreeQuantity())
            .append("fourQuantity", getFourQuantity())
            .append("fiveQuantity", getFiveQuantity())
            .append("sixQuantity", getSixQuantity())
            .append("sevenQuantity", getSevenQuantity())
            .append("eightQuantity", getEightQuantity())
            .append("nineQuantity", getNineQuantity())
            .append("tenQuantity", getTenQuantity())
            .append("elevenQuantity", getElevenQuantity())
            .append("twelveQuantity", getTwelveQuantity())
            .append("thirteenQuantity", getThirteenQuantity())
            .append("fourteenQuantity", getFourteenQuantity())
            .append("fifteenQuantity", getFifteenQuantity())
            .append("sixteenQuantity", getSixteenQuantity())
            .append("seventeenQuantity", getSeventeenQuantity())
            .append("eighteenQuantity", getEighteenQuantity())
            .append("nineteenQuantity", getNineteenQuantity())
            .append("twentyQuantity", getTwentyQuantity())
            .append("twentyOneQuantity", getTwentyOneQuantity())
            .append("twentyTwoQuantity", getTwentyTwoQuantity())
            .append("twentyThreeQuantity", getTwentyThreeQuantity())
            .append("twentyFourQuantity", getTwentyFourQuantity())
            .append("twentyFiveQuantity", getTwentyFiveQuantity())
            .append("twentySixQuantity", getTwentySixQuantity())
            .append("twentySevenQuantity", getTwentySevenQuantity())
            .append("twentyEightQuantity", getTwentyEightQuantity())
            .append("twentyNineQuantity", getTwentyNineQuantity())
            .append("thirtyQuantity", getThirtyQuantity())
            .append("thirtyOneQuantity", getThirtyOneQuantity())
            .append("thirtyTwoQuantity", getThirtyTwoQuantity())
            .append("thirtyThreeQuantity", getThirtyThreeQuantity())
            .append("thirtyFourQuantity", getThirtyFourQuantity())
            .append("thirtyFiveQuantity", getThirtyFiveQuantity())
            .append("thirtySixQuantity", getThirtySixQuantity())
            .append("thirtySevenQuantity", getThirtySevenQuantity())
            .append("thirtyEightQuantity", getThirtyEightQuantity())
            .append("thirtyNineQuantity", getThirtyNineQuantity())
            .append("fortyQuantity", getFortyQuantity())
            .append("fortyOneQuantity", getFortyOneQuantity())
            .append("fortyTwoQuantity", getFortyTwoQuantity())
            .append("fortyThreeQuantity", getFortyThreeQuantity())
            .append("fortyFourQuantity", getFortyFourQuantity())
            .append("fortyFiveQuantity", getFortyFiveQuantity())
            .append("fortySixQuantity", getFortySixQuantity())
            .append("fortySevenQuantity", getFortySevenQuantity())
            .append("fortyEightQuantity", getFortyEightQuantity())
            .append("fortyNineQuantity", getFortyNineQuantity())
            .append("fiftyQuantity", getFiftyQuantity())
            .append("fiftyOneQuantity", getFiftyOneQuantity())
            .append("fiftyTwoQuantity", getFiftyTwoQuantity())
            .append("fiftyThreeQuantity", getFiftyThreeQuantity())
            .append("lastUpdateDate", getLastUpdateDate())
            .toString();
    }
}
