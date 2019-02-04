package com.upgrad.learn.session2.module3.prep;

import java.util.Arrays;
import java.util.Scanner;

public class SubArrayGreaterthanPivot {

   public static int[] getSubarrayGreaterThan(int pivot, int[] arr) {
       if ((pivot >= arr.length) || (pivot < 0)) {
           return null;
       }
       int smallerIndex = -1, temp;
       temp = arr[arr.length - 1];
       arr[arr.length - 1] = arr[pivot];
       arr[pivot] = temp;
       pivot = arr.length - 1;
       for (int i = 0; i < (arr.length - 1); i++) {
           if (arr[i] < arr[pivot]) {
               smallerIndex++;
               temp = arr[i];
               arr[i] = arr[smallerIndex];
               arr[smallerIndex] = temp;
           }
       }
       temp = arr[arr.length - 1];
       arr[arr.length - 1] = arr[smallerIndex + 1];
       arr[smallerIndex + 1] = temp;
       return Arrays.copyOfRange(arr, smallerIndex + 1, arr.length);
   }

   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int length = sc.nextInt();
       int arr[] = new int[length];
       for (int i = 0; i < length; i++) {
           arr[i] = sc.nextInt();
       }
       int pivot = sc.nextInt();
       int newarr[] = getSubarrayGreaterThan(pivot, arr);
       if(newarr!=null) {
    	   for (int i : newarr) {
               System.out.println(i);
           } 
       }
   }
}