
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>checkInCancellingResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡisCancelling���Ե�ֵ��
     * 
     */
    public boolean isIsCancelling() {
        return isCancelling;
    }

    /**
     * ����isCancelling���Ե�ֵ��
     * 
     */
    public void setIsCancelling(boolean value) {
        this.isCancelling = value;
    }

}
