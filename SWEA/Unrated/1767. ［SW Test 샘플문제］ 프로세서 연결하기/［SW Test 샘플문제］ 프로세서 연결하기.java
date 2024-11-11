import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    /**
     * SWEA 1767 모의 프로세스 연결하기
     *
     * 문제 요약
     * N*N  cell 가장자리는 전원 흐름
     * 전선: core와 전원을 연결, 직선만 가능, 전선들은 교차되면 안된다.
     * 가장자리에 위치한 애들은 이미 전원이 연결되어 있다
     * 최대한 많은 Core에 연결하고 전선 길이의 합이 최소가 되는 것 구하기
     *
     * 초기 생각
     * 1. 인풋 케이스 받기
     * 2. DFS로 연결해보기
     *      2.1 기저 조건: depth가 연결안된 애들 크기만큼 되면 Core 갯수 비교하고 전선 길이 최소 비교하기
     *      2.2 4방, 연결안한 경우
     */

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int TC;
    static int N;
    static int[][] arr;
    static int count;
    static ArrayList<Core> coreList;
    static boolean[][] check;

    static int resultCore;
    static int resultLineCnt;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Core{
        int x,y;
        Core(int x, int y){
            this.x  = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            count = 0;
            coreList = new ArrayList<>();
            check = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 1){
                        if(i == 0 || i == N-1 || j == 0 || j == N-1) {
                            count++;
                        }else{
                            coreList.add(new Core(i,j));
                        }
                        check[i][j] = true;
                    }

                }
            }

            resultCore = 0;
            resultLineCnt = 0;
            DFS(count, 0,0);

            sb.append("#").append(tc).append(" ").append(resultLineCnt).append("\n");
        }
        System.out.println(sb);
    }


    static void DFS(int coreCnt, int depth, int lineCnt){
        //기저조건
        if(depth == coreList.size()){
            if(resultCore < coreCnt){
                resultCore = coreCnt;
                resultLineCnt = lineCnt;
            }else if(resultCore == coreCnt){
                if(resultLineCnt > lineCnt){
                    resultLineCnt = lineCnt;
                }
            }
            return;
        }

        //연결을 안하는 경우
        DFS(coreCnt, depth+1, lineCnt);

        //4방 연결하는 경우
        Core core = coreList.get(depth);
        for (int i = 0; i < 4; i++) {
            //경계까지 갈 수 있는 경우
            boolean canLine = true;
            int tmpX = core.x;
            int tmpY = core.y;
            while(true){
                tmpX = tmpX + dx[i];
                tmpY = tmpY + dy[i];

                if(tmpX < 0 || tmpY < 0 || tmpX >= N || tmpY >= N) break;
                if(check[tmpX][tmpY]) {
                    canLine = false;
                    break;
                }
            }

            //교차하는 경우는 그냥 넘어가기
            if(!canLine) continue;

            //선 연결하기
            int tmpLineCnt = 0;
            tmpX = core.x;
            tmpY = core.y;
            while(true){
                tmpX = tmpX + dx[i];
                tmpY = tmpY + dy[i];

                if(tmpX < 0 || tmpY < 0 || tmpX >= N || tmpY >= N) break;
                check[tmpX][tmpY] = true;
                tmpLineCnt++;
            }

            DFS(coreCnt+1, depth+1, lineCnt + tmpLineCnt);

            //다시 되돌려주기
            tmpX = core.x;
            tmpY = core.y;
            while(true){
                tmpX = tmpX + dx[i];
                tmpY = tmpY + dy[i];

                if(tmpX < 0 || tmpY < 0 || tmpX >= N || tmpY >= N) break;
                check[tmpX][tmpY] = false;
            }

        }
    }
}
