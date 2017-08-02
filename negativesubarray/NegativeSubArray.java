package negativesubarray;

import java.util.Scanner;

public class NegativeSubArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String s = sc.nextLine();
		String str[] = s.split(" ");

		int[] values = new int[n];
		for (int i = 0; i < str.length; i++) {
			values[i] = Integer.parseInt(str[i]);
		}

		int count = 0;
		for (int k = 0; k < str.length; k++) {
			for (int i = k; i < str.length; i++) {
				int sum = 0;
				for (int j = i; j < str.length; j++) {
//					System.out.print(values[j] + " ");
					sum += values[j];
				}
//				System.out.println();
				if (sum < 0)
					count++;
			}
		}

		 System.out.println(count);
	}
}