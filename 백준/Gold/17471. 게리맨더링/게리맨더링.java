import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int N;
    static int[] population;
    static boolean[] selected;
    static boolean[] visited; //DFS 방문 여부 체크
    static ArrayList<Integer>[] adj;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        population = new int[N];
        selected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int adjCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < adjCount; j++) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                adj[i].add(idx);
                adj[idx].add(i);
            }
        }

        subSet(0);

        //만들지 못한 경우
        if(minDifference == Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(minDifference);
        }
    }

    static void subSet(int cnt){
        if(cnt == N){
            //두 집합이 모두 연결되어 있는지 확인
            if(isConnected(true)  && isConnected(false)){
                //인구 차이 계산
                calculateDifference();
            }
            return;
        }

        //첫번째 집합에 포함
        selected[cnt] = true;
        subSet(cnt + 1);

        //두번째 집합에 포함
        selected[cnt] = false;
        subSet(cnt + 1);
    }

    //DFS로 연결되어 있는지 확인
    static boolean isConnected(boolean flag){
        visited = new boolean[N];
        int start = -1;

        for (int i = 0; i < N; i++) {
            if(selected[i] == flag){
                start = i;
                break;
            }
        }

        //시작점이 없으면 연결이 되지 않은 것
        if(start == -1) return false;

        int count = dfs(start, flag);

        //flag 집합에 속한 모든 구역이 방문되었는지 확인
        for (int i = 0; i < N; i++) {
            if(selected[i] == flag && !visited[i]){
                return false;
            }
        }
        return true;
    }

    static int dfs(int node, boolean flag) {
        visited[node] = true;
        int count = 1;

        for (int neighbor :
                adj[node]) {
            if (!visited[neighbor] && selected[neighbor] == flag) {
                count += dfs(neighbor, flag);
            }
        }
        return count;
    }

    static void calculateDifference(){
        int pA = 0;
        int pB = 0;

        for (int i = 0; i < N; i++) {
            if (selected[i]){
                pA += population[i];
            }else{
                pB += population[i];
            }
        }

        minDifference = Math.min(minDifference, Math.abs(pA - pB));
    }
}