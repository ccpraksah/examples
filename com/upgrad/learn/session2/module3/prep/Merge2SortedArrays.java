package com.upgrad.learn.session2.module3.prep;

import java.util.Scanner;

public class Merge2SortedArrays {
   public static void main(String ss[]) {
       Scanner scanner = new Scanner(System.in);
       int sizeArray1 = scanner.nextInt();
       int sizeArray2 = scanner.nextInt();
       int sortedArray1[] = getArrayInput(sizeArray1, scanner);
       int sortedArray2[] = getArrayInput(sizeArray2, scanner);
       int descendingMerge[] = mergeBothInDescendingOrder(sortedArray1, sortedArray2);
       for (int i = 0; i < descendingMerge.length; i++) {
           System.out.println(descendingMerge[i]);
       }
   }

   private static int[] mergeBothInDescendingOrder(int array1[], int array2[]) {
       int array3[] = new int[array1.length + array2.length];
       int pointer1 = array1.length - 1;
       int pointer2 = array2.length - 1;
       int k = 0;
       while (pointer1 >= 0 && pointer2 >= 0) {
           if (array1[pointer1] >= array2[pointer2]) {
               array3[k++] = array1[pointer1--];
           } else {
               array3[k++] = array2[pointer2--];
           }
       }
       while (pointer1 >= 0) {
           array3[k++] = array1[pointer1--];
       }
       while (pointer2 >= 0) {
           array3[k++] = array1[pointer2--];
       }
       return array3;
   }

   private static int[] getArrayInput(int size, Scanner scanner) {
       int array[] = new int[size];
       for (int i = 0; i < size; i++) {
           array[i] = scanner.nextInt();
       }
       return array;
   }
}