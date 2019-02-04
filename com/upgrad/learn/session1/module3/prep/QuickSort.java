package com.upgrad.learn.session1.module3.prep;

import java.util.Random;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {

   static Random random = new Random();
   public static int[] sort(int[] numbers) {
       quickSort(numbers, 0, numbers.length - 1);
       return numbers;
   }

   public static void quickSort(int[] numbers, int first, int last) {
       if (first < last) {
           // select a pivot point
           int pivotIndex = first + random.nextInt(last - first + 1);
           int pivot = numbers[pivotIndex];
           int k = partition(numbers, first, last, pivot);
           // recursively sort the elements to the left of the pivot
           quickSort(numbers, first, k);
           // recursively sort the elements to the right of the pivot
           quickSort(numbers, k + 1, last);
       }
   }

   public static int partition(int[] numbers, int first, int last, int pivot) {
       int l = first;
       int r = last;

       while (l <= r) {
           while (l <= r && numbers[l] >= pivot) {
               l++;
           }
           while (l <= r && numbers[r] < pivot) {
               r--;
           }
           if (l <= r) {
               exchangeNumbers(numbers, l, r);
               l++;
               r--;
           }
       }

       return l - 1;
   }

   public static void exchangeNumbers(int[] numbers, int i, int j) {
       int temp = numbers[i];
       numbers[i] = numbers[j];
       numbers[j] = temp;
   }

   public static void main(String args[]) {
       int[] randomNumbers = {2,4,6,8,10,12,14,16,18,20};
       int[] sortedNumbers;
       sortedNumbers = sort(randomNumbers); 
       System.out.println(Arrays.toString(sortedNumbers));
   }
}