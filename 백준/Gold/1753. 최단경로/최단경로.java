import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuffer sb;
	
	static int V,E,K;
	
	static class Node{
		int vertex;  // 도착 정점
		int weight;  //가중치
		Node nextNode;
		
		Node(int vertex, int weight, Node nextNode){
			this.vertex = vertex;
			this.weight = weight;
			this.nextNode = nextNode;
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuffer();
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());  //정점개수
		E = Integer.parseInt(st.nextToken());  //간선 개수
		K = Integer.parseInt(br.readLine());   //시작 정점 번호
		
		Node[] adjList = new Node[V+1];  //정점 갯수 만큼
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, cost, adjList[from]);
		}
		
		int[] minDistance = getMinDistance(adjList, K);
		
		
		for (int i = 1; i < minDistance.length; i++) {
			if(minDistance[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			}else {
				sb.append(minDistance[i]).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
	static int[] getMinDistance(Node[] adjList, int start) {
		final int V = adjList.length;  //정점 개수
		
		int[] minDistance = new int[V];  //시작 정점에서 자신으로의 최소 거리
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(minDistance, INF);
		minDistance[start] = 0;
		
		boolean[] visited = new boolean[V];  //방문한 정점 관리
		
		for (int i = 1; i < V; i++) {  //출발점에서 도착지까지 
			//미방문 정점중 시작 정점에서 가장 가까운 정점 선택, 경유지 정점을 찾아낸다.
			int min = INF;
			int stopOver = -1;
			for (int j = 1; j < V; j++) {
				//인접 정점이 아직 방문되지 않았고, 기존 거리보다 더 작은 경로가 발견되면 
				if(!visited[j] && min > minDistance[j]) {  
					min = minDistance[j];
					stopOver = j;
				}
			}
			
			//출발지에서 도착지로 못 가는 경우
			if(stopOver == -1) break;
			
			visited[stopOver] = true;
			
			//인접한 애들 비용 계산, 선택된 정점을 경유해서 미방문 인접한 정점으로의 최소 비용을 갱신할 수 있는지 체크
			for (Node node = adjList[stopOver]; node != null ; node = node.nextNode) {
				if(!visited[node.vertex] && minDistance[node.vertex] > min + node.weight) {
					minDistance[node.vertex] = min + node.weight;
				}
			}
		}
		
		return minDistance;
	}
}