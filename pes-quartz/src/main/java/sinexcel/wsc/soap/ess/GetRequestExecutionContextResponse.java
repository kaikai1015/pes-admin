
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getRequestExecutionContextResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getRequestExecutionContextResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestExecutionContext" type="{http://xmlns.oracle.com/scheduler/types}requestExecutionContext"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRequestExecutionContextResponse", propOrder = {
    "requestExecutionContext"
})
public class GetRequestExecutionContextResponse {

    @XmlElement(namespace = "", required = true)
    protected RequestExecutionContext requestExecutionContext;

    /**
     * 获取requestExecutionContext属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RequestExecutionContext }
     *     
     */
    public RequestExecutionContext getRequestExecutionContext() {
        return requestExecutionContext;
    }

    /**
     * 设置requestExecutionContext属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RequestExecutionContext }
     *     
     */
    public void setRequestExecutionContext(RequestExecutionContext value) {
        this.requestExecutionContext = value;
    }

}
