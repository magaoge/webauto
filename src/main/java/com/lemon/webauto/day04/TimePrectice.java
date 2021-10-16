package com.lemon.webauto.day04;

import com.lemon.webauto.tools.Base;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by mgg on 2021/9/25
 */

public class TimePrectice extends Base {

    @Test
    public void time(){
        //1.页面超时时间的设置要放在页面加载之前
        webDriver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        webDriver.navigate().to("https://www.sohu.com/");
        //2.隐式等待
        // 好处：在限定时间内一旦找到元素，寻找的动作就会结束
        //劣处：声明周期与webDriver一致，也就是作用于所有webDriver的查询动作上
        webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        //显示等待
        //1.首先获取WebDriverWait的对象

        //2.写明等待的条件，获取WebElement页面操作元素对象
        //ExpectedConditions中还有很多方法，可以自己去看一下

        //3.对页面元素进行操作
        getPresenceElement(By.xpath("//*[contains(text(),'媒体：《迪迦奥特曼》全网下架与江苏省消保委没有关联')]"),20).click();

        //4.新的方法的引用
        getElementWhilePageIsReady(By.xpath("//*[contains(text(),'媒体：《迪迦奥特曼》全网下架与江苏省消保委没有关联')]"),20).click();

        webDriver.findElement(By.xpath("//*[contains(text(),'媒体：《迪迦奥特曼》全网下架与江苏省消保委没有关联')]")).click();
    }

    //抽象出来公用的方法
    public WebElement getPresenceElement(By by , long secends){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, secends);

        try {
            WebElement webElement = webDriverWait.until(
                    //presenceOfElementLocated这个方法只能保证，你需要找的页面元素，可以在指定的时间内加载在我们的DOM树上
                    //但是不能保证是显现的，那就有一个问题，我们可以找到元素，但可能不会进行操作，也不会报错
                    ExpectedConditions.presenceOfElementLocated(by));
            return webElement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //获取一个可见元素
    public WebElement getVibileElement(By by , long secends){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, secends);

        try {
            WebElement webElement = webDriverWait.until(
                    ExpectedConditions.visibilityOfElementLocated(by));
            return webElement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//编写方法，保证页面完全加载完成，然后并且元素是可以操作的
    public WebElement getElementWhilePageIsReady(By by,long secends){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, secends);
        String jsToBeExecute = null;
        try {
            jsToBeExecute = "return document.readyState ==  'complete'";
            Boolean isReady = (Boolean) webDriverWait.until(ExpectedConditions.jsReturnsValue(jsToBeExecute));
            if (isReady){
                return getVibileElement(by,secends);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
