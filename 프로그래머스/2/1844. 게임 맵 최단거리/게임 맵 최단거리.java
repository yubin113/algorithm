import java.io.*;
import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] check = new boolean[n][m];
        
        int answer = bfs(check, maps, n, m);;
        
        return answer;
    }
    public int bfs(boolean[][] check, int[][] maps, int n, int m){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,1));
        check[0][0] = true;
        
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.x == n - 1 && node.y == m - 1){
                return node.cnt;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(check[nx][ny]) continue;
                if(maps[nx][ny] == 1 ){
                    check[nx][ny] = true;
                    queue.add(new Node(nx,ny,node.cnt+1));
                }
            }
        }
        return -1;
    }
    public class Node{
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            
        }
    }
}
