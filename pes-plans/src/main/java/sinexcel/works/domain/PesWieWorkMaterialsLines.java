package sinexcel.works.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 工单替代料数据对象 sync_wie_work_materials_lines
 * 
 * @author Zhang Kai
 * @date 2021-08-03
 */
public class PesWieWorkMaterialsLines extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    public Long getTidaiId() {
        return tidaiId;
    }

    public void setTidaiId(Long tidaiId) {
        this.tidaiId = tidaiId;
    }

    private Long tidaiId;

    /** 库存组织 */
    @Excel(name = "库存组织")
    private Long organizationId;

    /** 工单号 */
    @Excel(name = "工单号")
    private Long workOrderId;

    /** $column.columnComment */
    @Excel(name = "工单号")
    private Long woOperationId;

    /**  */
    private Long woOperationMaterialId;

    /** 序号 */
    @Excel(name = "序号")
    private Integer materialSeqNumber;

    /** 组件编码 */
    @Excel(name = "组件编码")
    private Long inventoryItemId;

    /** 需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date requiredDate;

    /** 单品用量 */
    @Excel(name = "单品用量")
    private BigDecimal quantityPerProduct;

    /** 需求数量 */
    @Excel(name = "需求数量")
    private BigDecimal requiredQuantity;

    private String workOrderNumber;
    private String pItemNumber;
    private String pItemDescription;
    private String itemNumber;
    private String itemDescription;
    private BigDecimal plannedStartQuantity;
    private BigDecimal newPercentQuantity;
    private String newItemNumber;
    private String newItemDescription;
    private BigDecimal onhandQuantity;
    private BigDecimal remainNewQuantity;
    private String typeFlag;
    private Long newInventoryItemId;
    private BigDecimal newRequiredQuantity;
    private String erpFlag;
    private Integer newMaterialSeqNumber;

    public Integer getNewMaterialSeqNumber() {
        return newMaterialSeqNumber;
    }

    public void setNewMaterialSeqNumber(Integer newMaterialSeqNumber) {
        this.newMaterialSeqNumber = newMaterialSeqNumber;
    }

    public String getErpFlag() {
        return erpFlag;
    }

    public void setErpFlag(String erpFlag) {
        this.erpFlag = erpFlag;
    }

    public Long getNewInventoryItemId() {
        return newInventoryItemId;
    }

    public void setNewInventoryItemId(Long newInventoryItemId) {
        this.newInventoryItemId = newInventoryItemId;
    }

    public BigDecimal getNewRequiredQuantity() {
        return newRequiredQuantity;
    }

    public void setNewRequiredQuantity(BigDecimal newRequiredQuantity) {
        this.newRequiredQuantity = newRequiredQuantity;
    }

    public String getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(String typeFlag) {
        this.typeFlag = typeFlag;
    }

    public BigDecimal getRemainNewQuantity() {
        return remainNewQuantity;
    }

    public void setRemainNewQuantity(BigDecimal remainNewQuantity) {
        this.remainNewQuantity = remainNewQuantity;
    }

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public BigDecimal getNewPercentQuantity() {
        return newPercentQuantity;
    }

    public void setNewPercentQuantity(BigDecimal newPercentQuantity) {
        this.newPercentQuantity = newPercentQuantity;
    }

    public String getNewItemNumber() {
        return newItemNumber;
    }

    public void setNewItemNumber(String newItemNumber) {
        this.newItemNumber = newItemNumber;
    }

    public String getNewItemDescription() {
        return newItemDescription;
    }

    public void setNewItemDescription(String newItemDescription) {
        this.newItemDescription = newItemDescription;
    }

    public BigDecimal getPlannedStartQuantity() {
        return plannedStartQuantity;
    }

    public void setPlannedStartQuantity(BigDecimal plannedStartQuantity) {
        this.plannedStartQuantity = plannedStartQuantity;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public String getpItemNumber() {
        return pItemNumber;
    }

    public void setpItemNumber(String pItemNumber) {
        this.pItemNumber = pItemNumber;
    }

    public String getpItemDescription() {
        return pItemDescription;
    }

    public void setpItemDescription(String pItemDescription) {
        this.pItemDescription = pItemDescription;
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

    public void setOrganizationId(Long organizationId)
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setWorkOrderId(Long workOrderId) 
    {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId() 
    {
        return workOrderId;
    }
    public void setWoOperationId(Long woOperationId) 
    {
        this.woOperationId = woOperationId;
    }

    public Long getWoOperationId() 
    {
        return woOperationId;
    }
    public void setWoOperationMaterialId(Long woOperationMaterialId) 
    {
        this.woOperationMaterialId = woOperationMaterialId;
    }

    public Long getWoOperationMaterialId() 
    {
        return woOperationMaterialId;
    }
    public void setMaterialSeqNumber(Integer materialSeqNumber) 
    {
        this.materialSeqNumber = materialSeqNumber;
    }

    public Integer getMaterialSeqNumber() 
    {
        return materialSeqNumber;
    }
    public void setInventoryItemId(Long inventoryItemId) 
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() 
    {
        return inventoryItemId;
    }
    public void setRequiredDate(Date requiredDate) 
    {
        this.requiredDate = requiredDate;
    }

    public Date getRequiredDate() 
    {
        return requiredDate;
    }
    public void setQuantityPerProduct(BigDecimal quantityPerProduct) 
    {
        this.quantityPerProduct = quantityPerProduct;
    }

    public BigDecimal getQuantityPerProduct() 
    {
        return quantityPerProduct;
    }
    public void setRequiredQuantity(BigDecimal requiredQuantity) 
    {
        this.requiredQuantity = requiredQuantity;
    }

    public BigDecimal getRequiredQuantity() 
    {
        return requiredQuantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("organizationId", getOrganizationId())
            .append("workOrderId", getWorkOrderId())
            .append("woOperationId", getWoOperationId())
            .append("woOperationMaterialId", getWoOperationMaterialId())
            .append("materialSeqNumber", getMaterialSeqNumber())
            .append("inventoryItemId", getInventoryItemId())
            .append("requiredDate", getRequiredDate())
            .append("quantityPerProduct", getQuantityPerProduct())
            .append("requiredQuantity", getRequiredQuantity())
            .toString();
    }
}
