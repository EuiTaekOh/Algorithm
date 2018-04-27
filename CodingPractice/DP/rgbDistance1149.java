package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class rgbDistance1149 {
	public static int[] minValue;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n==0){
			return;
		}
		int[][] house = new int[n][3];
		for (int i = 0; i < n; i++) {
			String[] strings = br.readLine().split("\\s+");
			house[i][0] = Integer.parseInt(strings[0]);
			house[i][1] = Integer.parseInt(strings[1]);
			house[i][2] = Integer.parseInt(strings[2]);
		}
		minValue = new int[3];
		minValue[0] = house[0][0];
		minValue[1] = house[0][1];
		minValue[2] = house[0][2];
		
		for(int i=1;i<n;i++){
			if(minValue[1]<minValue[2]){
				house[i][0] += minValue[1];
			}else{
				house[i][0] += minValue[2];
			}
			if(minValue[0]<minValue[2]){
				house[i][1] += minValue[0];
			}else{
				house[i][1] += minValue[2];
			}
			if(minValue[0]<minValue[1]){
				house[i][2] += minValue[0];
			}else{
				house[i][2] += minValue[1];
			}
			minValue[0] = house[i][0];
			minValue[1] = house[i][1];
			minValue[2] = house[i][2];
		}
		int totalMin = Integer.MAX_VALUE;
		for(int i=0;i<3;i++){
			if(totalMin>house[n-1][i])
				totalMin = house[n-1][i];
		}
		System.out.println(totalMin);
	}
}
