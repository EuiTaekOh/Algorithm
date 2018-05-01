package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class coin11047 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("\\s+");
		int n = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int[] value = new int[n];
		for (int i = 0; i < n; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		int count = 0;
		for (int i = n - 1; i > -1; i--) {
			if (K / value[i] >= 1) {
				while (K >= value[i]) {
					count += K / value[i];
					K %= value[i];
				}
			}
		}
		System.out.println(count);
	}
}
