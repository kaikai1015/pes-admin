
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>setNLSOptionsResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="setNLSOptionsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestParametersReturn" type="{http://xmlns.oracle.com/scheduler/types}requestParameters"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setNLSOptionsResponse", propOrder = {
    "requestParametersReturn"
})
public class SetNLSOptionsResponse {

    @XmlElement(namespace = "", required = true)
    protected RequestParameters requestParametersReturn;

    /**
     * ��ȡrequestParametersReturn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RequestParameters }
     *     
     */
    public RequestParameters getRequestParametersReturn() {
        return requestParametersReturn;
    }

    /**
     * ����requestParametersReturn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RequestParameters }
     *     
     */
    public void setRequestParametersReturn(RequestParameters value) {
        this.requestParametersReturn = value;
    }

}