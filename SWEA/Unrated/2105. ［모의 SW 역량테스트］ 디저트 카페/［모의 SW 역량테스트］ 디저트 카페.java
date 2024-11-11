
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	/**
	 * SWEA 2105 모의 디저트 카페
	 * 문제 요약
	 * 대각선 방향으로 움직이고 사각형 모양을 그리며 출발한 카페로 돌아와야 한다.
	 * 카페 투어 중에 같은 숫자의 디저트를 팔고 있는 카페가 있으면 안 된다.
	 * 하나 디저트 카페 x, 왔던 길 다시 가는 것도 x
	 * 디저트를 가장 많이 먹을 수 있는 경로를 찾고, 그 때의 디저트 수를 정답으로 출력하는 프로그램을 작성하라.
	 * 만약, 디저트를 먹을 수 없는 경우 -1을 출력한다.
	 * 
	 * 
	 */
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int N;
	static int[][] arr;
	static int answer;
	static boolean[] visited;
	
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			answer = -1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[101];
					visited[arr[i][j]] = true;
					dfs(i,j,i,j,1,0,i,j);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int x, int y, int preX, int preY, int cnt, int dir, int startX, int startY) {
		for (int i = dir; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			//경계를 벗어나는 경우
			if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
			
			//똑같은 경로로 돌아오는 경우
			if(nextX == preX && nextY == preY) continue;
			
			//출발점으로 돌아오는 경우
			if(nextX == startX && nextY == startY) {
				answer = Math.max(answer, cnt);
				return;
			}
			
			//이미 같은 종류의 디저트인 경우
			if(visited[arr[nextX][nextY]]) continue;
			
			//이제 다른 경로 갈 수 있는 경우이다
			visited[arr[nextX][nextY]] = true;
			dfs(nextX, nextY, x, y, cnt+1, i, startX, startY);
			//다시 되돌려주기
			visited[arr[nextX][nextY]] = false;
		}
	}
}
