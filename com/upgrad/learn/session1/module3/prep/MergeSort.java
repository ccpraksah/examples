package com.upgrad.learn.session1.module3.prep;

import java.util.Arrays;

public class MergeSort {
   public static int[] sort(int[] numbers) {
       int length = numbers.length;
       if (length <= 1)
           return numbers;
       // dividing the numbers array into its left sub-array
       int[] left = new int[length/2];
       for (int i = 0; i < left.length; i++)
           left[i] = numbers[i];
       int[] right = new int[length - length/2];
       for (int i = 0; i < right.length; i++)
           right[i] = numbers[i + length/2];
       return merge(sort(left), sort(right));
   }

   private static int[] merge(int[] left, int[] right) {
       int[] merged = new int[left.length + right.length];
       int i = 0, j = 0;
       // sorting and merging the the elements in the left
       // and the right arrays into the merged array
       for (int k = 0; k < merged.length; k++) {
           if (i >= left.length)
               merged[k] = right[j++];
           else if (j >= right.length)
               merged[k] = left[i++];
           else if (left[i] <= right[j])
               merged[k] = left[i++];
           else
               merged[k] = right[j++];
       }
       return merged;
   }
public static void main(String args[]) {
       int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
       int[] sortedNumbers;
       sortedNumbers = sort(randomNumbers); 
       System.out.println(Arrays.toString(sortedNumbers));
       }
  }