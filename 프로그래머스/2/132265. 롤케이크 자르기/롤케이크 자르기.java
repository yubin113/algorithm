import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        if(topping.length <= 1) answer = 0;
        else{
            HashMap<Integer, Integer> leftMap = new HashMap<>();
            HashMap<Integer, Integer> rightMap = new HashMap<>();
                
            // 처음엔 전부 오른쪽에 있음 (개수로 보관)
            for (int t : topping) {
                rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
            }
            // i를 경계로 [0..i] / [i+1..n-1] 이어야 하므로 n-1까지만 순회
            for(int i = 0; i < topping.length - 1; i++){
                int t = topping[i];
                
                // 왼쪽으로 이동
                leftMap.put(t, leftMap.getOrDefault(t, 0) + 1);
                
                // 오른쪽에서 제거
                int rc = rightMap.get(t) - 1;
                if (rc == 0) rightMap.remove(t);
                else rightMap.put(t, rc);
                    
                if(leftMap.size() == rightMap.size()) answer++;
            }
        }

        return answer;
    }
}