import java.util.*;

//순열
class Solution {
    static int result = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        permutation(dungeons, 0, dungeons.length, dungeons.length, k);
        answer = result;
        return answer;
    }
    
    static void permutation(int[][] arr, int depth, int n, int r, int k){
        if(depth == r){
            //순서대로 피로도 계산
            result = Math.max(result, calc(arr, k));
            return;
        }
        
        for(int i = depth; i < n; i++){
            swap(arr, depth, i);
            permutation(arr, depth+1, n, r, k);
            swap(arr, depth, i);
        }
    }
    static void swap(int[][] arr, int depth, int i){
        int[] tmp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = tmp;
        
    }
    static int calc(int[][] arr, int k){
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            if(k >= arr[i][0]){
                k -= arr[i][1];
                result++;
            }
        }
        return result;
    }
}