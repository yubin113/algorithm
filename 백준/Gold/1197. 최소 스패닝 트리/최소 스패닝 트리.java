import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	static int V, E;
	
	static void make() {
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
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
		
	}
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken())
					, Integer.parseInt(st.nextToken())
					, Integer.parseInt(st.nextToken()));

		}
		
		make();
		
		Arrays.sort(edges);
		
		int cnt = 0;
		long cost = 0;
		
		for (Edge edge : edges) {
			if(union(edge.start, edge.end)) {
				cost += edge.weight;
				if(++cnt == V - 1) {
					sb.append(cost);
				}
			}
		}
		
		System.out.println(sb);
	}
}
