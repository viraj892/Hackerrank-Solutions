package blackrock.problem2;

public class Solution {
	static int[] arbitrage(String[] quotes) {
		int[] arb = new int[quotes.length];
		for (int i = 0; i < quotes.length; i++) {
			int arbitrage = getArbitrage(quotes[i]);
			if(arbitrage>0)
				arb[i]=arbitrage;
			else
				arb[i]=0;
				
		}
		return arb;
	}

	static int getArbitrage(String q) {
		String[] values = q.split(" ");
		int investment = 100000;
		double usd_eur = investment / Double.parseDouble(values[0]);
		double eur_gbp = usd_eur / Double.parseDouble(values[1]);
		double gbp_usd = eur_gbp / Double.parseDouble(values[2]);
		return (int)gbp_usd - investment;
	}
}
