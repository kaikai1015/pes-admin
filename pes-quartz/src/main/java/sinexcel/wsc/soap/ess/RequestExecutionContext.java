
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>requestExecutionContext complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取requestId属性的值。
     * 
     */
    public long getRequestId() {
        return requestId;
    }

    /**
     * 设置requestId属性的值。
     * 
     */
    public void setRequestId(long value) {
        this.requestId = value;
    }

    /**
     * 获取requestHandle属性的值。
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
     * 设置requestHandle属性的值。
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
     * 获取pausedState属性的值。
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
     * 设置pausedState属性的值。
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
     * 获取resumed属性的值。
     * 
     */
    public boolean isResumed() {
        return resumed;
    }

    /**
     * 设置resumed属性的值。
     * 
     */
    public void setResumed(boolean value) {
        this.resumed = value;
    }

}
