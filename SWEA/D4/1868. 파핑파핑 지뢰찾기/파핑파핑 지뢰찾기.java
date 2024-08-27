
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int N;
	static char[][] arr;
	static int answer;
	
	static int[] dx = {0,0,1,-1,-1,1,-1,1};
	static int[] dy = {1,-1,0,0,-1,1,1,-1};
	
	static boolean[][] visited;
 	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			visited = new boolean[N][N];
			
			for (int j = 0; j < N; j++) {
				String str = br.readLine();
				for (int k = 0; k < N; k++) {
					arr[j][k] = str.charAt(k);
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(arr[j][j2] == '.' && !check(j,j2)) {
						bfs(j, j2);
						answer++;
					}
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(arr[j][j2] == '.') {
						answer++;
					}
				}
			}
			
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean check(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
				continue;
			}
			
			if(arr[nextX][nextY] == '*') return true;  //지뢰가 있는 경우
			
		}
		
		return false; //지뢰가 없는경우
	}
	
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x,y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			arr[node.x][node.y] = '-'; //체크한거면 -로 표시
			
			int count = 0;
			for (int i = 0; i < 8; i++) {
				int nextX = node.x + dx[i];
				int nextY = node.y + dy[i];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
					continue;
				}
				
				if(arr[nextX][nextY] == '*') {
					count++;
				}

			}
			
			if(count == 0) { 
				for (int i = 0; i < 8; i++) {
                    int nextX = node.x + dx[i];
                    int nextY = node.y + dy[i];
                    
                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                        continue;
                    }
                    
                    if (arr[nextX][nextY] == '.' && !visited[nextX][nextY]) {
                        queue.add(new Node(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
			}
		}
	}
}
