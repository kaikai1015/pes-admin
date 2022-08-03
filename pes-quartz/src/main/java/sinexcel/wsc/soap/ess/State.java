
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>state的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="state">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WAIT"/>
 *     &lt;enumeration value="READY"/>
 *     &lt;enumeration value="RUNNING"/>
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="BLOCKED"/>
 *     &lt;enumeration value="HOLD"/>
 *     &lt;enumeration value="CANCELLING"/>
 *     &lt;enumeration value="EXPIRED"/>
 *     &lt;enumeration value="CANCELLED"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="WARNING"/>
 *     &lt;enumeration value="SUCCEEDED"/>
 *     &lt;enumeration value="PAUSED"/>
 *     &lt;enumeration value="PENDING_VALIDATION"/>
 *     &lt;enumeration value="VALIDATION_FAILED"/>
 *     &lt;enumeration value="SCHEDULE_ENDED"/>
 *     &lt;enumeration value="FINISHED"/>
 *     &lt;enumeration value="ERROR_AUTO_RETRY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "state", namespace = "http://xmlns.oracle.com/scheduler/types")
@XmlEnum
public enum State {

    WAIT,
    READY,
    RUNNING,
    COMPLETED,
    BLOCKED,
    HOLD,
    CANCELLING,
    EXPIRED,
    CANCELLED,
    ERROR,
    WARNING,
    SUCCEEDED,
    PAUSED,
    PENDING_VALIDATION,
    VALIDATION_FAILED,
    SCHEDULE_ENDED,
    FINISHED,
    ERROR_AUTO_RETRY;

    public String value() {
        return name();
    }

    public static State fromValue(String v) {
        return valueOf(v);
    }

}
