package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CuxWorkOrdersBCheckHistoryEO {
    private Long ckId;
    private String organizationCode;
    private String workOrderNumber;
    private String prodLine;
    private String orderNum;
    private String customerName;
    private Date plannedStartDate;
    private String itemNumber;
    private String description;
    private BigDecimal plannedStartQuantity;
    private BigDecimal completedQuantity;
    private String workDef;
    private String prop;
    private String des;
    private String lotNum;
    private Date createDate;
    private String lastUpdateBy;
    private Date lastUpdateDate;
    private String createBy;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Long getCkId() {
        return ckId;
    }

    public void setCkId(Long ckId) {
        this.ckId = ckId;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public String getProdLine() {
        return prodLine;
    }

    public void setProdLine(String prodLine) {
        this.prodLine = prodLine;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPlannedStartQuantity() {
        return plannedStartQuantity;
    }

    public void setPlannedStartQuantity(BigDecimal plannedStartQuantity) {
        this.plannedStartQuantity = plannedStartQuantity;
    }

    public BigDecimal getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(BigDecimal completedQuantity) {
        this.completedQuantity = completedQuantity;
    }

    public String getWorkDef() {
        return workDef;
    }

    public void setWorkDef(String workDef) {
        this.workDef = workDef;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLotNum() {
        return lotNum;
    }

    public void setLotNum(String lotNum) {
        this.lotNum = lotNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
