package CodingPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Scale2920 {
	public static void main(String arge[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String scale = br.readLine();
		boolean check = true;
		if(scale.charAt(0) == '1'){
			for(int i=0;i<scale.length()-2;i+=2){
				if (Character.getNumericValue(scale.charAt(i+2))-
						Character.getNumericValue(scale.charAt(i))==1){
				}else{
					check = false;
				}
			}
			if(check){
				System.out.println("ascending");
			}
		}else if(scale.charAt(0)=='8'){
			for(int i=0;i<scale.length()-2;i+=2){
				if (Character.getNumericValue(scale.charAt(i))-
						Character.getNumericValue(scale.charAt(i+2))==1){
				}else{
					check = false;
				}
			}
			if(check){
				System.out.println("descending");
			}
		}
		if(!check){
			System.out.println("mixed");
		}
	}
}
