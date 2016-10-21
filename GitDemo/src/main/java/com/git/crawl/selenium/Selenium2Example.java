package com.git.crawl.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2Example  {
    public static void main(String[] args) throws InterruptedException {
        // 创建了一个 Firefox driver 的实例
        // 注意，其余的代码依赖于接口而非实例
//        WebDriver driver = new HtmlUnitDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\songqinghu\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 使用它访问 Google
//        driver.get("http://www.baidu.com");
        driver.get("http://weibo.com/minipublish");
        // 同样的事情也可以通过以下代码完成
        // driver.navigate().to("http://www.google.com");
        Thread.sleep(30*1000);
        System.out.println("到达");
        // 找到搜索输入框
//        WebElement element = driver.findElement(By.name("q"));

        // 提交表单

        // 检查页面标题
        System.out.println("Page title is: " + driver.getTitle());

        // Google 搜索结果由 JavaScript 动态渲染
        // 等待页面加载完毕，超时时间设为10秒
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        //应该能看到: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //关闭浏览器
        driver.quit();
    }
}