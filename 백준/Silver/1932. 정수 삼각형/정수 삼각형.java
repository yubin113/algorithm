import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0){
                    dp[i][j] += dp[i-1][j] + arr[i][j];
                }else if(j == i){
                    dp[i][j] += dp[i-1][j-1] + arr[i][j];
                }else {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                }
            }
        }

        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            sum = Math.max(sum, dp[N-1][i]);
        }

        System.out.println(sum);

    }
}