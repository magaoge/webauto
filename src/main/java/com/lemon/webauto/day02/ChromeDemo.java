package com.lemon.webauto.day02;

import com.lemon.webauto.tools.Base;
import com.lemon.webauto.tools.ReadProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ChromeDemo extends Base {

    @Test
    public void test() {
        //窗口操作
        //a.窗口最大化操作
        WebDriver.Window window = webDriver.manage().window();
        window.maximize();

        try {
            //3.访问百度
            webDriver.get(ReadProperty.getUrlPath("targetUrl"));
            //4.通过页面元素进行输入“百度”的操作
            webDriver.findElement(By.id("kw")).sendKeys("百度");
            Thread.sleep(2000);

            //窗口打开的位置
//        window.setPosition(new Point(1000,1000));
//      窗口的大小
//        window.setSize(new Dimension(800,800));

            //生成navigate对象
            WebDriver.Navigation navigate = webDriver.navigate();
//            //导航栏返回上一页
//            navigate.back();
//            Thread.sleep(2000);
//            //前进一页
//            navigate.forward();
//            Thread.sleep(2000);
            navigate.to("https://www.bilibili.com/");
            Thread.sleep(2000);
            //刷新
            navigate.refresh();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
