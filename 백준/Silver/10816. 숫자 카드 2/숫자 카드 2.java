import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            
            sb.append(upperBound(num) - lowerBound(num)).append(' ');
        }
        
        System.out.println(sb);
        
    }
    public static int lowerBound(int key){
        int low = 0;
        int high = arr.length;
        
        while(low < high){
            int mid = (low + high) / 2;
            
            if(key <= arr[mid]) high = mid;
            else low =  mid + 1;
        }
        
        return low;
    }
    
    public static int upperBound(int key){
        int low = 0;
        int high = arr.length;
        
        while(low < high){
            int mid = (low + high) / 2;
            
            if(key < arr[mid]) high = mid;
            else low =  mid + 1;
        }
        
        return low;
    }
}