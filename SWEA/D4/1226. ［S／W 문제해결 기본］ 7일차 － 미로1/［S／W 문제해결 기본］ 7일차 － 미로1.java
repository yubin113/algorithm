import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int[][] arr;
    static boolean[][] check;
    static boolean result;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            arr = new int[16][16];
            check = new boolean[16][16];
            for (int i = 0; i < 16; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < 16; j++) {
                    arr[i][j] = tmp.charAt(j) - '0';
                }
            }
            result = false;
            BFS();
            sb.append("#").append(tc).append(" ").append(result == true ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void BFS(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,1));
        check[1][1] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(arr[node.x][node.y] == 3){
                result = true;
                return;
            }

            if(result) return;

            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= 16 || nextY >= 16) continue;
                if(arr[nextX][nextY] == 1) continue;
                if(check[nextX][nextY]) continue;

                check[nextX][nextY] = true;
                queue.add(new Node(nextX, nextY));
            }
        }
    }
}