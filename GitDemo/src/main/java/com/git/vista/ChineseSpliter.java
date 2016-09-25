package com.git.vista;

import java.util.List;

import com.git.lucene.NGramTokenizerUtil;

/**
* 中文分词器
*/
public class ChineseSpliter 
{
	   /**
	    * 对给定的文本进行中文分词
	    * @param text 给定的文本
	    * @param splitToken 用于分割的标记,如"|"
	    * @return 分词完毕的文本
	    */
	public static String[] split(String text,String splitToken)
	{
		String[] result = null;
		//MMAnalyzer analyzer = new MMAnalyzer();  	
		//try  	
       // {
			//result = analyzer.segment(text, splitToken);
		    
		   List<String> words = NGramTokenizerUtil.analyzer(text);
		   result = new String[words.size()];
		   for (int i = 0; i < words.size(); i++) {
			  result[i] = words.get(i);
		   }
		//}  	
      //  catch (IOException e)  	
      //  { 	
      //  	e.printStackTrace(); 	
      //  } 	
        return result;
	}
}
