package sinexcel.quartz.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class MesOrderConfirmShipUtils {
    public static String analysisXML(String xml)throws Exception{
        Document document = null;
        String code = null;
        document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        Element body = root.element("Body");
        Element cr = body.element("createAndConfirmResponse");
        Element result = cr.element("result");
        Element value = result.element("Value");
        Element shipmentNameValue = value.element("ShipmentName");
        String status = shipmentNameValue.getTextTrim();
        if(status.isEmpty()){
            code = xml;
        }else {
            code = status;
        }
        return code;
    }
}
