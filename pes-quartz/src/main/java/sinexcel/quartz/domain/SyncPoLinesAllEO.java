package sinexcel.quartz.domain;

import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class SyncPoLinesAllEO extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long poHeaderId;
    private Long poLineId;
    private Long prcBuId;
    private Integer lineNum;
    private String lineStatus;
    private Long itemId;
    private Long workOrderId;
    private String uomCode;
    private BigDecimal quantity;
    private Date lastUpdateDate;
    private Date needByDate;
    private Long organizationId;
    private BigDecimal unitPrice;

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }


    public Date getNeedByDate() {
        return needByDate;
    }

    public void setNeedByDate(Date needByDate) {
        this.needByDate = needByDate;
    }

    public Long getPoHeaderId() {
        return poHeaderId;
    }

    public void setPoHeaderId(Long poHeaderId) {
        this.poHeaderId = poHeaderId;
    }

    public Long getPoLineId() {
        return poLineId;
    }

    public void setPoLineId(Long poLineId) {
        this.poLineId = poLineId;
    }

    public Long getPrcBuId() {
        return prcBuId;
    }

    public void setPrcBuId(Long prcBuId) {
        this.prcBuId = prcBuId;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer lineNum) {
        this.lineNum = lineNum;
    }

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
