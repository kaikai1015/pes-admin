
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getCompletionStatus complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="getCompletionStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}long" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCompletionStatus", propOrder = {
    "requestId"
})
public class GetCompletionStatus {

    protected long requestId;

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

}