package sinexcel.wms.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * WMS工单扣账逻辑对象 cux_wms_work_kou_zhang_list
 * 
 * @author Zhang Kai
 * @date 2021-09-13
 */
public class CuxWmsWorkKouZhangList
{

    /** $column.columnComment */
    private Long workOrderId;

    /** 工单号 */
    @Excel(name = "工单号")
    private String workOrderNumber;

    /** 成品编码 */
    @Excel(name = "成品编码")
    private String itemNumber;

    /** 成品描述 */
    @Excel(name = "成品描述")
    private String itemDescription;

    /** 生产数量 */
    @Excel(name = "生产数量")
    private BigDecimal plannedStartQuantity;

    /** 扣账套数 */
    @Excel(name = "扣账套数")
    private BigDecimal kouZhnagQuantity;

    /** 扣账类型 */
    private String type;

    private Long lotNumber;

    private String createBy;
    private String lastUpdateBy;
    private Long kouZhangId;
    private Long organizationId;
    private BigDecimal xianBianQuantity;
    private String uom;
    private BigDecimal overReceiveQuantity;
    private String organizationCode;
    private Long inventoryItemId;
    private Integer lotControlCode;
    private Long workOrderLineId;
    private Date transactionDate;
    private String itemWorkNameFlag;;
    private String subinventoryCode;
    private String isWwFlag;
    private BigDecimal requiredQuantity;
    private BigDecimal overIssueQuantity;
    private BigDecimal issuedQuantity;


    private Integer prodLineFlag;

    public Integer getProdLineFlag() {
        return prodLineFlag;
    }

    public void setProdLineFlag(Integer prodLineFlag) {
        this.prodLineFlag = prodLineFlag;
    }

    public BigDecimal getRequiredQuantity() {
        return requiredQuantity;
    }

    public BigDecimal getOverIssueQuantity() {
        return overIssueQuantity;
    }

    public void setOverIssueQuantity(BigDecimal overIssueQuantity) {
        this.overIssueQuantity = overIssueQuantity;
    }

    public BigDecimal getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(BigDecimal issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public String getIsWwFlag() {
        return isWwFlag;
    }

    public void setIsWwFlag(String isWwFlag) {
        this.isWwFlag = isWwFlag;
    }

    public void setRequiredQuantity(BigDecimal requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public String getItemWorkNameFlag() {
        return itemWorkNameFlag;
    }

    public void setItemWorkNameFlag(String itemWorkNameFlag) {
        this.itemWorkNameFlag = itemWorkNameFlag;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getWorkOrderLineId() {
        return workOrderLineId;
    }

    public void setWorkOrderLineId(Long workOrderLineId) {
        this.workOrderLineId = workOrderLineId;
    }

    public Integer getLotControlCode() {
        return lotControlCode;
    }

    public void setLotControlCode(Integer lotControlCode) {
        this.lotControlCode = lotControlCode;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public BigDecimal getOverReceiveQuantity() {
        return overReceiveQuantity;
    }

    public void setOverReceiveQuantity(BigDecimal overReceiveQuantity) {
        this.overReceiveQuantity = overReceiveQuantity;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public BigDecimal getXianBianQuantity() {
        return xianBianQuantity;
    }

    public void setXianBianQuantity(BigDecimal xianBianQuantity) {
        this.xianBianQuantity = xianBianQuantity;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getKouZhangId() {
        return kouZhangId;
    }

    public void setKouZhangId(Long kouZhangId) {
        this.kouZhangId = kouZhangId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Long getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(Long lotNumber) {
        this.lotNumber = lotNumber;
    }

    public void setWorkOrderId(Long workOrderId) 
    {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId() 
    {
        return workOrderId;
    }
    public void setWorkOrderNumber(String workOrderNumber) 
    {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWorkOrderNumber() 
    {
        return workOrderNumber;
    }
    public void setItemNumber(String itemNumber) 
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() 
    {
        return itemNumber;
    }
    public void setItemDescription(String itemDescription) 
    {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() 
    {
        return itemDescription;
    }
    public void setPlannedStartQuantity(BigDecimal plannedStartQuantity) 
    {
        this.plannedStartQuantity = plannedStartQuantity;
    }

    public BigDecimal getPlannedStartQuantity() 
    {
        return plannedStartQuantity;
    }
    public void setKouZhnagQuantity(BigDecimal kouZhnagQuantity) 
    {
        this.kouZhnagQuantity = kouZhnagQuantity;
    }

    public BigDecimal getKouZhnagQuantity() 
    {
        return kouZhnagQuantity;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
}
