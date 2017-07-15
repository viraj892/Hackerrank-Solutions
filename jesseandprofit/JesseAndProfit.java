package jesseandprofit;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JesseAndProfit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line1 = sc.nextLine().split(" ");
		int n = Integer.parseInt(line1[0]);
		int d = Integer.parseInt(line1[1]);
		int price[] = new int[n];
		String price_line = sc.nextLine();
		price = Arrays.stream(price_line.split("\\s+")).mapToInt(Integer::parseInt).toArray();

		int profit[] = new int[d];
		for (int i = 0; i < d; i++)
			profit[i] = sc.nextInt();

		for (int i = 0; i < d; i++) {
			int min_days = Integer.MAX_VALUE;
			int buy_pos = 0;
			int sell_pos = 0;
			boolean profit_achievable = false;
			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if ((price[k] - price[j]) == profit[i]) {
						if (k - j < min_days) {
							min_days = k - j;
							buy_pos = j;
							sell_pos = k;
							profit_achievable = true;
						}
					}
				}
			}
			if(profit_achievable){
				System.out.print(buy_pos+1+" ");
				System.out.println(sell_pos+1);
			}
			else
				System.out.println("-1");
		}
	}
}