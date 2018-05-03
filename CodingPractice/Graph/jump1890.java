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
		if ((x == n - 1) && (y == n - 1)) { // ���������� ã�Ҵٸ�(������ �� �Ʒ�) ����
			caseMap[x][y]++;
			return;
		}
		if ((caseMap[x][y] != 0) || (number == 0)) { // ���� ���ڰ� 0�̸� ����, �ش� ������ ����Ǽ��� �̹� �ִٸ� ������� �ʰ� �շ�
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
