import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int M;
	static int N;
	static int K;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int count;
	static ArrayList<Integer> answer;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int firstY = Integer.parseInt(st.nextToken());
			int firstX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			for (int j = firstX; j < endX; j++) {
				for (int j2 = firstY; j2 < endY; j2++) {
					arr[j][j2] = 1;
					visited[j][j2] = true;
				}
			}
		}
		
		answer = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] != 1 && !visited[i][j]) {
					count = 0;
					BFS(i, j);
					answer.add(count);
				}
			}
		}
		
		Collections.sort(answer);
		
		sb.append(answer.size()).append("\n");
		for (int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i)).append(" ");
		}
		sb.append("\n");
		System.out.println(sb);
	}
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x,y));
		visited[x][y] = true;
		count++;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if(visited[nx][ny]) continue;
				if(arr[nx][ny] == 1) continue;
				
				queue.add(new Node(nx, ny));
				count++;
				visited[nx][ny] = true;
			}
		}
	}
}
