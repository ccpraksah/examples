package com.upgrad.learn.others.module4;

import java.util.HashMap;
import java.util.Map;

public class WordCountMapper {

	private Map<String, Long> wordCount = new HashMap<String, Long>();
	
	public void read(String word) {
		if(word != null && word.length() > 0) {
			long count = 1;
			if(wordCount.containsKey(word)) {
				count += wordCount.get(word);
			}
			wordCount.put(word, count);
		}
	}
	
	public Map<String, Long> getWordCount() {
		return wordCount;
	}
}
