package sinexcel.quartz.domain;

public class DooHeadersEffBEO {
    private Long headerId;
    private String orderNumber;
    private String chanPingXian;

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getChanPingXian() {
        return chanPingXian;
    }

    public void setChanPingXian(String chanPingXian) {
        this.chanPingXian = chanPingXian;
    }
}
