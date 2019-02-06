package com.upgrad.learn.others.module4;



import java.util.Arrays;
import java.util.List;

public class WordCountMapperFactory {

	private static WordCountMapper mapper1 = new WordCountMapper();
	private static WordCountMapper mapper2 = new WordCountMapper();
	private static WordCountMapper mapper3 = new WordCountMapper();
	
	public static WordCountMapper getMapperFor(String word) {
		int hash = genHash(word);
		int hashmod3 = Math.abs(hash) % 3;
		switch(hashmod3) {
		case 0:
			return mapper1;
		case 1:
			return mapper2;
		case 2:
			return mapper3;
		default:
			throw new RuntimeException("Internal Error. There is some issue with getHashMod3 Function. "
					+ "Expected values between 0 to 2 while the current value is : " + hash);
		}
	}
	
	public static int genHash(String word) {
		int prime = 3;
		String s = "upgrad";
		int a = 1;
		int hash = word.hashCode();
		for(int i = 0; i < s.length(); i++) {
			a = (prime * a) + s.charAt(i) + hash;
		}
		return a;
	}
	
	public static List<WordCountMapper> getAllWordCountMappers() {
		return Arrays.asList(new WordCountMapper[] {mapper1, mapper2, mapper3});
	}
}
