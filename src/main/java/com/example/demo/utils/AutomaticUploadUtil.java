package com.example.demo.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 创建人:连磊
 * 日期: 2018/4/19. 17:16
 * 描述：根据链接自动下载文件
 */
public class AutomaticUploadUtil {

    /**
     *开 发 者：连磊
     *开发时间：2018/4/19 17:33
     *方 法 名：downloadUrlFile
     *传入参数：[fileName, fileUrl]
     *返 回 值：java.io.File
     *描    述：根据文件链接自动下载文件
     **/

    public static File downloadUrlFile(String fileName , String fileUrl){
        fileUrl = fileUrl.trim();
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        File file = new File("");
        try {
            URL url = new URL(fileUrl);
            HttpURLConnection connection =  (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();

            bis = new BufferedInputStream(is);

            String path =  "/home/test";
            file = new File(path);
            if(!file.exists()){
                file.mkdir();
            }
            file = new File(path +fileName);
            if (!file.exists()){
                file.createNewFile();
            }else {
                file.delete();
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            int b = 0;
            byte[] byArr = new byte[1024*4];
            while((b=bis.read(byArr))!=-1){
                bos.write(byArr, 0, b);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(bos!=null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            return null;
        }finally{
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(bos!=null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return file;
    }
}
