
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	/**
	 * SWEA 5643 D4 키 순서
	 * 풀이 방법: 플로이드 워셜
	 */
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int N,M;
	static boolean[][] adjList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine()); //학생들의 수
			M = Integer.parseInt(br.readLine()); //두 학생들의 키를 비교한 횟수
			
			adjList = new boolean[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int student1 = Integer.parseInt(st.nextToken());
				int student2 = Integer.parseInt(st.nextToken());
				
				adjList[student1][student2] = true;
			}
			
			for (int k = 1; k < N+1; k++) {
				for (int i = 1; i < N+1; i++) {
					for (int j = 1; j < N+1; j++) {
						if(adjList[i][k] && adjList[k][j]) adjList[i][j] = true;
					}
				}
			}
			
			int resultStudents = 0;
			for (int i = 1; i < N+1; i++) {
				boolean check = true;
				for (int j = 1; j < N+1; j++) {
					//자기 자신은 패스
					if(i == j) continue;
					if(!adjList[i][j] ) {
						if(!adjList[j][i]) {
							check = false;
							break;
						}
					}
				}
				if(check) resultStudents++;
			}
			
			sb.append("#").append(tc).append(" ").append(resultStudents).append("\n");
		}
		System.out.println(sb);
	}

}
