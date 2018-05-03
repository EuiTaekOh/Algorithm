package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class jump1890 {
	public static int n;
	public static int[][] map;
	public static long[][] caseMap;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		caseMap = new long[n][n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("\\s+");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		jump(0, 0);
		System.out.println(caseMap[0][0]);
	}

	public static void jump(int x, int y) {
		int number = map[x][y];
		if ((x == n - 1) && (y == n - 1)) { // 종료지점을 찾았다면(오른쪽 맨 아래) 종료
			caseMap[x][y]++;
			return;
		}
		if ((caseMap[x][y] != 0) || (number == 0)) { // 만약 숫자가 0이면 종료, 해당 지역의 경우의수가 이미 있다면 계산하지 않고 죵료
			return;
		}
		if (x + number < n) { // down
			if (caseMap[x + number][y] == 0) {
				jump(x + number, y);
				caseMap[x][y] += caseMap[x + number][y];
			} else {
				caseMap[x][y] += caseMap[x + number][y];
			}
		}
		if (y + number < n) { // right
			if (caseMap[x][y + number] == 0) {
				jump(x, y + number);
				caseMap[x][y] += caseMap[x][y + number];
			} else {
				caseMap[x][y] += caseMap[x][y + number];
			}
		}
		return;
	}
}
