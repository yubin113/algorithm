import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int N,M;
    static long totalSum;
    static long result;
    static int[] parents;

    static void make(){
        parents = new int[N+1];
        Arrays.fill(parents, -1);
    }

    static int find(int a){
        if(parents[a] < 0 ) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            return false;
        }

        parents[rootA] += parents[rootB];
        parents[rootB] = rootA;
        return true;
    }
    static class Edge implements Comparable<Edge> {
        int start, end, value;
        Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  //건물의 개수
        M = Integer.parseInt(st.nextToken());  //도로의 개수

        totalSum = 0;
        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, value);
            totalSum += value;
        }

        Arrays.sort(edges);

        make();
        result = 0;
        int edgeCount = 0;
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];

            if(union(edge.start, edge.end)){
                result += edge.value;
                edgeCount++;
                if(edgeCount ==  N-1) break;
            }
        }

        int cnt = 0;
        for (int i = 1; i < parents.length; i++) {
            if(parents[i] < 0) cnt++;
            if(cnt >= 2) break;
        }
        if(cnt >= 2){
            System.out.println("-1");
        }else{
            System.out.println(totalSum - result);
        }

    }
}