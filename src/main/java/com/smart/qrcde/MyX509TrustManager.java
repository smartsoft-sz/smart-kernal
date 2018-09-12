package com.smart.qrcde;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 信任管理器
 * @author fjing
 *
 */
public class MyX509TrustManager implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] arg0, String arg1)throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] arg0, String arg1)throws CertificateException {

    }

    @Override
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return null;
    }

}
