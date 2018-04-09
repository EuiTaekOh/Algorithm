package CodingPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OXquiz8958 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList();
		for(int i=0;i<number;i++){
			String s = br.readLine();
			int prevScore = 1;
			int totalScore = 0;
			for(int j=0;j<s.length();j++){
				if (s.charAt(j)=='O'){
					totalScore = prevScore + totalScore;
					prevScore += 1;
				}
				else{
					prevScore = 1;
				}
			}
			list.add(totalScore);
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
