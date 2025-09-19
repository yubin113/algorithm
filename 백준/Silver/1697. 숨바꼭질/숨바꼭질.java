import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static StringTokenizer st;
    
    static int N,K;
    static boolean[] visited;
    static Queue<Node> queue;
    static int result;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        
        visited = new boolean[100001];
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visited[N] = true;
        
        queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.num == K) {
                System.out.println(node.time);
                return;
            }
            //+1,-1,*2
            if(node.num+1 <= 100000 && !visited[node.num + 1]){
                queue.add(new Node(node.num+1, node.time+1));
                visited[node.num+1] = true;
            }
            if(node.num-1 >= 0 && !visited[node.num - 1]){
                queue.add(new Node(node.num-1, node.time+1));
                visited[node.num-1] = true;
            }
            if(node.num*2 <= 100000 && !visited[node.num * 2]){
                queue.add(new Node(node.num*2, node.time+1));
                visited[node.num*2] = true;
            }            
        }
    }
    static class Node{
        int num;
        int time;
        public Node(int num, int time){
            this.num = num;
            this.time = time;
        }
    }
}