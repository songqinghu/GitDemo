package com.git.books.a_lucene_java.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.miscellaneous.LengthFilter;
import org.apache.lucene.analysis.ngram.NGramTokenizer;
import org.apache.lucene.analysis.standard.ClassicFilter;
import org.apache.lucene.analysis.standard.StandardFilter;

public class MyAnalyzerOneDemo extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
       
        NGramTokenizer tokenizer = new NGramTokenizer(1,3);
        
        TokenStream result = new  ClassicFilter(tokenizer);
        result =new StandardFilter(result);
        result= new LengthFilter(result, 1, 2);
        
        result = new LowerCaseFilter(result);
        
        return new TokenStreamComponents(tokenizer, result);
    }


}
