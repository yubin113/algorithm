import java.util.*;
import java.io.*;

class Main{
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static int TC, M, N, K;
    static int[][] arr;
    static boolean[][] isvisited;
    static int answer;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++ ){
            answer = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        
            arr = new int[N][M];
            isvisited = new boolean[N][M];
        
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(!isvisited[i][j] && arr[i][j] == 1){
                        BFS(i, j);
                        answer++;
                    }
                }
            }
            sb.append(answer + "\n");
            
        } 
        System.out.println(sb);
    }
    static void BFS(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        isvisited[x][y] = true;
        queue.add(new Node(x,y));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(arr[nextX][nextY] != 1 || isvisited[nextX][nextY]) continue;
                
                isvisited[nextX][nextY] = true;
                queue.add(new Node(nextX, nextY));
            }
        } 
    }
    public static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}