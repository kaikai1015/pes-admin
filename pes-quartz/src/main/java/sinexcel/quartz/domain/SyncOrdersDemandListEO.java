package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncOrdersDemandListEO {
    private Long planLotNum;
    private String planItemNumber;
    private String planItemType;
    private Long organizationId;
    private Long inventoryItemId;
    private BigDecimal planItemQuantity;
    private Date planDate;
    private String custPoNumber;
    private String documentNumber;
    private Long demandId;
    private Integer documentLineNum;
    private Long planLotLineNum;
    private Long customerId;
    private String customerName;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getPlanLotLineNum() {
        return planLotLineNum;
    }

    public void setPlanLotLineNum(Long planLotLineNum) {
        this.planLotLineNum = planLotLineNum;
    }

    public Integer getDocumentLineNum() {
        return documentLineNum;
    }

    public void setDocumentLineNum(Integer documentLineNum) {
        this.documentLineNum = documentLineNum;
    }

    public Long getPlanLotNum() {
        return planLotNum;
    }

    public void setPlanLotNum(Long planLotNum) {
        this.planLotNum = planLotNum;
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

    public String getCustPoNumber() {
        return custPoNumber;
    }

    public void setCustPoNumber(String custPoNumber) {
        this.custPoNumber = custPoNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }
}
