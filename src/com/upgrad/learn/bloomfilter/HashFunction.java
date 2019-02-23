package com.upgrad.learn.bloomfilter;

/**
 * Utility class with the hash functions
 * @author PrakashC
 *
 */
public class HashFunction {
	
	/**
	 * generates the hash for the data
	 * @param data
	 * @return
	 */
	public int genHash1(String data) {
		int prime =331;
		String s ="PrakashC";
		int a =1;
		int hash = data.hashCode();
		for(int i=0;i<s.length();i++) {
			a = (prime*a)+s.charAt(i)+hash;
		}
		return a;
	}
	
	/**
	 * generates the hash for the data
	 * @param data
	 * @return
	 */
	public int genHash2(String data) {
		int prime=701;
		String s ="Chinta";
		int a =1;
		int hash = data.hashCode();
		for(int i=0;i<s.length();i++) {
			a = (prime*a)+s.charAt(i)+hash;
		}
		return a;
	}
	
	/**
	 * generates the hash for the data
	 * @param data
	 * @return
	 */
	public int genHash3(String data) {
		int key = Integer.parseInt(data);
		key = (~key) + (key << 18); // key = (key << 18) - key - 1;
		key = key ^ (key >>> 31);
		key = key * 21; // key = (key + (key << 2)) + (key << 4);
		key = key ^ (key >>> 11);
		key = key + (key << 6);
		key = key ^ (key >>> 22);
		return key;
	}
}
