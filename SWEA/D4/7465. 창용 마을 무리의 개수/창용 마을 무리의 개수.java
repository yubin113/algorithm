import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    /**
     * 창용 마을 무리의 개수
     * 유니온파인드해서 -1인 애들만 찾기
     */
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int[] parent;
    static int N;
    static int M;
    static int TC;
    static void make(){
        parent = new int[N+1];
        Arrays.fill(parent, -1);
    }
    static int find(int a){
        if(parent[a] < 0) return a;
        return parent[a] = find(parent[a]);
    }
    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parent[aRoot] += parent[bRoot];
        parent[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            make();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                union(num1, num2);
            }

            int sum = 0;
            for (int i = 1; i < N+1; i++) {
                if(parent[i] < 0) sum++;
            }
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
