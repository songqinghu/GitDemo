package com.git.utils;
/**
 * 容器类 --对solr中涉及的词语出现的词语进行本地缓存 和 同步处理
 * 分布式时可以考虑 放入 共享容器中
 * @author songqinghu
 *
 */
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class WordCountCache {

    private  static  Logger logger = LoggerFactory.getLogger(WordCountCache.class);
    /**
     * 容器  放入word的md5加密后的 和次数
     */
    private static ConcurrentHashMap<String, Integer> wordCountMap = new ConcurrentHashMap<String,Integer>();
    
    private static Object lock  = new  Object();
    
    /**
     * 
     * @描述：设置词语的次数 ---设置锁处理
     * @param word 词语(加密后的)id
     * @param count 次数
     * @return void
     * @exception
     * @createTime：2016年3月28日
     * @author: songqinghu
     */
    public static Integer putCount(String id,Integer count){
        logger.warn("WordCountCache 线程: "+ Thread.currentThread().getName() +" id: "+id+" count: "+count);
        synchronized (lock) {
            Integer result = wordCountMap.get(id);
            if(result !=null){ //存在此key 加上已经缓存的---不存在 直接存这次的
                count = result + count;
            }
            wordCountMap.put(id, count);
            return wordCountMap.get(id);
        }
    }
    /**
     * 
     * @描述：是否缓存到了本地中
     * @param id
     * @return
     * @return boolean
     * @exception
     * @createTime：2016年3月28日
     * @author: songqinghu
     */
    public static boolean containsKey(String id){
        if(wordCountMap.containsKey(id)){
            return true;
        }
        return false;
    }
    /**
     * 
     * @描述：清空本地的 缓存---全量结束 和  清理全量索引的时候
     * @return
     * @return boolean
     * @exception
     * @createTime：2016年3月28日
     * @author: songqinghu
     */
    public static boolean clear(){
        wordCountMap.clear();
        return true;
    }
    
    /**
     * 
     * @描述：当全量索引导入结束后 获取缓存的词频 进行词频重写--后清空
     *  这里还要优化下 当索引量很多 不能一次全部都提交了--设置为添加到定量的list中
     * @return
     * @return List<SolrInputDocument>
     * @exception
     * @createTime：2016年3月28日
     * @author: songqinghu
     */
//    public static List<List<SolrInputDocument>> getDocs(){
//        //文档容器
//        List<List<SolrInputDocument>> list = new  ArrayList<List<SolrInputDocument>>();
//        
//        ArrayList<SolrInputDocument> docs = new  ArrayList<SolrInputDocument>();//测试一下
//        
//        Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
//        int i =0;
//        for (Entry<String, Integer> entry : entrySet) {
//            String id = entry.getKey();
//            Integer count = entry.getValue();
//            SolrInputDocument doc = new SolrInputDocument();
//            doc.setField(BaseSuggestIndex.Fd.suggestId.name(),id);//这里的硬编码可以设置成类的形式
//            Map<String, Integer> counts = new HashMap<String, Integer>(1);
//            counts.put("set", count);
//            doc.setField(BaseSuggestIndex.Fd.count.name(), counts);
//            docs.add(doc);
//            i++;
//            if(i>=1000){//为1000  单次修改文档数目设置为1000--总量最后一次进不来 的处理
//                ArrayList<SolrInputDocument> tmp = new  ArrayList<SolrInputDocument>();
//                tmp.addAll(docs);
//                list.add(tmp);
//                i=0;
//                docs.clear();
//            }
//        }
//        if(i!=0){//最后一次没有进入判断里
//            list.add(docs);
//        }
//        return list;
//    }
    /**
     * 
     * @描述：获取总数量--id就为总的索引数
     * @return
     * @return Integer
     * @exception
     * @createTime：2016年3月28日
     * @author: songqinghu
     */
    public static Integer getRows(){
        return wordCountMap.size();
    }
    
    
}
