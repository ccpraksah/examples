package com.upgrad.learn.session2.module3.prep;

import java.util.Scanner;

public class BubbleSortVariation {
  static int totalBubbleSortSwaps(int[] array, int M) {
      int size = array.length;
      int var = 0;
      int totalSwaps = 0;
      for (int i = 0; i < M; i++) {
          for (int j = 1; j < (size - i); j++) {
              if (array[j - 1] < array[j]) {
                  // swap elements
                  var = array[j - 1];
                  array[j - 1] = array[j];
                  array[j] = var;
                  totalSwaps++;
              }
          }
     }
      return totalSwaps;
  }

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int M = scanner.nextInt();
      int size = scanner.nextInt();
      int array[] = new int[size];
      for (int i = 0; i < size; i++) {
          array[i] = scanner.nextInt();
      }
      System.out.println(totalBubbleSortSwaps(array, M));
  }
}