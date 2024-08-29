
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] parents;
	static int V;  //정점의 개수
	
	static void make() {  //트리 초기화
		parents = new int[V + 1];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = -1;
		}
	}
	
	static int find(int a) {
		if(parents[a] < 0) return a;
		return parents[a] = find(parents[a]);
		
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[aRoot] += parents[bRoot];
		parents[bRoot] = aRoot;
		return true;
		
	}
	static int TC;
	static int E;   //간선 수
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static Edge[] edges;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edges = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edges[i] = new Edge(Integer.parseInt(st.nextToken())
						, Integer.parseInt(st.nextToken())
						, Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(edges);
			
			make();
			
			int cnt = 0;
			long cost = 0;
			for (Edge edge : edges) {
				if(union(edge.start, edge.end)) {
					cost += edge.weight;
					if(++cnt == V - 1) {
						break;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cost).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
}
