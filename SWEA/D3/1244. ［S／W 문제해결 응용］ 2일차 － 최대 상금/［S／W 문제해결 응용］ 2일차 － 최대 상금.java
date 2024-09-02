import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int TC;
    static int[] arr;
    static int swapNum;
    static int max;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            arr = new int[str.length()];
            swapNum  = Integer.parseInt(st.nextToken());

            for (int i = 0; i < arr.length; i++) {
                arr[i] = str.charAt(i) - '0';
            }

            if(swapNum > arr.length) swapNum = arr.length;
            max = Integer.MIN_VALUE;
            DFS(0,0);

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
    static void DFS(int cnt, int idx){
        if(cnt == swapNum) {
            int result = 0;
            for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
                result += (arr[j] * Math.pow(10, i));
            }
            max = Math.max(result, max);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(i,j);
                DFS(cnt + 1, i);
                swap(i,j);
            }
        }
    }
    static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
