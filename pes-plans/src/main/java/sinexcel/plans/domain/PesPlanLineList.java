package sinexcel.plans.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.annotation.Excel.Type;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 主计划行对象 pes_plan_line_list
 *
 * @author Zhang Kai
 * @date 2020-11-20
 */
public class PesPlanLineList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 组织ID */
    private Long organizationId;

    /** 主计划批次号 */
    @Excel(name = "主计划批次号", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.EXPORT)
    private Long planLotNum;

    /** 行号 */
    @Excel(name = "行号", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.EXPORT)
    private Integer planLotLineNum;

    /** 库存组织 */
    @Excel(name = "库存组织",width = 10,combo = {"INV_SH_X","INV_HZ_X","INV_XA","INV_HZSH","INV_US","INV_ZHNY","INV_HZSH_FEE","INV_SHENZHEN_HZ_X"},type = Type.ALL)
    private String organizationCode;

    /** 产品线 */
    private String prodLine;

    /** 物料ID */
    private Long inventoryItemId;

    /** 物料编码 */
    @Excel(name = "物料编码",width = 15,type = Type.ALL)
    private String planItemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述",width = 40,type = Type.EXPORT)
    private String planItemDescription;

    /** 类型 */
    @Excel(name = "物料类型",width = 10,type = Type.EXPORT)
    private String planItemType;

    /** 需求数量 */
    @Excel(name = "需求数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.ALL)
    private BigDecimal planItemQuantity;

    /** 树状码 */
    @Excel(name = "树状码",width = 15,type = Type.EXPORT)
    private String planTreeCode;

    /** 需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求日期", width = 10, dateFormat = "yyyy-MM-dd",prompt="日期格式：yyyy-MM-dd（2021-01-01）",type = Type.ALL)
    private Date planDate;

    @Excel(name = "备货来源",width = 15,type = Excel.Type.ALL,combo = {"客户提前下单","电子料备货","库存水位","售后需求","其他"},readConverterExp = "1=客户提前下单,2=电子料备货,3=库存水位,4=售后需求,5=其他")
    private String planForcastType;

    @Excel(name = "备货单价", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.ALL)
    private BigDecimal planForcastPrice;

    @Excel(name = "备货总金额", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.ALL)
    private BigDecimal planForcastAmount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计消耗时间", width = 10, dateFormat = "yyyy-MM-dd",prompt="日期格式：yyyy-MM-dd（2022-01-01）",type = Type.ALL)
    private Date planForcastDeliveryDate;

    public String getPlanForcastType() {
        return planForcastType;
    }

    public void setPlanForcastType(String planForcastType) {
        this.planForcastType = planForcastType;
    }

    public BigDecimal getPlanForcastPrice() {
        return planForcastPrice;
    }

    public void setPlanForcastPrice(BigDecimal planForcastPrice) {
        this.planForcastPrice = planForcastPrice;
    }

    public BigDecimal getPlanForcastAmount() {
        return planForcastAmount;
    }

    public void setPlanForcastAmount(BigDecimal planForcastAmount) {
        this.planForcastAmount = planForcastAmount;
    }

    public Date getPlanForcastDeliveryDate() {
        return planForcastDeliveryDate;
    }

    public void setPlanForcastDeliveryDate(Date planForcastDeliveryDate) {
        this.planForcastDeliveryDate = planForcastDeliveryDate;
    }

    /** 创建日期 */
    private Date createDate;

    /** 最后更新日期 */
    private Date lastUpdateDate;

    /** 最后跟新人 */
    private String lastUpdateBy;

    /** ID */
    private Integer id;

    /**MRP计算标识*/
    private char mrpFlag;

    public char getMrpFlag() {
        return mrpFlag;
    }

    public void setMrpFlag(char mrpFlag) {
        this.mrpFlag = mrpFlag;
    }

    public void setOrganizationId(Long organizationId)
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId()
    {
        return organizationId;
    }
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationCode()
    {
        return organizationCode;
    }
    public void setProdLine(String prodLine)
    {
        this.prodLine = prodLine;
    }

    public String getProdLine()
    {
        return prodLine;
    }
    public void setPlanLotNum(Long planLotNum)
    {
        this.planLotNum = planLotNum;
    }

    public Long getPlanLotNum()
    {
        return planLotNum;
    }
    public void setPlanLotLineNum(Integer planLotLineNum)
    {
        this.planLotLineNum = planLotLineNum;
    }

    public Integer getPlanLotLineNum()
    {
        return planLotLineNum;
    }
    public void setInventoryItemId(Long inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId()
    {
        return inventoryItemId;
    }
    public void setPlanItemNumber(String planItemNumber)
    {
        this.planItemNumber = planItemNumber;
    }

    public String getPlanItemNumber()
    {
        return planItemNumber;
    }
    public void setPlanItemDescription(String planItemDescription)
    {
        this.planItemDescription = planItemDescription;
    }

    public String getPlanItemDescription()
    {
        return planItemDescription;
    }
    public void setPlanItemType(String planItemType)
    {
        this.planItemType = planItemType;
    }

    public String getPlanItemType()
    {
        return planItemType;
    }
    public void setPlanItemQuantity(BigDecimal planItemQuantity)
    {
        this.planItemQuantity = planItemQuantity;
    }

    public BigDecimal getPlanItemQuantity()
    {
        return planItemQuantity;
    }
    public void setPlanTreeCode(String planTreeCode)
    {
        this.planTreeCode = planTreeCode;
    }

    public String getPlanTreeCode()
    {
        return planTreeCode;
    }
    public void setPlanDate(Date planDate)
    {
        this.planDate = planDate;
    }

    public Date getPlanDate()
    {
        return planDate;
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
    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("organizationId", getOrganizationId())
                .append("organizationCode", getOrganizationCode())
                .append("prodLine", getProdLine())
                .append("planLotNum", getPlanLotNum())
                .append("planLotLineNum", getPlanLotLineNum())
                .append("inventoryItemId", getInventoryItemId())
                .append("planItemNumber", getPlanItemNumber())
                .append("planItemDescription", getPlanItemDescription())
                .append("planItemType", getPlanItemType())
                .append("planItemQuantity", getPlanItemQuantity())
                .append("planTreeCode", getPlanTreeCode())
                .append("planDate", getPlanDate())
                .append("createDate", getCreateDate())
                .append("createBy", getCreateBy())
                .append("lastUpdateDate", getLastUpdateDate())
                .append("lastUpdateBy", getLastUpdateBy())
                .append("id", getId())
                .append("mrpFlag", getMrpFlag())
                .toString();
    }
}
