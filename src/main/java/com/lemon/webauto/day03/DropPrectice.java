package com.lemon.webauto.day03;


import com.lemon.webauto.tools.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Created by mgg on 2021/9/23
 */

public class DropPrectice extends Base {

    @Test
    public void drop() {
        webDriver.navigate().to("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");

        //封装驱动为Actions对象
        Actions actions = new Actions(webDriver);
        //寻找到源与目标
        WebElement sorce = webDriver.findElement(By.id("treeDemo_6_span"));
        WebElement target = webDriver.findElement(By.id("treeDemo_7_span"));
        //拖拽，并且执行
        try {
            Thread.sleep(2000);
            actions.dragAndDrop(sorce,target).build().perform();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
