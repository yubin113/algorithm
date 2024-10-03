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
    static int N,M;
    static class Node implements Comparable<Node> {
        int start;
        int end;
        int value;

        public Node(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    static int[] parent;
    static void make(){
        parent = new int[N+1];
        Arrays.fill(parent,-1);
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
        parent[rootB] = rootA ;
        return true;
    }

    static ArrayList<Node> nodes;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            nodes.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(nodes);

        make();

        int count = 0;
        long valueSum = 0;
        int maxEdgeValue = Integer.MIN_VALUE;

        for (Node node :
                nodes) {
            if(count < N-1){
                if(union(node.start, node.end)){
                    count++;
                    valueSum += node.value;
                    maxEdgeValue = Math.max(maxEdgeValue, node.value);
                }
            }
        }
        System.out.println(valueSum - maxEdgeValue);
    }
}