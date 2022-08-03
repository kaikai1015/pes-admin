package sinexcel.quartz.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
public class RcvPurchaseUtils {
    public static String analysisXML(String xml)throws Exception{
        Document document = null;
        String code = null;
            document = DocumentHelper.parseText(xml);
            Element root = document.getRootElement();
            Element body = root.element("Body");
            Element cr = body.element("processorResponse");
            Element result = cr.element("result");
            Element value = result.element("Value");
            Element statusValue = value.element("Status");
            String status = statusValue.getTextTrim();
            if(!"SUCCESS".equals(status)){
                code = xml;
            }else {
                code = status;
            }
        return code;
    }
}
