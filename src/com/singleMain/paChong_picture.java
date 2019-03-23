package com.singleMain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class paChong_picture {
    /**
     * ��һ������ȡҳ���Դ���룻
     * �ڶ���������Դ���룬����ͼƬ�ı�ǩ�����ҵ�ͼƬ��ǩ�����src��
     * ������������Java�����net����������
     * */

    /**
     * ������ҳ�ͱ����ȡ��ҳ���ݺ�Դ����
     * @param url
     * @param encoding
     */
    public static String getHtmlResourceByUrl(String url,String encoding){
        StringBuffer buffer   = new StringBuffer();
        URL urlObj            = null;
        URLConnection uc      = null;
        InputStreamReader in  = null;
        BufferedReader reader = null;

        try {
            // ������������
            urlObj = new URL(url);
            // ����������
            uc = urlObj.openConnection();
            // ����������
            in = new InputStreamReader(uc.getInputStream(),encoding);
            // ����һ������д����
            reader = new BufferedReader(in);

            String line = null;
            while ((line = reader.readLine()) != null) {
                // һ��һ��׷��
                buffer.append(line+"\r\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }

    /**
     * ����ͼƬ��URL���ص�ͼƬ�����ص�filePath
     * @param filePath �ļ���
     * @param imageUrl ͼƬ����ַ
     */
    public static void downImages(String filePath,String imageUrl){
        // ��ȡͼƬ������
        String fileName = imageUrl.substring(imageUrl.lastIndexOf("/"));

        //�����ļ���Ŀ¼�ṹ
        File files = new File(filePath);
        if(!files.exists()){// �ж��ļ����Ƿ���ڣ���������ھʹ���һ���ļ���
            files.mkdirs();
        }
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            // �����ļ�
            File file = new File(filePath+fileName);
            FileOutputStream out = new FileOutputStream(file);
            int i = 0;
            while((i = is.read()) != -1){
                out.write(i);
            }
            is.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //ִ�в��Գ������
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("��������ҳ��ַ��");//http://www.qq.com
        String url = input.nextLine();
        System.out.print("��������뷽ʽ��");//gb2312
        String encoding = input.nextLine();
        System.out.print("���������ص����Ե�λ�ã�");//D://TEST_img_to/TEST_QQ_COM
        String filePath = input.nextLine();
        String htmlResource = getHtmlResourceByUrl(url, encoding);
        // System.out.println(htmlResource);

        /* -------------������jsoup-1.11.2.jar��--------------------- */

        // ������ҳԴ����
        Document document = Jsoup.parse(htmlResource);
        // ��ȡ����ͼƬ�ĵ�ַ
        Elements elements = document.getElementsByTag("img");

        for(Element element : elements){
            String imgSrc = element.attr("src");
            if (!"".equals(imgSrc) && (imgSrc.startsWith("http://") || imgSrc.startsWith("https://"))) {
                // �ж�imgSrc�Ƿ�Ϊ�����Ƿ���"http://"��ͷ
                System.out.println("�������ص�ͼƬ�ĵ�ַ��" + imgSrc);
                downImages(filePath, imgSrc);
            }
        }

        System.out.println("-------------------------������ϣ�----------------------------");

        //http://img1.gtimg.com/ninja/2/2018/04/ninja152271335652235.jpg

    }
}
