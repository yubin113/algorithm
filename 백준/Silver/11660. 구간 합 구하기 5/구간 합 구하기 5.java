import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[][] prefixSum;
	static int[][] where;
	public static void main(String[] args) throws Exception{
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		prefixSum = new int[N+1][N+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				prefixSum[i][j] = prefixSum[i-1][j] 
						+ prefixSum[i][j-1] 
						- prefixSum[i-1][j-1] 
						+ arr[i-1][j-1]; 
			}
		}
		
		where = new int[M][4];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				where[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			int sum = prefixSum[where[i][2]][where[i][3]] 
					- prefixSum[where[i][2]][where[i][1] - 1]
					- prefixSum[where[i][0] - 1][where[i][3]]
							+ prefixSum[where[i][0] - 1][where[i][1]-1];
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
