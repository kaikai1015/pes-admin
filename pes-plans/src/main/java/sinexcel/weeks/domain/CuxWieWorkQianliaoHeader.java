package sinexcel.weeks.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 排程欠料头信息对象 cux_wie_work_qianliao_header
 * 
 * @author Zhang Kai
 * @date 2021-11-05
 */
public class CuxWieWorkQianliaoHeader
{

    /** 批号 */
    private Long lotNumber;

    /** srm标识 */
    private String srmFlag;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    private String createBy;
    private String remark;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setLotNumber(Long lotNumber) 
    {
        this.lotNumber = lotNumber;
    }

    public Long getLotNumber() 
    {
        return lotNumber;
    }
    public void setSrmFlag(String srmFlag) 
    {
        this.srmFlag = srmFlag;
    }

    public String getSrmFlag() 
    {
        return srmFlag;
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

}
