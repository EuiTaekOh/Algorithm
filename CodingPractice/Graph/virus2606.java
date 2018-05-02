package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class virus2606 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computer = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		ArrayList<ArrayList<Integer>> map = new <ArrayList<Integer>>ArrayList();
		for(int i=0;i<computer+1;i++){
			map.add(new ArrayList<Integer>());
		}
		//Using Adjacency List
		for(int i=0;i<T;i++){
			String[] str = br.readLine().split("\\s+");
			map.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
			map.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
		}
		boolean x[] = new boolean[computer+1];
		while(!queue.isEmpty()){
			int vertex = queue.poll(); 	//Search the queue using BFS
			x[vertex] = true;
			for(int i=0;i<map.get(vertex).size();i++){
				int newbie = map.get(vertex).get(i);
				if(x[newbie]==false){
					queue.add(newbie);
				}
			}
		}
		int count=-1;
		for(int i=0;i<computer+1;i++){
			if(true==x[i]){
				count++;
			}
		}
		System.out.println(count);
	}
}
