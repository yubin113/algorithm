
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	/**
	 * SWEA 10966 물놀이를 가자
	 * 
	 * 초반 생각 -> L기준으로 생각했다가 시간초과
	 * 1. 인풋 받기
	 * 2. 배열 반복문 돌면서 L 발견하면 BFS 실행하고 최소거리값 더해주기
	 * 3. BFS - 4방 탐색하면서 경계를 벗어나지 않으면서 방문하지 않았고 W라면 즉시 count 리턴
	 * 
	 * 물기준으로 BFS
	 * 1. 인풋 받기
	 * 2. 배열 반복문 돌면서 W 발견하면 큐에 넣어주기
	 * 3. BFS
	 */
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int N,M;
	static char[][] arr;
	static boolean[][] check;
	static int[][] distance;
	static Queue<Node> queue;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Node{
		int x,y;
		int count;
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	public static void main(String[] args) throws IOException{
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken()); 
			
			arr = new char[N][M];
			
			
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < M; j++) {
					arr[i][j] = tmp.charAt(j);
				}
			}
			
			queue = new LinkedList<>();
			distance = new int[N][M];
			check = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j] == 'W') {
						queue.add(new Node(i,j,0));
						check[i][j] = true;
//						sb.append(i).append(" ").append(j).append(" sum : ").append(sum).append("\n");
					}
				}
			}
			
			BFS();
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sum += distance[i][j];
				}
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
		
	}
	
	
	static void BFS() {
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
				if(check[nextX][nextY]) continue;
				
				
				check[nextX][nextY] = true;
				distance[nextX][nextY] = now.count+1;
				queue.add(new Node(nextX, nextY, now.count+1));
			}
		}
	}
}
