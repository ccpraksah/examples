package com.upgrad.learn.session2.module5.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SwitchCase {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            int c = Integer.parseInt(br.readLine());
            printDay(c);
        }
        br.close();
    }

    private static void printDay(int c) {
        switch (c) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
        }
    }
}