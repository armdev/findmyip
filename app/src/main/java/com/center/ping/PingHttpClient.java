package com.center.ping;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by armenar on 2/24/2017.
 */

public class PingHttpClient {

    public UserIp findMyIp() {
        //HttpClient client = HttpClientBuilder.create().build();
        HttpClient client = new DefaultHttpClient();
        UserIp userIp = null;
        try {
            HttpGet request = new HttpGet("http://ip.jsontest.com/");
            request.addHeader("content-type", "application/json");
            request.addHeader("charset", "UTF-8");
            HttpResponse response = client.execute(request);
            response.addHeader("content-type", "application/json;charset=UTF-8");
            HttpEntity entity = response.getEntity();
            ObjectMapper mapper = new ObjectMapper();
            userIp = mapper.readValue(EntityUtils.toString(entity), UserIp.class);
           // System.out.println("userIp is ? " + userIp.getIp());
        } catch (IOException e) {
            //e.printStackTrace();
            userIp = new UserIp();
            userIp.setIp("127.0.0.1");
        }
        return userIp;
    }

}
