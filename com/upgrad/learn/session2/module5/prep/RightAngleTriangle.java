package com.upgrad.learn.session2.module5.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class RightAngleTriangle {

    public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            int c = Integer.parseInt(br.readLine());
            printRightAngleTriangle(c);
        }
        br.close();
    }

    private static void printRightAngleTriangle(int c) {
        for (int i = 1; i <= c; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}