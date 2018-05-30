package com.future.thost.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 加载动态库
 * @author caojia
 *
 */
public class LibLoader {

    public static synchronized void loadLib(String libName) throws IOException {
        
        String systemType = System.getProperty("os.name");
        System.out.println("操作系统："+systemType);
        String libExtension = "";
        String prefix = "";
        if(systemType.toLowerCase().indexOf("win") != -1){
            libExtension = ".dll";
        }else {
            prefix="lib";
            libExtension = ".so";
        }
        String libFullName = prefix+libName + libExtension;
        
        System.out.println("动态链接库名称："+libFullName);
        
        String nativeTempDir = System.getProperty("java.io.tmpdir");
        
        System.out.println("临时文件目录："+nativeTempDir);
        
        String fileSeparator = System.getProperty("file.separator");
        
        String filepath = nativeTempDir+fileSeparator+libFullName;
        
        InputStream in = null;
        FileOutputStream writer = null;

        File extractedLibFile = new File(filepath);

        if(extractedLibFile.exists()){
            extractedLibFile.delete();
        }
        
        try {
            String resource = "/"+((systemType.toLowerCase().indexOf("win") != -1) ? "win" : "linux")+"/"+libFullName;
            in = Class.class.getResourceAsStream(resource);
            
            writer = new FileOutputStream(extractedLibFile);
            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = in.read(buffer)) != -1) {
                writer.write(buffer,0,bytesRead);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (in != null)
                in.close();
            if (writer != null)
                writer.close();
        }
        
        System.load(extractedLibFile.toString());
    }
    
    public static void main(String[] args) {
        try {
            LibLoader.loadLib("thosttraderapi_wrap");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
