package com.git.books.a_lucene_java.lucene;

import java.io.IOException;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.flexible.core.QueryNodeException;
import org.apache.lucene.queryparser.flexible.standard.StandardQueryParser;
import org.apache.lucene.queryparser.flexible.standard.config.StandardQueryConfigHandler;
import org.apache.lucene.queryparser.surround.parser.ParseException;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;

/**
 * 
 * @Description: lucene查询解析过程 调试demo
 * @author: songqinghu
 * @date: 2017年2月15日 下午8:22:47
 * Version:1.0
 */
public class LuceneQueryParserDemo {

    public static void main(String[] args) throws ParseException, org.apache.lucene.queryparser.classic.ParseException, QueryNodeException, IOException {
        
        MyAnalyzerUseDemoTwo();
    }
    
    public static void MyAnalyzerUseDemoTwo() throws IOException {

        @SuppressWarnings("resource")
        MyAnalyzerOneDemo analyzer = new MyAnalyzerOneDemo();

        TokenStream tokenStream = analyzer.tokenStream("name", "USE some num is very good");

        CharTermAttribute term = tokenStream.addAttribute(CharTermAttribute.class);
        
        
        tokenStream.reset();
        
        while (tokenStream.incrementToken()) {
            System.out.println(term.toString());
        }

    }
    
    
    
    
    public static void MyAnalyzerUseDemo() throws IOException {

        @SuppressWarnings("resource")
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();

        TokenStream tokenStream = analyzer.tokenStream("name", "特朗普要俄归还克里米亚 美俄蜜月期结束?");

        CharTermAttribute term = tokenStream.addAttribute(CharTermAttribute.class);
        
        
        tokenStream.reset();
        
        while (tokenStream.incrementToken()) {
            System.out.println(term.toString());
        }

    }
    
    
    
    
    public static void queryParserTest() throws org.apache.lucene.queryparser.classic.ParseException, QueryNodeException{
       BooleanQuery bq = new BooleanQuery();
        
        Term t1 = new Term("name", "1");
        TermQuery tq1 = new TermQuery(t1);
        Term t2 = new Term("name", "2");
        TermQuery tq2 = new TermQuery(t2);
        
        
        bq.add(tq1, Occur.SHOULD);
        bq.add(tq2, Occur.MUST_NOT);
        
        System.out.println(bq);
//        SrndQuery parse = QueryParser.parse("-1 +2");
//        new QueryParser(f, a)
        QueryParser queryParser = new QueryParser("name",new SmartChineseAnalyzer());
        
        Query parse = queryParser.parse("(测试  -不是测试吗) +国美测试");
        
        System.out.println(parse);
        
        
        StandardQueryParser qpHelper = new StandardQueryParser();
        
        StandardQueryConfigHandler config = (StandardQueryConfigHandler) qpHelper.getQueryConfigHandler();
        
        Query parse2 = qpHelper.parse("啦啦啦啦 -1 +1 content:1^2", "name");
        System.out.println(parse2);
        
    }
    
    
}
