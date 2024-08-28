
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
/*
 * 인접행렬 사용
 * 
 */
	
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int N;
	static int start;
	static int[][] graph;
	
	static int answer;
	static boolean[] visited;
	static int[] distance;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			graph = new int[101][101];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a][b] = 1;
			}
			visited = new boolean[101];
			distance = new int[101];
			
			BFS(start);
			
			int maxDistance = 0;
			for (int i = 1; i <= 100; i++) {
				if(distance[i] > maxDistance) {
					maxDistance = distance[i];
				}
			}
			
			int maxNum = 0;
			answer = Integer.MIN_VALUE;
			for (int i = 1; i <= 100; i++) {
				if(distance[i] == maxDistance && maxNum < distance[i]) {
					answer = i;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	
	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i = 1; i <= graph.length - 1; i++) {
				if(graph[now][i] == 1 && !visited[i]) {
					visited[i] = true;
					distance[i] = distance[now] + 1;
					queue.add(i);
				}
			}
		}
	}
}
