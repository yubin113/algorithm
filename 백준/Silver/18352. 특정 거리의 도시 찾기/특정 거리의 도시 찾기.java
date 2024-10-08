import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuffer sb;
	
	static int[] dist;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int N,M,K,X;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuffer();
		
		boolean result = false;  //??
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  //도시의 개수
		M = Integer.parseInt(st.nextToken());  //도로의 개수
		K = Integer.parseInt(st.nextToken());  //거리 정보
		X = Integer.parseInt(st.nextToken());  //시작 노드

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new Node(end,1));  //단방향 도로
		}
		
		dist = new int[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		solution(X);
		
		for (int i = 1; i <= N; i++) {
			if(dist[i] != Integer.MAX_VALUE && dist[i] == K) {
				sb.append(i).append("\n");
				result = true;
			}
		}
		
		if(result) {
			System.out.println(sb);
		}else {
			System.out.println("-1");
		}
	}

	static class Node implements Comparable<Node>{
		int v;  //목적지
		int cost;  //비용
		
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static void solution(int k) {
		PriorityQueue<Node> queue = new PriorityQueue<>();  //오름차순
		queue.add(new Node(k, 0));
		dist[k] = 0;
		
		while(!queue.isEmpty()){
			Node now = queue.poll();
			
			for (Node next : graph.get(now.v)) {
				if(dist[next.v] > dist[now.v] + next.cost) {
					dist[next.v] = dist[now.v] + next.cost;
					queue.add(new Node(next.v, dist[next.v]));
				}
			}
		}
		
				
	}
}