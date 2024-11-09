import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    /**
     * BOJ 11725 G2 트리의 부모 찾기
     * 핵심 풀이 DFS
     *
     * 인접리스트로 만든 뒤에 DFS
     */
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int N;
    static ArrayList<ArrayList<Integer>> adjList;
    static int[] parent;
    static boolean[] isChecked;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        parent = new int[N+1];
        isChecked = new boolean[N+1];


        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            adjList.get(num1).add(num2);
            adjList.get(num2).add(num1);
        }

        DFS(1);

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);

    }
    static void DFS(int start){
        isChecked[start] = true;

        for (int i = 0; i < adjList.get(start).size(); i++) {
            if(!isChecked[adjList.get(start).get(i)]){
                parent[adjList.get(start).get(i)] = start;
                DFS(adjList.get(start).get(i));
            }
        }
    }
}
