package divideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class z1074 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("\\s+");
		int n = Integer.parseInt(str[0]);
		int r = Integer.parseInt(str[1]);
		int c = Integer.parseInt(str[2]);
		if (r<Math.pow(2, n)&&(c<Math.pow(2, n)))
			System.out.println(divide((int) Math.pow(2,n),r,c,0));
	}
	
	public static int divide(int n,int x, int y,int minimum){
		if (n==2){					//Base
			return 2*x+y + minimum; 
		}
		n=n/2;
		if(x>=n&&y>=n){
			return divide(n,x-n,y-n,n*n*3+minimum);
		}else if(x>=n&&y<=n){
			return divide(n,x-n,y,n*n*2+minimum);
		}else if(x<=n&&y>=n){
			return divide(n,x,y-n,n*n*1+minimum);
		}else{
			return divide(n,x,y,n*n*0+minimum);
		}
	}
	
}
