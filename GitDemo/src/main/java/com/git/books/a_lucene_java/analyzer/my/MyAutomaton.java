package com.git.books.a_lucene_java.analyzer.my;



import org.apache.lucene.index.Term;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.util.automaton.LevenshteinAutomata;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.BasicAutomata;
import dk.brics.automaton.BasicOperations;





/**
 * 
 * @Description: 有限状态机 demo
 * @author: songqinghu
 * @date: 2017年2月15日 下午2:37:47
 * Version:1.0
 */
public class MyAutomaton {

    public static void main(String[] args) {
        
         two();
         
    }
    
    public static void two(){
        
        FuzzyQuery query = new FuzzyQuery(new Term("name", "songqinghu"),2,1);
        
        
//        LevenshteinAutomata builder = new LevenshteinAutomata("宋庆", true);
//        
//        org.apache.lucene.util.automaton.Automaton a = builder.toAutomaton(1);
//        
//        
//        
//        
//        
//        Automaton b = BasicAutomata.makeChar('虎');
//        
//        
//        BasicOperations.concatenate(a, b);
        
    }
    
    public static void one(){
        
//        //Automaton num = BasicAutomata.makeCharRange('0', '9').repeat(1);
//        
//        num.determinize();
//        
//        num.minimize();
//        
//        String singleton = num.getSingleton();
//        
//        
//        System.out.println(singleton);
    }
    
    
}
