
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution {
	/**
	 * SWEA 1249 D4 보급로
	 * 풀이: 다익스트라
	 * 		
	 */
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int N;
	static int[][] arr;
	static int[][] distance;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int result;
	
	static class Node implements Comparable<Node>{
		int x,y,time;

		public Node(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			distance = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = tmp.charAt(j) - '0';
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			
			result = Integer.MAX_VALUE;
			BFS();
			
			sb.append("#").append(tc).append(" ").append(distance[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	
	}
	
	static void BFS() {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Node(0,0,0));
		distance[0][0] = 0;
		
		while(!priorityQueue.isEmpty()) {
			Node now = priorityQueue.poll();
			
			//이미 현재 시간이 넘은 경우
			if(now.time > distance[now.x][now.y]) continue;
			
			for (int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				
				
				//경계
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				
				//더 작은경우만
				int nextTime = now.time + arr[nextX][nextY];
				if(nextTime < distance[nextX][nextY]) {
					distance[nextX][nextY] = nextTime;
					priorityQueue.add(new Node(nextX, nextY, nextTime));
				}
				
			}
		}
		
	}
}
