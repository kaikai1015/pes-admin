package sinexcel.daysPlan.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 生产日计划调拨明细单
 * </p>
 *
 * @author mingshen.wang
 * @since 2021-08-27
 */
public class MesTransferHeaderAll  {

    private static final long serialVersionUID = 1L;

    /**
     * 组织id
     */
    private Long organizationId;

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

    private String createBy;

    private Date lastUpdateDate;

    private String lastUpdateBy;

    private Date createDate;

    private List<MesTransferLineAll> lineAllList;

    public MesTransferHeaderAll() {
    }

    public MesTransferHeaderAll(Long organizationId, String diaoChuSubinventory, String diaoRuSubinventory, String type, String sourceCategory, String sourceType, String sourceCode, String sourceName, Long sourceReferenceId, String createBy, Date lastUpdateDate, String lastUpdateBy, Date createDate) {
        this.organizationId = organizationId;
        this.diaoChuSubinventory = diaoChuSubinventory;
        this.diaoRuSubinventory = diaoRuSubinventory;
        this.type = type;
        this.sourceCategory = sourceCategory;
        this.sourceType = sourceType;
        this.sourceCode = sourceCode;
        this.sourceName = sourceName;
        this.sourceReferenceId = sourceReferenceId;
        this.createBy = createBy;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateBy = lastUpdateBy;
        this.createDate = createDate;
    }
    public void setMesTransferHeaderAll(Long organizationId, String diaoChuSubinventory, String diaoRuSubinventory, String type, String sourceCategory, String sourceType, String sourceCode, String sourceName, Long sourceReferenceId, String createBy, Date lastUpdateDate, String lastUpdateBy, Date createDate) {
        this.organizationId = organizationId;
        this.diaoChuSubinventory = diaoChuSubinventory;
        this.diaoRuSubinventory = diaoRuSubinventory;
        this.type = type;
        this.sourceCategory = sourceCategory;
        this.sourceType = sourceType;
        this.sourceCode = sourceCode;
        this.sourceName = sourceName;
        this.sourceReferenceId = sourceReferenceId;
        this.createBy = createBy;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateBy = lastUpdateBy;
        this.createDate = createDate;
    }

    public List<MesTransferLineAll> getLineAllList() {
        return lineAllList;
    }

    public void setLineAllList(List<MesTransferLineAll> lineAllList) {
        this.lineAllList = lineAllList;
    }
    public void addLineAllList(MesTransferLineAll lineAll) {
        if (this.lineAllList == null){
            this.lineAllList = new ArrayList<>();
        }
        this.lineAllList.add(lineAll);
    }
    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "MesTransferHeaderAll{" +
        "organizationId=" + organizationId +
        ", diaoChuSubinventory=" + diaoChuSubinventory +
        ", diaoRuSubinventory=" + diaoRuSubinventory +
        ", id=" + id +
        ", wmsFlag=" + wmsFlag +
        ", type=" + type +
        ", sourceCategory=" + sourceCategory +
        ", sourceType=" + sourceType +
        ", sourceCode=" + sourceCode +
        ", sourceName=" + sourceName +
        ", sourceReferenceId=" + sourceReferenceId +
        ", createBy=" + createBy +
        ", lastUpdateDate=" + lastUpdateDate +
        ", lastUpdateBy=" + lastUpdateBy +
        ", createDate=" + createDate +
        "}";
    }
}
