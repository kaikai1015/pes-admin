package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 工单报工完工对象 mes_wie_wo_complete_all
 *
 * @author Zhang Kai
 * @date 2021-02-24
 */
public class MesWieWoCompleteAllEO {

    /** 库存组织ID */
    private Long organizationId;

    /** 完工数量 */
    private BigDecimal transactionQuantity;

    /** 日期 */
    private Date transactionDate;

    /** 完工仓库 */
    private String subinventoryCode;

    /** 工单ID */
    private Long workOrderId;

    /** 工单编码 */
    private String workOrderNumber;

    /** 最后同步时间 */
    private Date lastUpdateDate;

    /** ERP回传标识（0未回写，1回写成功，2回写失败） */
    private String erpFlagWork;

    /** erp回写时间 */
    private Date erpFlagWorkDate;

    /** 报工完工主键ID */
    private Long woCompleteId;

    private String remark;

    /** 最后同步时间 */
    private String startUpdateDate;

    /** 最后同步时间 */
    private String endUpdateDate;

    /** 组织 */
    private String organizationCode;

    private Integer woOperationSequenceNumber;

    private Integer lotControlCode;

    /** 单位 */
    private String uomCode;

    private String errorInfor;

    public String getErrorInfor() {
        return errorInfor;
    }

    public void setErrorInfor(String errorInfor) {
        this.errorInfor = errorInfor;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public Integer getLotControlCode() {
        return lotControlCode;
    }

    public void setLotControlCode(Integer lotControlCode) {
        this.lotControlCode = lotControlCode;
    }

    public Integer getWoOperationSequenceNumber() {
        return woOperationSequenceNumber;
    }

    public void setWoOperationSequenceNumber(Integer woOperationSequenceNumber) {
        this.woOperationSequenceNumber = woOperationSequenceNumber;
    }
    public String getErpFlagWork() {
        return erpFlagWork;
    }

    public void setErpFlagWork(String erpFlagWork) {
        this.erpFlagWork = erpFlagWork;
    }

    public Date getErpFlagWorkDate() {
        return erpFlagWorkDate;
    }

    public void setErpFlagWorkDate(Date erpFlagWorkDate) {
        this.erpFlagWorkDate = erpFlagWorkDate;
    }


    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public BigDecimal getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(BigDecimal transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getWoCompleteId() {
        return woCompleteId;
    }

    public void setWoCompleteId(Long woCompleteId) {
        this.woCompleteId = woCompleteId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStartUpdateDate() {
        return startUpdateDate;
    }

    public void setStartUpdateDate(String startUpdateDate) {
        this.startUpdateDate = startUpdateDate;
    }

    public String getEndUpdateDate() {
        return endUpdateDate;
    }

    public void setEndUpdateDate(String endUpdateDate) {
        this.endUpdateDate = endUpdateDate;
    }
}
