package com.smart.service.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @createdBy:jx
 * @crteat:2018-05-21
 */
public class DownImage {

    public static void saveToFile(String destUrl,String filname,String imageName) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            File file = new File(filname);
            if (!file.exists()){
                file.mkdir();
            }
            bis = new BufferedInputStream(httpUrl.getInputStream());
            fos = new FileOutputStream(file+"/"+imageName);
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            fos.flush();
        } catch (IOException e) {
        } catch (ClassCastException e) {
        } finally {
            try {
                fos.close();
                bis.close();
                httpUrl.disconnect();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        saveToFile("http://owgf0oooy.bkt.clouddn.com/FlRFOe5BlHPjryfwzM-Msstf47Cq");
    }
}
