package com.upgrad.learn.session1.module3.prep;

import java.util.Arrays;
public class InsertionSort {
   public static int[] sort(int[] numbers) {
       for (int i = 1; i < numbers.length; i++) {
           for (int j = i; j > 0; j--) {
               if (numbers[j] < numbers[j - 1]) {
                   // if number at jth position is smaller
                   // than the number at jth - 1 position
                   // swap the numbers
                   swap(j, j - 1, numbers);
               }
           }
       }
       return numbers; // returning the final sorted array
   }

   public static void swap(int i, int j, int[] array) {
       int temp = array[i];
       array[i] = array[j];
       array[j] = temp;
   }

   public static void main(String args[]) {
       int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
       int[] sortedNumbers;
       sortedNumbers = sort(randomNumbers); // insertion sort
       System.out.println(Arrays.toString(sortedNumbers));
   }
}