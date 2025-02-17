 package com.upgrad.learn.session2.module4.foundation;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class TwoSum
{
    static int getPairsCount(int n, int sum, int[] arr)
    {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i=0; i<n; i++){
            if(!hash.containsKey(arr[i]))
                hash.put(arr[i],1);
            else if(hash.get(arr[i])==1)
            	hash.put(arr[i],2);            
        }
        int count = 0;
        for (int i=0; i<n; i++)
        {
        	if((hash.get(arr[i])!=0)&&(hash.get(sum-arr[i])!=null)) {
        		if(sum-arr[i] == arr[i]) {
            		if(hash.get(sum-arr[i]) ==2)
            			count++;
            	}
            	else {
            		if((hash.get(sum-arr[i]) ==1)||(hash.get(sum-arr[i]) ==2))
                        count++;
            	}
        		hash.put(arr[i],0);
        		hash.put(sum-arr[i],0);
        	}          
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt (br.readLine());
    	int[] array = new int[n];
    	String[] strNums;
    	strNums = br.readLine().split("\\s");
    	for (int i=0 ; i<n ; i++)
    		array[i] = Integer.parseInt(strNums[i]);
        int sum = Integer.parseInt (br.readLine());
        System.out.println(getPairsCount(n,sum, array));        
    }
}