package FindRule;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BeeHouse2292 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputNumber = Integer.parseInt(br.readLine());
		int sum=1;
		boolean check = false;
		int i=0;
		if(inputNumber==1){
			check=true;
			System.out.println(1);
		}
		while(!check){
			i++;
			sum+=6*i;
			if(sum>=inputNumber){
				check = true;
				System.out.println(i+1);
			}
		}
	}
}
