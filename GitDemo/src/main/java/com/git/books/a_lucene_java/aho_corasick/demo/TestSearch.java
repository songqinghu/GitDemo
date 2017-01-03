package com.git.books.a_lucene_java.aho_corasick.demo;

public class TestSearch {
	public static void main(String[] args) {
		String[] keyWords = {"北京","武汉","夏科","夏新","夏普"};//{"aa","bb"};
		StringSearch searchAlg = new StringSearch(keyWords);
		searchAlg.buildTree();
		String textToSearch="从武汉来到北京,夏普的夏天的夏科节啊分开了就是快乐的经过了时间的老公尽量空间";//"aa bb cc gg hh ff";
		// Find all matching keywords?
		long start = System.currentTimeMillis();
		StringSearchResult[] results=searchAlg.findAll(textToSearch);
		long end = System.currentTimeMillis();
		System.out.println("resultsLength="+results.length + " time : " + (end -start) + " ms");
		// Write all results?
		for(StringSearchResult r : results)
		{
			System.out.println("Keyword='"+r.keyword()+"', Index="+r.index());
		}
	}
}