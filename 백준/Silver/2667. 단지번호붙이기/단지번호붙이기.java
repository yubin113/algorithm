import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static StringBuilder sb;
    
    static int N;
    static int[][] arr;
    static boolean[][] isVisited;
    static Queue<Node> queue;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        isVisited = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = (int) tmp.charAt(j) - '0';
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 1 && !isVisited[i][j]){
                    arrayList.add(BFS(i,j));
                }
            }
        }
        Collections.sort(arrayList);
        sb.append(arrayList.size() + "\n");
        for(int num: arrayList){
            sb.append(num+"\n");
        }
        
        System.out.println(sb);
    }
    
    static int BFS(int x, int y){
        queue = new LinkedList<>();
        queue.add(new Node(x,y));
        int sum = 1;
        isVisited[x][y] = true;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(isVisited[nx][ny]) continue;
                if(arr[nx][ny] == 0) continue;
                
                queue.add(new Node(nx, ny));
                sum++;
                isVisited[nx][ny] = true;
            }
        }
        
        return sum;
    }
    
    static class Node{
        int x,y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}