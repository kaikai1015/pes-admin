package sinexcel.works.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

/**
 * 月结工单批量操行对象 cux_fin_work_months_end_list
 *
 * @author Zhang Kai
 * @date 2021-05-08
 */
public class CuxFinWorkMonthsEndList
{
    /** 库存组织 */
    @Excel(name = "库存组织")
    private String organizationcode;

    private Long organizationId;

    /** $column.columnComment */
    private Long workOrderId;

    /** 工单号 */
    @Excel(name = "工单号")
    private String workOrderNumber;

    @Excel(name = "备注")
    private String remark;

    /** ERP回传标识 */
    private String erpFlag;

    /** ERP回传日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date erpUpdateDate;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    private String monthsFlag;

    private String monthsFlagStstus;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMonthsFlagStstus() {
        return monthsFlagStstus;
    }

    public void setMonthsFlagStstus(String monthsFlagStstus) {
        this.monthsFlagStstus = monthsFlagStstus;
    }


    public String getMonthsFlag() {
        return monthsFlag;
    }

    public void setMonthsFlag(String monthsFlag) {
        this.monthsFlag = monthsFlag;
    }

    public String getOrganizationcode() {
        return organizationcode;
    }

    public void setOrganizationcode(String organizationcode) {
        this.organizationcode = organizationcode;
    }

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** 批次号 */
    private Long lotNum;

    /** $column.columnComment */
    private Long id;

    private String createBy;
    private Integer workOrderStatusId;

    public Integer getWorkOrderStatusId() {
        return workOrderStatusId;
    }

    public void setWorkOrderStatusId(Integer workOrderStatusId) {
        this.workOrderStatusId = workOrderStatusId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
    public void setWorkOrderNumber(String workOrderNumber)
    {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWorkOrderNumber()
    {
        return workOrderNumber;
    }
    public void setErpFlag(String erpFlag)
    {
        this.erpFlag = erpFlag;
    }

    public String getErpFlag()
    {
        return erpFlag;
    }
    public void setErpUpdateDate(Date erpUpdateDate)
    {
        this.erpUpdateDate = erpUpdateDate;
    }

    public Date getErpUpdateDate()
    {
        return erpUpdateDate;
    }
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
    }
    public void setLastUpdateBy(String lastUpdateBy)
    {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdateBy()
    {
        return lastUpdateBy;
    }
    public void setLastUpdateDate(Date lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate()
    {
        return lastUpdateDate;
    }
    public void setLotNum(Long lotNum)
    {
        this.lotNum = lotNum;
    }

    public Long getLotNum()
    {
        return lotNum;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
}