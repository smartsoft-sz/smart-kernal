package com.smart.model;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Email {

    public static final String ENCODEING_GBK = "GBK";
    public static final String ENCODING_UTF8 = "UTF-8";
    /**
     * 发件人 mail from
     */
    private String from;
    private String fromName;
    /**
     * 收件人 mail to
     */
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    /**
     * 主题 mail subject
     */
    private String subject;
    /**
     * 内容 mail content
     */
    private String content;
    /**
     * 附件map，key是文件名，value是File<br/> attachment map,key is attach name,value is attachment File
     */
    private Map<String, File> fileMap;
    /**
     * 附件map，key是文件名，value是byte[]数组，可以通过调用apache commons 的IOUtils.toByteArray方法将InputStream转为byte数组 <br/> attachment
     * map,key is attach name,value is byte[]. you can use IOUtils.toByteArray to switch InputStream to byte[]
     */
    private Map<String, byte[]> byteMap;

    private Map<String, Object> templateValues;

    private String emailEncoding = ENCODEING_GBK;

    private String templateEncoding = ENCODING_UTF8;

    private String templateLocation;

    public Email() {

    }

    public Map<String, File> getFileMap() {
        return fileMap;
    }

    public void setFileMap(Map<String, File> fileMap) {
        this.fileMap = fileMap;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, byte[]> getByteMap() {
        return byteMap;
    }

    public void setByteMap(Map<String, byte[]> byteMap) {
        this.byteMap = byteMap;
    }

    public Map<String, Object> getTemplateValues() {
        return templateValues;
    }

    public void setTemplateValues(Map<String, Object> templateValues) {
        this.templateValues = templateValues;
    }

    public String getTemplateLocation() {
        return templateLocation;
    }

    public void setTemplateLocation(String templateLocation) {
        this.templateLocation = templateLocation;
    }

    public String getEmailEncoding() {
        return emailEncoding;
    }

    public void setEmailEncoding(String emailEncoding) {
        this.emailEncoding = emailEncoding;
    }

    public String getTemplateEncoding() {
        return templateEncoding;
    }

    public void setTemplateEncoding(String templateEncoding) {
        this.templateEncoding = templateEncoding;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

}
