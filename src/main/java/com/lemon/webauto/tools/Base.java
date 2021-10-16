package com.lemon.webauto.tools;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


//根据配置文件中的配置，启动对应浏览器，注册驱动实例
public class Base {

    public static WebDriver webDriver;

    private Logger baseLogger = Logger.getLogger(Base.class);


    @Parameters(value = {"browserType"})
    @BeforeTest
    public void init(String browserType){
        //根据日志不同的输出级别，来调用对应的方法,这里是info级别
        baseLogger.info("*********************配置的浏览器类型："+ browserType );
        System.out.println(browserType);
        //equalsIgnoreCase忽略大小写
        if ("IE".equalsIgnoreCase(browserType)){
            System.out.println("IE");
        }else if (browserType.equalsIgnoreCase("Chrome")){
            //1.设置系统变量，声明浏览器驱动的位置
            System.setProperty("webdriver.chrome.driver", ReadProperty.getBrowserDriverPath("webDriverPath"));
            //2.创建驱动实例
            webDriver = new ChromeDriver();
        }else if (browserType.equalsIgnoreCase("Firefox")){

        }else {
            //根据日志不同的输出级别，来调用对应的方法,这里是error级别
            baseLogger.error("暂不支持该浏览器！");
        }
    }
//
//    public void 访问(String targetUrl){
//
//        webDriver.navigate().to(ReadProperty.getUrlPath(targetUrl));
//    }

    //访问地址
    public void toUrl(String targetUrl){
        String urlPath = ReadProperty.getUrlPath(targetUrl);
        baseLogger.info("访问到的地址是【"+urlPath+"】");
        webDriver.navigate().to(urlPath);
    }

//点击操作
    public void click(String pageKeyword, String uiElmentKeyword){
        baseLogger.info("点击的是页面【"+pageKeyword+"】中的【"+uiElmentKeyword+"】元素");
        WebElement element =
                UILibraryUtil.getElementByKeyword(pageKeyword, uiElmentKeyword);
        element.click();
    }

//文本输入操作
    public void sendKey(String pageKeyword, String uiElmentKeyword,String inputContent){
        baseLogger.info("定位到的【"+pageKeyword+"】的【"+uiElmentKeyword+"】，往里面写入数据【"+inputContent+"】");
        WebElement element =
                UILibraryUtil.getElementByKeyword(pageKeyword, uiElmentKeyword);
        //因为这里框架并不会在每一次重新调用这个方法的时候去进行数据清除再重写的操作，所以这里主动清除一下
        element.clear();
        element.sendKeys(inputContent);
    }

    @AfterSuite
    public void quitDriver(){
        //线程睡眠等待，线程是进程的最小单位
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }
}
