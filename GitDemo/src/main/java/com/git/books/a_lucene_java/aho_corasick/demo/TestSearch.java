package com.git.books.a_lucene_java.aho_corasick.demo;

public class TestSearch {
	public static void main(String[] args) {
		String[] keyWords = {"我是好人","我是坏人","好人","坏人","世界","那么大","世界那么大","大"};;//{"aa","bb"};
		StringSearch searchAlg = new StringSearch(keyWords);
		searchAlg.buildTree();
		String textToSearch="我是好人吗?这事需要问问自己,人能分成好人坏人吗?这恐怕谁也无法解答.世界那么大,给你的想法那么大,我们世界里,只能想想大而已";//"aa bb cc gg hh ff";
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