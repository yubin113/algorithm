import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 알파벳
     * 핵심 풀이: DFS
     *
     * 1. 인풋 케이스 받는다.(R,C int[][] arr)
     * 2. Node 클래스 만든다.
     * 3. DFS(new Node(0,0), 0, arrayList) 실행
     *      3.1 result, 값과 max 비교해서 최댓값 찾는다.
     *      3.2 4방 탐색(dx, dy)한다.
     *          3.2.1 경계 넘어가거나, 이미 포함된 알파벳이면(arrayList) continue
     *          3.2.2 arrayList에 다음 알파벳을 넣어준다
     *          3.2.3 DFS(next Node, sum+1, arrayList)
     *          3.2.4 원상복구해주기
     */

    static BufferedReader br;
    static StringTokenizer st;

    static int R,C;
    static char[][] arr;
    //2. Node 클래스 만든다.
    static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static ArrayList<Character> arrayList;
    static int result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        //1. 인풋 케이스 받는다.(R,C int[][] arr)
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        //3. DFS(new Node(0,0), 0, arrayList) 실행
        arrayList = new ArrayList<>();
        result = Integer.MIN_VALUE;
        arrayList.add(arr[0][0]);
        DFS(new Node(0,0), 1, arrayList);
        System.out.println(result);
    }
    static void DFS(Node n, int sum, ArrayList<Character> arrayList){
        //3.1 result, 값과 max 비교해서 최댓값 찾는다.
        result = Math.max(result, sum);

        //3.2 4방 탐색(dx, dy)한다.
        for (int i = 0; i < 4; i++) {
            int nextX = n.x + dx[i];
            int nextY = n.y + dy[i];

            //3.2.1 경계 넘어가거나, 이미 포함된 알파벳이면(arrayList) continue
            if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
            if(arrayList.contains(arr[nextX][nextY])) continue;


            //3.2.2 arrayList에 다음 알파벳을 넣어준다
            arrayList.add(arr[nextX][nextY]);

            //3.2.3 DFS(next Node, sum+1, arrayList)
            DFS(new Node(nextX,nextY), sum+1, arrayList);


        }
        //원상복구
        arrayList.remove(arrayList.size()-1);
    }
}