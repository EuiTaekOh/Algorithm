package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class maze2178 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] xy = br.readLine().split("\\s+");
		int xMax = Integer.parseInt(xy[0]);
		int yMax = Integer.parseInt(xy[1]);
		int[][] map = new int[xMax][yMax];
		int[][] distanceMap = new int[xMax][yMax];
		for (int i = 0; i < xMax; i++) {			//Initialize
			String string = br.readLine();
			for (int j = 0; j < string.length(); j++) {
				map[i][j] = string.charAt(j) - '0';
				distanceMap[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<ArrayList<Integer>> queue = new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer> point = new ArrayList<Integer>();
		point.add(0);			//시작점
		point.add(0);
		distanceMap[0][0] = 1;	
		queue.add(point);
		while (!queue.isEmpty()) {
			point = queue.poll();
			int x = point.get(0);
			int y = point.get(1);
			//Down
			if ((x < xMax - 1) && map[x + 1][y] == 1) {
				if (distanceMap[x + 1][y] > distanceMap[x][y] + 1) { //기존에 저장된 거리보다 더 작을경우 저장
					distanceMap[x + 1][y] = distanceMap[x][y] + 1;
					ArrayList<Integer> newPoint = new ArrayList<Integer>();
					newPoint.add(x + 1);
					newPoint.add(y);
					queue.add(newPoint);
				}
			}
			//Right
			if ((y < yMax - 1) && map[x][y + 1] == 1) {			//인덱스가 벽을 넘지 않도록 && 방문 할 수 있는곳인지 탐색
				if (distanceMap[x][y + 1] > distanceMap[x][y] + 1) {
					distanceMap[x][y + 1] = distanceMap[x][y] + 1;
					ArrayList<Integer> newPoint = new ArrayList<Integer>();
					newPoint.add(x);
					newPoint.add(y + 1);
					queue.add(newPoint);
				}
			}
			//Up
			if ((x > 0 && map[x - 1][y] == 1)) {
				if (distanceMap[x - 1][y] > distanceMap[x][y] + 1) {
					distanceMap[x - 1][y] = distanceMap[x][y] + 1;
					ArrayList<Integer> newPoint = new ArrayList<Integer>();
					newPoint.add(x - 1);
					newPoint.add(y);
					queue.add(newPoint);
				}
			}
			//Left
			if (y > 0 && map[x][y - 1] == 1) {
				if (distanceMap[x][y - 1] > distanceMap[x][y] + 1) {
					distanceMap[x][y - 1] = distanceMap[x][y] + 1;
					ArrayList<Integer> newPoint = new ArrayList<Integer>();
					newPoint.add(x);
					newPoint.add(y - 1);
					queue.add(newPoint);
				}
			}
		}
		
		System.out.println(distanceMap[xMax - 1][yMax - 1]);
	}
}
