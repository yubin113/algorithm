import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	/**
	 * 중복 순열 + BFS
	 * 
	 * 1. 인풋 케이스 받기(TC, N,W,H, arr)
	 */
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuffer sb;
	
	static int TC;
	static int N,W,H;
	static int[][] arr;
	static int[] selected;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int answer;
	
	static class Node{
		int x,y;
		int value;
		Node(int x, int y, int value){
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuffer();
		
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  //구슬 갯수
			W = Integer.parseInt(st.nextToken());  //W * H 배열
			H = Integer.parseInt(st.nextToken());
			
			arr = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = Integer.MAX_VALUE;
			
			//중복순열
			selected = new int[N];
			Permutation(0);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void Permutation(int cnt) {
		if(cnt == N) {
			int[][] copiedArr = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					copiedArr[i][j] = arr[i][j];
				}
			}
			
			//중복순열(selected)
			for (int i = 0; i < N; i++) {
				copiedArr = BFS(selected[i], copiedArr);
			}
			
			//남은 벽돌 갯수
			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(copiedArr[i][j] != 0) {
						count++;
					}
				}
			}
			
			answer = Math.min(count, answer);
			
			return;
		}
		
		for (int i = 0; i < W; i++) {
			selected[cnt] = i;
			Permutation(cnt + 1);
		}
	}
	
	static int[][] BFS(int idx, int[][] arr) {
		int lastWhere = -1;
		//벽돌있는 제일 윗칸 찾기
		for (int i = 0; i < H; i++) {
			if(arr[i][idx] != 0) {
				lastWhere = i;
				break;
			}
		}
		
		//해당 칸 벽돌이 없는거
		if(lastWhere == -1) return arr;
		
		//구슬 영역 미치는 곳 
		boolean[][] effected = new boolean[H][W];
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(lastWhere, idx, arr[lastWhere][idx]));
		effected[lastWhere][idx] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			//4방 탐색
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < now.value; j++) {
					int nextX = now.x + dx[i] * j;
					int nextY = now.y + dy[i] * j;
					
					//경계 벗어나거나 0이거나
					if(nextX < 0 || nextY < 0 || nextX >= H || nextY >= W || arr[nextX][nextY] == 0) continue;
					if(effected[nextX][nextY]) continue;
					
					effected[nextX][nextY] = true;
					queue.add(new Node(nextX, nextY, arr[nextX][nextY]));
				}
			}
		}
		
		//벽돌깨기
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(effected[i][j]) {
					arr[i][j] = 0;
				}
			}
		}
		
		//벽돌 내리기
		int[][] result = Down(arr);
		return result;
		
	}
	
	static int[][] Down(int[][] arr) {
		for (int i = 0; i < W; i++) {
			ArrayList<Integer> line = new ArrayList<>();
			for (int j = H-1; j >= 0; j--) {
				if(arr[j][i] != 0) {
					line.add(arr[j][i]);
				}
			}
			
			int idx = H-1;
			int size = 0;
			while(size != line.size()) {
				arr[idx--][i] = line.get(size++);
			}
			while(idx >= 0) {
				arr[idx--][i] = 0;
			}
		}
		
		return arr;
	}
}