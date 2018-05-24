package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class continuousSum1912 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strings = br.readLine().split("\\s+");
		int[] number = new int[n];
		int i = 0;
		for (String str : strings) {
			number[i] = Integer.parseInt(str);
			i++;
		}
		int max = number[0];
		for (i = 1; i < n; i++) {
			// 이전합이 음수라면 선택할 필요 없이 다시 선택
			// 이전합과 현재 값은 더한것이 음수라면 선택할 필요가 없다.
			if ((number[i - 1] >= 0) && (number[i] + number[i - 1] > 0)) {
				number[i] += number[i - 1];
			}
			// 최댓값을 계속 업데이트
			if (number[i] > max) {
				max = number[i];
			}
		}
		System.out.println(max);
	}
}
