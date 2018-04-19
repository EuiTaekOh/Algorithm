package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class triangle1932 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] triangleMatrix = new int[n][n];
		for (int i=0;i<n;i++){
			String[] string = br.readLine().split("\\s+");
			for(int j=0;j<string.length;j++){
				triangleMatrix[i][j]=Integer.parseInt(string[j]);
		    }
			for(int j=string.length;j<n;j++){
				triangleMatrix[i][j]=0;
			}
		}
		int[][] sumMatrix = new int[n][n];		//For saving the all sum value.
		sumMatrix[0][0] = triangleMatrix[0][0];	 	
		for(int i=1;i<n;i++){
			sumMatrix[i][0]=sumMatrix[i-1][0]+triangleMatrix[i][0];
			for(int j=1;j<n;j++){
				if(sumMatrix[i-1][j-1]<sumMatrix[i-1][j])	//Choose the maximum value.
					sumMatrix[i][j] = triangleMatrix[i][j]+sumMatrix[i-1][j];
				else{
					sumMatrix[i][j] = triangleMatrix[i][j]+sumMatrix[i-1][j-1];	
				}
			}
		}
		
		int max=0;	//Search the max in last array
		for(int j=0;j<n;j++){
			if(sumMatrix[n-1][j]>max){
				max = sumMatrix[n-1][j];
			}
		}
		System.out.println(max);
	}
}
