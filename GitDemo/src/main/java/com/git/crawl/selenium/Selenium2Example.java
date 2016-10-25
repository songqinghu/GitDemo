package com.git.crawl.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
        Thread.sleep(60*1000);
        System.out.println("到达");
        // 找到搜索输入框
//        WebElement element = driver.findElement(By.name("q"));
        WebElement element = driver.findElement(By.linkText("图片"));

        Actions builder = new Actions(driver);

        Action build = builder.moveToElement(element).click().build();
        build.perform();
        // 提交表单
//        <input type="file" node-type="upload_input" class="input_f" name="pic1">
        WebElement pic = driver.findElement(By.name("pic1"));
        pic.sendKeys("C:\\Users\\songqinghu\\Desktop\\44.jpg");
//        <img node-type="img" alt="" src="http://ww1.sinaimg.cn/small/9bd2ff25jw1f906elj7f7j20yx0gatb1.jpg">
        // 等待页面加载完毕，超时时间设为10秒
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("//*[@id='pl_content_simplePublisher']/div/div[6]/div[3]/div/img")).getAttribute("src")!=null;
            }
        });
      
        WebElement img =  driver.findElement(By.xpath("//*[@id='pl_content_simplePublisher']/div/div[6]/div[3]/div/img"));
        String src = img.getAttribute("src");
        // 检查页面标题
        System.out.println("Page src is: " + src);
        // Google 搜索结果由 JavaScript 动态渲染
//
//        //应该能看到: "cheese! - Google Search"
//        System.out.println("Page title is: " + driver.getTitle());

        //关闭浏览器
        driver.quit();
    }
}