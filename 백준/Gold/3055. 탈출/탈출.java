import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	
	static int R,C;
	static char[][] arr;
	
	static Node Dnode; //고슴도치 위치
	static Node Snode; //비버굴 위치
	static Queue<Node> waters;
	static boolean[][] check; //고슴도치 방문 체크
	static class Node{
		int x;
		int y;
		int sum;
		public Node(int i, int j, int sum) {
			this.x = i;
			this.y = j;
			this.sum = sum;
		}
	}
	static int result;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int checkWater = 0;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		waters = new LinkedList<>();
		check = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if(str.charAt(j) == 'S') {
					Snode = new Node(i,j,0);
					arr[i][j] = '.';
					continue;
				}else if(str.charAt(j) == 'D') {
					Dnode = new Node(i,j,0);
				}else if(str.charAt(j) == '*') {
					waters.add(new Node(i,j,0));
					checkWater++;
				}
				arr[i][j] = str.charAt(j);
			}
		}
		result = Integer.MAX_VALUE;
		backTracking();
		
		if(result == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		}else{			
			System.out.println(result);
		}
	}
	
	static void backTracking() {
	    Queue<Node> nodes = new LinkedList<>();
	    nodes.add(Snode);
	    check[Snode.x][Snode.y] = true;

	    while (!nodes.isEmpty()) {
	        // 불을 먼저 확산시킵니다.
	        int waterSize = waters.size();
	        for (int w = 0; w < waterSize; w++) {
	            Node water = waters.poll();
	            for (int i = 0; i < 4; i++) {
	                int nextX = water.x + dx[i];
	                int nextY = water.y + dy[i];

	                if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
	                if (arr[nextX][nextY] == 'X' || arr[nextX][nextY] == 'D' || arr[nextX][nextY] == '*') continue;

	                arr[nextX][nextY] = '*'; // 불이 퍼짐
	                waters.add(new Node(nextX, nextY, 0));
	            }
	        }

	        // 고슴도치 이동 처리
	        int nodeSize = nodes.size();
	        for (int n = 0; n < nodeSize; n++) {
	        	Node now = nodes.poll();
	            for (int i = 0; i < 4; i++) {
	                int nextX = now.x + dx[i];
	                int nextY = now.y + dy[i];

	                if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
	                if (check[nextX][nextY] || arr[nextX][nextY] == '*' || arr[nextX][nextY] == 'X') continue;

	                if (nextX == Dnode.x && nextY == Dnode.y) {
	                    result = Math.min(result, now.sum + 1);
	                    return; // 비버 굴에 도착
	                }

	                check[nextX][nextY] = true; // 방문 체크
	                nodes.add(new Node(nextX, nextY, now.sum + 1));
	            }
	        }
	    }
	}

}