package com.lemon.webauto.tools;

import com.lemon.webauto.pojo.Page;

import com.lemon.webauto.pojo.UIElement;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgg on 2021/9/28
 */

public class UILibraryUtil  {
    //面向PageObject开发，先创建我们的列表，存放Page对象，依旧是需要创建Page实体类
    //类一旦被引用，UILibrary.xml配置文件中的所有标签及属性值都被封装进pages中
    public static List<Page> pages = new ArrayList<Page>();

    static {
        //通过配置文件，获取UILibrary的文件路径
        loadPages(ReadProperty.getUiLibraryPath("uiLibraryPath"));
    }

    private static void loadPages(String uiLibraryPath) {
        //解析xml文件
        //获取解析器
        SAXReader reader = new SAXReader();
        InputStream inputStream = null;
        try {
            //读取配置进入流
            inputStream = new FileInputStream(new File(uiLibraryPath));
            //拿到document对象
            Document document = reader.read(inputStream);
            //获取根元素
            Element rootElement = document.getRootElement();
            //遍历子元素，根据标签，完成Page对象封装，与下面"封装"关联
            List<Element> pagesElement = rootElement.elements("Page");
            for (Element pageElement : pagesElement) {
                //获取标签的指定属性的属性值，与下面"封装"关联
                String keyword = pageElement.attributeValue("keyword");
                //遍历子元素，根据标签，完成UIElement对象封装
                List<Element> uiElement = pageElement.elements("UIElement");
                //生成，承接UIElement对象的列表
                List<UIElement> uiElementList = new ArrayList<UIElement>();
                for (Element element : uiElement) {
                    String keywordKeyword = element.attributeValue("keyword");
                    String by = element.attributeValue("by");
                    String value = element.attributeValue("value");

                    UIElement uiEle = new UIElement(keywordKeyword,by,value);
                    uiElementList.add(uiEle);
                }
                //"封装"
                Page page = new Page(keyword,uiElementList);
                pages.add(page);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //根据传入的pageKeyword，uiElmentKeyword和pages列表中Page对象的对应值进行比较，记得pages中还有列表，最终获取到的是可操的WWebElement对象元素
    public static WebElement getElementByKeyword(String pageKeyword, String uiElmentKeyword){
        WebElement element = null;
        for (Page page : pages) {
            if (page.getKeyword().equals(pageKeyword)){
                List<UIElement> uiElements = page.getUiElements();
                for (UIElement uiElement : uiElements) {
                    if (uiElement.getKeyword().equals(uiElmentKeyword)){
                        String by = uiElement.getBy();
                        String value = uiElement.getValue();
                        //
                        element = getVisibleElement(by, value);
                    }
                }
            }
        }
        return element;
    }

    //
    private static WebElement getVisibleElement(String by,String value) {
        //设置显示等待
        WebDriverWait wait = new WebDriverWait(Base.webDriver,20);
        WebElement element = null;
        By locater = null;
        /*这里之前我都是写的变量在前，字符串在后，但是这样可能存在一个问题,
                        如果变量值为空，则比较结果就会报空指针
                        **/
        //根据传入的类型，匹配对应的查找元素方式，这里也可以通过穿透来做选择
        if ("id".equals(by)){
            //查找元素
            locater = By.id(value);
        }else {
            System.out.println("暂不支持类型！");
        }
        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }


}
