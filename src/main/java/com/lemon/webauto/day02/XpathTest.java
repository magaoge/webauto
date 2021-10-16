package com.lemon.webauto.day02;

import com.lemon.webauto.tools.Base;
import com.lemon.webauto.tools.ReadProperty;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class XpathTest extends Base {

    @Test
    public void test() {

        try {
            //get和naviget.to方法都有一个限制，就是必须等待页面加载完毕，所以
            // 不必要害怕页面没有加载完毕而找不到元素的情况
            webDriver.get(ReadProperty.getUrlPath("targetUrl"));

//            //通过id找的元素:
//            //<input type="text" placeholder="用户名" onblur="javascript:checkStr(this.value,this)" name="username" id="username">
            //绝对路径
//            webDriver.findElement(By.xpath("/html/body/div/section/form/div/input")).sendKeys("Wil");

            //相对路径
//            webDriver.findElement(By.xpath("//*[@id='username']")).sendKeys("Will");
            //属性相对路径
//            webDriver.findElement(By.xpath("//section/form/div/input")).sendKeys("Wil");
            //元素名相对路径
//            webDriver.findElement(By.xpath("//section/form/div/input")).sendKeys("Wil");
            //部分属性值
//            webDriver.findElement(By.xpath("//*[contains(@id,'user')]")).sendKeys("Wil");
            //文本内容(一般用于超链接或者存在文本的内容)
//            webDriver.findElement(By.xpath("//*[text()='忘记密码?']")).click();
            //文本内容(一般用于超链接或者存在文本的内容)
            webDriver.findElement(By.xpath("//*[contains(text(),'忘记')]")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
