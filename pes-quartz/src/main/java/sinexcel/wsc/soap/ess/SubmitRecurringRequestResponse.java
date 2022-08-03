
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>submitRecurringRequestResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="submitRecurringRequestResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "submitRecurringRequestResponse", propOrder = {
    "requestId"
})
public class SubmitRecurringRequestResponse {

    @XmlElement(namespace = "")
    protected long requestId;

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

}
