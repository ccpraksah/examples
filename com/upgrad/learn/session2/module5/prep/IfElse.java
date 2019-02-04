package com.upgrad.learn.session2.module5.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfElse {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            int c = Integer.parseInt(br.readLine());
            printMonth(c);
        }
        br.close();
    }

    private static void printMonth(int c) {
        if (c == 1) {
            System.out.println("January");
        } else if (c == 2) {
            System.out.println("February");
        } else if (c == 3) {
            System.out.println("March");
        } else if (c == 4) {
            System.out.println("April");
        } else if (c == 5) {
            System.out.println("May");
        } else if (c == 6) {
            System.out.println("June");
        } else if (c == 7) {
            System.out.println("July");
        } else if (c == 8) {
            System.out.println("August");
        } else if (c == 9) {
            System.out.println("September");
        } else if (c == 10) {
            System.out.println("October");
        } else if (c == 11) {
            System.out.println("November");
        } else if (c == 12) {
            System.out.println("December");
        }

    }
}