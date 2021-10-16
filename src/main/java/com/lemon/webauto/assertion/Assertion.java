package com.lemon.webauto.assertion;

import com.lemon.webauto.tools.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by mgg on 2021/10/16
 */

//封装各种断言的类
public class Assertion extends Base {

    private static Logger logger = Logger.getLogger(Assertion.class);

    //断言是否URL包含信息
    public static void assertUrlContains(String urlContains) {
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        boolean isDiretedToLogin = true;
        try {
            wait.until(ExpectedConditions.urlContains(urlContains));
        } catch (Exception e) {
            logger.info("=======================网站不包括地址================================");
            e.printStackTrace();
            isDiretedToLogin = false;
        }
        Assert.assertTrue(isDiretedToLogin);
    }

    //断言是否包含文本信息
    public static void assertTextPresent(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(webDriver,10);

        Boolean textToBePresentInElement = true ;
        try {
            textToBePresentInElement = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            logger.info("=======================断言文本信息不匹配================================");
            e.printStackTrace();
            textToBePresentInElement = false;
        }
        Assert.assertTrue(textToBePresentInElement);
    }

    //断言是否包含文本信息
    public static void assertElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver,10);

        Boolean textToBePresentInElement = true ;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.info("=======================断言文本信息不匹配================================");
            e.printStackTrace();
            textToBePresentInElement = false;
        }
        Assert.assertTrue(textToBePresentInElement);
    }

}
