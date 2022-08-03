package sinexcel.quartz.domain;

import java.util.Date;

public class SyncWieWoStatusHistoryEO {
    private Long organizationId;
    private Long workOrderId;
    private Date statusChangeDate;
    private Integer newStatusId;

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Date getStatusChangeDate() {
        return statusChangeDate;
    }

    public void setStatusChangeDate(Date statusChangeDate) {
        this.statusChangeDate = statusChangeDate;
    }

    public Integer getNewStatusId() {
        return newStatusId;
    }

    public void setNewStatusId(Integer newStatusId) {
        this.newStatusId = newStatusId;
    }
}
