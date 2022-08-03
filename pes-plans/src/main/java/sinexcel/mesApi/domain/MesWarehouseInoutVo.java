package sinexcel.mesApi.domain;

/**
 * @Author mingshen.wang
 * @Date 2021/9/6 17:09
 * @Version 1.0
 * @Description TODO
 **/
public class MesWarehouseInoutVo {

    /**
     * billNo :
     * billType :
     * productName :
     * productDescription :
     * qty :
     * wareHouseName :
     * pOName :
     * mOName :
     * entryName :
     * vendorDescription :
     * customerDescription :
     * fromWareHouseName :
     * toWareHouseName :
     * lastUpdateUser :
     * createDate :
     * inventoryItemId :
     * workOrderId :
     * woOperationMaterialId :
     * sourceId :
     * pesSourceId :
     */

    private String billNo;
    private String billType;
    private String productName;
    private String productDescription;
    private String qty;
    private String wareHouseName;
    private String poName;
    private String moName;
    private String entryName;
    private String vendorDescription;
    private String customerDescription;
    private String fromWareHouseName;
    private String toWareHouseName;
    private String lastUpdateUser;
    private String createDate;
    private Long inventoryItemId;
    private Long workOrderId;
    private Long woOperationMaterialId;
    private Long sourceId;
    private Long pesSourceId;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getWareHouseName() {
        return wareHouseName;
    }

    public void setWareHouseName(String wareHouseName) {
        this.wareHouseName = wareHouseName;
    }

    public String getPoName() {
        return poName;
    }

    public void setPoName(String poName) {
        this.poName = poName;
    }

    public String getMoName() {
        return moName;
    }

    public void setMoName(String moName) {
        this.moName = moName;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getVendorDescription() {
        return vendorDescription;
    }

    public void setVendorDescription(String vendorDescription) {
        this.vendorDescription = vendorDescription;
    }

    public String getCustomerDescription() {
        return customerDescription;
    }

    public void setCustomerDescription(String customerDescription) {
        this.customerDescription = customerDescription;
    }

    public String getFromWareHouseName() {
        return fromWareHouseName;
    }

    public void setFromWareHouseName(String fromWareHouseName) {
        this.fromWareHouseName = fromWareHouseName;
    }

    public String getToWareHouseName() {
        return toWareHouseName;
    }

    public void setToWareHouseName(String toWareHouseName) {
        this.toWareHouseName = toWareHouseName;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Long getWoOperationMaterialId() {
        return woOperationMaterialId;
    }

    public void setWoOperationMaterialId(Long woOperationMaterialId) {
        this.woOperationMaterialId = woOperationMaterialId;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getPesSourceId() {
        return pesSourceId;
    }

    public void setPesSourceId(Long pesSourceId) {
        this.pesSourceId = pesSourceId;
    }
}
