package com.example.exercise.week2.nio01;

import lombok.SneakyThrows;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

    /**
     * httpclient get同步请求
     *
     * @param url
     * @return
     */
    @SneakyThrows
    public static String get(String url) {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        try {
            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpGet.releaseConnection();
            client.close();
        }

        System.err.println("httpClient execute error");
        return null;
    }

    public static void main(String[] args) {
        String url = "http://localhost:9901";
        String result = HttpClientUtil.get(url);
        System.out.println(result);
    }
}
