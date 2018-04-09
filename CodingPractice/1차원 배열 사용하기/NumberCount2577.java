package CodingPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumberCount2577 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		int num3 = Integer.parseInt(br.readLine());
		int total = num1*num2*num3;
		int[] count = new int[10];
		
		while(total!=0){
			count[total%10]++;
			total = total/10;
		}
		for(int i=0;i<10;i++){
			System.out.println(count[i]);
		}
		br.close();
	}
}
