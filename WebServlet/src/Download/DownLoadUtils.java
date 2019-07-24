package Download;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;


public class DownLoadUtils {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            //旧版写法
            // BASE64Encoder encoder = new BASE64Encoder();
            // String encode = encoder.encode(data);


            // 从JKD 9开始rt.jar包已废除，从JDK 1.8开始使用java.util.Base64.Encoder

            //新的写法
            //   Encoder encoder = Base64.getEncoder();
            //  String encode = encoder.encodeToString(data);


            Base64.Encoder encoder = Base64.getEncoder();
            filename = "=?utf-8?B?" + encoder.encodeToString(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
