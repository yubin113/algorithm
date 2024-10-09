import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.StringTokenizer;

public class Main {
    /**
     * 문제: 연구소 3
     * 풀이: 조합 + BFS
     */

    static BufferedReader br;
    static StringTokenizer st;

    static int N; //연구소 크기
    static int M; //바이러스 개수
    static int[][] arr; //연구소 상태
    static int[] dx = {-1,1,0,0};  //4방 탐색
    static int[] dy = {0,0,-1,1};
    static boolean[][] isChecked; //방문확인
    static boolean[] isSelected; //조합선택
    static ArrayList<Node> virusList;  //바이러스리스트
    static Node[] selectedVirus; //조합 선택된 바이러스들
    static int result = Integer.MAX_VALUE;
    static class Node{
        int x,y;
        int sum;  //시간 계산용
        Node(int x, int y, int sum){
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        //N,M
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //arr, virusList
        arr = new int[N][N];
        virusList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                //벽은 -1, 바이러스는 -2로 두기
                //바이러스 리스트안에넣기
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    arr[i][j] = -1;  //벽
                } else if (num == 2) {
                    //바이러스
                    arr[i][j] = -2;
                    virusList.add(new Node(i,j,0));
                }else{
                    arr[i][j] = num;
                }
            }
        }

        //조합 구하기
        isSelected = new boolean[virusList.size()];
        selectedVirus = new Node[M];
        Combination(0,0);

        if(result == Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(result);
        }

    }

    static void Combination(int at, int cnt){
        if(cnt == M){
            //조합으로 M개 구해진 상태(selectedVirus)
            //BFS 돌리기
            //배열 복사본 필요
            int[][] copiedArr = new int[N][N];
            isChecked = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    copiedArr[i][j] = arr[i][j];
                }
            }
            BFS(copiedArr, selectedVirus, isChecked);
            //최저값인지 확인
            int maxTime = findMaxTime(copiedArr);
            if(maxTime != -1){
                result = Math.min(result, maxTime);

            }
            return;
        }

        for (int i = at; i < virusList.size(); i++) {
            if(!isSelected[i]){
                isSelected[i] = true;
                selectedVirus[cnt] = virusList.get(i);
                Combination(i+1, cnt+1);
                isSelected[i] = false;
            }
        }
    }
    static void BFS(int[][] arr, Node[] selectedVirus, boolean[][] isChecked){
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            queue.add(selectedVirus[i]);
            isChecked[selectedVirus[i].x][selectedVirus[i].y] = true;
        }

        while(!queue.isEmpty()){
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)  continue;  //경계 확인
                if(arr[nextX][nextY] == -1) continue;  //벽
                if(isChecked[nextX][nextY]) continue;  //방문했던 곳

                //빈칸
                isChecked[nextX][nextY] = true;
                if(arr[nextX][nextY] != -2){
                    arr[nextX][nextY] = now.sum + 1;
                }
                queue.add(new Node(nextX, nextY, now.sum+1));
            }
        }
    }

    static int findMaxTime(int[][] arr) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    return -1; // 빈 칸이 남아 있다면 바이러스를 모두 퍼뜨릴 수 없음
                }
                if (arr[i][j] > 0) {
                    max = Math.max(max, arr[i][j]);
                }
            }
        }
        return max;
    }
}