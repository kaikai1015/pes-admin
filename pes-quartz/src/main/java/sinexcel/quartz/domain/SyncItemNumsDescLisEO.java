package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 物料编码和描述快码对象 sync_items_num_des_list
 *
 * @author Zhang Kai
 * @date 2020-12-14
 */
public class SyncItemNumsDescLisEO extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private Long organizationId;
    private Long inventoryItemId;
    private String itemDescription;
    private String itemNumber;
    private Date lastUpdateDate;
    private String itemType;
    private String planningMakeBuyCode;
    private String primaryUomCode;
    private String inventoryItemStatusCode;
    private String itemWorkNameFlag;
    protected BigDecimal fixedSuoHaoQuantiy;
    private BigDecimal fixedLeadTime;
    private BigDecimal minimumOrderQuantity;
    private String buyerName;

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public BigDecimal getFixedLeadTime() {
        return fixedLeadTime;
    }

    public void setFixedLeadTime(BigDecimal fixedLeadTime) {
        this.fixedLeadTime = fixedLeadTime;
    }

    public BigDecimal getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(BigDecimal minimumOrderQuantity) {
        this.minimumOrderQuantity = minimumOrderQuantity;
    }

    public String getItemWorkNameFlag() {
        return itemWorkNameFlag;
    }

    public void setItemWorkNameFlag(String itemWorkNameFlag) {
        this.itemWorkNameFlag = itemWorkNameFlag;
    }

    public BigDecimal getFixedSuoHaoQuantiy() {
        return fixedSuoHaoQuantiy;
    }

    public void setFixedSuoHaoQuantiy(BigDecimal fixedSuoHaoQuantiy) {
        this.fixedSuoHaoQuantiy = fixedSuoHaoQuantiy;
    }

    public String getInventoryItemStatusCode() {
        return inventoryItemStatusCode;
    }

    public void setInventoryItemStatusCode(String inventoryItemStatusCode) {
        this.inventoryItemStatusCode = inventoryItemStatusCode;
    }

    public String getPrimaryUomCode() {
        return primaryUomCode;
    }

    public void setPrimaryUomCode(String primaryUomCode) {
        this.primaryUomCode = primaryUomCode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getPlanningMakeBuyCode() {
        return planningMakeBuyCode;
    }

    public void setPlanningMakeBuyCode(String planningMakeBuyCode) {
        this.planningMakeBuyCode = planningMakeBuyCode;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }


    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}
