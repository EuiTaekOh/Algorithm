package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class apartNumber2667 {
	public static int[][] map;
	public static int[] houseCount;
	public static int complex;
	public static int n;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		houseCount = new int[n * n];
		complex = 0;
		for (int i = 0; i < n; i++) { // Initialize
			String string = br.readLine();
			for (int j = 0; j < string.length(); j++) {
				map[i][j] = string.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					findComplex(i, j);		//단지를 찾는 함수
					complex++;
				}
			}
		}
		System.out.println(complex);
		//선택정렬을 이용해 정렬
		for (int i = 0; i < complex - 1; i++) {
			int min = i;
			for (int j = i + 1; j < complex; j++) {
				if (houseCount[j] < houseCount[min]) {
					min = j;
				}
			}
			int temp = houseCount[min];
			houseCount[min] = houseCount[i];
			houseCount[i] = temp;
		}
		for (int i = 0; i < complex; i++) {
			System.out.println(houseCount[i]);
		}
	}

	public static void findComplex(int xStart, int yStart) {
		Queue<ArrayList<Integer>> queue = new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer> point = new ArrayList<Integer>();
		point.add(xStart);		//시작점
		point.add(yStart);
		queue.add(point);
		while (!queue.isEmpty()) {		//큐를 이용해 BFS 구현
			ArrayList<Integer> checkPoint = queue.poll();
			int x = checkPoint.get(0);
			int y = checkPoint.get(1);
			if ((x < n - 1) && map[x + 1][y] == 1) {
				ArrayList<Integer> newPoint = new ArrayList<Integer>();
				newPoint.add(x + 1);
				newPoint.add(y);
				queue.add(newPoint);
				map[x + 1][y] = 0;
				houseCount[complex]++;
			}
			if ((y < n - 1) && map[x][y + 1] == 1) {
				ArrayList<Integer> newPoint = new ArrayList<Integer>();
				newPoint.add(x);
				newPoint.add(y + 1);
				queue.add(newPoint);
				map[x][y + 1] = 0;
				houseCount[complex]++;
			}
			if ((x > 0) && map[x - 1][y] == 1) {
				ArrayList<Integer> newPoint = new ArrayList<Integer>();
				newPoint.add(x - 1);
				newPoint.add(y);
				queue.add(newPoint);
				map[x - 1][y] = 0;
				houseCount[complex]++;
			}
			if ((y > 0) && map[x][y - 1] == 1) {
				ArrayList<Integer> newPoint = new ArrayList<Integer>();
				newPoint.add(x);
				newPoint.add(y - 1);
				queue.add(newPoint);
				map[x][y - 1] = 0;
				houseCount[complex]++;
			}
		}
		if(map[xStart][yStart]==1){
			map[xStart][yStart] = 0;
			houseCount[complex]++;
		}
	}
}
