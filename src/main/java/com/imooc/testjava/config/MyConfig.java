package com.imooc.testjava.config;

/**
 * @author : jack sd
 * @date : 2019/12/13
 */

import com.github.wxpay.sdk.WXPayConfig;

import java.io.*;

public class MyConfig implements WXPayConfig {

    private byte[] certData;

    public MyConfig() throws Exception {
//        String certPath = "/path/to/apiclient_cert.p12";
//        File file = new File(certPath);
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();
    }

    public String getAppID() {
        return "wxc638edbc1aa86b65";
    }

    public String getMchID() {
        return "1497121602";
    }

    public String getKey() {
        return "chachadian1QA2WS20180124cde3VFR4";
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

}