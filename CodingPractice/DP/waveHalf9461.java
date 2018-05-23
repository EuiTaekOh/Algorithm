package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class waveHalf9461 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] P = new long[101];
		for (int i = 1; i <= 3; i++) {
			P[i] = 1;
		}
		for (int i = 4; i <= 5; i++) {
			P[i] = 2;
		}
		int max = 0;
		int[] n = new int[101];
		for (int i = 0; i < T; i++) {
			n[i] = Integer.parseInt(br.readLine());
			if(n[i]>max) {
				max = n[i];
			}
		}
		
		if (max > 5) {
			for (int i = 6; i <= max; i++) {
				P[i] = P[i - 1] + P[i - 5];
			}
		}
		for (int i = 0; i < T; i++) {
			System.out.println(P[n[i]]);
		}

	}

}
