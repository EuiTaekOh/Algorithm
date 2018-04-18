package fibonacci;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class fibonacciFunction1003 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<String>();
		for(int i=0;i<t;i++){
			int n = Integer.parseInt(br.readLine());			
			if(n>2)
				list.add(fibonacci(n));
			else if(n==2)
				list.add(1+" "+1);
			else if(n==1)
				list.add(0+" "+1);
			else if(n==0)
				list.add(1+" "+0);
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	public static String fibonacci(int n){
		int first = 1;
		int second = 1;
		int third=0;
		for (int i=3;i<=n;++i){
			third = first + second;
			first = second;
			second = third;
		}
		return first+" "+third;
	}
	
}
