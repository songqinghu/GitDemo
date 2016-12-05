package com.git.crawl.webmagic.suggest.tb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
/**
 * 淘宝搜索建议词语爬取
 * <p>Title: DemoIntroPageProcessor.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年10月2日下午8:40:03
 * @version 1.0
 */
public class TaobaoPinyinSuggestWordPageProcessor implements PageProcessor{
	
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.
    		me().
    		setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36ss").
    		setRetryTimes(5).setSleepTime(10);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        //["童装","40827952"]
        JSONArray a = JSON.parseArray(JSON.parseObject(page.getJson().toString()).get("result").toString());
        for (Object aa : a) {
            String replace = aa.toString().replace("[", "").replace("]", "").replace("\"", "");            
            String substring = replace.substring(0,replace.indexOf(","));
            try {
                IOUtils.write(substring.getBytes(), new FileOutputStream(new File(fileName),true));
                IOUtils.write(IOUtils.LINE_SEPARATOR.getBytes(), new FileOutputStream(new File(fileName),true));
            
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(a.size()>9){
            String url = page.getUrl().toString();
            //https://suggest.taobao.com/sug?code=utf-8&q=
            int index = "https://suggest.taobao.com/sug?code=utf-8&q=".length();
            String query = url.substring(index, url.length());
            char[] chars = query.toCharArray();
            int num = 0;
            for (char c : chars) {
                if(c>=65 && c <= 90){
                    num++;
                }
            }
            if(num <3){
                List<String> temp = new ArrayList<String>();
                for (String add : speeeds) {
                    temp.add(url+add);
                }
                page.addTargetRequests(temp);
            }
        }
            
    }

    @Override
    public Site getSite() {
        return site;
    }

    private static String fileName ;
    
    private static List<String> speeeds;
    
    
    public static void main(String[] args) throws IOException {
          
         if(args.length>1 && args.length<3){
              fileName = args[0];
              speeeds = FileUtils.readLines(new File(args[1]));
          }else{
              fileName = "E:\\temp\\temp_pinyin_suggest.txt";
              speeeds = FileUtils.readLines(new File("E:\\temp\\pinyin.txt"));
          }
        

           long one = System.currentTimeMillis();
           for (String q : speeeds) {
                long temp = System.currentTimeMillis();
                       String url ="https://suggest.taobao.com/sug?code=utf-8&q="+q;
                       Spider.create(new TaobaoPinyinSuggestWordPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
                       thread(7).run();
              System.out.println("the speeed is : "+q+"  end and time is :" + (System.currentTimeMillis() -temp) + " ms");
           }
           long two = System.currentTimeMillis();
           System.out.println("one end and time is :" + (two -one) + " ms");
        
    }
    
    
}
