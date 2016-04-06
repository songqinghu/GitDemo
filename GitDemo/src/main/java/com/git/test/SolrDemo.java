package com.git.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse.Suggestion;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.NamedList;

import com.git.utils.Pinyin4jUtil;

import net.sourceforge.pinyin4j.PinyinHelper;



public class SolrDemo {

    
    public static void main(String[] args) throws Exception, IOException {
        
//        addDocuments();
        
        //getSuggest(null);
        addDocumentAndPY();
    }
    
    /**
     * 
     * @描述：为字段添加拼音全名称和首字母
     * @return void
     * @exception
     * @createTime：2016年3月22日
     * @author: songqinghu
     * @throws Exception 
     * @throws SolrServerException 
     */
    public static void addDocumentAndPY() throws SolrServerException, Exception{
        
        SolrClient solrClient = new  HttpSolrClient("http://localhost:8983/solr/group");
        Collection<SolrInputDocument> docs  = new ArrayList<SolrInputDocument>();
           List<String> words = new ArrayList<String>();
           words.add("测试");
           int i = 0;
           for (String word : words) {
               
               SolrInputDocument doc = new SolrInputDocument();
            
               doc.addField("groupId", i+"");

               doc.addField("categoryName", word);
               //需要对工具类进行改写--返回的是多值的时候需要进行数组的切分 确保可以使用 xxx* 进行匹配
               Set<String> lengths = Pinyin4jUtil.converterToSpellToSet(word);
               Set<String> shorts = Pinyin4jUtil.converterToFirstSpellToSet(word);
               for (String py : shorts) {
                
                   doc.addField("pinyin", py);
               }
               for (String py : lengths) {
                
                   doc.addField("pinyin", py);
               }
               i++;
               docs.add(doc);
               System.out.println(word + " length : " + lengths + " shorts: "+ shorts);
           }
          
          solrClient.add(docs);
          
          System.out.println("索引建立结束");
    }
    
    
    
    /**
     * 
     * @描述：搜索建议
     * @return void
     * @exception
     * @createTime：2016年3月21日
     * @author: songqinghu
     * @throws Exception 
     * @throws SolrServerException 
     */
    public static void getSuggest(String suggest) throws SolrServerException, Exception{
        
        HttpSolrClient solrClient = new HttpSolrClient("http://localhost:8983/solr/group");
        
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.set("qt", "/suggest");
        
        solrQuery.set("q", "衣");   
        
        solrQuery.set("spellcheck.count", "10");
        
        QueryResponse response = solrClient.query(solrQuery);
        
        SpellCheckResponse checkResponse = response.getSpellCheckResponse();
        ArrayList<String> spellwords = new ArrayList<String>();
        if(checkResponse!=null){
            List<Suggestion> suggestions = checkResponse.getSuggestions();
            
            for (Suggestion s : suggestions) {
                
                List<String> list = s.getAlternatives();
                for (String spellword : list) {
                    System.out.println(spellword);
                    spellwords.add(spellword);
                }
            }
        }
        System.out.println(spellwords);
        
        
        String firstSuggestion = checkResponse.getFirstSuggestion("衣");
        System.out.println(firstSuggestion);
     
    }
    
    
    /**
     * 
     * @描述：添加文档
     * @return void
     * @exception
     * @createTime：2016年3月21日
     * @author: songqinghu
     * @throws Exception 
     * @throws SolrServerException 
     */
    public static  void addDocuments() throws SolrServerException, Exception{

        HttpSolrClient solrClient = new HttpSolrClient("http://localhost:8983/solr/group");
        
        List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        SolrInputDocument doc1 = new SolrInputDocument();
        doc1.addField("groupId", "1");
        doc1.addField("categoryName", "衣服");
        SolrInputDocument doc2 = new SolrInputDocument();
        doc2.addField("groupId", "2");
        doc2.addField("categoryName", "衣柜");
        SolrInputDocument doc3 = new SolrInputDocument();
        doc3.addField("groupId", "3");
        doc3.addField("categoryName", "漂亮衣服");
        SolrInputDocument doc4 = new SolrInputDocument();
        
        doc4.addField("groupId", "4");
        doc4.addField("categoryName", "大气风衣");
        SolrInputDocument doc5 = new SolrInputDocument();
        doc5.addField("groupId", "5");
        doc5.addField("categoryName", "时尚衬衣");
        docs.add(doc1);
        docs.add(doc2);
        docs.add(doc3);
        docs.add(doc4);
        docs.add(doc5);
        solrClient.add(docs);
        solrClient.commit();
    }
    
    
    
    
}
