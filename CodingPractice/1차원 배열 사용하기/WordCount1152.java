package CodingPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WordCount1152 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine().trim();
		String[] arStr = word.split("\\s+");
		if (word.isEmpty()){
			System.out.println(0);
		}else{
			System.out.println(arStr.length);
		}
	}
}
