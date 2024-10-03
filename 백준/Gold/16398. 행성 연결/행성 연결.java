import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    /**
     * 행성 연결
     * 풀이 방법: mst, 유니온파인드 사용
     *
     * 1. 인풋 받기(N, Edge 클래스)
     * 2. 유니온파인드 만들기
     * 3. Edge 정렬시키기
     * 4. Edge돌면서 노드-1일때까지 union시키면서 최소 비용 찾기
     */

    static BufferedReader br;
    static StringTokenizer st;

    static int N;
    static ArrayList<Edge> edges;
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value) {
            super();
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }

    }
    static int[] parent;
    static void make(){
        parent = new int[N];
        Arrays.fill(parent, -1);
    }
    static int find(int a){
        if(parent[a] < 0){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            return false;
        }

        parent[rootA] += parent[rootB];
        parent[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if(j >= i+1){
                    edges.add(new Edge(i,j,Integer.parseInt(st.nextToken())));
                }else{
                    st.nextToken();
                }
            }
        }

        Collections.sort(edges);

        make();

        int count = 0;
        long valueSum = 0;
        for (Edge edge:
             edges) {
            if(count <= N-1){
                if(union(edge.start, edge.end)){
                    count++;
                    valueSum += edge.value;
                }
            }
        }
        System.out.println(valueSum);
    }
}