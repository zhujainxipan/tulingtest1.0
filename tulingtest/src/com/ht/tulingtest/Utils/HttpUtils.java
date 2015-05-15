package com.ht.tulingtest.Utils;

import com.ht.tulingtest.pojo.ReceiveJavaBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by IntelliJ IDEA
 * Project: com.ht.tulingtest.Utils
 * Author: 安诺爱成长
 * Email: 1399487511@qq.com
 * Date: 2015/5/13
 */
public class HttpUtils {
    public static String getResponse(String content) throws IOException {
        String APIKEY = "130cb5d7edf7d753b1698f43e7db72a8";
        String INFO = URLEncoder.encode(content, "utf-8");
        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
        URL getUrl = new URL(getURL);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();
        // 取得输入流，并使用Reader读取
        BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        // 断开连接
        connection.disconnect();
        ReceiveJavaBean receiveJavaBean = FastJsonTools.getObject(sb.toString(), ReceiveJavaBean.class);
        return receiveJavaBean.getText();
    }

}
