import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static int start;
	public static StringBuilder sb;
	
	public static ArrayList<Integer>[] lists;
	
	public static boolean[] dfsvisited;
	public static boolean[] bfsvisited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		dfsvisited = new boolean[N+1];
		bfsvisited = new boolean[N+1];
		lists = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			lists[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			lists[node1].add(node2);
			lists[node2].add(node1);
		}
		
		for (ArrayList<Integer> nodes : lists) {
			Collections.sort(nodes);
		}
		
		sb = new StringBuilder();
		
		dfs(start);
		sb.append("\n");
		
		bfs(start);
		System.out.println(sb);
	}


	public static void dfs(int node) {
		if(dfsvisited[node]) {
			return;
		}
		
		dfsvisited[node] = true;
		sb.append(node).append(" ");
		for (Integer check : lists[node]) {
			if(!dfsvisited[check]) {
				dfs(check);
			}
		}
	}
	
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(!bfsvisited[now]) {
				sb.append(now).append(" ");
			}
			
			bfsvisited[now] = true;
			
			for (Integer num : lists[now]) {
				if(!bfsvisited[num]) {
					queue.offer(num);
				}
			}
		}
	}
}
