package com.upgrad.learn.project1.session2;

import java.util.ArrayList;

public class SpamFilter {
	public int generateHashCode(String state) {
		int length = state.length();
		char first = state.charAt(0);
		int firstInt = (int) first;
		int hashcode = length * firstInt;
		return hashcode;
	}

	public static void main(String args[]) {
		ArrayList<String> states = new ArrayList<String>();
		states.add("Barun");
		states.add("Mayank");
		states.add("Karan");
		states.add("Shubham");

		SpamFilter hd = new SpamFilter();
		for (String s : states)
			System.out.println(hd.generateHashCode(s));
	}
}