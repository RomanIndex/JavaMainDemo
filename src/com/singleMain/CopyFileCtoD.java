package com.singleMain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class CopyFileCtoD {
    public static void main(String[] args) {
	/**
	 * 创建一个文件：
	 * 注意创建目录和文件Files.createDirectories 和 Files.createFile不能混用，必须先有目录，才能在目录中创建文件。
	 */
	Path target2 = Paths.get("E:\\TestReceiveFile\\D.txt");
	try {
            Files.createDirectories(Paths.get("E:\\TestReceiveFile"));
            if(!Files.exists(Paths.get("E:\\TestReceiveFile"))){
        	Files.createFile(Paths.get("E:\\TestReceiveFile\\D.txt"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try {
            if(!Files.exists(target2))
                Files.createFile(target2);//也可以用这种方式生成文件夹
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /**
         * 读取文件
         * 这里如果指定的字符编码不对，可能会抛出异常 MalformedInputException ，或者读取到了乱码
         */
        /*try {
          //Charset.forName("GBK");
          List<String> lines = Files.readAllLines(Paths.get("D:\\TestJavaFilesC\\C.txt"), Charset.forName("gbk"));
          System.out.println(lines);
          BufferedReader reader = Files.newBufferedReader(Paths.get("D:\\TestJavaFilesC\\C.txt"), StandardCharsets.ISO_8859_1);
          String str = null;
          while((str = reader.readLine()) != null){
              System.out.println(str);
          }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /**
         * 文件写操作
         */
        /*try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("D:\\Tencent\\mystuff.txt"), StandardCharsets.UTF_8);
            writer.write("测试文件写操作fdgdfgfdffffffffffffffff");
            writer.flush();
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/
	//遍历一个文件夹：
	/*Path dir = Paths.get("D:\\Tencent");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
            for(Path e : stream){
                System.out.println(e.getFileName());
            }
        }catch(IOException e){
            
        }*/
        /**
         *从文件复制到文件：Files.copy(Path source, Path target, CopyOption options);

                                从输入流复制到文件：Files.copy(InputStream in, Path target, CopyOption options);
                                
                                从文件复制到输出流：Files.copy(Path source, OutputStream out);
         */
        try {
	    Files.copy(Paths.get("D:\\TestJavaFilesC\\C.txt"), Paths.get("E:\\TestReceiveFile\\D.txt"), StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
