import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N,L,R;
	static int[][] A;
	static int[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static LinkedList<Node> unionList;
	static int result;

	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  //땅크기
		L = Integer.parseInt(st.nextToken());  //인구차이
		R = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		while(true) {
			if(!bfs()) break;
			result++;
		}
		System.out.println(result);
	}
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static boolean bfs() {
	    boolean moved = false;  // 인구 이동이 일어났는지 체크
	    check = new int[N][N];  // 방문 여부 초기화
	    int index = 1;

	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            if (check[i][j] == 0) {
	                Queue<Node> queue = new LinkedList<>();
	                unionList = new LinkedList<>();  // 연합 좌표를 저장할 리스트
	                queue.add(new Node(i, j));
	                check[i][j] = index;

	                int populationSum = 0;  // 연합의 인구 합
	                int unionCount = 0;  // 연합에 속한 나라의 수

	                while (!queue.isEmpty()) {
	                    Node now = queue.poll();
	                    unionList.add(now);  // 연합에 추가
	                    populationSum += A[now.x][now.y];
	                    unionCount++;

	                    for (int k = 0; k < 4; k++) {
	                        int nextX = now.x + dx[k];
	                        int nextY = now.y + dy[k];

	                        if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
	                        if (check[nextX][nextY] > 0) continue;

	                        int gap = Math.abs(A[now.x][now.y] - A[nextX][nextY]);
	                        if (gap >= L && gap <= R) {
	                            check[nextX][nextY] = index;
	                            queue.add(new Node(nextX, nextY));
	                        }
	                    }
	                }

	                // 연합에 속한 국가가 2개 이상이면 인구 이동이 발생
	                if (unionCount > 1) {
	                    moved = true;
	                    int newPopulation = populationSum / unionCount;  // 새로운 인구 수
	                    for (Node node : unionList) {
	                        A[node.x][node.y] = newPopulation;  // 인구 갱신
	                    }
	                }
	                index++;
	            }
	        }
	    }
	    return moved;
	}

}
