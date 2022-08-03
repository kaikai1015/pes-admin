package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * mes回传工单超耗对象 mes_work_material_all
 * 
 * @author Zhang Kai
 * @date 2022-04-12
 */
public class MesWorkOverMaterialAll extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工单ID */
    private Long workOrderId;

    /** 工单号 */
    @Excel(name = "工单号")
    private String workOrderNumber;

    /** 工序号（默认10） */
//    @Excel(name = "工序号", readConverterExp = "默=认10")
    private Integer operationSequence;

    /** 类型 */
    @Excel(name = "类型")
    private String transactionType;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String itemNumber;

    /** 物料ID */
    private Long inventoryItemId;

    /** 组织ID */
    private Long organizationId;

    /** 交易数量 */
    @Excel(name = "交易数量")
    private BigDecimal transactionQuantity;

    /** 交易日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "交易日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date transactionDate;

    /** 仓库 */
    @Excel(name = "仓库")
    private String subinventoryCode;

    /** 最后同步日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date erpFlagDate;

    /** ERP回传标识（0未回写，1回写成功，2回写失败） */
    private String erpFlag;

    /** 工单超耗ID */
    private Long materialId;

    private String errorInfor;

    public Date getErpFlagDate() {
        return erpFlagDate;
    }

    public void setErpFlagDate(Date erpFlagDate) {
        this.erpFlagDate = erpFlagDate;
    }

    public String getErrorInfor() {
        return errorInfor;
    }

    public void setErrorInfor(String errorInfor) {
        this.errorInfor = errorInfor;
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
    public void setOperationSequence(Integer operationSequence) 
    {
        this.operationSequence = operationSequence;
    }

    public Integer getOperationSequence() 
    {
        return operationSequence;
    }
    public void setTransactionType(String transactionType) 
    {
        this.transactionType = transactionType;
    }

    public String getTransactionType() 
    {
        return transactionType;
    }
    public void setItemNumber(String itemNumber) 
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() 
    {
        return itemNumber;
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
    public void setTransactionQuantity(BigDecimal transactionQuantity) 
    {
        this.transactionQuantity = transactionQuantity;
    }

    public BigDecimal getTransactionQuantity() 
    {
        return transactionQuantity;
    }
    public void setTransactionDate(Date transactionDate) 
    {
        this.transactionDate = transactionDate;
    }

    public Date getTransactionDate() 
    {
        return transactionDate;
    }
    public void setSubinventoryCode(String subinventoryCode) 
    {
        this.subinventoryCode = subinventoryCode;
    }

    public String getSubinventoryCode() 
    {
        return subinventoryCode;
    }
    public void setErpFlag(String erpFlag) 
    {
        this.erpFlag = erpFlag;
    }

    public String getErpFlag() 
    {
        return erpFlag;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("workOrderId", getWorkOrderId())
            .append("workOrderNumber", getWorkOrderNumber())
            .append("operationSequence", getOperationSequence())
            .append("transactionType", getTransactionType())
            .append("itemNumber", getItemNumber())
            .append("inventoryItemId", getInventoryItemId())
            .append("organizationId", getOrganizationId())
            .append("transactionQuantity", getTransactionQuantity())
            .append("transactionDate", getTransactionDate())
            .append("subinventoryCode", getSubinventoryCode())
            .append("remark", getRemark())
            .append("erpFlag", getErpFlag())
            .append("materialId", getMaterialId())
            .toString();
    }
}
