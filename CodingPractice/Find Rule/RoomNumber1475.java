package FindRule;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RoomNumber1475 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[10];
		int roomNumber = Integer.parseInt(br.readLine());
		int max = -1;
		if (roomNumber==0){
			max=1;
		}
		for (int i = 0;roomNumber>0;i++){
			count[roomNumber%10]++;
			roomNumber/=10;
		}
		count[6] = (int) Math.ceil((count[6]+count[9])/2.0);
		count[9] = 0;
		for(int i=0;i<count.length;i++){
			if(count[i]>max){
				max = count[i];
			}
		}
		System.out.println(max);
	}
}
