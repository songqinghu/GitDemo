package com.git.books.a_lucene_java.aho_corasick.demo;

/**
 * 搜索结果
 * @author lg
 *
 */
public class StringSearchResult {
	private int _index;//所在位置
	private String _keyword;//关键词

	public StringSearchResult(int index, String keyword) {
		_index = index;
		_keyword = keyword;
	}

	public int index() {
		return _index;
	}

	public String keyword() {
		return _keyword;
	}
}
