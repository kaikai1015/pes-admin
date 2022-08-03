
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>requestExecutionContext complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="requestExecutionContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="requestHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pausedState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resumed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestExecutionContext", namespace = "http://xmlns.oracle.com/scheduler/types", propOrder = {
    "requestId",
    "requestHandle",
    "pausedState",
    "resumed"
})
public class RequestExecutionContext {

    protected long requestId;
    @XmlElement(required = true)
    protected String requestHandle;
    @XmlElement(required = true)
    protected String pausedState;
    protected boolean resumed;

    /**
     * ��ȡrequestId���Ե�ֵ��
     * 
     */
    public long getRequestId() {
        return requestId;
    }

    /**
     * ����requestId���Ե�ֵ��
     * 
     */
    public void setRequestId(long value) {
        this.requestId = value;
    }

    /**
     * ��ȡrequestHandle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestHandle() {
        return requestHandle;
    }

    /**
     * ����requestHandle���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestHandle(String value) {
        this.requestHandle = value;
    }

    /**
     * ��ȡpausedState���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPausedState() {
        return pausedState;
    }

    /**
     * ����pausedState���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPausedState(String value) {
        this.pausedState = value;
    }

    /**
     * ��ȡresumed���Ե�ֵ��
     * 
     */
    public boolean isResumed() {
        return resumed;
    }

    /**
     * ����resumed���Ե�ֵ��
     * 
     */
    public void setResumed(boolean value) {
        this.resumed = value;
    }

}
