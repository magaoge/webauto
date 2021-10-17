package com.lemon.webauto.day05;

import com.lemon.webauto.assertion.Assertion;
import com.lemon.webauto.tools.Base;

import com.lemon.webauto.tools.ReadProperty;
import com.lemon.webauto.tools.RegisterUtil;
import com.lemon.webauto.tools.UILibraryUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by mgg on 2021/9/27
 */

public class RegisterCase extends Base {

    private Logger registerCaseLogger = Logger.getLogger(RegisterCase.class);

    @Test(priority = 1)
    public void chioseHTTP(){

        //声明请求地址
//        访问("targetUrl");
        toUrl("targetUrl");
        //        webDriver.navigate().to(ReadProperty.getUrlPath("targetUrl"));

        Assertion.assertUrlContains("index.html");

        //点击选中访问的接口类型
        click("注册页面","接口类型选择");
//        UILibraryUtil.getElementByKeyword("注册页面", "接口类型选择").click();
//        webDriver.findElement(By.id("HTTP")).click();
    }


    @Test(priority = 2,dataProvider = "datas_0")
    public void testNegativeCases(String username,String password,String expcted){
        registerCaseLogger.info("*********用户名："+username+"*********密码："+password+"*********预期："+expcted);
        //输入用户名
        sendKey("注册页面","用户名",username);
//        UILibraryUtil.getElementByKeyword("注册页面","用户名").sendKeys(username);
//        webDriver.findElement(By.id("username")).sendKeys(username);
        //输入密码
        sendKey("注册页面","密码",password);
//        UILibraryUtil.getElementByKeyword("注册页面","密码").sendKeys(password);
//        webDriver.findElement(By.id("password")).sendKeys(password);
        //点击登录
        click("注册页面","登录按钮");
//        UILibraryUtil.getElementByKeyword("注册页面","登录按钮").click();
//        webDriver.findElement(By.id("js-btn-login")).click();

        //获取响应结果,如果存在页面跳转之类需要加载元素的行为，最好加上一个显式等待
//        WebDriverWait wait = new WebDriverWait(webDriver,5);
//        boolean isDirectedToLogin = true;
//        try {
//            wait.until(ExpectedConditions.textToBePresentInElement(
//                    UILibraryUtil.getElementByKeyword("断言", "信息"),expcted));
////            wait.until(ExpectedConditions.textToBePresentInElement(UILibraryUtil.getElementByKeyword("断言","信息").getText());
//
//        } catch (Exception e) {
//            System.out.println("实际结果与预期不符");
//            e.printStackTrace();
//        }
//        Assert.assertTrue(isDirectedToLogin);
        //获取响应结果
//        String actual = UILibraryUtil.getElementByKeyword("断言","信息").getText();
        WebElement actual = UILibraryUtil.getElementByKeyword("断言", "信息");
        Assertion.assertTextPresent(actual,expcted);

//        Assert.assertEquals(actual,expcted);
    }

    @DataProvider
    //这里获取指定行列的数据，封装成二维数组，提供数据
    public Object[][] datas_0(){
        String[] cellName = {"Username","Password","Expected"};
        Object[][] datas = RegisterUtil.getNegativeDatas("0",cellName);
        return datas;
    }

//    @Test(dataProvider = "datas_1")
//    public void testNegativeSuccessCases(String username,String password){
//        //声明请求地址
//        webDriver.navigate().to(ReadProperty.getProperty("targetUrl"));
//        //选中访问的接口类型
//        webDriver.findElement(By.id("HTTP")).click();
//        //输入用户名
//        webDriver.findElement(By.id("username")).sendKeys(username);
//        //输入密码
//        webDriver.findElement(By.id("password")).sendKeys(password);
//        //点击登录
//        webDriver.findElement(By.id("js-btn-login")).click();
//        //获取响应结果
//        boolean contains = webDriver.getCurrentUrl().contains("user.html");
//        Assert.assertTrue(contains);
//    }
//
//    @DataProvider
//    public Object[][] datas_1(){
//        String[] cellName = {"Username","Password"};
//        Object[][] datas = RegisterUtil.getNegativeDatas("1",cellName);
//        return datas;
//    }
}
