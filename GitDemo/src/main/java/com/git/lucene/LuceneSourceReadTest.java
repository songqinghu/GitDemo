package com.git.lucene;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.chenlb.mmseg4j.analysis.MMSegAnalyzer;

/**
 * 使用lucene进行索引的增删改查时 观察具体的源码执行过程
 * 目前先看查询
 * @author songqinghu
 *
 */
public class LuceneSourceReadTest {

    public static void main(String[] args) throws Exception {
       //fullIndex();
       readIndex();
        //deleteAllDocment();
       // addDocuments() ;
       //updateDocument();
        //deleteDocument();
        
       // readIndexByMoreQuery();
       // parseQuery();
    }
    /**
     * 
     * @描述：增加文档
     * @return void
     * @exception
     * @createTime：2016年4月14日
     * @author: songqinghu
     * @throws Exception 
     */
    public static void addDocuments() throws Exception{
        
        IndexWriter indexWriter = getIndexWriter();
        
        Document doc = new Document();
        
        TextField content = new TextField("content", "时间是一种很宝贵的资源,请好好珍惜它!", Store.YES);
        
        StringField name = new StringField("name", "生命", Store.YES);
        
        doc.add(content);
        
        doc.add(name);
        
        indexWriter.addDocument(doc);
        
        indexWriter.commit();
        
        indexWriter.close();
        
        System.out.println("索引写入完成");
        
    }
    
    /**
     * 修改文档--本质是先删除后增加
     * @throws Exception 
     */
    public static void updateDocument() throws Exception{
        
        IndexWriter indexWriter = getIndexWriter();
        
        Term term = new Term("name", "生命");
        
        Document doc  = new Document();
        
        TextField content = new TextField("content", "人活着不是为了快乐吗?为什么你总是不微笑", Store.YES);
        
        StringField name = new StringField("name", "快乐", Store.YES);
        
        doc.add(content);
        
        doc.add(name);
        
        indexWriter.updateDocument(term, doc);
        
        indexWriter.commit();
        
        indexWriter.close();
        
        System.out.println("修改结束");
    }

    /**
     * 删除指定的文档对象
     * @throws Exception 
     */
      public static void deleteDocument() throws Exception{
          
          IndexWriter indexWriter = getIndexWriter();
          
          Term term  = new  Term("content","什么");
       
          indexWriter.deleteDocuments(term);
          
          indexWriter.commit();
          
          indexWriter.close();
          
          System.out.println("删除结束");
          
          
      }
    
    /**
     * 
     * @描述：删除索引库中的文档
     * @return void
     * @exception
     * @createTime：2016年4月14日
     * @author: songqinghu
     * @throws Exception 
     */
    public static void deleteAllDocment() throws Exception{
       
       IndexWriter indexWriter = getIndexWriter(); 
       
       indexWriter.deleteAll();
       
       indexWriter.commit();
       
       indexWriter.close();
       
       System.out.println("删除了全部的索引!");
    }
    
    /**
     * 
     * @描述：使用多种query进行查询
     * @return void
     * @exception
     * @createTime：2016年4月14日
     * @author: songqinghu
     * @throws Exception 
     */
    public static void readIndexByMoreQuery() throws Exception{
      
        IndexSearcher searcher = getSearcher();
        //数字区间
        Query query1  = NumericRangeQuery.newLongRange("fileSize", 0l, 1000l, true, true);
        //合并两个条件
        BooleanQuery query2 = new BooleanQuery();
        
        TermQuery term1 = new  TermQuery( new Term("content","this"));
        
        TermQuery term2 = new  TermQuery(new Term("content","http"));
        
        query2.add(term1, Occur.MUST);
        
        query2.add(term2, Occur.MUST_NOT);
        
        //查询所有
        MatchAllDocsQuery query3 = new MatchAllDocsQuery();
        
        System.out.println("query1: " + query1);
        System.out.println("query2: " + query2);
        System.out.println("query3: " + query3);
        System.out.println("===================================");
        
        TopDocs topDocs = searcher.search(query3, 10);
        
        showDoc(topDocs, searcher);
        
        
    }
    /**
     * 查询条件的解析
     * @throws ParseException 
     */
    public static void parseQuery() throws ParseException{
        //指定单个查询域
        QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "content", new MMSegAnalyzer());
        Query parse = parser.parse("美信网络科技有限公司是国美集团旗下的全资控股的子公司");
        System.out.println(parse);
        //指定多个查询域
        String[] fields = new  String[]{"content","fileName"};
        MultiFieldQueryParser multiParser = new MultiFieldQueryParser(Version.LUCENE_CURRENT, fields, new MMSegAnalyzer());
        Query parse2 = multiParser.parse("美信网络科技有限公司是国美集团旗下的全资控股的子公司");
        System.out.println(parse2);
    }
    
    
    
    /**
     * 
     * @throws IOException 
     * @描述：读取索引信息
     */
    public static void readIndex() throws Exception{
        
     IndexSearcher index = getSearcher();
      
     Term t  = new Term("content", "apache");
     Query query  = new TermQuery(t);
     
     TopDocs topdocs = index.search(query,20);

     showDoc(topdocs,index);
    }
    /**
     * 
     * @描述：获取查询对象
     */
    private static IndexSearcher getSearcher() throws Exception{
        
     Directory directory  = FSDirectory.open(new File("E:\\lucene\\index")) ;
   
     DirectoryReader reader = DirectoryReader.open(directory);
       
     IndexSearcher index = new  IndexSearcher(reader);
     
     return index;
    }
    
    
    /**
     * 显示查询到信息
     * @throws IOException 
     */
    private  static void showDoc(TopDocs topDocs,IndexSearcher searcher) throws IOException{

        int totalHits = topDocs.totalHits;
        
        System.out.println("总条目: "+totalHits);
        
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        
        for (ScoreDoc scoreDoc : scoreDocs) {
           int docid = scoreDoc.doc;
           System.out.println(docid);
           
           Document doc = searcher.doc(docid);
           
           System.out.println("fileName : "+doc.getField("fileName").stringValue());
           
           System.out.println("content : "+doc.getField("content").stringValue());
           
           System.out.println("fileSize : "+doc.getField("fileSize").stringValue());
        }
        
    }
    
    
    /**
     * @throws IOException 
     * @描述：索引的建立
     */
    public static void fullIndex() throws Exception{
        IndexWriter indexWriter = getIndexWriter();
        
        ArrayList<Document> docs = new ArrayList<Document>();
        
        File filepath = new File("E:\\lucene\\file");
        
        if(filepath.isDirectory()){
            
            File[] files = filepath.listFiles();
            
            for (File file : files) {
                
                String fileName = file.getName();
                
                long fileSize = FileUtils.sizeOf(file);
                
                String content = FileUtils.readFileToString(file);
                if(content.length()>100){
                    content = content.substring(0,20);
                }
                
                String path = file.getPath();
                
                Document doc = new  Document();
                
                StringField fileNameField = new StringField("fileName", fileName, Store.YES);
                doc.add(fileNameField);
                StringField pathField = new StringField("path", path, Store.YES);
                doc.add(fileNameField);
                
                LongField fileSizeField = new LongField("fileSize", fileSize, Store.YES);
                doc.add(fileSizeField);
                
                TextField contentField = new TextField("content", content, Store.YES);
                doc.add(contentField);
                
                docs.add(doc);
            }
        }
        
        indexWriter.addDocuments(docs);
        
        indexWriter.commit();
        
        System.out.println("全量索引导入结束!");
        
    }
    
    private static  IndexWriter getIndexWriter() throws Exception{
        //索引存放
        Directory d = FSDirectory.open(new File("E:\\lucene\\index")) ;
        //分词器
        Analyzer analyzer  = new MMSegAnalyzer();
        //写入设置
        IndexWriterConfig conf = new  IndexWriterConfig(Version.LUCENE_CURRENT, analyzer);
        //写入器
        IndexWriter indexWriter = new IndexWriter(d, conf);
        
        return indexWriter;
    }
}
