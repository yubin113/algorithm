import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N,M;
	static int[][] arr;
	
	static int result;
	
	public static void main(String[] args) throws IOException{
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = Integer.MIN_VALUE;
		//1*4
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M-4+1; j++) {
				int sum = 0;
				for (int k = j; k < j+4; k++) {
					sum += arr[i][k];
				}
				result = Math.max(result, sum);
			}
		}

		
		//4*1
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N-4+1; j++) {
				int sum = 0;
				for (int k = j; k < j+4; k++) {
					sum += arr[k][i];
				}
				result = Math.max(result, sum);
			}
		}
		//2*2
		for (int i = 0; i < N-2+1; i++) {
			for (int j = 0; j < M-2+1; j++) {
				int sum = 0;
				for (int k = i; k < i+2; k++) {
					for (int k2 = j; k2 < j+2; k2++) {
						sum += arr[k][k2];					}
				}
				result = Math.max(result, sum);
			}
		}
		//2*3
		for (int i = 0; i < N-2+1; i++) {
			for (int j = 0; j < M-3+1; j++) {
				int sum = 0;
				for (int k = i; k < i+2; k++) {
					for (int k2 = j; k2 < j+3; k2++) {
						sum += arr[k][k2];
					}
				}
				int case1 = sum - arr[i][j+1] - arr[i][j+2];
				result = Math.max(result, case1);
				int case2 = sum - arr[i+1][j] - arr[i+1][j+1];
				result = Math.max(result, case2);
				int case3 = sum - arr[i+1][j] - arr[i][j+2];
				result = Math.max(result, case3);
				int case4 = sum - arr[i][j] - arr[i+1][j+2];
				result = Math.max(result, case4);
				int case5 = sum - arr[i][j] - arr[i][j+2];
				result = Math.max(result, case5);
				int case6 = sum - arr[i+1][j] - arr[i+1][j+2];
				result = Math.max(result, case6);
				int case7 = sum - arr[i+1][j+1] - arr[i+1][j+2];
				result = Math.max(result, case7);
				int case8 = sum - arr[i][j] - arr[i][j+1];
				result = Math.max(result, case8);
			}
		}
		
		
		//3*2
		for (int i = 0; i < N-3+1; i++) {
			for (int j = 0; j < M-2+1; j++) {
				int sum = 0;
				for (int k = i; k < i+3; k++) {
					for (int k2 = j; k2 < j+2; k2++) {
						sum += arr[k][k2];
					}
				}
				int case1 = sum - arr[i][j+1] - arr[i+1][j+1];
				result = Math.max(result, case1);
				int case2 = sum - arr[i+1][j] - arr[i+2][j];
				result = Math.max(result, case2);
				int case3 = sum - arr[i+2][j] - arr[i][j+1];
				result = Math.max(result, case3);
				int case4 = sum - arr[i][j] - arr[i+2][j];
				result = Math.max(result, case4);
				int case5 = sum - arr[i][j+1] - arr[i+2][j+1];
				result = Math.max(result, case5);
				int case6 = sum - arr[i][j] - arr[i+2][j+1];
				result = Math.max(result, case6);
				int case7 = sum - arr[i][j] - arr[i+1][j];
				result = Math.max(result, case7);
				int case8 = sum - arr[i][j+1] - arr[i+1][j+1];
				result = Math.max(result, case8);
                int case9 = sum - arr[i+1][j+1] - arr[i+2][j+1];
				result = Math.max(result, case9);

			}
		}
		
		System.out.println(result);
	}
}