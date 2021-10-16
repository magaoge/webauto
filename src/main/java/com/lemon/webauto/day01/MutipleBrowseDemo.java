package com.lemon.webauto.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MutipleBrowseDemo {

    @Parameters(value = {"browserType"})
    @Test
    public void entrance(String browserType){
        System.out.println(browserType);
        //equalsIgnoreCase忽略大小写
        if ("IE".equalsIgnoreCase(browserType)){
            System.out.println("IE");
        }else if (browserType.equalsIgnoreCase("Chrome")){
            ChromeDemo chromeDemo = new ChromeDemo();
            chromeDemo.test();
        }else if (browserType.equalsIgnoreCase("Firefox")){

        }else {
            System.out.println("暂不支持该浏览器！");
        }
    }
}
