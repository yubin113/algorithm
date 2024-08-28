import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[] visited;
	public static ArrayList<Integer>[] lists;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int computers = Integer.parseInt(br.readLine());
		int linesNum = Integer.parseInt(br.readLine());
		
		visited = new boolean[computers+1];
		lists = new ArrayList[computers+1];
		
		for (int i = 0; i <= computers; i++) {
			lists[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < linesNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			lists[node1].add(node2);
			lists[node2].add(node1);
		}
		bfs(1);
		
		int result = 0;
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]) result++;
		}
		System.out.println(result-1);
	}
    
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		 
		while(!queue.isEmpty()) {
			int v = queue.poll();
			visited[v] = true;
			for (Integer num : lists[v]) {
				if(!visited[num]) {
					queue.offer(num);
				}
			}
		}
	}
}
