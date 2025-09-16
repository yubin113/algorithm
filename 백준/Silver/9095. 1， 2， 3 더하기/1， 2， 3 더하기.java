import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
    static int T;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        
        arr = new int[12];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        
        for(int i = 4; i < 11; i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        for(int tc = 0; tc < T; tc++){
            int num = Integer.parseInt(br.readLine());
            sb.append(arr[num]+"\n");
        }
        
        System.out.println(sb);
    }
}