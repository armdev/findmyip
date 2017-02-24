package com.center.ping;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by armenar on 2/24/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserIp {

    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
