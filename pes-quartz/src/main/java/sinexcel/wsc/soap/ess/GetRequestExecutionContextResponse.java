
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getRequestExecutionContextResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡrequestExecutionContext���Ե�ֵ��
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
     * ����requestExecutionContext���Ե�ֵ��
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
