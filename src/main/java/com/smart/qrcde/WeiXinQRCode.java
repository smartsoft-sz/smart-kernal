package com.smart.qrcde;

public class WeiXinQRCode {
    private String ticket;
    private int expire_seconds;
    private String url;


    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(int expireSeconds) {
        expire_seconds = expireSeconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {        this.url = url;    }

}
