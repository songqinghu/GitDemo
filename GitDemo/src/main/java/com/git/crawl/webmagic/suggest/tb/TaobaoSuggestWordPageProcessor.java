package com.git.crawl.webmagic.suggest.tb;

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
public class TaobaoSuggestWordPageProcessor implements PageProcessor{
	
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.
    		me().
    		setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36ss").
    		setRetryTimes(5).setSleepTime(100);

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

            if(query.length() <4){
                String[] speeeds = {"q","w","e","r","t","y","u","i","o","p","a",
                        "s","d","f","g","h","j","k","l",
                        "z","x","c","v","b","n","m"};

                
                List<String> temp = new ArrayList<String>();
                for (String add : speeeds) {
                    temp.add(url+add);
                }
                page.addTargetRequests(temp);
            }
        }
        
//        if(Integer.valueOf(totalPage.get(0)) > Integer.valueOf(currentPage.get(0))){
//            Integer pagenum = Integer.valueOf(currentPage.get(0));
//            String newUrl = page.getUrl().toString().replace("&s="+((pagenum-1)*20), "&s="+(pagenum*20));
//            System.out.println(newUrl);
//            page.addTargetRequest(newUrl);
//        }
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
              fileName = "E:\\temp\\temp_tb_suggest.txt";
          }
        
//        if(args.length>0 && args.length<2){
//            initData(args[0]);
//        }else if(args.length ==2){
//            initData(args[0]);
//            shopStartId = Long.parseLong(args[1]);
//            shopId = shopStartId;
//        }
//        else{
//            initData(null);
//        }
        
           String[] speeeds = {"q","w","e","r","t","y","u","i","o","p","a",
                                "s","d","f","g","h","j","k","l",
                                "z","x","c","v","b","n","m"};

           long one = System.currentTimeMillis();
           for (String q : speeeds) {
               
               long temp = System.currentTimeMillis();
               
                       String url ="https://suggest.taobao.com/sug?code=utf-8&q="+q;
                       Spider.create(new TaobaoSuggestWordPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
                       thread(7).run();
                       
                       System.out.println("the speeed is : "+q+"  end and time is :" + (System.currentTimeMillis() -temp) + " ms");
            
           }
           long two = System.currentTimeMillis();
           System.out.println("one end and time is :" + (two -one) + " ms");
//           for (String q : speeeds) {
//               for (String qq : speeeds) {
//                           
//                           String url ="https://suggest.taobao.com/sug?code=utf-8&q="+q+qq;
//                           Spider.create(new TaobaoSuggestWordPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
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
//                           Spider.create(new TaobaoSuggestWordPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
//                           thread(7).run();
//                   }
//               }
//               
//           }
//           long four = System.currentTimeMillis();
//           System.out.println("three end and time is :" + (four -three) + " ms");
//           for (String q : speeeds) {
//               for (String qq : speeeds) {
//                   for (String qqq : speeeds) {
//                       for (String qqqq : speeeds) {
//                           
//                           String url ="https://suggest.taobao.com/sug?code=utf-8&q="+q+qq+qqq+qqqq;
//                           Spider.create(new TaobaoSuggestWordPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
//                           thread(7).run();
//                       }
//                   }
//               }
//               
//           }
//           long five = System.currentTimeMillis();
//           System.out.println("four end and time is :" + (five -four) + " ms");
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
