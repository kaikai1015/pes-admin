package sinexcel.procument.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 生成采购计划行信息对象 pes_procument_plan_line_list
 * 
 * @author Zhang Kai
 * @date 2020-12-09
 */
public class PesProcumentPlanLineList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 行ID */
    private Integer lineId;

    /** 组织ID */
    @Excel(name = "组织ID")
    private Long organizationId;

    /** 阶次 */
    @Excel(name = "阶次")
    private Integer level;

    /** 计划批次行号 */
    @Excel(name = "计划批次行号")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long lineNum;

    /** 计划类型 */
    @Excel(name = "计划类型")
    private String planType;

    /** 本阶树状码 */
    @Excel(name = "本阶树状码")
    private String levelTreeCode;

    /** 物料ID */
    private Long inventoryItemId;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述")
    private String itemDescription;

    /** 物料类型 */
    @Excel(name = "物料类型")
    private String itemType;

    /** 单品用量 */
    @Excel(name = "单品用量")
    private BigDecimal componentQuantity;

    /** 单位 */
    @Excel(name = "单位")
    private String uom;

    /** 计划采购数量 */
    @Excel(name = "计划采购数量")
    private BigDecimal planPoQuantity;

    /** 计划入库日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划入库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planRcvtDate;

    /** 计划采购日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划采购日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planPoDate;

    /** 毛需求数量 */
    @Excel(name = "毛需求数量")
    private BigDecimal grossQuantity;

    /** 毛需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "毛需求日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date grossDate;

    /** 上阶主件ID */
    private Long pInventoryItemId;

    /** 上阶主件 */
    @Excel(name = "上阶主件")
    private String pItemNumber;

    /** 上阶主件描述 */
    @Excel(name = "上阶主件描述")
    private String pItemDescription;

    /** 上阶树状码 */
    @Excel(name = "上阶树状码")
    private String parentLevelTreeCode;

    /** 上阶需求数量 */
    @Excel(name = "上阶需求数量")
    private BigDecimal parentGrossQuantity;

    /** 上阶需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上阶需求日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date parentGrossDate;

    /** 来源主计划批号 */
    @Excel(name = "来源主计划批号")
    private Long planLotNum;

    /** 来源主计划行号 */
    @Excel(name = "来源主计划行号")
    private Long planLotLineNum;

    /** 来源物料编码 */
    @Excel(name = "来源物料编码")
    private String planItemNumber;

    /** 来源物料类别 */
    @Excel(name = "来源物料类别")
    private String planItemType;

    /** 来源主计划数量 */
    @Excel(name = "来源主计划数量")
    private BigDecimal planItemQuantity;

    /** 来源计划日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "来源计划日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planDate;

    /** 来源树状码 */
    @Excel(name = "来源树状码")
    private String planTreeCode;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    private String buyerName;

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setLineId(Integer lineId) 
    {
        this.lineId = lineId;
    }

    public Integer getLineId() 
    {
        return lineId;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setLevel(Integer level) 
    {
        this.level = level;
    }

    public Integer getLevel() 
    {
        return level;
    }
    public void setLineNum(Long lineNum) 
    {
        this.lineNum = lineNum;
    }

    public Long getLineNum() 
    {
        return lineNum;
    }
    public void setPlanType(String planType) 
    {
        this.planType = planType;
    }

    public String getPlanType() 
    {
        return planType;
    }
    public void setLevelTreeCode(String levelTreeCode) 
    {
        this.levelTreeCode = levelTreeCode;
    }

    public String getLevelTreeCode() 
    {
        return levelTreeCode;
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
    public void setUom(String uom) 
    {
        this.uom = uom;
    }

    public String getUom() 
    {
        return uom;
    }
    public void setPlanPoQuantity(BigDecimal planPoQuantity) 
    {
        this.planPoQuantity = planPoQuantity;
    }

    public BigDecimal getPlanPoQuantity() 
    {
        return planPoQuantity;
    }
    public void setPlanRcvtDate(Date planRcvtDate) 
    {
        this.planRcvtDate = planRcvtDate;
    }

    public Date getPlanRcvtDate() 
    {
        return planRcvtDate;
    }
    public void setPlanPoDate(Date planPoDate) 
    {
        this.planPoDate = planPoDate;
    }

    public Date getPlanPoDate() 
    {
        return planPoDate;
    }
    public void setGrossQuantity(BigDecimal grossQuantity) 
    {
        this.grossQuantity = grossQuantity;
    }

    public BigDecimal getGrossQuantity() 
    {
        return grossQuantity;
    }
    public void setGrossDate(Date grossDate) 
    {
        this.grossDate = grossDate;
    }

    public Date getGrossDate() 
    {
        return grossDate;
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
    public void setParentLevelTreeCode(String parentLevelTreeCode) 
    {
        this.parentLevelTreeCode = parentLevelTreeCode;
    }

    public String getParentLevelTreeCode() 
    {
        return parentLevelTreeCode;
    }
    public void setParentGrossQuantity(BigDecimal parentGrossQuantity) 
    {
        this.parentGrossQuantity = parentGrossQuantity;
    }

    public BigDecimal getParentGrossQuantity() 
    {
        return parentGrossQuantity;
    }
    public void setParentGrossDate(Date parentGrossDate) 
    {
        this.parentGrossDate = parentGrossDate;
    }

    public Date getParentGrossDate() 
    {
        return parentGrossDate;
    }
    public void setPlanLotNum(Long planLotNum) 
    {
        this.planLotNum = planLotNum;
    }

    public Long getPlanLotNum() 
    {
        return planLotNum;
    }
    public void setPlanLotLineNum(Long planLotLineNum) 
    {
        this.planLotLineNum = planLotLineNum;
    }

    public Long getPlanLotLineNum() 
    {
        return planLotLineNum;
    }
    public void setPlanItemNumber(String planItemNumber) 
    {
        this.planItemNumber = planItemNumber;
    }

    public String getPlanItemNumber() 
    {
        return planItemNumber;
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
    public void setPlanDate(Date planDate) 
    {
        this.planDate = planDate;
    }

    public Date getPlanDate() 
    {
        return planDate;
    }
    public void setPlanTreeCode(String planTreeCode) 
    {
        this.planTreeCode = planTreeCode;
    }

    public String getPlanTreeCode() 
    {
        return planTreeCode;
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
            .append("lineId", getLineId())
            .append("organizationId", getOrganizationId())
            .append("level", getLevel())
            .append("lineNum", getLineNum())
            .append("planType", getPlanType())
            .append("levelTreeCode", getLevelTreeCode())
            .append("inventoryItemId", getInventoryItemId())
            .append("itemNumber", getItemNumber())
            .append("itemDescription", getItemDescription())
            .append("itemType", getItemType())
            .append("componentQuantity", getComponentQuantity())
            .append("uom", getUom())
            .append("planPoQuantity", getPlanPoQuantity())
            .append("planRcvtDate", getPlanRcvtDate())
            .append("planPoDate", getPlanPoDate())
            .append("grossQuantity", getGrossQuantity())
            .append("grossDate", getGrossDate())
            .append("pInventoryItemId", getpInventoryItemId())
            .append("pItemNumber", getpItemNumber())
            .append("pItemDescription", getpItemDescription())
            .append("parentLevelTreeCode", getParentLevelTreeCode())
            .append("parentGrossQuantity", getParentGrossQuantity())
            .append("parentGrossDate", getParentGrossDate())
            .append("planLotNum", getPlanLotNum())
            .append("planLotLineNum", getPlanLotLineNum())
            .append("planItemNumber", getPlanItemNumber())
            .append("planItemType", getPlanItemType())
            .append("planItemQuantity", getPlanItemQuantity())
            .append("planDate", getPlanDate())
            .append("planTreeCode", getPlanTreeCode())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .toString();
    }
}
