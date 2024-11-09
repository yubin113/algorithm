import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    /**
     * SWEA 5656 모의 벽돌 깨기
     * 풀이 : 중복 순열 + 백트래킹
     */

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int TC;
    static int N,W,H;
    static int[][] arr;
    static int[] selected;
    static int minSum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            arr = new int[W][H];
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < H; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            minSum = Integer.MAX_VALUE;

            //중복 순열 구하기
            selected = new int[N];
            permutation(0);

            sb.append("#").append(tc).append(" ").append(minSum).append("\n");
        }
        System.out.println(sb);
    }
    static void permutation(int depth){
        if(depth == N){
            //selected: 구슬 놓을 위치 정해짐
//            System.out.println(Arrays.toString(selected));
            //벽돌깨트리기
            int[][] copyArr = new int[W][H];
            for (int i = 0; i < W; i++) {
                for (int j = 0; j < H; j++) {
                    copyArr[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < selected.length; i++) {
                boolean[][] removeCheck = new boolean[W][H];
                remove(copyArr, removeCheck, selected[i]);
                down(copyArr);
            }

            minSum = Integer.min(minSum, countArr(copyArr));
            return;
        }

        for (int i = 0; i < H; i++) {
            selected[depth] = i;
            permutation(depth+1);
        }
    }

    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //벽돌 없애기
   static void remove(int[][] arr, boolean[][] check, int where){
       //명중 위치 찾기
       Node startNode = null;
       for (int i = 0; i < W; i++) {
           if(arr[i][where] != 0){
               startNode = new Node(i, where);
               break;
           }
       }

       if(startNode == null){
           return;
       }
       //BFS
       BFS(startNode.x, startNode.y, check, arr);

       //check배열담긴 애들은 파괴되는 애들이므로 0으로 만든기
       remove2(arr, check);

   }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

   static void BFS(int x, int y, boolean[][] check, int[][] arr){
       Queue<Node> queue = new LinkedList<>();
       queue.add(new Node(x,y));
       check[x][y] = true;

       while (!queue.isEmpty()){
           Node now = queue.poll();

           for (int i = 0; i < 4; i++) {
               for (int j = 1; j <= arr[now.x][now.y] - 1; j++) {
                   int nextX = now.x + (dx[i] * j);
                   int nextY = now.y + (dy[i] * j);

                   if(nextX < 0 || nextY < 0 || nextX >= W || nextY >= H) continue;
                   if(check[nextX][nextY]) continue;
                   if(arr[nextX][nextY] == 0) continue;

                   check[nextX][nextY] = true;
                   queue.add(new Node(nextX, nextY));
               }
           }
       }
   }

   static void remove2(int[][] arr, boolean[][] check){
       for (int i = 0; i < W; i++) {
           for (int j = 0; j < H; j++) {
               if(check[i][j]){
                   arr[i][j] = 0;
               }
           }
       }
   }

   static void down(int[][] arr){
       for (int i = 0; i < H; i++) {
           Queue<Integer> queue = new LinkedList<>();
           for (int j = W-1; j >= 0; j--) {
               if(arr[j][i] != 0) queue.add(arr[j][i]);
           }
           for (int j = W-1; j >= 0; j--) {
               if(!queue.isEmpty()){
                   arr[j][i] = queue.poll();
               }else{
                   arr[j][i] = 0;
               }
           }
       }
   }

   static int countArr(int[][] arr){
       int sum = 0;
       for (int i = 0; i < W; i++) {
           for (int j = 0; j < H; j++) {
               if(arr[i][j] != 0){
                   sum++;
               }
           }
       }
       return sum;
   }
}
