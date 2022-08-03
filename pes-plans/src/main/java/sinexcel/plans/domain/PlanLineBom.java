package sinexcel.plans.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class PlanLineBom extends BaseEntity {

	private Long pInventoryItemId;
	private Long organizationId;
	private String pItemNumber;
	private String pItemDescription;
	private Integer level;
	private String planType;
	private String levelTreeCode;
	private Long inventoryItemId;
	private String itemNumber;
	private String itemDescription;
	private String itemType;
	private BigDecimal componentQuantity;
	private BigDecimal biaoComponentQuantity;
	private String uom;
	private BigDecimal grossQuantity;
	private Date grossDate;
	private String parentLevelTreeCode;
	private Long planLotNum;
	private Long planLotLineNum;
	@JsonSerialize(using= ToStringSerializer.class)
	private Long lineNum;
	private String planItemNumber;
	private String planItemType;
	private BigDecimal planItemQuantity;
	private Date planDate;
	private String planTreeCode;
	private String organizationCode;
	private Date createDate;
	private Date lastUpdateDate;
	private String lastUpdateBy;
	private Integer id;
	private BigDecimal parentGrossQuantity;
	private Date parentGrossDate;
	private String mrpFlag;
	private String createBy;
	private String planItemDescription;
	private BigDecimal sumGrossQuantity;

	public BigDecimal getBiaoComponentQuantity() {
		return biaoComponentQuantity;
	}

	public void setBiaoComponentQuantity(BigDecimal biaoComponentQuantity) {
		this.biaoComponentQuantity = biaoComponentQuantity;
	}

	public BigDecimal getSumGrossQuantity() {
		return sumGrossQuantity;
	}

	public void setSumGrossQuantity(BigDecimal sumGrossQuantity) {
		this.sumGrossQuantity = sumGrossQuantity;
	}


	public String getPlanItemDescription() {
		return planItemDescription;
	}

	public void setPlanItemDescription(String planItemDescription) {
		this.planItemDescription = planItemDescription;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getMrpFlag() {
		return mrpFlag;
	}

	public void setMrpFlag(String mrpFlag) {
		this.mrpFlag = mrpFlag;
	}

	public Long getpInventoryItemId() {
		return pInventoryItemId;
	}

	public void setpInventoryItemId(Long pInventoryItemId) {
		this.pInventoryItemId = pInventoryItemId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getpItemNumber() {
		return pItemNumber;
	}

	public void setpItemNumber(String pItemNumber) {
		this.pItemNumber = pItemNumber;
	}

	public String getpItemDescription() {
		return pItemDescription;
	}

	public void setpItemDescription(String pItemDescription) {
		this.pItemDescription = pItemDescription;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getLevelTreeCode() {
		return levelTreeCode;
	}

	public void setLevelTreeCode(String levelTreeCode) {
		this.levelTreeCode = levelTreeCode;
	}

	public Long getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(Long inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
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

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public BigDecimal getComponentQuantity() {
		return componentQuantity;
	}

	public void setComponentQuantity(BigDecimal componentQuantity) {
		this.componentQuantity = componentQuantity;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public BigDecimal getGrossQuantity() {
		return grossQuantity;
	}

	public void setGrossQuantity(BigDecimal grossQuantity) {
		this.grossQuantity = grossQuantity;
	}

	public Date getGrossDate() {
		return grossDate;
	}

	public void setGrossDate(Date grossDate) {
		this.grossDate = grossDate;
	}

	public String getParentLevelTreeCode() {
		return parentLevelTreeCode;
	}

	public void setParentLevelTreeCode(String parentLevelTreeCode) {
		this.parentLevelTreeCode = parentLevelTreeCode;
	}

	public Long getPlanLotNum() {
		return planLotNum;
	}

	public void setPlanLotNum(Long planLotNum) {
		this.planLotNum = planLotNum;
	}

	public Long getPlanLotLineNum() {
		return planLotLineNum;
	}

	public void setPlanLotLineNum(Long planLotLineNum) {
		this.planLotLineNum = planLotLineNum;
	}

	public Long getLineNum() {
		return lineNum;
	}

	public void setLineNum(Long lineNum) {
		this.lineNum = lineNum;
	}

	public String getPlanItemNumber() {
		return planItemNumber;
	}

	public void setPlanItemNumber(String planItemNumber) {
		this.planItemNumber = planItemNumber;
	}

	public String getPlanItemType() {
		return planItemType;
	}

	public void setPlanItemType(String planItemType) {
		this.planItemType = planItemType;
	}

	public BigDecimal getPlanItemQuantity() {
		return planItemQuantity;
	}

	public void setPlanItemQuantity(BigDecimal planItemQuantity) {
		this.planItemQuantity = planItemQuantity;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public String getPlanTreeCode() {
		return planTreeCode;
	}

	public void setPlanTreeCode(String planTreeCode) {
		this.planTreeCode = planTreeCode;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getParentGrossQuantity() {
		return parentGrossQuantity;
	}

	public void setParentGrossQuantity(BigDecimal parentGrossQuantity) {
		this.parentGrossQuantity = parentGrossQuantity;
	}

	public Date getParentGrossDate() {
		return parentGrossDate;
	}

	public void setParentGrossDate(Date parentGrossDate) {
		this.parentGrossDate = parentGrossDate;
	}
}
