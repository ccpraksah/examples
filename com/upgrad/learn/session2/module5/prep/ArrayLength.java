package com.upgrad.learn.session2.module5.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayLength {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            String input = br.readLine();
            System.out.println(input.split(" ").length);
        }

        br.close();
    }
}