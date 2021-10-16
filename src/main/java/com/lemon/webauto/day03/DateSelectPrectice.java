package com.lemon.webauto.day03;

import com.lemon.webauto.tools.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

/**
 * Created by mgg on 2021/9/23
 */

public class DateSelectPrectice extends Base {
    @Test
    public void date(){
        webDriver.navigate().to("file:///C:/Users/%E8%88%9B/Desktop/%E7%BB%83%E4%B9%A0%E6%96%87%E4%BB%B6/time.html");
//允许写入的时候就用sendKey写入
        webDriver.findElement(By.id("input1")).sendKeys("002021/923");
        //或者通过元素定位点击选择
        //不允许写入的时候饮用Js脚本

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        //原来写在head标签下的脚本信息
//        		<script>
//                window.onload = function (){
//            var time = document.getElementById("input2");
//            time.value = "002021/926"
//        }
//		</script>
        javascriptExecutor.executeScript(
                "var time = document.getElementById(\"input2\");\n" +
                "\t\t\ttime.value = \"002021/926\"");
    }
}
