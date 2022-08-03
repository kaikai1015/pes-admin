package sinexcel.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class InSoapUtil {


    /**
     * 通过url调用soap类型的webService接口
     * <p>
     * //     * @param          soap类型的webService接口地址
     *
     * @param sendSoapData 需要传递的数据，xml格式
     * @return soap协议xml格式
     * @Param authnameStr             用户名密码  userName:password
     * <p>
     * , String authnameStr
     */
    public static String callSoapWSUrlTransData(String sendSoapData,String url,String intefaceName,String intefaceMethodName) throws Exception{

        String returnStr = null;
        String soap = sendSoapData;
        String authStr = null;

        if (soap == null) {
            returnStr = null;
        }

//        try {
        //判断是否是修改PO接收方式，如果是需要使用超级管理员账号，绕过审批规则
        if("changePurchaseOrder".equals(intefaceMethodName)){
            authStr = "X0025" + ":" + "123456789";
        }else {
            authStr = ConfigUtils.getErpUser() + ":" + ConfigUtils.getErpPass();
        }
            byte[] authBytes = authStr.getBytes("UTF-8");
            String auth = Base64.encodeBase64String(authBytes);

            URL soapUrl = new URL(url);
            URLConnection conn = soapUrl.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Length",
                    Integer.toString(soap.length()));

            conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            conn.setRequestProperty("Authorization", "Basic " + auth);

            conn.setRequestProperty(intefaceName, intefaceMethodName);
            OutputStream outputStream = conn.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
            outputStreamWriter.write(soap);
            outputStreamWriter.flush();
            outputStreamWriter.close();

            InputStream inputStream = conn.getInputStream();

            if (inputStream != null) {
                byte[] getData = readInputStream(inputStream);
                inputStream.read(getData);
                String str = new String(getData);
                returnStr = str;
            } else {
                returnStr = sendSoapData;
            }
//        } catch (Exception e) {
//            returnStr = e.getMessage();
//        }
        return returnStr;
    }

    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}

