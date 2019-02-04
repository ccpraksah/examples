package com.upgrad.learn.session3.module1.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arrays {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt (br.readLine());
    	int [] input = new int[n];
    	String[] strNums;
    	strNums = br.readLine().split("\\s");
    	for (int i=0 ; i<n ; i++)
    		input[i] = Integer.parseInt(strNums[i]);
    	for (int i=0 ; i<n ; i++)
		{
			if(input[i]%2 == 1)
				input[i]++;
			System.out.print(input[i]+ " ");
		}
    }
}