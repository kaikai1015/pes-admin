
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>setAsyncRequestStatus complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="setAsyncRequestStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestExecutionContext" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="status" type="{http://xmlns.oracle.com/scheduler/types}asyncStatus" form="qualified"/>
 *         &lt;element name="statusMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setAsyncRequestStatus", propOrder = {
    "requestExecutionContext",
    "status",
    "statusMessage"
})
public class SetAsyncRequestStatus {

    @XmlElement(required = true)
    protected String requestExecutionContext;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected AsyncStatus status;
    protected String statusMessage;

    /**
     * 获取requestExecutionContext属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestExecutionContext() {
        return requestExecutionContext;
    }

    /**
     * 设置requestExecutionContext属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestExecutionContext(String value) {
        this.requestExecutionContext = value;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AsyncStatus }
     *     
     */
    public AsyncStatus getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AsyncStatus }
     *     
     */
    public void setStatus(AsyncStatus value) {
        this.status = value;
    }

    /**
     * 获取statusMessage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * 设置statusMessage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusMessage(String value) {
        this.statusMessage = value;
    }

}
