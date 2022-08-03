package sinexcel.daysPlan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 库存出入库明细-中间对象 mes_inv_material_txns
 * 
 * @author Zhang Kai
 * @date 2021-08-28
 */
public class MesInvMaterialTxns extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 中间表id */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date lastUpdateDate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String lastUpdatedBy;

    /** 物料id */
    @Excel(name = "物料id")
    private Long inventoryItemId;

    /** 组织id */
    @Excel(name = "组织id")
    private Long organizationId;

    /** 子仓代码 */
    @Excel(name = "子仓代码")
    private String subinventoryCode;

    /** 出入类型(OUT:出库；IN：入库) */
    @Excel(name = "出入类型(OUT:出库；IN：入库)")
    private String transactionType;

    /** 出入库类别(
PURCHASE_IN:采购入库；PURCH */
    @Excel(name = "出入库类别(PURCHASE_IN:采购入库；PURCH")
    private String transactionSourceCategory;

    /** 出入库种类(ISSUE:厂内工单发料调拨;OUTSIDE:委 */
    @Excel(name = "出入库种类(ISSUE:厂内工单发料调拨;OUTSIDE:委")
    private String transactionSourceType;

    /** 来源对象代码(PURCHASE:采购单；WORK:工单) */
    @Excel(name = "来源对象代码(PURCHASE:采购单；WORK:工单)")
    private String transactionSourceCode;

    /** 来源对象名称(采购单号/工单号) */
    @Excel(name = "来源对象名称(采购单号/工单号)")
    private String transactionSourceName;

    /** 出入库数量 */
    @Excel(name = "出入库数量")
    private BigDecimal transactionQuantity;

    /** $column.columnComment */
    @Excel(name = "出入库数量")
    private BigDecimal primaryQuantity;

    /** 出入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transactionDate;

    /** 对象id */
    @Excel(name = "对象id")
    private Long transactionSourceReferenceId;

    /** 来源id */
    @Excel(name = "来源id")
    private Long transactionSourceId;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "来源id", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 检查结果 */
    @Excel(name = "检查结果")
    private String checkResult;

    /** mes出入库id */
    @Excel(name = "mes出入库id")
    private Long mesTransferId;

    /** 状态 0-待处理 1-处理中 2-处理完成 3-处理失败 */
    @Excel(name = "状态 0-待处理 1-处理中 2-处理完成 3-处理失败")
    private String state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLastUpdateDate(Date lastUpdateDate) 
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() 
    {
        return lastUpdateDate;
    }
    public void setLastUpdatedBy(String lastUpdatedBy) 
    {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedBy() 
    {
        return lastUpdatedBy;
    }
    public void setInventoryItemId(Long inventoryItemId) 
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() 
    {
        return inventoryItemId;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setSubinventoryCode(String subinventoryCode) 
    {
        this.subinventoryCode = subinventoryCode;
    }

    public String getSubinventoryCode() 
    {
        return subinventoryCode;
    }
    public void setTransactionType(String transactionType) 
    {
        this.transactionType = transactionType;
    }

    public String getTransactionType() 
    {
        return transactionType;
    }
    public void setTransactionSourceCategory(String transactionSourceCategory) 
    {
        this.transactionSourceCategory = transactionSourceCategory;
    }

    public String getTransactionSourceCategory() 
    {
        return transactionSourceCategory;
    }
    public void setTransactionSourceType(String transactionSourceType) 
    {
        this.transactionSourceType = transactionSourceType;
    }

    public String getTransactionSourceType() 
    {
        return transactionSourceType;
    }
    public void setTransactionSourceCode(String transactionSourceCode) 
    {
        this.transactionSourceCode = transactionSourceCode;
    }

    public String getTransactionSourceCode() 
    {
        return transactionSourceCode;
    }
    public void setTransactionSourceName(String transactionSourceName) 
    {
        this.transactionSourceName = transactionSourceName;
    }

    public String getTransactionSourceName() 
    {
        return transactionSourceName;
    }
    public void setTransactionQuantity(BigDecimal transactionQuantity)
    {
        this.transactionQuantity = transactionQuantity;
    }

    public BigDecimal getTransactionQuantity()
    {
        return transactionQuantity;
    }
    public void setPrimaryQuantity(BigDecimal primaryQuantity)
    {
        this.primaryQuantity = primaryQuantity;
    }

    public BigDecimal getPrimaryQuantity()
    {
        return primaryQuantity;
    }
    public void setTransactionDate(Date transactionDate) 
    {
        this.transactionDate = transactionDate;
    }

    public Date getTransactionDate() 
    {
        return transactionDate;
    }
    public void settransactionSourceReferenceId(Long transactionSourceReferenceId)
    {
        this.transactionSourceReferenceId = transactionSourceReferenceId;
    }

    public Long gettransactionSourceReferenceId()
    {
        return transactionSourceReferenceId;
    }
    public void setTransactionSourceId(Long transactionSourceId) 
    {
        this.transactionSourceId = transactionSourceId;
    }

    public Long getTransactionSourceId() 
    {
        return transactionSourceId;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setCheckResult(String checkResult) 
    {
        this.checkResult = checkResult;
    }

    public String getCheckResult() 
    {
        return checkResult;
    }
    public void setMesTransferId(Long mesTransferId) 
    {
        this.mesTransferId = mesTransferId;
    }

    public Long getMesTransferId() 
    {
        return mesTransferId;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
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
            .append("primaryQuantity", getPrimaryQuantity())
            .append("transactionDate", getTransactionDate())
            .append("transactionSourceReferenceId", gettransactionSourceReferenceId())
            .append("transactionSourceId", getTransactionSourceId())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("checkResult", getCheckResult())
            .append("mesTransferId", getMesTransferId())
            .append("state", getState())
            .toString();
    }
}
