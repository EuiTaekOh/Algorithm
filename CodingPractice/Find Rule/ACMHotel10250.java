package FindRule;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ACMHotel10250 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testDataCount = Integer.parseInt(br.readLine());
		int maxHeight = 0;
		int customer = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<testDataCount;i++){
			String[] arStr = br.readLine().split("\\s+");
			maxHeight= Integer.parseInt(arStr[0]);
			customer= Integer.parseInt(arStr[2]);
			int width,height;
			if (customer%maxHeight==0){		//Case of top floor
				width=customer/maxHeight;
				height=maxHeight;
			}else{	
				width=customer/maxHeight+1;
				height=customer%maxHeight;
			}
			list.add(height*100+width);
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
