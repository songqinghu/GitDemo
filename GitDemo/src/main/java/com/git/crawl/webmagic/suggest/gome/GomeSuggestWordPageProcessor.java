package com.git.crawl.webmagic.suggest.gome;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class GomeSuggestWordPageProcessor implements PageProcessor{
	
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.
    		me().
    		setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36ss").
    		setRetryTimes(5).setSleepTime(100);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        //["童装","40827952"]
        JSONArray a = JSON.parseArray(page.getJson().toString());
        ArrayList<String> temp = new ArrayList<String>();
        for (Object aa : a) {
            
            if(aa.toString().indexOf("{\"cat\":")==-1){
                String replace = aa.toString().replace("[", "").replace("]", "").replace("\"", "");            
                String substring = replace.substring(0,replace.indexOf(","));
                temp.add(substring);
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            try {
                IOUtils.write(temp.get(i).getBytes(), new FileOutputStream(new File(fileName),true));
                IOUtils.write(IOUtils.LINE_SEPARATOR.getBytes(), new FileOutputStream(new File(fileName),true));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
        if(temp.size()>8){

            
            String url = page.getUrl().toString();
            //https://suggest.taobao.com/sug?code=utf-8&q=
            int index = "http://api.search.gome.com.cn/p/suggest?from=headSearch&query=".length();
            String query = url.substring(index, url.length());
            if(query.length() <4){
                String[] speeeds = {"q","w","e","r","t","y","u","i","o","p","a",
                        "s","d","f","g","h","j","k","l",
                        "z","x","c","v","b","n","m"};
                
                List<String> temps = new ArrayList<String>();
                for (String add : speeeds) {
                    temps.add(url+add);
                }
                page.addTargetRequests(temps);
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    private static String fileName ;
    
    public static void main(String[] args) throws IOException {
        if(args.length>0 && args.length<2){
            fileName = args[0];
        }else{
            fileName = "E:\\temp\\temp_gome_suggest.txt";
        }
        
        
           String[] speeeds = {"q","w","e","r","t","y","u","i","o","p","a",
                                "s","d","f","g","h","j","k","l",
                                "z","x","c","v","b","n","m"};
        long one = System.currentTimeMillis();
        for (String q : speeeds) {
            long temp = System.currentTimeMillis();
                  String url ="http://api.search.gome.com.cn/p/suggest?from=headSearch&query="+q;
                  Spider.create(new GomeSuggestWordPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
                  thread(7).run();
           System.out.println("the speeed is : "+q+"  end and time is :" + (System.currentTimeMillis() -temp) + " ms");
        }
        long two = System.currentTimeMillis();
        System.out.println("one end and time is :" + (two -one) + " ms");
    }
    

    
    
}
