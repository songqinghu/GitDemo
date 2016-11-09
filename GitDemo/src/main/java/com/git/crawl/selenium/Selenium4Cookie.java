package com.git.crawl.selenium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @Description: 借助cookie免去登录
 * @author: songqinghu
 * @date: 2016年11月9日 上午10:53:35
 * Version:1.0
 */
public class Selenium4Cookie  {
    public static void main(String[] args) throws InterruptedException {
        // 创建了一个 Firefox driver 的实例
        // 注意，其余的代码依赖于接口而非实例
//        WebDriver driver = new HtmlUnitDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\songqinghu\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        // 使用它访问 Google
//        driver.get("http://www.baidu.com");
        driver.get("http://www.baidu.com");
        // 同样的事情也可以通过以下代码完成
        // driver.navigate().to("http://www.google.com");
        Thread.sleep(60*1000);
        Set<Cookie> cookies = driver.manage().getCookies();

        File file = new File("broswer.data");
        try {
            // delete file if exists
            file.delete();
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Cookie ck : driver.manage().getCookies()) {
                bw.write(ck.getName() + ";" + ck.getValue() + ";"
                        + ck.getDomain() + ";" + ck.getPath() + ";"
                        + ck.getExpiry() + ";" + ck.isSecure());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("cookie write to file");
        }
        System.out.println("到达");
        driver.quit();
        
        driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
//        try 
//        {
//            File file2=new File("broswer.data");
//            FileReader fr=new FileReader(file2);
//            BufferedReader br=new BufferedReader(fr);
//            String line;
//            while((line=br.readLine())!= null)
//            {
//                StringTokenizer str=new StringTokenizer(line,";");
//                while(str.hasMoreTokens())
//                {
//                    String name=str.nextToken();
//                    String value=str.nextToken();
//                    String domain=str.nextToken();
//                    String path=str.nextToken();
//                    Date expiry=null;
//                    String dt;
//                    if(!(dt=str.nextToken()).equals(null))
//                    {
//                        expiry=new Date(dt);
////                        System.out.println();
//                    }
//                    boolean isSecure=new Boolean(str.nextToken()).booleanValue();
//                    Cookie ck=new Cookie(name,value,domain,path,expiry,isSecure);
//                    driver.manage().addCookie(ck);
//                }
//            }
//            
//            
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }

        driver.get("http://www.baidu.com");
      WebElement element = driver.findElement(By.linkText("默默不能知"));

      Actions builder = new Actions(driver);

      Action build = builder.moveToElement(element).click().build();
      build.perform();
    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver d) {
            //return d.findElement(By.xpath("//*[@id='pl_content_simplePublisher']/div/div[6]/div[3]/div/img")).getAttribute("src")!=null;
            return true;
        }
    });
      Thread.sleep(60*1000);
        // 找到搜索输入框
//        WebElement element = driver.findElement(By.name("q"));
//        WebElement element = driver.findElement(By.linkText("图片"));
//
//        Actions builder = new Actions(driver);
//
//        Action build = builder.moveToElement(element).click().build();
//        build.perform();
//        // 提交表单
////        <input type="file" node-type="upload_input" class="input_f" name="pic1">
//        WebElement pic = driver.findElement(By.name("pic1"));
//        pic.sendKeys("C:\\Users\\songqinghu\\Desktop\\44.jpg");
////        <img node-type="img" alt="" src="http://ww1.sinaimg.cn/small/9bd2ff25jw1f906elj7f7j20yx0gatb1.jpg">
//        // 等待页面加载完毕，超时时间设为10秒
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.findElement(By.xpath("//*[@id='pl_content_simplePublisher']/div/div[6]/div[3]/div/img")).getAttribute("src")!=null;
//            }
//        });
//      
//        WebElement img =  driver.findElement(By.xpath("//*[@id='pl_content_simplePublisher']/div/div[6]/div[3]/div/img"));
//        String src = img.getAttribute("src");
//        // 检查页面标题
//        System.out.println("Page src is: " + src);
        // Google 搜索结果由 JavaScript 动态渲染
//
//        //应该能看到: "cheese! - Google Search"
//        System.out.println("Page title is: " + driver.getTitle());

        //关闭浏览器
        driver.quit();
    }
}