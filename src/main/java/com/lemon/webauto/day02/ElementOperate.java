package com.lemon.webauto.day02;


import com.lemon.webauto.tools.Base;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by mgg on 2021/9/22
 */

public class ElementOperate extends Base {
    @Test
    public void test() {

        try {
            //get和naviget.to方法都有一个限制，就是必须等待页面加载完毕，所以
            // 不必要害怕页面没有加载完毕而找不到元素的情况
            webDriver.get("file:///C:/Users/%E8%88%9B/Desktop/%E7%BB%83%E4%B9%A0%E6%96%87%E4%BB%B6/jubing/a.html");

            //获取页面的句柄，其实应当进入页面的，不过这里第一个页面本来就是当前页，也就选择窗口进入了
            String aHandle = webDriver.getWindowHandle();
            System.out.println("a.html的句柄是：" + aHandle);
            webDriver.findElement(By.tagName("input")).sendKeys("aa");
            Thread.sleep(2000);

            webDriver.findElement(By.linkText("b.html")).click();
            Thread.sleep(2000);
            webDriver.findElement(By.linkText("c.html")).click();
            Thread.sleep(2000);

            //打开所有页面之后，将所有页面的句柄都收集起来
            Set<String> windowHandles = webDriver.getWindowHandles();

            //遍历
            for (String windowHandle : windowHandles) {
                System.out.println(windowHandle);
                if (windowHandle.equals(aHandle)) {
                        continue;
                }
                //根据句柄进入对应窗口
                webDriver.switchTo().window(windowHandle);
                Thread.sleep(2000);
                //获取当前句柄页面的title来进行判断
                String title = webDriver.getTitle();

                if (title.equals("b.html")) {
                    System.out.println("b.html的句柄是：" + aHandle);
                    webDriver.findElement(By.tagName("input")).sendKeys("bb");
                    Thread.sleep(3000);
                } else if(title.equals("c.html")){
                    System.out.println(windowHandle);
                    webDriver.findElement(By.tagName("input")).sendKeys("cc");
                    Thread.sleep(3000);
                }
            }
            //还可以通过页面的URL来判断页面，或者页面中的元素之类的
            System.out.println(webDriver.getCurrentUrl());

//
//            //<input type="text" placeholder="用户名" onblur="javascript:checkStr(this.value,this)" name="username" id="username">
//            System.out.println("标签名："+webDriver.findElement(By.id("username")).getTagName());
//            System.out.println("属性值："+webDriver.findElement(By.id("username")).getAttribute("type"));
////            <a id="qiehuan" href="">接口文档</a>
//            System.out.println("文本值："+webDriver.findElement(By.id("qiehuan")).getText());
//            //通过name:
//            //<input type="password" placeholder="密码" onblur="javascript:checkStr(this.value,this)" name="password" id="password">
//            webDriver.findElement(By.name("password")).sendKeys("123456");
//            //通过tagName:
//            //<input type="button" onclick="login()" value="登录" class="btn btn-primary" id="js-btn-login">
//            //这个网址里面有一个input标签被注释掉了，所以数组中其实只有6个元素
//            webDriver.findElements(By.tagName("input")).get(5).click();


            //这是图片的xpath
//            System.out.println("是否可显现："+webDriver.findElement(By.xpath("/html/body/input[1]")).isDisplayed());
//            //这是一个超链接的xpath
//            System.out.println("是否可编辑："+webDriver.findElement(By.xpath("/html/body/input[2]")).isEnabled());

//            //针对下拉列表
//            //1.定位到select下拉框，并且封装成select类型的对象
//            Select select = new Select(webDriver.findElement(By.tagName("select")));
//            //2.获取所有select下拉框中的选项
//            List<WebElement> options = select.getOptions();
//            //3.遍历
//            for (WebElement option : options) {
//                if(option.getText().equals("河南")){
//                    System.out.println("河南是否被选中："+option.isSelected());
//                }
//            }

//            //点击确定
//            webDriver.findElement(By.id("submit")).click();
//            Thread.sleep(2000);
//            webDriver.switchTo().alert().accept();
//            Thread.sleep(2000);
//
//            //点击取消
//            webDriver.findElement(By.id("reset")).click();
//            Thread.sleep(2000);
//            webDriver.switchTo().alert().dismiss();

            //webDriver.switchTo().frame(WebElement)
//            webDriver.switchTo().frame(webDriver.findElement(By.xpath("//*[@id=\"bfrase\"]")));
////            webDriver.switchTo().frame("first");
//            webDriver.findElement(By.xpath("/html/body/input")).sendKeys("aa");
//            webDriver.switchTo().frame("bfrase");
//            webDriver.findElement(By.xpath("/html/body/input")).sendKeys("bb");
//            //返回上一个iframe框
//            webDriver.switchTo().parentFrame();
//            webDriver.findElement(By.xpath("/html/body/input")).sendKeys("bb");
//            //传递索引0是向下一层(如果有两个，则可以传递索引1，以此规则递增)
//            webDriver.switchTo().frame(0);
//            webDriver.findElement(By.xpath("/html/body/input")).sendKeys("ff");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
