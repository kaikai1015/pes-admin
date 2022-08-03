package sinexcel.daysPlan.domain;



import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 生产日计划调拨明细单
 * </p>
 *
 * @author mingshen.wang
 * @since 2021-08-27
 */
public class MesTransferLineAll  {

    private static final long serialVersionUID = 1L;

    /**
     * 组织id
     */
    private Long organizationId;

    /**
     * 物料id
     */
    private Long inventoryItemId;

    /**
     * 调拨数量
     */
    private BigDecimal quantity;

    /**
     * 调出子仓
     */
    private String diaoChuSubinventory;

    /**
     * 调入目标子仓
     */
    private String diaoRuSubinventory;

    /**
     * 中间表id
     */
    private Long id;

    /**
     * 0等待写入WMS，1写入WMS,2写入失败
     */
    private String wmsFlag;

    /**
     * 调拨单来源id（备料调拨申请单id）
     */
    private Long sourceId;

    /**
     * 出入类型 0：周转仓调拨，1：调拨接收
     */
    private String type;

    /**
     * 出入库类别(BEI_LIAO:备料;SUPPLEMENT_LIAO:补料;SUPERCOLLAR:超领；BACK_LIAO:退料)
     */
    private String sourceCategory;

    /**
     * 出入库种类(ISSUE:厂内工单发料调拨/OUTSIDE:委外工单领料调拨)
     */
    private String sourceType;

    /**
     * 来源对象代码(工单：WORK_ORDER)
     */
    private String sourceCode;

    /**
     * 来源对象名称(例如 工单号)
     */
    private String sourceName;

    /**
     * 对象id(例如 工单行id)
     */
    private Long sourceReferenceId;

    /**
     * 调拨单行id
     */
    private Long transferId;

    /**
     * 头id
     */
    private Long headerId;

    private Date createDate;

    private String lastUpdateBy;

    private String createBy;

    private Date lastUpdateDate;

    public MesTransferLineAll() {
    }

    public MesTransferLineAll(Long organizationId, Long inventoryItemId, BigDecimal quantity, String diaoChuSubinventory, String diaoRuSubinventory, Long sourceId, String type, String sourceCategory, String sourceType, String sourceCode, String sourceName, Long sourceReferenceId, Long transferId, Long headerId, Date createDate, String lastUpdateBy, String createBy, Date lastUpdateDate) {
        this.organizationId = organizationId;
        this.inventoryItemId = inventoryItemId;
        this.quantity = quantity;
        this.diaoChuSubinventory = diaoChuSubinventory;
        this.diaoRuSubinventory = diaoRuSubinventory;
        this.sourceId = sourceId;
        this.type = type;
        this.sourceCategory = sourceCategory;
        this.sourceType = sourceType;
        this.sourceCode = sourceCode;
        this.sourceName = sourceName;
        this.sourceReferenceId = sourceReferenceId;
        this.transferId = transferId;
        this.headerId = headerId;
        this.createDate = createDate;
        this.lastUpdateBy = lastUpdateBy;
        this.createBy = createBy;
        this.lastUpdateDate = lastUpdateDate;
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
    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
    public String getDiaoChuSubinventory() {
        return diaoChuSubinventory;
    }

    public void setDiaoChuSubinventory(String diaoChuSubinventory) {
        this.diaoChuSubinventory = diaoChuSubinventory;
    }
    public String getDiaoRuSubinventory() {
        return diaoRuSubinventory;
    }

    public void setDiaoRuSubinventory(String diaoRuSubinventory) {
        this.diaoRuSubinventory = diaoRuSubinventory;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getWmsFlag() {
        return wmsFlag;
    }

    public void setWmsFlag(String wmsFlag) {
        this.wmsFlag = wmsFlag;
    }
    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getSourceCategory() {
        return sourceCategory;
    }

    public void setSourceCategory(String sourceCategory) {
        this.sourceCategory = sourceCategory;
    }
    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }
    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }
    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
    public Long getSourceReferenceId() {
        return sourceReferenceId;
    }

    public void setSourceReferenceId(Long sourceReferenceId) {
        this.sourceReferenceId = sourceReferenceId;
    }
    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }
    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
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
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


    @Override
    public String toString() {
        return "MesTransferLineAll{" +
        "organizationId=" + organizationId +
        ", inventoryItemId=" + inventoryItemId +
        ", quantity=" + quantity +
        ", diaoChuSubinventory=" + diaoChuSubinventory +
        ", diaoRuSubinventory=" + diaoRuSubinventory +
        ", id=" + id +
        ", wmsFlag=" + wmsFlag +
        ", sourceId=" + sourceId +
        ", type=" + type +
        ", sourceCategory=" + sourceCategory +
        ", sourceType=" + sourceType +
        ", sourceCode=" + sourceCode +
        ", sourceName=" + sourceName +
        ", sourceReferenceId=" + sourceReferenceId +
        ", transferId=" + transferId +
        ", headerId=" + headerId +
        ", createDate=" + createDate +
        ", lastUpdateBy=" + lastUpdateBy +
        ", createBy=" + createBy +
        ", lastUpdateDate=" + lastUpdateDate +
        "}";
    }
}
