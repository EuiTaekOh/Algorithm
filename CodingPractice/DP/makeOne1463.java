package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class makeOne1463 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] memo = new int[n + 1];
		memo[1] = 0;
		for (int i = 2; i < n + 1; i++) {
			calc(memo, i);
		}
		System.out.println(memo[n]);
	}

	public static void calc(int[] memo, int x) {
		int min = Integer.MAX_VALUE;
		if (x % 3 == 0) {
			if (min > memo[x / 3]) {
				min = memo[x / 3];
			}
		}
		if (x % 2 == 0) {
			if (min > memo[x / 2]) {
				min = memo[x / 2];
			}
		}
		if (min > memo[x - 1])
			min = memo[x - 1];
		memo[x] = min + 1;
	}
}
