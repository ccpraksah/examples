package com.upgrad.learn.session1.module3.prep;

import java.util.Arrays;
public class SelectionSort {
   public static int[] sort(int[] numbers) {
       for (int i = 0; i < numbers.length - 1; i++) {
           // assume the ith element is the smallest element
           int minimumElement = i;

           // looping through the rest of the array to find a smaller element
           for (int j = i + 1; j < numbers.length; j++) {
               if (numbers[j] < numbers[minimumElement]) {
                   minimumElement = j; // smaller element found
               }
           }
           // swap the smallest element found with the ith element
           swap(minimumElement, i, numbers);
       }
       return numbers;
   }

   public static void swap(int i, int j, int[] array) {
       int temp = array[i];
       array[i] = array[j];
       array[j] = temp;
   }

   public static void main(String args[]) {
       int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
       int[] sortedNumbers;
       sortedNumbers = sort(randomNumbers); // selection sort
       System.out.println(Arrays.toString(sortedNumbers));
   }
}