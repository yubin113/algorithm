import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < ingredient.length; i++) {
            s.append(ingredient[i]);
        }

        for (int i = 0; i < s.length() - 3; i++) {
            if(s.substring(i, i + 4).equals("1231")){
                answer++;
                s = s.delete(i, i + 4);
                i -= 4;
                if(i<0) i = -1;
            }
        }
        
        return answer;
    }
}