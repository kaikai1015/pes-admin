
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>setSubmitArgsResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="setSubmitArgsResponse">
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
@XmlType(name = "setSubmitArgsResponse", propOrder = {
    "requestParametersReturn"
})
public class SetSubmitArgsResponse {

    @XmlElement(namespace = "", required = true)
    protected RequestParameters requestParametersReturn;

    /**
     * 获取requestParametersReturn属性的值。
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
     * 设置requestParametersReturn属性的值。
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
