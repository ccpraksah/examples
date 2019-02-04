package com.upgrad.learn.session2.module4.foundation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashingAlgorithm { 
static int hashFunction(String key) {
	    int hash = 7;
	    for (int i = 0; i < key.length(); i++) {
	        hash = (hash*31 + key.charAt(i))%10;
	    }
return hash;
}
public static void main(String[] args) throws IOException{  
	int[] array = new int[3];
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	for(int i = 0;i<3;i++)
		array[i] = hashFunction(br.readLine());  
    int flag=0;
    for (int j=0;j<3;j++) {
    	for (int k=j+1;k<3;k++) {
    		 if (array[k] >9 ||array[j]>9||(k!=j && array[k] == array[j]))
             {
             	flag=1;
             	break;
             }
    	}
    	if (flag==1)
    		break;
    }
    if(flag==0)
    	System.out.println("Correct");
}  
}