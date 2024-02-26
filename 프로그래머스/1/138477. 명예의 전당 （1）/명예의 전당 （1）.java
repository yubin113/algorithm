import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> hallOfFrame = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            hallOfFrame.add(score[i]);
            Collections.sort(hallOfFrame);
            if(i >= k) {
                hallOfFrame.remove(0);
            }
            answer[i] = hallOfFrame.get(0);
        }
        return answer;
    }
}