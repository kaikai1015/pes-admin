package sinexcel.quartz.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
public class MiscellaneousTrnUtils {
    public static String analysisXML(String xml)throws Exception{
        Document document = null;
        String code = null;
        document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        Element body = root.element("Body");
        Element cr = body.element("insertAndProcessInterfaceRowsResponse");
        Element result = cr.element("result");
        String status = result.getTextTrim();
        if(!"0".equals(status)){
            code = xml;
        }else {
            code = status;
        }
        return code;
    }
}