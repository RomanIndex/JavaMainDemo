package com.singleMain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class downloadPicture {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String url = "http://lol.qq.com/act/a20170926preseason/img/content/logo-wip.png";
        String fileName = "logo-wip.png";
        String savePath = "D:\\TEST_img_to\\2019-03-23";
        download(url, fileName, savePath);
        System.out.println("END!");
    }

    public static void download(String urlString, String filename,String savePath) throws Exception {
        try {
            // ����URL
            URL url = new URL(urlString);
            // ������
            URLConnection con = url.openConnection();
            //��������ʱΪ5s
            con.setConnectTimeout(5*1000);
            // ������
            InputStream is = con.getInputStream();

            // 1K�����ݻ���
            byte[] bs = new byte[1024];
            // ��ȡ�������ݳ���
            int len;
            // ������ļ���
            File sf=new File(savePath);
            if(!sf.exists()){
                sf.mkdirs();
            }
            OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);
            // ��ʼ��ȡ
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // ��ϣ��ر���������
            os.close();
            is.close();
        } catch (Exception e) {
            System.out.println("DownLoadCutPhotoService.download error:"+e.getMessage());
            e.printStackTrace();
        }
    }
}
