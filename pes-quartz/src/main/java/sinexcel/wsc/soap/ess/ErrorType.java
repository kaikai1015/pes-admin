
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>errorType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="errorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UNDEFINED"/>
 *     &lt;enumeration value="SYSTEM"/>
 *     &lt;enumeration value="BUSINESS"/>
 *     &lt;enumeration value="TIMEOUT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "errorType", namespace = "http://xmlns.oracle.com/scheduler/types")
@XmlEnum
public enum ErrorType {

    UNDEFINED,
    SYSTEM,
    BUSINESS,
    TIMEOUT;

    public String value() {
        return name();
    }

    public static ErrorType fromValue(String v) {
        return valueOf(v);
    }

}
