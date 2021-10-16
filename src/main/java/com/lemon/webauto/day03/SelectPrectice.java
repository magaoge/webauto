package com.lemon.webauto.day03;

import com.lemon.webauto.tools.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by mgg on 2021/9/23
 */

public class SelectPrectice extends Base {
    @Test
    public void select(){

        webDriver.navigate().to("file:///C:/Users/%E8%88%9B/Desktop/%E7%BB%83%E4%B9%A0%E6%96%87%E4%BB%B6/prectice.html");
//首先根据WebElement创建select对象来选中该标签
        Select select = new Select(webDriver.findElement(By.id("select")));
//        获取列表下的所有选项
        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            String text = option.getText();
            System.out.println(text);
            if (text.equals("河北")){
                //根据文本值选中某个option
//                select.selectByVisibleText(text);
                //根据index选中某个option
//                select.selectByIndex(3);
                //根据value选中某个option个
                select.selectByValue("hunan");
            }
        }
    }
}
