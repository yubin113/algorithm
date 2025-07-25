import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while(n != 0){
            //홀수
            if(n % 2 != 0){
                n--;
                ans++;
                continue;
            }else{
                //짝수
                n /= 2;
            }
        }

        return ans;
    }
}