package sinexcel.items.domain;

import sinexcel.common.annotation.Excel;

import java.math.BigDecimal;

public class PesItemBomFanChaEO {
    private Long pInventoryItemId;
    private Long organizationId;
    @Excel(name = "父项编码", width = 15)
    private String pItemNumber;
    @Excel(name = "工单号", width = 15)
    private String workOrderNumber;
    @Excel(name = "工单状态", width = 10,readConverterExp = "10000=已取消,10001=已关闭,10002=已完成,10004=已发放,10005=未发放")
    private Integer workOrderStatusId;
    @Excel(name = "订单号", width = 15)
    private String orderNumber;
    @Excel(name = "客户", width = 20)
    private String customerName;
    @Excel(name = "父项描述", width = 40)
    private String pItemDescription;
    private Long inventoryItemId;
    @Excel(name = "物料编码", width = 15)
    private String itemNumber;
    @Excel(name = "物料描述", width = 40)
    private String itemDescription;
    @Excel(name = "物料类型", width = 10)
    private String itemType;
    @Excel(name = "用量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal componentQuantity;

    @Excel(name = "产品类别", width = 30)
    private String productCatalog;
    @Excel(name = "物料类别", width = 30)
    private String itemCatalog;

    public String getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(String productCatalog) {
        this.productCatalog = productCatalog;
    }

    public String getItemCatalog() {
        return itemCatalog;
    }

    public void setItemCatalog(String itemCatalog) {
        this.itemCatalog = itemCatalog;
    }

    private String isWieFlag;

    public String getIsWieFlag() {
        return isWieFlag;
    }

    public void setIsWieFlag(String isWieFlag) {
        this.isWieFlag = isWieFlag;
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

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public Integer getWorkOrderStatusId() {
        return workOrderStatusId;
    }

    public void setWorkOrderStatusId(Integer workOrderStatusId) {
        this.workOrderStatusId = workOrderStatusId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getpItemDescription() {
        return pItemDescription;
    }

    public void setpItemDescription(String pItemDescription) {
        this.pItemDescription = pItemDescription;
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
}
