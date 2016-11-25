package com.git.crawl.webmagic.suggest.gome;

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
public class GomePinyinSuggestWordPageProcessor implements PageProcessor{
	
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.
    		me().
    		setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36ss").
    		setRetryTimes(5).setSleepTime(50);

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
            char[] chars = query.toCharArray();
            int num = 0;
            for (char c : chars) {
                if(c>=65 && c <= 90){
                    num++;
                }
            }
            if(num <3){
                List<String> temps = new ArrayList<String>();
                for (String add : speeeds) {
                    temps.add(url+add);
                }
                page.addTargetRequests(temps);
            }
        }
//        if(Integer.valueOf(totalPage.get(0)) > Integer.valueOf(currentPage.get(0))){
//            Integer pagenum = Integer.valueOf(currentPage.get(0));
//            String newUrl = page.getUrl().toString().replace("&s="+((pagenum-1)*20), "&s="+(pagenum*20));
//            System.out.println(newUrl);
            
//        }
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
              fileName = "E:\\temp\\temp_pinyin_gome_suggest.txt";
              speeeds = FileUtils.readLines(new File("E:\\temp\\pinyin.txt"));
          }
        

           long one = System.currentTimeMillis();
           for (String q : speeeds) {
                long temp = System.currentTimeMillis();
                       String url ="http://api.search.gome.com.cn/p/suggest?from=headSearch&query="+q;
                       Spider.create(new GomePinyinSuggestWordPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
                       thread(5).run();
              System.out.println("the speeed is : "+q+"  end and time is :" + (System.currentTimeMillis() -temp) + " ms");
           }
           long two = System.currentTimeMillis();
           System.out.println("one end and time is :" + (two -one) + " ms");
//           for (String q : speeeds) {
//               for (String qq : speeeds) {
//                           
//                           String url ="https://suggest.taobao.com/sug?code=utf-8&q="+q+qq;
//                           Spider.create(new TaobaoPinyinSuggestWordPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
//                           thread(7).run();
//                       }
//           }
//           long three = System.currentTimeMillis();
//           System.out.println("two end and time is :" + (three -two) + " ms");
//           for (String q : speeeds) {
//               for (String qq : speeeds) {
//                   for (String qqq : speeeds) {
//                           
//                           String url ="https://suggest.taobao.com/sug?code=utf-8&q="+q+qq+qqq;
//                           Spider.create(new TaobaoPinyinSuggestWordPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
//                           thread(7).run();
//                   }
//               }
//               
//           }
//           long four = System.currentTimeMillis();
//           System.out.println("three end and time is :" + (four -three) + " ms");
            //抓完一个词,需要存到hbase中,且清空缓存
            //insertHbase();

        

        
    }
    
//    private static void insertHbase(){
//        insertShop();
//        
//    }
//    
//    private static void insertShop(){
//        
//        List<HbaseDataEntity> lists = new ArrayList<HbaseDataEntity>();
//        Set<String> keys = ShopNameLURCache.getShopNamesCache().keySet();
//        for (String key : keys) {
//            String id = shopId+"";
//            shopId++;
//            HbaseDataEntity entity = new HbaseDataEntity();
//            entity.setNameSpace(null);
//            entity.setTableName("shop_name");
//            entity.setRowKey(id);
//            Map<String, Map<String, Object>> columns = new HashMap<String, Map<String, Object>>();
//            Map<String, Object> map = new HashMap<String, Object>();
//            columns.put("bean", map);
//            map.put("id", id);
//            map.put("name", key);
//            entity.setColumns(columns );
//            lists.add(entity);
//        }
//        HBaseUtils.insertDataList(lists);
//        ShopNameLURCache.getShopNamesCache().clear();
//        if(shopId-shopStartId >=10000000){
//            flag =true;
//        }
//    }
//    
    private static List<String> words;
    
    
//    public static void initData(String textLocation) throws IOException{
//        
//        System.getProperties().setProperty("hbase.flag", "true");
//        System.getProperties().setProperty("hbase.zookeeper.property.clientPort", "2182");
//        System.getProperties().setProperty("hbase.zookeeper.quorum", "10.69.205.28");
//        System.getProperties().setProperty("hbase.master", "10.69.205.28:8020");
//        if(textLocation ==null){
//            URL url = Thread.currentThread().getContextClassLoader().getResource("words.txt");
//            words = FileUtils.readLines(new File(url.getPath()));
//        }else{
//            System.out.println(textLocation);
//            words = FileUtils.readLines(new File(textLocation));
//            System.out.println(words.get(0));
//        }
//        
//    }
    
    
    
    
}
