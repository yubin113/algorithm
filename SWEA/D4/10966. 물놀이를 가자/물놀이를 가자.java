import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
 
    static int TC;
    static int N, M;
    static char[][] arr;
    static boolean[][] visited;
    static Queue<Node> queue;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int result;
 
    static class Node{
        int x, y, distance;
        Node(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
 
        TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new char[N][M];
            for (int i = 0; i < N; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = chars[j];
                }
            }
            result = 0;
            queue = new LinkedList<>();
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] == 'W'){
                        queue.add(new  Node(i,j, 0));
                        visited[i][j] = true;
                    }
                }
            }
            BFS();
 
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    static void BFS(){
        while (!queue.isEmpty()){
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
 
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
 
                queue.add(new Node(nx, ny, node.distance + 1));
                visited[nx][ny] = true;
                result += node.distance + 1;
            }
        }
    }
}