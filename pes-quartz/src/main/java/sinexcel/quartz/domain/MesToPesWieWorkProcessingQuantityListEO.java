package sinexcel.quartz.domain;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;

public class MesToPesWieWorkProcessingQuantityListEO {
    private Long workOrderId;
    private Long organizationId;
    private String workOrderNumber;
    private Date lastUpdateDate;
    private BigDecimal completeQuantity;
    private Date completeDate;
    private BigDecimal laoHuaQuantity;
    private Date laoHuaDate;
    private BigDecimal testQuantity;
    private Date testDate;
    private BigDecimal baoZhuangQuantity;
    private Date baoZhuangDate;
    private BigDecimal zuZhuangStartQuantity;
    private Date zuZhuangStartDate;
    private BigDecimal zuZhuangCaiQuantity;
    private Date zuZhuangCaiDate;
    private BigDecimal zuZhuangEndQuantity;
    private Date zuZhuangEndDate;

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public BigDecimal getCompleteQuantity() {
        return completeQuantity;
    }

    public void setCompleteQuantity(BigDecimal completeQuantity) {
        this.completeQuantity = completeQuantity;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public BigDecimal getLaoHuaQuantity() {
        return laoHuaQuantity;
    }

    public void setLaoHuaQuantity(BigDecimal laoHuaQuantity) {
        this.laoHuaQuantity = laoHuaQuantity;
    }

    public Date getLaoHuaDate() {
        return laoHuaDate;
    }

    public void setLaoHuaDate(Date laoHuaDate) {
        this.laoHuaDate = laoHuaDate;
    }

    public BigDecimal getTestQuantity() {
        return testQuantity;
    }

    public void setTestQuantity(BigDecimal testQuantity) {
        this.testQuantity = testQuantity;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public BigDecimal getBaoZhuangQuantity() {
        return baoZhuangQuantity;
    }

    public void setBaoZhuangQuantity(BigDecimal baoZhuangQuantity) {
        this.baoZhuangQuantity = baoZhuangQuantity;
    }

    public Date getBaoZhuangDate() {
        return baoZhuangDate;
    }

    public void setBaoZhuangDate(Date baoZhuangDate) {
        this.baoZhuangDate = baoZhuangDate;
    }

    public BigDecimal getZuZhuangStartQuantity() {
        return zuZhuangStartQuantity;
    }

    public void setZuZhuangStartQuantity(BigDecimal zuZhuangStartQuantity) {
        this.zuZhuangStartQuantity = zuZhuangStartQuantity;
    }

    public Date getZuZhuangStartDate() {
        return zuZhuangStartDate;
    }

    public void setZuZhuangStartDate(Date zuZhuangStartDate) {
        this.zuZhuangStartDate = zuZhuangStartDate;
    }

    public BigDecimal getZuZhuangCaiQuantity() {
        return zuZhuangCaiQuantity;
    }

    public void setZuZhuangCaiQuantity(BigDecimal zuZhuangCaiQuantity) {
        this.zuZhuangCaiQuantity = zuZhuangCaiQuantity;
    }

    public Date getZuZhuangCaiDate() {
        return zuZhuangCaiDate;
    }

    public void setZuZhuangCaiDate(Date zuZhuangCaiDate) {
        this.zuZhuangCaiDate = zuZhuangCaiDate;
    }

    public BigDecimal getZuZhuangEndQuantity() {
        return zuZhuangEndQuantity;
    }

    public void setZuZhuangEndQuantity(BigDecimal zuZhuangEndQuantity) {
        this.zuZhuangEndQuantity = zuZhuangEndQuantity;
    }

    public Date getZuZhuangEndDate() {
        return zuZhuangEndDate;
    }

    public void setZuZhuangEndDate(Date zuZhuangEndDate) {
        this.zuZhuangEndDate = zuZhuangEndDate;
    }
}
