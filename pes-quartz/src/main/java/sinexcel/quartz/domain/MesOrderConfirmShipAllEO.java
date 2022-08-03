package sinexcel.quartz.domain;

import java.util.Date;

/**
 * MES销售发运回写ERP对象 mes_order_confirm_ship_all
 *
 * @author Zhang Kai
 * @date 2021-03-04
 */
public class MesOrderConfirmShipAllEO {

    /** 库存组织ID */
    private Long organizationId;

    /** 发货通知单 */
    private String waybillNumber;

    /** 密封单号 */
    private String sealNumber;

    /** 物料ID */
    private Long inventoryItemId;

    /** 物料编码 */
    private String itemNumber;

    /** 发运数量 */
    private Long shippedQuantity;

    /** 单位 */
    private String unitUode;

    /** 仓库 */
    private String subinventoryCode;

    /** 最后同步时间 */
    private Date lastUpdateDate;

    /** ERP回传标识（0未回写，1回写成功，2回写失败） */
    private String erpFlag;

    /** erp回写时间 */
    private Date erpFlagDate;

    /** 订单号 */
    private String salesOrderNumber;

    /** 订单行号 */
    private Long salesOrderLineNumber;

    private Long confirmId;

    /** 进程ID */
    private Long requestId;

    private String remark;

    /** 最后同步时间 */
    private String startUpdateDate;

    /** 最后同步时间 */
    private String endUpdateDate;

    private String organizationCode;

    private Integer lotControlCode;

    private Long deliveryDetailId;

    private String requestStatus;

    private String shimentName;

    private String errorInfor;

    public String getErrorInfor() {
        return errorInfor;
    }

    public void setErrorInfor(String errorInfor) {
        this.errorInfor = errorInfor;
    }

    public String getShimentName() {
        return shimentName;
    }

    public void setShimentName(String shimentName) {
        this.shimentName = shimentName;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Long getDeliveryDetailId() {
        return deliveryDetailId;
    }

    public void setDeliveryDetailId(Long deliveryDetailId) {
        this.deliveryDetailId = deliveryDetailId;
    }

    public Integer getLotControlCode() {
        return lotControlCode;
    }

    public void setLotControlCode(Integer lotControlCode) {
        this.lotControlCode = lotControlCode;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public String getSealNumber() {
        return sealNumber;
    }

    public void setSealNumber(String sealNumber) {
        this.sealNumber = sealNumber;
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

    public Long getShippedQuantity() {
        return shippedQuantity;
    }

    public void setShippedQuantity(Long shippedQuantity) {
        this.shippedQuantity = shippedQuantity;
    }

    public String getUnitUode() {
        return unitUode;
    }

    public void setUnitUode(String unitUode) {
        this.unitUode = unitUode;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
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

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public Long getSalesOrderLineNumber() {
        return salesOrderLineNumber;
    }

    public void setSalesOrderLineNumber(Long salesOrderLineNumber) {
        this.salesOrderLineNumber = salesOrderLineNumber;
    }

    public Long getConfirmId() {
        return confirmId;
    }

    public void setConfirmId(Long confirmId) {
        this.confirmId = confirmId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
