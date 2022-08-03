package sinexcel.daysPlan.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 工单生产进度明细对象 pes_wie_work_processing_line
 * 
 * @author Zhang Kai
 * @date 2021-11-03
 */
public class    PesWieWorkProcessingLine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;
    /** 工单id */
    @Excel(name = "工单id")
    private Long workOrderId;

    /** 组织id */
    @Excel(name = "组织id")
    private Long organizationId;

    /** 工单号 */
    @Excel(name = "工单号")
    private String workOrderNumber;

    /** 扫描时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "扫描时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /** 类型：COMPLETE-完工入库；AGEING-老化；TES */
    @Excel(name = "类型：COMPLETE-完工入库；AGEING-老化；TES")
    private String type;

    /** mesid */
    @Excel(name = "mesid")
    private String mesId;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWorkOrderId(Long workOrderId)
    {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId() 
    {
        return workOrderId;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setWorkOrderNumber(String workOrderNumber) 
    {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWorkOrderNumber() 
    {
        return workOrderNumber;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setMesId(String mesId) 
    {
        this.mesId = mesId;
    }

    public String getMesId() 
    {
        return mesId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("workOrderId", getWorkOrderId())
            .append("organizationId", getOrganizationId())
            .append("workOrderNumber", getWorkOrderNumber())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("type", getType())
            .append("mesId", getMesId())
            .append("quantity", getQuantity())
            .toString();
    }
}
