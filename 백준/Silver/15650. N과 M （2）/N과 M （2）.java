import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        for (int i = 1; i <= N; i++) {
            arr[i-1] = i;
        }

        backTracking(0,0);

    }
    public static void backTracking(int at, int depth){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        for (int i = at; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i + 1;
                backTracking(i, depth+1);

                visited[i] = false;
            }
        }
    }
}

