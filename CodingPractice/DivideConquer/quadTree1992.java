package divideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class quadTree1992 {
	public static int[] count = new int[3];
	public static String code = "(";

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];

		for (int i = 0; i < n; i++) {
			String strings = br.readLine();
			for (int j = 0; j < strings.length(); j++) {
				if (Integer.parseInt("" + strings.charAt(j)) > 1) {
					return;
				}
				board[i][j] = Integer.parseInt("" + strings.charAt(j));
			}
		}
		if (n == 0)
			return;
		if (n == 1) {
			System.out.println(board[0][0]);
			return;
		}
		divide(board, n, 0, 0);
		code += ")";
		for (int i = 0; i < n / 2; i++) {
			code = code.replaceAll("\\(0{4}\\)", "0");
			code = code.replaceAll("\\(1{4}\\)", "1");
		}
		System.out.println(code);
	}

	public static void divide(int[][] board, int n, int x, int y) {
		if (n == 2) { // Base
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					code += board[i + x][j + y];
				}
			}
		} else {
			n = n / 2;
			code += "(";
			divide(board, n, x, y);
			code += ")(";
			divide(board, n, x, y + n);
			code += ")(";
			divide(board, n, x + n, y);
			code += ")(";
			divide(board, n, x + n, y + n);
			code += ")";
		}
	}
}
