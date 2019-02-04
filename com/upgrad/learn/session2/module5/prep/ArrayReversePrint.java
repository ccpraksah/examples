package com.upgrad.learn.session2.module5.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ArrayReversePrint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());

        int[] inputLength = new int[numberOfTestCases];

        for (int i = 0; i < numberOfTestCases; i++) {
            String input = br.readLine();
            inputLength[i] = input.split(" ").length;
        }

        for (int i = inputLength.length - 1; i >= 0; i--) {
            System.out.println(inputLength[i]);
        }

        br.close();
    }
}