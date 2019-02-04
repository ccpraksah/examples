package com.upgrad.learn.session2.module1.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Operations{
	private int a;
	private int b;
	public Operations(int number1,int number2){
		this.a = number1;
		this.b = number2;
	}
	public int addition()
	{
		return (a+b);
	}
	public int subtraction()
	{
		return (a-b);
	}
	public int multiply()
	{
		return (addition()*subtraction());
	}		
}

public class Operations1 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int a = Integer.parseInt(br.readLine());
    	int b = Integer.parseInt(br.readLine());
    	Operations object1 = new Operations(a,b); 
    	System.out.println(object1.multiply());
    }
}
