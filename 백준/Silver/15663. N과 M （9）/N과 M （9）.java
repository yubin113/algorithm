import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backTracking(0);

    }

    static void backTracking(int depth){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        int before = 0;
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;

            if(before != arr[i]){
                visited[i] = true;
                result[depth] = arr[i];
                before = arr[i];
                backTracking(depth + 1);
                visited[i] = false;
            }
        }

    }

}


