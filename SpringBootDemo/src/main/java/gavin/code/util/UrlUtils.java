package gavin.code.util;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 本类提供了对URL所指向的内容的加载操作
 *
 * @author boot
 */
public class UrlUtils {

    /**
     * 获取url网址返回的数据内容
     *
     * @param urlStr
     * @return
     */
    public static String loadURL(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            String responseStr = ConvertToString(inputStream);
            return responseStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String ConvertToString(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder result = new StringBuilder();
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStreamReader.close();
                inputStream.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

//    public static String doPost(String url, String data, int timeout) {
//        CloseableHttpResponse response = null;
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();//创建CloseableHttpClient
//        HttpPost httpPost = new HttpPost(url);//实现HttpPost
//        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
//        httpPost.setConfig(requestConfig); //设置httpPost的状态参数
//        httpPost.addHeader("Content-Type", "application/json");//设置httpPost的请求头中的MIME类型为json
//        StringEntity requestEntity = new StringEntity(data, "utf-8");
//        httpPost.setEntity(requestEntity);//设置请求体
//        try {
//            response = httpClient.execute(httpPost, new BasicHttpContext());//执行请求返回结果
//            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
//                return null;
//            }
//            HttpEntity entity = response.getEntity();
//            if (entity != null) {
//                String resultStr = EntityUtils.toString(entity, "utf-8");
//                return resultStr;
//            } else {
//                return null;
//            }
//        } catch (Exception e) {
//
//            return null;
//        } finally {
//            if (response != null) {
//                try {
//                    response.close();//最后关闭response
//                } catch (IOException e) {
//                }
//            }
//            if (httpClient != null) {
//                try {
//                    httpClient.close();
//                } catch (IOException e) {
//                }
//            }
//        }
//    }


}
