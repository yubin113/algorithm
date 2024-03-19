import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;


        ArrayList<Integer> lostArrayList = new ArrayList<>();

        for (int i = 0; i < lost.length; i++) {
            lostArrayList.add(lost[i]);
        }
        Collections.sort(lostArrayList);
        Arrays.sort(reserve);

        for (int i = 0; i < reserve.length; i++) {
            if(lostArrayList.contains(reserve[i])){
                lostArrayList.remove(lostArrayList.indexOf(reserve[i]));
                reserve[i] = -1;
                answer++;
            }
        }
        for (int i = 0; i < reserve.length; i++) {
            if(lostArrayList.contains(reserve[i])){
                answer++;
                lostArrayList.remove(lostArrayList.indexOf(reserve[i]));
            } 
            else if(lostArrayList.contains(reserve[i] - 1)){
                answer++;
                lostArrayList.remove(lostArrayList.indexOf(reserve[i] - 1));
            } else if (lostArrayList.contains(reserve[i] + 1)) {
                answer++;
                lostArrayList.remove(lostArrayList.indexOf(reserve[i] + 1));
            }
        }
        return answer;
    }
}