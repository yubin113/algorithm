import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	/**
	 * 상호의 배틀필드
	 * 풀이: 구현
	 * 
	 * 1. 인풋케이스 받는다(TC, H,W, char[][] arr, N, String inputs)
	 * 2. 전차 위치 정보 클래스 만든다.(class node - x,y, int[] dir)
	 * 3. N번 반복 수행하면서, 수행 함수 실행한다.
	 * 4. 수행 함수(char method)
	 * 		4.1 method가 U이라면, direction = {-1,0}이런식으로 D,L,R까지 적는다.
	 * 		4.2 범위 체크 함수 
	 * 		4.3 method가 S라면,
	 * 			4.3.0 nextX = x + direction[0], nextY = y + direction[1]
	 * 			4.3.1 while(true)
	 * 			4.3.2 범위 체크 안되면 break 
	 * 			4.3.3 벽돌(*)이면 해당 위치 . 바꿔주고 break
	 * 			4.3.4 강철(#)이면 break
	 */
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int H, W;
	static char[][] arr;
	static int N;
	static String inputs;
	
	//2. 전차 위치 정보 클래스 만든다.(class node - x,y, int[] dir)
	static class Node{
		int x, y;
		int dirX;
		int dirY;
		public Node(int x, int y, int dirX, int dirY) {
			this.x = x;
			this.y = y;
			this.dirX = dirX;
			this.dirY = dirY;
		}
	}
	static Node node;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		//1. 인풋케이스 받는다(TC, H,W, char[][] arr, N, String inputs)
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new char[H][W];
			node = new Node(-1, -1, 0, 0);
			for (int i = 0; i < H; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < W; j++) {
					if(tmp.charAt(j) == '^' || tmp.charAt(j) == 'v' || tmp.charAt(j) == '<' || tmp.charAt(j) == '>') {
						node.x = i;
						node.y = j;
						directionCheck(tmp.charAt(j));
						arr[i][j] = '.';
						continue;
					}
					arr[i][j] = tmp.charAt(j);
					
				}
			}
			
			N = Integer.parseInt(br.readLine());
			inputs = br.readLine();
			
			//4. 수행 함수(char method)
			for (int i = 0; i < N; i++) {
				func(inputs.charAt(i));
			}
			
			sb.append("#").append(tc).append(" ");
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(node.x == i && node.y == j) {
						sb.append(reversedDir());
						continue;
					}
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	static void directionCheck(char dir) {
		switch (dir) {
		case '^':
			node.dirX = -1;
			node.dirY = 0;
			break;
		case 'v':
			node.dirX = 1;
			node.dirY = 0;
			break;
		case '<':
			node.dirX = 0;
			node.dirY = -1;
			break;
		case '>':
			node.dirX = 0;
			node.dirY = 1;
			break;
		}
	}
	
	static char reversedDir() {
		if(node.dirY == 0) {
			if(node.dirX == 1) return 'v';
			else return '^';
		}else {
			if(node.dirY == 1) return '>';
			else return '<';
		}
	}
	
	static void func(char method) {
		//4.1 method가 U이라면, direction = {-1,0}이런식으로 D,L,R까지 적는다.
		if(method == 'U' || method == 'R' || method == 'D' || method == 'L') {
			switch (method) {
			case 'U':
				node.dirX = -1;
				node.dirY = 0;
				break;
			case 'D':
				node.dirX = 1;
				node.dirY = 0;
				break;
			case 'L':
				node.dirX = 0;
				node.dirY = -1;
				break;
			case 'R':
				node.dirX = 0;
				node.dirY = 1;
				break;
			}
			
			//4.3.0 nextX = x + direction[0], nextY = y + direction[1]
			int nextX = node.x + node.dirX;
			int nextY = node.y + node.dirY;
			
			//4.3.2 범위 체크 안되면 break 
			if(!check(nextX, nextY)) return;
			//4.3.3 앞이 평지이면 한 칸앞으로 이동
			if(arr[nextX][nextY] == '.') {
				node.x = nextX;
				node.y = nextY;
				return;
			}
		}else {
			//4.3.0 nextX = x + direction[0], nextY = y + direction[1]
			int nextX = node.x + node.dirX;
			int nextY = node.y + node.dirY;
			
			//4.3.1 while(true)
			while(true) {
				//4.3.2 범위 체크 안되면 break 
				if(!check(nextX, nextY)) break;
				//4.3.3 벽돌(*)이면 해당 위치 . 바꿔주고 break
				if(arr[nextX][nextY]=='*') {
					arr[nextX][nextY] = '.';
					break;
				}
				if(arr[nextX][nextY]=='#') {
					break;
				}
				
				nextX = nextX + node.dirX;
				nextY = nextY + node.dirY;
			}
			
		}
	}
	
	static boolean check(int x, int y) {
		if(x >= H || y >= W || x < 0 || y < 0) return false;
		return true;
	}
}