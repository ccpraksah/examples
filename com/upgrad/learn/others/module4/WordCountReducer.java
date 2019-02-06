package com.upgrad.learn.others.module4;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCountReducer {

	public static Map<String, Long> getAggregatedWordCount(List<WordCountMapper> mappers) {
		Map<String, Long> aggregatedWordCount = new HashMap<String, Long>();
		
		for(WordCountMapper mapper : mappers) {
			Map<String, Long> wordCount = mapper.getWordCount();
			for(String word : wordCount.keySet()) {
				long count = wordCount.get(word);
				if(aggregatedWordCount.containsKey(word)) {
					count += aggregatedWordCount.get(word);
				}
				aggregatedWordCount.put(word, count);
			}
		}
		return aggregatedWordCount;
	}
}
