package com.lemon.webauto.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperty {
    private static Properties properties = new Properties();

    static {
        File file = new File("src/main/resources/property.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取驱动地址的配置信息
    public static String getBrowserDriverPath(String webDriverPath){
        return properties.getProperty(webDriverPath);
    }

    //获取Url的配置信息
    public static String getUrlPath(String targetUrl){
        return properties.getProperty(targetUrl);
    }

    //获取excelPath的配置信息
    public static String getExcelPath(String excelPath){
        return properties.getProperty(excelPath);
    }

    //获取uiLibraryPath的配置信息
    public static String getUiLibraryPath(String uiLibraryPath){
        return properties.getProperty(uiLibraryPath);
    }



}
