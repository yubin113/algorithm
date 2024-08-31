import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int N;
    static int[][] arr;
    static int totalCnt = 0;
    static int sharkSize = 2;
    static int eatSize = 0;
    static Queue<Node> queue;
    static int sharkX;
    static int sharkY;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9){
                    sharkX = i;
                    sharkY = j;
                    arr[i][j] = 0;
                }
            }
        }

        while(true){

            Node node = BFS();
            if(node == null){
                break;
            }

            arr[sharkX][sharkY] = 0;
            sharkX = node.x;
            sharkY = node.y;
            totalCnt += node.distance;
            arr[sharkX][sharkY] = 0;
            eatSize++;

            if(eatSize == sharkSize){
                sharkSize++;
                eatSize = 0;
            }
        }

        System.out.println(totalCnt);
    }

    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static Node BFS(){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        visited = new boolean[N][N];
        queue = new LinkedList<>();
        queue.offer(new Node(sharkX, sharkY, 0));

        int minDistance = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.distance >  minDistance){
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(arr[nx][ny] > sharkSize) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny, node.distance + 1));

                if(arr[nx][ny] > 0 && arr[nx][ny] < sharkSize){
                     priorityQueue.offer(new Node(nx, ny, node.distance  + 1));
                     minDistance = node.distance + 1;
                }
            }
        }
        return priorityQueue.isEmpty() ? null : priorityQueue.poll();
    }
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int distance;
        Node(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if(this.distance == o.distance){
                if(this.x == o.x){
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.distance - o.distance;
        }
    }

}
