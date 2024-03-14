import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);

        for (int i = score.length - 1; i >= m - 1 ; i = i - m) {
            ArrayList<Integer> box = new ArrayList<>();
            for (int j = i; j > i - m; j--) {
                box.add(score[j]);
            }
            Collections.sort(box);
            int min = box.get(0);
            answer += min * m;
        }
        return answer;
    }
}