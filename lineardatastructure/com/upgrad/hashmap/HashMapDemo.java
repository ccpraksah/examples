package com.upgrad.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapDemo {

	private static HashMap<Long,String> spamList = new HashMap<Long,String>();
	static {
		spamList.put(111L, "SPAM");
		spamList.put(112L, "SPAM");
		spamList.put(113L, "SPAM");
		spamList.put(114L, "SPAM");
		spamList.put(115L, "SPAM");
		spamList.put(116L, "SPAM");
	}

	public static String isSpam(Long phoneNumber) {
		String val="";
		if (spamList.containsKey(phoneNumber)) {
			val = spamList.get(phoneNumber);
		} else {
			val = "NOT SPAM";
		}
		return val;
	}

	public static void main(String[] args) {
		ArrayList<Long> phoneNum = new ArrayList<Long>();
		phoneNum.add(111L);
		phoneNum.add(101L);
		phoneNum.add(105L);
		phoneNum.add(113L);
		phoneNum.add(118L);


		for(Long ln : phoneNum) {
			System.out.println(ln + ":" + HashMapDemo.isSpam(ln));
		}

	}
}
