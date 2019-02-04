package com.upgrad.learn.session2.module5.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SequenceJumper {

    public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            String rangeLine = br.readLine();
            String[] split = rangeLine.split(" ");
            int r1 = Integer.parseInt(split[0]);
            int r2 = Integer.parseInt(split[1]);

            String jumpAndNumberLine = br.readLine();
            String[] split1 = jumpAndNumberLine.split(" ");
            int k = Integer.parseInt(split1[0]);
            int n = Integer.parseInt(split1[1]);
            int sum = getSum(r1, r2, k, n);
            System.out.println(sum);
        }

        br.close();
    }

    private static int getSum(int r1, int r2, int k, int n) {
        int sum = 0;
        for (int i = r1, jumpCounter = 0; i <= r2 && jumpCounter <= n; i = i + k, jumpCounter++) {
            sum = sum + i;
        }
        return sum;  
    }
}