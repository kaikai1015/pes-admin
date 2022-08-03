package sinexcel.daysPlan.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 日计划对象 pes_prod_line_days_header_all
 *
 * @author Zhang Kai
 * @date 2021-06-07
 */
public class PesProdLineDaysHeaderAllWW extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private Long id;
    /** 产品线 */
    private Integer prodLineFlag;

    private String prodLineFlagName;

    /** 批次号 */
    private Long lotNum;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lotNumDate;

    private String createBy;

    /** 最后更新人 */
    private String lastUpdateBy;

    /** 最后更新日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate;

    private String remark;

    private String resetDataFlag;
    private String transferFlag;
    private String isWwFlag;
    private String daysProdFlag;

    public String getDaysProdFlag() {
        return daysProdFlag;
    }

    public void setDaysProdFlag(String daysProdFlag) {
        this.daysProdFlag = daysProdFlag;
    }

    public String getIsWwFlag() {
        return isWwFlag;
    }

    public void setIsWwFlag(String isWwFlag) {
        this.isWwFlag = isWwFlag;
    }

    public String getResetDataFlag() {
        return resetDataFlag;
    }

    public void setResetDataFlag(String resetDataFlag) {
        this.resetDataFlag = resetDataFlag;
    }

    public String getTransferFlag() {
        return transferFlag;
    }

    public void setTransferFlag(String transferFlag) {
        this.transferFlag = transferFlag;
    }

    public String getProdLineFlagName() {
        return prodLineFlagName;
    }

    public void setProdLineFlagName(String prodLineFlagName) {
        this.prodLineFlagName = prodLineFlagName;
    }

    public Date getLotNumDate() {
        return lotNumDate;
    }

    public void setLotNumDate(Date lotNumDate) {
        this.lotNumDate = lotNumDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setProdLineFlag(Integer prodLineFlag)
    {
        this.prodLineFlag = prodLineFlag;
    }

    public Integer getProdLineFlag()
    {
        return prodLineFlag;
    }
    public void setLotNum(Long lotNum)
    {
        this.lotNum = lotNum;
    }

    public Long getLotNum()
    {
        return lotNum;
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
