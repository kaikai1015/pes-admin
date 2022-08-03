
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>checkInCancellingResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="checkInCancellingResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isCancelling" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkInCancellingResponse", propOrder = {
    "isCancelling"
})
public class CheckInCancellingResponse {

    @XmlElement(namespace = "")
    protected boolean isCancelling;

    /**
     * 获取isCancelling属性的值。
     * 
     */
    public boolean isIsCancelling() {
        return isCancelling;
    }

    /**
     * 设置isCancelling属性的值。
     * 
     */
    public void setIsCancelling(boolean value) {
        this.isCancelling = value;
    }

}
