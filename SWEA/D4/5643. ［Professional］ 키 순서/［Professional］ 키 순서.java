import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        sb = new StringBuilder();

        br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            int N, M, answer = 0;
            int a,b;
            boolean[][] distance;

            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            distance = new boolean[N+1][N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                distance[a][b] = true;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if(distance[i][k] && distance[k][j]){
                            distance[i][j] = true;
                        }
                    }
                }
            }

            boolean check;
            for (int i = 1; i <= N ; i++) {
                check = false;
                for (int j = 1; j <= N ; j++) {
                    if(i != j && !distance[j][i] && !distance[i][j]){
                        check = true;
                        break;
                    }
                }
                if(!check) answer++;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

}