package sinexcel.daysPlan.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 库存事务处理明细对象 pes_inv_material_txns
 * 
 * @author Zhang Kai
 * @date 2021-08-28
 */
public class PesInvMaterialTxns extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @Excel(name = "序号", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long id;

    /**
     * 物料编码
     */
    @Excel(name = "物料编码", width = 15)
    private String inventoryItemCode;

    /**
     * 物料描述
     */
    @Excel(name = "物料描述", width = 40)
    private String inventoryItemDescribe;
    /**
     * 子仓代码
     */
    @Excel(name = "子仓代码", width = 15)
    private String subinventoryCode;

    /**
     * 出入类型(OUT:出库；IN：入库)
     */
    @Excel(name = "出入类型",readConverterExp = "OUT=出库,IN=入库", width = 15)
    private String transactionType;

    /**
     * 出入库类别(
     * PURCHASE_IN:采购入库；PURCH
     */
    @Excel(name = "出入库类别", width = 15)
    private String transactionSourceCategory;
    /**
     * 出入库种类(ISSUE:厂内工单发料调拨;OUTSIDE:委
     */
    @Excel(name = "出入库种类", width = 15)
    private String transactionSourceType;

    /**
     * $column.columnComment
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate;

    /**
     * $column.columnComment
     */
    private String lastUpdatedBy;

    /**
     * 物料id
     */
    private Long inventoryItemId;

    /**
     * 组织id
     */
    private Long organizationId;
    private  String mesKey;


    /**
     * 来源对象代码(PURCHASE:采购单；WORK:工单)
     */
    @Excel(name = "来源对象代码", width = 15)
    private String transactionSourceCode;

    /**
     * 来源对象名称(采购单号/工单号)
     */
    @Excel(name = "来源对象名称", width = 15)
    private String transactionSourceName;

    /**
     * 出入库数量
     */
    @Excel(name = "出入库数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal transactionQuantity;

    /**
     * 单位
     */
    @Excel(name = "单位", width = 10)
    private String transactionUom;

    /**
     * 预留
     */
    private BigDecimal primaryQuantity;

    /**
     * 出入库时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "出入库时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date transactionDate;

    /**
     * 对象id(如：pes工单id)
     */
    private Long transactionSourceReferenceId;

    /**
     * 来源类型  PES  WMS
     */
    @Excel(name = "来源类型", width = 10)
    private String sourceCode;

    /**
     * PES需求来源行ID（如：pes工单行id）
     */
    private Long sourceLineId;

    /**
     * 来源id(例如：pes调拨单行ID)
     */
    private Long transactionSourceId;

    /** 创建者 */
    private String createBy;
    /**
     * $column.columnComment
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**
     * 检查结果(0-调拨待处理；1-调拨处理完成；2-处理失败)
     */
    private String checkResult;

    /**
     * mes出入库id
     */
    @Excel(name = "mes出入库id", width = 20)
    private String mesTransferId;

    /**
     * 批号/序列号
     */
    @Excel(name = "批号/序列号", width = 20)
    private String batchNum;

    public String getMesKey() {
        return mesKey;
    }

    public void setMesKey(String mesKey) {
        this.mesKey = mesKey;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionSourceCategory(String transactionSourceCategory) {
        this.transactionSourceCategory = transactionSourceCategory;
    }

    public String getTransactionSourceCategory() {
        return transactionSourceCategory;
    }

    public void setTransactionSourceType(String transactionSourceType) {
        this.transactionSourceType = transactionSourceType;
    }

    public String getTransactionSourceType() {
        return transactionSourceType;
    }

    public void setTransactionSourceCode(String transactionSourceCode) {
        this.transactionSourceCode = transactionSourceCode;
    }

    public String getTransactionSourceCode() {
        return transactionSourceCode;
    }

    public void setTransactionSourceName(String transactionSourceName) {
        this.transactionSourceName = transactionSourceName;
    }

    public String getTransactionSourceName() {
        return transactionSourceName;
    }

    public void setTransactionQuantity(BigDecimal transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public BigDecimal getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionUom(String transactionUom) {
        this.transactionUom = transactionUom;
    }

    public String getTransactionUom() {
        return transactionUom;
    }

    public void setPrimaryQuantity(BigDecimal primaryQuantity) {
        this.primaryQuantity = primaryQuantity;
    }

    public BigDecimal getPrimaryQuantity() {
        return primaryQuantity;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionSourceReferenceId(Long transactionSourceReferenceId) {
        this.transactionSourceReferenceId = transactionSourceReferenceId;
    }

    public Long getTransactionSourceReferenceId() {
        return transactionSourceReferenceId;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceLineId(Long sourceLineId) {
        this.sourceLineId = sourceLineId;
    }

    public Long getSourceLineId() {
        return sourceLineId;
    }

    public void setTransactionSourceId(Long transactionSourceId) {
        this.transactionSourceId = transactionSourceId;
    }

    public Long getTransactionSourceId() {
        return transactionSourceId;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setMesTransferId(String mesTransferId) {
        this.mesTransferId = mesTransferId;
    }

    public String getMesTransferId() {
        return mesTransferId;
    }

    public void setInventoryItemCode(String inventoryItemCode) {
        this.inventoryItemCode = inventoryItemCode;
    }

    public String getInventoryItemCode() {
        return inventoryItemCode;
    }

    public void setInventoryItemDescribe(String inventoryItemDescribe) {
        this.inventoryItemDescribe = inventoryItemDescribe;
    }

    public String getInventoryItemDescribe() {
        return inventoryItemDescribe;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getBatchNum() {
        return batchNum;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("lastUpdateDate", getLastUpdateDate())
                .append("lastUpdatedBy", getLastUpdatedBy())
                .append("inventoryItemId", getInventoryItemId())
                .append("organizationId", getOrganizationId())
                .append("subinventoryCode", getSubinventoryCode())
                .append("transactionType", getTransactionType())
                .append("transactionSourceCategory", getTransactionSourceCategory())
                .append("transactionSourceType", getTransactionSourceType())
                .append("transactionSourceCode", getTransactionSourceCode())
                .append("transactionSourceName", getTransactionSourceName())
                .append("transactionQuantity", getTransactionQuantity())
                .append("transactionUom", getTransactionUom())
                .append("primaryQuantity", getPrimaryQuantity())
                .append("transactionDate", getTransactionDate())
                .append("transactionSourceReferenceId", getTransactionSourceReferenceId())
                .append("sourceCode", getSourceCode())
                .append("sourceLineId", getSourceLineId())
                .append("transactionSourceId", getTransactionSourceId())
                .append("createBy", getCreateBy())
                .append("createDate", getCreateDate())
                .append("checkResult", getCheckResult())
                .append("mesTransferId", getMesTransferId())
                .append("inventoryItemCode", getInventoryItemCode())
                .append("inventoryItemDescribe", getInventoryItemDescribe())
                .append("batchNum", getBatchNum())
                .toString();
    }

    public PesInvMaterialTxns() {
    }

    public PesInvMaterialTxns(Long inventoryItemId, Long organizationId, String subinventoryCode, String transactionType, String transactionSourceCategory, String transactionSourceType, String transactionSourceCode, String transactionSourceName, BigDecimal transactionQuantity, String transactionUom, BigDecimal primaryQuantity, Date transactionDate, Long transactionSourceReferenceId, String sourceCode, Long sourceLineId, Long transactionSourceId, Date createDate, String checkResult, String mesTransferId) {
        this.inventoryItemId = inventoryItemId;
        this.organizationId = organizationId;
        this.subinventoryCode = subinventoryCode;
        this.transactionType = transactionType;
        this.transactionSourceCategory = transactionSourceCategory;
        this.transactionSourceType = transactionSourceType;
        this.transactionSourceCode = transactionSourceCode;
        this.transactionSourceName = transactionSourceName;
        this.transactionQuantity = transactionQuantity;
        this.transactionUom = transactionUom;
        this.primaryQuantity = primaryQuantity;
        this.transactionDate = transactionDate;
        this.transactionSourceReferenceId = transactionSourceReferenceId;
        this.sourceCode = sourceCode;
        this.sourceLineId = sourceLineId;
        this.transactionSourceId = transactionSourceId;
        this.createDate = createDate;
        this.checkResult = checkResult;
        this.mesTransferId = mesTransferId;
    }
}
