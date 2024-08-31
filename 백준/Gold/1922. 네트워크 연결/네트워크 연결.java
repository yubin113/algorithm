import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int[] parents;
    static int V;
    static int E;
    static Edge[] edges;
    static void make(){
        parents = new int[V+1];
        for (int i = 1; i < V + 1; i++) {
            parents[i] = -1;
        }
    }

    static int find(int a){
        if(parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[aRoot] += parents[bRoot];
        parents[bRoot] = aRoot;
        return true;
    }


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(edges);

        make();

        int cnt = 0;
        int cost = 0;
        for (Edge edge :
                edges) {
            if(union(edge.start, edge.end)){
                cost += edge.weight;
                if (++cnt == V - 1){
                    break;
                }
            }
        }

        System.out.println(cost);
    }
    
    static class Edge implements Comparable<Edge>{
        int start, end, weight;
        Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
