package sinexcel.daysPlan.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * WMS工单执行情况数据对象 pes_wie_work_processing
 * 
 * @author Zhang Kai
 * @date 2021-09-08
 */
public class PesWieWorkProcessing extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工单id */
    private Long workOrderId;

    /** 组织id */
    private Long organizationId;

    /** 工单号 */
    @Excel(name = "工单号")
    private String workOrderNumber;

    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdateDate;

    /** 已经调拨数量(工单入库累计数) */
    @Excel(name = "已经调拨数量(工单入库累计数)")
    private BigDecimal completeQuantity;

    /** 已经调拨数量(工单入库累计数)最后时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "已经调拨数量(工单入库累计数)最后时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completeDate;

    /** 老化数量（工单老化累计数） */
    @Excel(name = "老化数量", readConverterExp = "工=单老化累计数")
    private BigDecimal laoHuaQuantity;

    /** 老化数量（工单老化累计数）最后时间 */
    @Excel(name = "老化数量", readConverterExp = "工=单老化累计数")
    private Date laoHuaDate;

    /** 测试数量（工单测试累计数） */
    @Excel(name = "测试数量", readConverterExp = "工=单测试累计数")
    private BigDecimal testQuantity;

    /** 测试数量（工单测试累计数）最后时间 */
    @Excel(name = "测试数量", readConverterExp = "工=单测试累计数")
    private Date testDate;

    /** 包装数量（工单包装累计数量） */
    @Excel(name = "包装数量", readConverterExp = "工=单包装累计数量")
    private BigDecimal baoZhuangQuantity;

    /** 包装数量（工单包装累计数量）最后时间 */
    @Excel(name = "包装数量", readConverterExp = "工=单包装累计数量")
    private Date baoZhuangDate;

    /** 投料数量（工单投料累计数） */
    @Excel(name = "投料数量", readConverterExp = "工=单投料累计数")
    private BigDecimal zuZhuangStartQuantity;

    /** 投料数量（工单投料累计数）最后时间 */
    @Excel(name = "投料数量", readConverterExp = "工=单投料累计数")
    private Date zuZhuangStartDate;

    /** $column.columnComment */
    @Excel(name = "投料数量", readConverterExp = "$column.readConverterExp()")
    private BigDecimal zuZhuangCaiQuantity;

    /** $column.columnComment */
    @Excel(name = "投料数量", readConverterExp = "$column.readConverterExp()")
    private Date zuZhuangCaiDate;

    /** 装配完成数量（工单装配完成累计数） */
    @Excel(name = "装配完成数量", readConverterExp = "工=单装配完成累计数")
    private BigDecimal zuZhuangEndQuantity;

    /** 装配完成数量（工单装配完成累计数）最后时间 */
    @Excel(name = "装配完成数量", readConverterExp = "工=单装配完成累计数")
    private Date zuZhuangEndDate;

    /** pes计划批次号 */
    @Excel(name = "pes计划批次号")
    private String planLotsId;

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
    public void setLastUpdateDate(Date lastUpdateDate) 
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() 
    {
        return lastUpdateDate;
    }
    public void setCompleteQuantity(BigDecimal completeQuantity) 
    {
        this.completeQuantity = completeQuantity;
    }

    public BigDecimal getCompleteQuantity() 
    {
        return completeQuantity;
    }
    public void setCompleteDate(Date completeDate) 
    {
        this.completeDate = completeDate;
    }

    public Date getCompleteDate() 
    {
        return completeDate;
    }
    public void setLaoHuaQuantity(BigDecimal laoHuaQuantity) 
    {
        this.laoHuaQuantity = laoHuaQuantity;
    }

    public BigDecimal getLaoHuaQuantity() 
    {
        return laoHuaQuantity;
    }
    public void setLaoHuaDate(Date laoHuaDate) 
    {
        this.laoHuaDate = laoHuaDate;
    }

    public Date getLaoHuaDate() 
    {
        return laoHuaDate;
    }
    public void setTestQuantity(BigDecimal testQuantity) 
    {
        this.testQuantity = testQuantity;
    }

    public BigDecimal getTestQuantity() 
    {
        return testQuantity;
    }
    public void setTestDate(Date testDate) 
    {
        this.testDate = testDate;
    }

    public Date getTestDate() 
    {
        return testDate;
    }
    public void setBaoZhuangQuantity(BigDecimal baoZhuangQuantity) 
    {
        this.baoZhuangQuantity = baoZhuangQuantity;
    }

    public BigDecimal getBaoZhuangQuantity() 
    {
        return baoZhuangQuantity;
    }
    public void setBaoZhuangDate(Date baoZhuangDate) 
    {
        this.baoZhuangDate = baoZhuangDate;
    }

    public Date getBaoZhuangDate() 
    {
        return baoZhuangDate;
    }
    public void setZuZhuangStartQuantity(BigDecimal zuZhuangStartQuantity) 
    {
        this.zuZhuangStartQuantity = zuZhuangStartQuantity;
    }

    public BigDecimal getZuZhuangStartQuantity() 
    {
        return zuZhuangStartQuantity;
    }
    public void setZuZhuangStartDate(Date zuZhuangStartDate) 
    {
        this.zuZhuangStartDate = zuZhuangStartDate;
    }

    public Date getZuZhuangStartDate() 
    {
        return zuZhuangStartDate;
    }
    public void setZuZhuangCaiQuantity(BigDecimal zuZhuangCaiQuantity) 
    {
        this.zuZhuangCaiQuantity = zuZhuangCaiQuantity;
    }

    public BigDecimal getZuZhuangCaiQuantity() 
    {
        return zuZhuangCaiQuantity;
    }
    public void setZuZhuangCaiDate(Date zuZhuangCaiDate) 
    {
        this.zuZhuangCaiDate = zuZhuangCaiDate;
    }

    public Date getZuZhuangCaiDate() 
    {
        return zuZhuangCaiDate;
    }
    public void setZuZhuangEndQuantity(BigDecimal zuZhuangEndQuantity) 
    {
        this.zuZhuangEndQuantity = zuZhuangEndQuantity;
    }

    public BigDecimal getZuZhuangEndQuantity() 
    {
        return zuZhuangEndQuantity;
    }
    public void setZuZhuangEndDate(Date zuZhuangEndDate) 
    {
        this.zuZhuangEndDate = zuZhuangEndDate;
    }

    public Date getZuZhuangEndDate() 
    {
        return zuZhuangEndDate;
    }
    public void setPlanLotsId(String planLotsId) 
    {
        this.planLotsId = planLotsId;
    }

    public String getPlanLotsId() 
    {
        return planLotsId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("workOrderId", getWorkOrderId())
            .append("organizationId", getOrganizationId())
            .append("workOrderNumber", getWorkOrderNumber())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("completeQuantity", getCompleteQuantity())
            .append("completeDate", getCompleteDate())
            .append("laoHuaQuantity", getLaoHuaQuantity())
            .append("laoHuaDate", getLaoHuaDate())
            .append("testQuantity", getTestQuantity())
            .append("testDate", getTestDate())
            .append("baoZhuangQuantity", getBaoZhuangQuantity())
            .append("baoZhuangDate", getBaoZhuangDate())
            .append("zuZhuangStartQuantity", getZuZhuangStartQuantity())
            .append("zuZhuangStartDate", getZuZhuangStartDate())
            .append("zuZhuangCaiQuantity", getZuZhuangCaiQuantity())
            .append("zuZhuangCaiDate", getZuZhuangCaiDate())
            .append("zuZhuangEndQuantity", getZuZhuangEndQuantity())
            .append("zuZhuangEndDate", getZuZhuangEndDate())
            .append("planLotsId", getPlanLotsId())
            .toString();
    }
}
