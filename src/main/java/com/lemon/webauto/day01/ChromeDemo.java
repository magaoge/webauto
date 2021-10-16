package com.lemon.webauto.day01;

import com.lemon.webauto.tools.ReadProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeDemo {
    @Test
    public  void test() {
        //1.设置系统变量，声明浏览器驱动的位置
        System.setProperty("webdriver.chrome.driver", ReadProperty.getBrowserDriverPath("webDriverPath"));
        //2.创建驱动实例
        WebDriver webDriver = new ChromeDriver();
        //3.访问百度
        webDriver.get(ReadProperty.getUrlPath("targetUrl"));
        //4.通过页面元素进行输入“百度”的操作
        webDriver.findElement(By.id("kw")).sendKeys("百度");
    }
}
