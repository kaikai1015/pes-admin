package sinexcel.common.utils;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RestClient {

    public static String postData(String url, String requestBody, String contentType, String encoder, String userName, String passWord) throws Exception{
        String bodyStr = null;
        CloseableHttpClient httpClient = null;
//        try {
            httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);


            //设置请求Header
            post.addHeader("Content-Type", contentType);


            //设置身份认证
            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            UsernamePasswordCredentials usernamePassword = new UsernamePasswordCredentials(userName, passWord);
            credsProvider.setCredentials(AuthScope.ANY, usernamePassword);

            HttpClientContext localContext = HttpClientContext.create();
            localContext.setCredentialsProvider(credsProvider);

            // ---------------直连OSC--------------------//
            StringEntity stringEntity = new StringEntity(requestBody, Charset.forName(encoder));
            stringEntity.setContentType(contentType);
            post.setEntity(stringEntity);


            // 响应
                CloseableHttpResponse response = httpClient.execute(post, localContext);
            int sta = response.getStatusLine().getStatusCode();// 状态码
            if (sta != 200 && sta != 201) {
                throw new Exception("Failed : HTTP error code : " + response.getStatusLine().getStatusCode() + ":" + bodyStr);
            }else {
                bodyStr = EntityUtils.toString(response.getEntity());// body
            }
            if (httpClient != null) { httpClient.close(); }
//        } catch (Exception ex) {
//        } finally {
//            // 关闭连接,释放资源
//            try {
//                if (httpClient != null) {
//                    httpClient.close();
//                }
//            } catch (IOException e) {
//                //e.printStackTrace();
//            }
//        }
        return bodyStr;
    }

    public static String putData(String url) {
        String bodyStr = null;
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpPut put = new HttpPut(url);

            // 响应
            CloseableHttpResponse response = httpClient.execute(put);
            int sta = response.getStatusLine().getStatusCode();// 状态码
            bodyStr = EntityUtils.toString(response.getEntity(),"UTF-8");// body
            if (sta != 200 && sta != 201) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode() + ":" + bodyStr);
            }
        } catch (Exception ex) {
        } finally {
            // 关闭连接,释放资源
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
        return bodyStr;
    }

    public static int deleteData(String url,String userName, String passWord) {
        int sta = 0;
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpDelete delete = new HttpDelete(url);

            //设置身份认证
            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            UsernamePasswordCredentials usernamePassword = new UsernamePasswordCredentials(userName, passWord);
            credsProvider.setCredentials(AuthScope.ANY, usernamePassword);

            HttpClientContext localContext = HttpClientContext.create();
            localContext.setCredentialsProvider(credsProvider);

            // 响应
            CloseableHttpResponse response = httpClient.execute(delete,localContext);
            sta = response.getStatusLine().getStatusCode();// 状态码
            if (sta != 204) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode() + ":" + sta);
            }
        } catch (Exception ex) {
        } finally {
            // 关闭连接,释放资源
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
        return sta;
    }


    public static int patchData(String url, String requestBody, String contentType, String encoder, String userName, String passWord) {
        int sta = 0;
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpPatch patch = new HttpPatch(url);

            //设置请求Header
            patch.addHeader("Content-type", contentType);

            //设置身份认证
            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            UsernamePasswordCredentials usernamePassword = new UsernamePasswordCredentials(userName, passWord);
            credsProvider.setCredentials(AuthScope.ANY, usernamePassword);

            HttpClientContext localContext = HttpClientContext.create();
            localContext.setCredentialsProvider(credsProvider);

            // ---------------直连OSC--------------------//
            StringEntity stringEntity = new StringEntity(requestBody, Charset.forName(encoder));
            stringEntity.setContentType(contentType);
            patch.setEntity(stringEntity);

            // 响应
            CloseableHttpResponse response = httpClient.execute(patch, localContext);
            sta = response.getStatusLine().getStatusCode();// 状态码
            if (sta != 200 && sta != 201) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode() + ":" + sta);
            }
        } catch (Exception ex) {
        } finally {
            // 关闭连接,释放资源
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
        return sta;
    }
}
