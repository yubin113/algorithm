import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 파이프 옮기기1
     * 1. 인풋 정보 받기(N, arr)
     * 2. 파이프 정보 클래스 만들기(x,y,어디 방향)
     * 3. 백트래킹
     *      3.1 기저 조건: 파이프 좌표가  목표 좌표일떼(n-1,n-1) answer++
     *      3.2 for문으로 가로, 세로, 대각선 체크하기
     *          3.2.1 경계 범위 안 벗어나는지와 앞에 벽이 있는지 체크하기
     *          3.2.2 가로방향일 경우는 전 파이프가 가로, 대각선이면 가능
     *          3.2.3 세로방향일 경우 전 파이프가 세로, 대각선이면 가능
     *          3.4.4 대각선은 다 된다, 밑과 옆에 벽이 없는지는 체크하기
     */
    static BufferedReader br;
    static StringTokenizer st;

    static int N;
    static int[][] arr;
    static int[] dx = {0,1,1};  //가로,세로,대각선순
    static int[] dy = {1,0,1};
    static int answer;

    //2. 파이프 정보 클래스 만들기(x,y,어디 방향)
    static class Pipe{
        int x, y;
        int direction;  //1: 가로, 2: 세로, 3:대각선
        Pipe(int x, int y, int direction){
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        //1. 인풋 정보 받기(N, arr)
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //3. 백트래킹
        answer = 0;
        backTracking(new Pipe(0,1,1));
        System.out.println(answer);
    }
    static void backTracking(Pipe pipe){
        //3.1 기저 조건: 파이프 좌표가  목표 좌표일떼(n-1,n-1) answer++
        if(pipe.x == N-1 && pipe.y == N-1){
            answer++;
            return;
        }
        //3.2 for문으로 가로, 세로, 대각선 체크하기
        for (int i = 0; i < 3; i++) {  //가로, 세로, 대각선 순
            int nextX = pipe.x + dx[i];
            int nextY = pipe.y + dy[i];

            //3.2.1 경계 범위 안 벗어나는지와 앞에 벽이 있는지 체크하기
            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
            if(arr[nextX][nextY] == 1) continue;

            //3.2.2 가로방향일 경우는 전 파이프가 가로, 대각선이면 가능
            if(i == 0){
                if(pipe.direction == 1 || pipe.direction == 3){
                    backTracking(new Pipe(nextX, nextY, 1));
                }
            } else if (i == 1) {
                //3.2.3 세로방향일 경우 전 파이프가 세로, 대각선이면 가능
                if(pipe.direction == 2 || pipe.direction == 3){
                    backTracking(new Pipe(nextX, nextY, 2));
                }
            }else{
                //3.4.4 대각선은 다 된다.
                //주의할 점으로는 대각선은 파이프의 밑과 옆에도 벽이 있으면 안된다.
                    if(arr[pipe.x+1][pipe.y] == 0 && arr[pipe.x][pipe.y+1] == 0){
                    backTracking(new Pipe(nextX, nextY, 3));
                }
            }
        }
    }
}