package com.upgrad.learn.project1.session2;


import java.util.*;

public class CarFilter {
	static class ADT {
		int a, b;

		ADT(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ADT[] arr = new ADT[n];
		for (int i = 0; i < n; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			arr[i] = new ADT(a, b);
		}
		Arrays.sort(arr, new Comparator<ADT>() {
			public int compare(ADT first, ADT second) {
				if (first.a > second.a)
					return 1;
				else if (first.a < second.a)
					return -1;
				else {
					if (first.b > second.b)
						return 1;
					else
						return -1;
				}
			}
		});
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i].a + " " + arr[i].b);
		}
	}
}