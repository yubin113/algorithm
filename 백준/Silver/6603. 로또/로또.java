import java.awt.image.Kernel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 로또
     * 핵심 풀이: 조합
     * 1. 인풋 받는다. while문에서 한줄씩 받고 첫번째 k를 받고 k가 0이 아니면 테케 진행
     * 2. 숫자 배열 저장
     * 3. 조합 만들기(visited, result, cnt, idx)
     *      3.1 기저 조건: cnt == 6 정렬시키고 sb 넣기
     * 4. 한 테케 끝나면 빈 칸 한줄 넣기
     * 5. 테케 끝나면 sb 출력
     */

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int k;
    static int[] arr;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        //1. 인풋 받는다. while문에서 한줄씩 받고 첫번째 k를 받고 k가 0이 아니면 테케 진행
        while (true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            //2. 숫자 배열 저장
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //3. 조합 만들기(visited, result, cnt, idx)
            visited = new boolean[k];
            result = new int[6];
            combination(0,0);
            //4. 한 테케 끝나면 빈 칸 한줄 넣기
            sb.append("\n");
        }
        //5. 테케 끝나면 sb 출력
        System.out.println(sb);
    }
    static void combination(int cnt, int idx){
        //3.1 기저 조건: cnt == 6 정렬시키고 sb 넣기
        if(cnt == 6){
            Arrays.sort(result);
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < k; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[cnt] = arr[i];
                combination(cnt + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}