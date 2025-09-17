import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static StringTokenizer st;
    
    static int N, sum;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        sum = 0;
        int tmp = N;
        for(int i = 0; i < N; i++){
            sum += arr[i] * tmp--;
        }
        System.out.println(sum);
    }
}