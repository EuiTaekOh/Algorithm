package divideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class paperNumber1780 {
	public static int[] count = new int[3];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[n][n];

		for (int i = 0; i < n; i++) {
			int j = 0;
			String[] strings = br.readLine().split("\\s+");
			for (String str : strings) {
				paper[i][j] = Integer.parseInt(str);
				count[paper[i][j] + 1]++;
				j++;
			}
		}
		
		int edge = 3;
		while (edge < n) {
			for (int i = 0; i < n; i += edge)
				for (int j = 0; j < n; j += edge) {
					check(paper, i, j, edge);
				}
			edge *= 3;
		}
		check(paper, 0, 0, edge);
		for (int i = 0; i < 3; i++) {
			System.out.println(count[i]);
		}
	}

	public static void check(int[][] paper, int xStart, int yStart, int edge) {
		int first = paper[xStart][yStart];
		for (int i = 0; i < edge; i++) {
			for (int j = 0; j < edge; j++) {
				if (first != paper[xStart + i][yStart + j]) {
					return;
				}
			}
		}
		count[first + 1] -= 8;
	}
}
