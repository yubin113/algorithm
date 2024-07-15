import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backTracking(0,0);
        System.out.println(sb);
    }

    public static void backTracking(int at, int depth){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[depth] = arr[i];
                backTracking(i, depth + 1);
                visited[i] = false;
            }
        }
    }

}