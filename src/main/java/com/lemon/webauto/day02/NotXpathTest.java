package com.lemon.webauto.day02;

import com.lemon.webauto.tools.Base;
import com.lemon.webauto.tools.ReadProperty;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NotXpathTest extends Base {

    @Test
    public void test() {

        try {
            //get和naviget.to方法都有一个限制，就是必须等待页面加载完毕，所以
            // 不必要害怕页面没有加载完毕而找不到元素的情况
            webDriver.get(ReadProperty.getUrlPath("targetUrl"));

//            //通过id找的元素:
//            //<input type="text" placeholder="用户名" onblur="javascript:checkStr(this.value,this)" name="username" id="username">
//            webDriver.findElement(By.id("username")).sendKeys("Wil");
//            //通过name:
//            //<input type="password" placeholder="密码" onblur="javascript:checkStr(this.value,this)" name="password" id="password">
//            webDriver.findElement(By.name("password")).sendKeys("123456");
//            //通过tagName:
//            //<input type="button" onclick="login()" value="登录" class="btn btn-primary" id="js-btn-login">
//            //这个网址里面有一个input标签被注释掉了，所以数组中其实只有6个元素
//            webDriver.findElements(By.tagName("input")).get(5).click();

            //通过样式选择器id找的元素:
            //<input type="text" placeholder="用户名" onblur="javascript:checkStr(this.value,this)" name="username" id="username">
            webDriver.findElement(By.cssSelector("#username")).sendKeys("Wil");
            //通过样式选择器name找的元素，由于这里没有css样式，所以不做演示，下面这个是错误的:
            //<input type="password" placeholder="密码" onblur="javascript:checkStr(this.value,this)" name="password" id="password">
//            webDriver.findElement(By.cssSelector(".password")).sendKeys("123456");
//          但是我们可以使用组合元素选择器的方法定位,下面就是“标签选择器+属性选择器”的方法，注意属性选择器的引用格式：
            webDriver.findElement(By.cssSelector("input[type='password']")).sendKeys("123456");
            //通过样式选择器找标签名的元素:
            //<input type="button" onclick="login()" value="登录" class="btn btn-primary" id="js-btn-login">
            //这个网址里面有一个input标签被注释掉了，所以数组中其实只有6个元素
            webDriver.findElements(By.cssSelector("input")).get(5).click();

//            webDriver.get("http://www.baidu.com");
//            //通过超链接文本信息定位
////            webDriver.findElement(By.linkText("新闻")).click();
//            //通过超链接部分文本信息定位
//            webDriver.findElement(By.partialLinkText("闻")).click();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
