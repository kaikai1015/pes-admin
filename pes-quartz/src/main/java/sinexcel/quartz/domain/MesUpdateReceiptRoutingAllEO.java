package sinexcel.quartz.domain;

import java.util.Date;

public class MesUpdateReceiptRoutingAllEO {
    /** 法人实体 */
    private Long soldToLegalEntityId;

    /** 采购订单 */
    private String orderNumber;

    /** 行号 */
    private Long lineNumber;

    /** 提交行 */
    private Long scheduleNumber;

    /** 地点 */
    private String shipToLocationCode;

    /** 组织ID */
    private Long shipToOrganizationId;

    /** 最后更新日期 */
    private Date lastUpdateDate;

    /** ERP回传标识（0未回写，1回写成功，2回写失败） */
    private String erpFlag;

    /** erp回写时间 */
    private Date erpFlagDate;

    private Long receiptRoutingId;

    /** 最后同步时间 */
    private String startUpdateDate;

    /** 最后同步时间 */
    private String endUpdateDate;

    /** 物料编码 */
    private String itemNumber;

    private String errorInfor;

    public String getErrorInfor() {
        return errorInfor;
    }

    public void setErrorInfor(String errorInfor) {
        this.errorInfor = errorInfor;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Long getSoldToLegalEntityId() {
        return soldToLegalEntityId;
    }

    public void setSoldToLegalEntityId(Long soldToLegalEntityId) {
        this.soldToLegalEntityId = soldToLegalEntityId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getScheduleNumber() {
        return scheduleNumber;
    }

    public void setScheduleNumber(Long scheduleNumber) {
        this.scheduleNumber = scheduleNumber;
    }

    public String getShipToLocationCode() {
        return shipToLocationCode;
    }

    public void setShipToLocationCode(String shipToLocationCode) {
        this.shipToLocationCode = shipToLocationCode;
    }

    public Long getShipToOrganizationId() {
        return shipToOrganizationId;
    }

    public void setShipToOrganizationId(Long shipToOrganizationId) {
        this.shipToOrganizationId = shipToOrganizationId;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getErpFlag() {
        return erpFlag;
    }

    public void setErpFlag(String erpFlag) {
        this.erpFlag = erpFlag;
    }

    public Date getErpFlagDate() {
        return erpFlagDate;
    }

    public void setErpFlagDate(Date erpFlagDate) {
        this.erpFlagDate = erpFlagDate;
    }

    public Long getReceiptRoutingId() {
        return receiptRoutingId;
    }

    public void setReceiptRoutingId(Long receiptRoutingId) {
        this.receiptRoutingId = receiptRoutingId;
    }

    public String getStartUpdateDate() {
        return startUpdateDate;
    }

    public void setStartUpdateDate(String startUpdateDate) {
        this.startUpdateDate = startUpdateDate;
    }

    public String getEndUpdateDate() {
        return endUpdateDate;
    }

    public void setEndUpdateDate(String endUpdateDate) {
        this.endUpdateDate = endUpdateDate;
    }
}
