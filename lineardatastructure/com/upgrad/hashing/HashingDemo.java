package com.upgrad.hashing;

import java.util.ArrayList;

public class HashingDemo {
	public int generateHashCode(String state) {
		int length = state.length();
		char first = state.charAt(0);
		int firstInt = (int)first;
		int hashcode = length * firstInt;
		return hashcode;
	}
	
	public static void main(String args[]) {
		ArrayList<String> states = new ArrayList<String>();
		states.add("Uttar Pradesh");
		states.add("Maharashtra");
		states.add("Bihar");
		states.add("West Bengal");
		states.add("Madhya Pradesh");
		states.add("Tamil Nadu");
		states.add("Rajasthan");
		states.add("Karnataka");
		states.add("Gujarat");
		states.add("Andhra Pradesh");
		states.add("Odisha");
		states.add("Telangana");
		states.add("Kerala");
		states.add("Jharkhand");
		states.add("Assam");
		states.add("Punjab");
		states.add("Haryana");
		states.add("Chattisgarh");
		states.add("Jammu and Kashmir");
		states.add("Uttarakhand");
		states.add("Himachal Pradesh");
		states.add("Tripura");
		states.add("Meghalaya");
		states.add("Manipur");
		states.add("Nagaland");
		states.add("Goa");
		states.add("Arunachal Pradesh");
		states.add("Mizoram");
		states.add("Sikkim");		
		HashingDemo hd = new HashingDemo();
		for (String s : states)
			System.out.println(s + ":" + hd.generateHashCode(s));
	}
}
