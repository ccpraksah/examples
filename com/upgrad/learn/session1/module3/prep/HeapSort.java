package com.upgrad.learn.session1.module3.prep;

import java.util.Arrays;
public class HeapSort {
       public static int[] sort ( int[] numbers){
           int n = numbers.length;
           for (int i = (n/2) - 1; i >= 0; i--)
               heapify(numbers, n, i);
           // One by one extract an element from heap
           for (int i=n-1; i>=0; i--)
           {
               // Move current root to end
        	   swap(0, i, numbers);  
               // call MAX-heapify on the reduced heap
               heapify(numbers, i, 0);
           }
           return numbers;
       }
       public static void swap(int i, int j, int[] array) {
           int temp = array[i];
           array[i] = array[j];
           array[j] = temp;
       }
       public static void heapify(int arr[], int size_of_heap, int root)//recursive
       {
           int largest = root;// Initialize largest as root
           int left = 2*root + 1;
           int right = 2*root + 2;
           // If left child is larger than root
           if (left < size_of_heap && arr[left] > arr[largest])
               largest = left;
           // If right child is larger than current largest
           if (right < size_of_heap && arr[right] > arr[largest])
               largest = right;
           // If largest is not root
           if (largest!= root)
           {
        	swap(largest, root, arr);
             heapify(arr, size_of_heap, largest);//Recursively heapify sub-tree
           }
       }

   public static void main(String args[]) {
       int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
       int[] sortedNumbers;
       sortedNumbers = sort(randomNumbers);
       System.out.println(Arrays.toString(sortedNumbers));
}
}