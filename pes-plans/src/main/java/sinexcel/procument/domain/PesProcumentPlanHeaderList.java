package sinexcel.procument.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 生成采购计划头信息对象 pes_procument_plan_header_list
 * 
 * @author Zhang Kai
 * @date 2020-12-09
 */
public class PesProcumentPlanHeaderList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采购计划头ID */
    private Integer headerId;

    /** 组织ID */
    @Excel(name = "组织ID")
    private Long organizationId;

    /** 计划批次号 */
    @Excel(name = "计划批次号")
    private Long planLotNum;

    /** 类型 */
    @Excel(name = "类型")
    private String planType;

    /** 有效码 */
    @Excel(name = "有效码")
    private String activeCode;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private String approvalCode;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新日期 */
    private Date lastUpdateDate;

    /** 更新人 */
    private String lastUpdateBy;

    public void setHeaderId(Integer headerId) 
    {
        this.headerId = headerId;
    }

    public Integer getHeaderId() 
    {
        return headerId;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setPlanLotNum(Long planLotNum) 
    {
        this.planLotNum = planLotNum;
    }

    public Long getPlanLotNum() 
    {
        return planLotNum;
    }
    public void setPlanType(String planType) 
    {
        this.planType = planType;
    }

    public String getPlanType() 
    {
        return planType;
    }
    public void setActiveCode(String activeCode) 
    {
        this.activeCode = activeCode;
    }

    public String getActiveCode() 
    {
        return activeCode;
    }
    public void setApprovalCode(String approvalCode) 
    {
        this.approvalCode = approvalCode;
    }

    public String getApprovalCode() 
    {
        return approvalCode;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setLastUpdateDate(Date lastUpdateDate) 
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() 
    {
        return lastUpdateDate;
    }
    public void setLastUpdateBy(String lastUpdateBy) 
    {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdateBy() 
    {
        return lastUpdateBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("headerId", getHeaderId())
            .append("organizationId", getOrganizationId())
            .append("planLotNum", getPlanLotNum())
            .append("planType", getPlanType())
            .append("activeCode", getActiveCode())
            .append("approvalCode", getApprovalCode())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .toString();
    }
}
