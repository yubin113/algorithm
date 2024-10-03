import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static class Node implements Comparable<Node>{
        int start;
        int end;
        double value;
        public Node(int start, int end, double value){
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.value, o.value);
        }

    }

    static int[] parent;
    static void make(){
        parent = new int[N];
        Arrays.fill(parent, -1);
    }
    static int find(int a){
        if(parent[a] < 0) return a;
        return parent[a] = find(parent[a]);
    }
    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false;

        parent[rootA] += parent[rootB];
        parent[rootB] = rootA;
        return true;
    }

    static ArrayList<Node> nodes;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] tmpNode = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            tmpNode[i][0] = Integer.parseInt(st.nextToken());
            tmpNode[i][1] = Integer.parseInt(st.nextToken());
        }

        nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                double sum = Math.sqrt(Math.pow((tmpNode[i][0] - tmpNode[j][0]),2) + Math.pow((tmpNode[i][1] - tmpNode[j][1]),2));
                nodes.add(new Node(i,j, sum));
            }
        }

        make();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        }

        int count = M;
        double sum = 0;

        Collections.sort(nodes);

        for (Node node :
                nodes) {
                if(union(node.start, node.end)){
                    count++;
                    sum += node.value;
                }
        }

        System.out.printf("%.2f%n", sum);

    }
}