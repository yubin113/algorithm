import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    /**
     * 남녀 간선만 넣는다
     */

    static BufferedReader br;
    static StringTokenizer st;
    static int N,M;
    static char[] school;
    static class Node implements Comparable<Node>{
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
         parent[rootB] = rootA;
         return true;
    }

    static ArrayList<Node> nodes;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] tmp = br.readLine().split(" ");
        school = new char[N+1];
        for (int i = 1; i <= N; i++) {
            school[i] = tmp[i-1].charAt(0);
        }

        nodes = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if(school[start] == 'W' && school[end] == 'W'){
                continue;
            }
            if(school[start] == 'M' && school[end] == 'M'){
                continue;
            }
            nodes.add(new Node(start, end, value));
        }

        Collections.sort(nodes);

        make();

        int count = 0;
        long sum = 0;

        for (Node node:
             nodes) {
            if(union(node.start, node.end)){
                count++;
                sum += node.value;
                if(count == N-1) break;
            }
        }

        int check = 0;
        for (int i = 1; i < N+1; i++) {
            if(parent[i] < 0) check++;
        }

        if(check != 1){
            System.out.println("-1");
        }else{
            System.out.println(sum);
        }
    }
}