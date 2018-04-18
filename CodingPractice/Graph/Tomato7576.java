package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tomato7576 {
	static Queue<Integer> xPoint = new LinkedList<Integer>();
	static Queue<Integer> yPoint = new LinkedList<Integer>();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] xy = br.readLine().split("\\s+");
		int y = Integer.parseInt(xy[0]);
		int x = Integer.parseInt(xy[1]);
		int[][] box=  new int[x][y];
		
		for (int i=0;i<x;i++){
			int j=0;
			String[] strings = br.readLine().split("\\s+");
			for(String str:strings){
				box[i][j]=Integer.parseInt(str);
		        if(box[i][j]==1){
		        	xPoint.add(i);
		        	yPoint.add(j);
		        }
				j++;
		    }
		}
		boolean change = false;
		boolean finish = false;
		int day = 0;
		finish = finishTomato(box,x,y);
		if(finish)
			System.out.println("0");
		else{
			while(!finish){
				day++;
				change= dayForTomato(box,x,y);
				if(!change){
					finish=true;
					day=-1;
				}
				else{
					finish = finishTomato(box,x,y);
				}
			}
			System.out.println(day);
		}
	}
	
	public static boolean dayForTomato(int[][] box,int x,int y){
		boolean change=false;
		List<Integer> tempX = new ArrayList<Integer>();
		List<Integer> tempY = new ArrayList<Integer>();
		//상하좌우 탐색
		while(!xPoint.isEmpty()){
			int baseX=xPoint.poll();
			int baseY=yPoint.poll();
			if(baseX!=x-1){
				if(box[baseX+1][baseY]==0){
					box[baseX+1][baseY]=1;
					change=true;
					tempX.add(baseX+1);
					tempY.add(baseY);
				}
			}
			if(baseY!=y-1){
				if(box[baseX][baseY+1]==0){
					box[baseX][baseY+1]=1;
					change=true;
					tempX.add(baseX);
					tempY.add(baseY+1);
				}
			}
			if(baseX!=0){
				if(box[baseX-1][baseY]==0){
				    box[baseX-1][baseY]=1;
					change=true;
					tempX.add(baseX-1);
					tempY.add(baseY);
				}
			}
			if(baseY!=0){
				if(box[baseX][baseY-1]==0){
					box[baseX][baseY-1]=1;
					change=true;
					tempX.add(baseX);
					tempY.add(baseY-1);
				}
			}
		}
		//추가된 위치를 큐에 넣는다.
		while(!tempX.isEmpty()){
			xPoint.add(tempX.get(0));
			yPoint.add(tempY.get(0));
			tempX.remove(0);
			tempY.remove(0);
		}
		return change;
	}
	
	//토마토가 모두 찼는지 체크
	public static boolean finishTomato(int[][] box,int x,int y){
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(box[i][j]==0)
					return false;				
			}
		}
		return true;
	}
}
