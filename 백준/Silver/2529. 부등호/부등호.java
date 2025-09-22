import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static StringTokenizer st;
    static int[] arr = {0,1,2,3,4,5,6,7,8,9};
    static int[] num;
    static boolean[] isvisited;
    
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    static int k;
    static char[] signs;
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        signs = new char[k];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < k; i++){
            signs[i] = st.nextToken().charAt(0);
        }
        
        num = new int[k+1];
        isvisited = new boolean[10];
        
        backtracking(0);
        
        //0붙이기
        String maxStr = Long.toString(max);
        int maxL = maxStr.length();
        if(maxL < k+1){
            for(int i = 0; i < k+1 - maxL; i++){
                maxStr = '0' + maxStr;
            }
        }
        String minStr = Long.toString(min);
        int minL = minStr.length();
        if(minL < k+1){
            for(int i = 0; i < k+1 - minL; i++){
                minStr = '0' + minStr;
            }
        }
        System.out.println(maxStr);
        System.out.println(minStr);
        
    }
    
    static void backtracking(int idx){
        //기저 조건
        if(idx == k+1){
            //int: 2,xxx,xxx,xxx(10자리수 다 못 담음)
            long tmp = 0;
            for(int i = 0; i < k+1; i++){
                tmp = tmp * 10 + num[i];
            }
                        
            if(max < tmp) max = tmp;
            if(min > tmp) min = tmp;
            
            return;
        }
        
        for(int i = 0; i <= 9; i++){
            if(isvisited[i]) continue;
            
            //여기서 가지치기
            if(idx > 0){
                char sign = signs[idx-1];
                if(sign == '<' && !(num[idx-1] < i)) continue;
                if(sign == '>' && !(num[idx-1] > i)) continue;
            }
            
            isvisited[i] = true;
            num[idx] = i;
            backtracking(idx+1);
            isvisited[i] = false;
        }
    }
}