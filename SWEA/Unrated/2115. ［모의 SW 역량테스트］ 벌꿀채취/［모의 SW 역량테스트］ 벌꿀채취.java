import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	/**
	 * 벌꿀 채취
	 */
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int N, M, C;
	static int[][] arr;
	static ArrayList<Integer> resultArr;
	static int maxSum;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  //벌통들의 크기
			M = Integer.parseInt(st.nextToken());  //선택할 수 있는 벌통의 개수
			C = Integer.parseInt(st.nextToken());  //꿀을 채취할 수 있는 최대 양
			
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			resultArr = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				maxSum = Integer.MIN_VALUE;
				for (int j = 0; j <= N-M; j++) {
					int[] tmp = new int[M];
					for (int k = j, idx = 0; k < j+M; k++, idx++) {
						tmp[idx] = arr[i][k];
					}
					visited = new boolean[M];
					PowerSet(0, tmp, 0);
				}
				if(maxSum == Integer.MIN_VALUE) maxSum = 0;
				resultArr.add(maxSum);
			}
			
			Collections.sort(resultArr);
			
			answer = resultArr.get(resultArr.size() - 1) + resultArr.get(resultArr.size() - 2);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		
		System.out.println(sb);
		
	}
	static void PowerSet(int cnt, int[] arr, int sum2) {
		if(sum2 > C) return;
		
		if(cnt == M) {
			int sum = 0;
			for (int i = 0; i < M; i++) {
				if(visited[i]) {
					sum += arr[i] * arr[i];
				}
			}
			maxSum = Math.max(maxSum, sum);
			return ;
		}
		
		visited[cnt] = false;
		PowerSet(cnt + 1, arr, sum2);
		
		visited[cnt] = true;
		PowerSet(cnt + 1, arr, sum2 + arr[cnt]);
		
	}
}
