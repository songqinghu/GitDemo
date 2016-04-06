package com.git.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse.Collation;
import org.apache.solr.client.solrj.response.SpellCheckResponse.Suggestion;
import org.apache.solr.common.params.CommonParams;

/**
 * 拼写检查  测试类
 * @author songqinghu
 *
 */
public class SpellTest {
    
    
    
    public static void main(String[] args) throws SolrServerException, IOException {
        
         HttpSolrClient solrClient = new HttpSolrClient("http://localhost:8983/solr/meixin_suggest");
        
         List<String> spellCheck = getSpellCheck(solrClient);
         for (String spellWord : spellCheck) {
            System.out.println(spellWord);
         }
         System.out.println("================纠错结束===============");
    }
   
    /**
     * 
     * @描述：获取纠错词语
     * @return
     * @return List<String>
     * @exception
     * @createTime：2016年4月1日
     * @author: songqinghu
     * @throws IOException 
     * @throws SolrServerException 
     */
    private static List<String> getSpellCheck(SolrClient solrClient) throws SolrServerException, IOException{
      
        //应该先进行正规的查询如果查询不到(结果为0)那么就继续进行词语纠错查询,还查询不到,返回null
        
        SolrQuery query = new SolrQuery();
        
        query.set(CommonParams.QT, "/spell");
        
        query.set(CommonParams.Q, "suggest:安全膜");
        
        QueryResponse response = solrClient.query(query);
        
        SpellCheckResponse checkResponse = response.getSpellCheckResponse();
       
        List<Suggestion> suggestions = checkResponse.getSuggestions();

        List<String> result = new  ArrayList<String>();
        for (Suggestion suggestion : suggestions) {
            //int numFound = suggestion.getNumFound();
            //System.out.println(numFound);
            List<String> alternatives = suggestion.getAlternatives();
            for (String string : alternatives) {
                result.add(string);
            }
        }
        int numFound = result.size();//纠错词个数
        boolean correctlySpelled = checkResponse.isCorrectlySpelled();//这个没啥意义
        System.out.println(correctlySpelled);
        
        List<Collation> collatedResults = checkResponse.getCollatedResults();//这里也没啥意义
        for (Collation collation : collatedResults) {
           System.out.println(collation.getCollationQueryString()); 
        }
        
        return result;
    }
    
    
    
//    private Collection<String> getSpellCheckFromCore(String keyword,String coreName) throws Exception {  
//        
//        Collection<String> suggestion = new ArrayList<String>();  
//        
//          CoreContainer container = SearchManager.getCoreContainer();  
//        
//         SolrCore core = container.getCore(coreName);  
//        
//          SearchComponent speller = core.getSearchComponent("spellcheck");  
//        
//        
//        
//          ModifiableSolrParams params = new ModifiableSolrParams();  
//        
//          params.add(CommonParams.QT, "/spell");  
//        
//          params.add(SpellCheckComponent.SPELLCHECK_BUILD, "true");  
//        
//          params.add(CommonParams.Q, keyword);  
//        
//          params.add(SpellCheckComponent.COMPONENT_NAME, "true");  
//        
//          params.add(SpellCheckComponent.SPELLCHECK_COLLATE, "true");  
//        
//        
//        
//          SolrRequestHandler handler = core.getRequestHandler("/spell");  
//        
//          SolrQueryResponse rsp = new SolrQueryResponse();  
//        
//          rsp.add("responseHeader", new SimpleOrderedMap());  
//        
//          handler.handleRequest(new LocalSolrQueryRequest(core, params), rsp);  
//        
//          NamedList values = rsp.getValues();  
//        
//          NamedList spellCheck = (NamedList) values.get("spellcheck");  
//        
//          NamedList suggestions = (NamedList) spellCheck.get("suggestions");  
//        
//          Boolean correctlySpelled = (Boolean) suggestions.get("correctlySpelled");  
//        
//          if(correctlySpelled == null){  
//        
//           String collation = (String) suggestions.get("collation");  
//        
//           suggestion.add(collation);  
//        
//          }  
//        
//            
//        
//          return suggestion;  
//        
//      }  
    
//    public  List<String>   spellcheck(String word){  
//        List<String>  wordList=new ArrayList<String>();  
//        SolrQuery query = new SolrQuery();  
//        //query.set("q","name:ac");  
//        //query.set("qt", "/spell");  
//     //默认是主索引  
//        query.set("q", "my_word:"+word+"");    
//        query.set("qt", "/select");  
//        //query.set("spellcheck.build", "true");//遇到新的检查词，会自动添加到索引里面  
//        //query.set("spellcheck.dictionary", "file");//使用副索引，checkSpellFile里面的进行使用  
//        query.set("spellcheck", "true");  
//        query.set("spellcheck.count", Integer.MAX_VALUE);  
//          //  params.set("spellcheck.build", "true");  
//           
//        try {  
//        QueryResponse   rsp = server.query(query);  
//        System.out.println("直接命中:"+rsp.getResults().size());               
//        SolrDocumentList ss=rsp.getResults();  
//        for(SolrDocument doc:ss){  
//            System.out.println(doc.get("my_word"));  
//        }  
//        //…上面取结果的代码  
//        SpellCheckResponse re=rsp.getSpellCheckResponse();  
//          
//        if (re != null) {  
//            for(Suggestion s:re.getSuggestions()){  
//             List<String> list=s.getAlternatives();  
//             for(String spellWord:list){  
//                 System.out.println(spellWord);  
//                // wordList.add(spellWord);  
//             }  
//            }  
////        for(Collation s: spellCheckResponse.getCollatedResults()){  
////            System.out.println(s.toString());  
////        }  
//        }  
//  
//          return wordList;  
//        } catch (SolrServerException e) {  
//            // TODO Auto-generated catch block  
//            e.printStackTrace();  
//        }  
//          
//        return null;  
//    }  


}

