import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        ArrayList<Integer> lottosArrayList = new ArrayList<>();
        ArrayList<Integer> winNumsArrayList = new ArrayList<>();
        for (int i = 0; i < lottos.length; i++) {
            lottosArrayList.add(lottos[i]);
            winNumsArrayList.add(win_nums[i]);
        }

        int correctNumber = 0;
        int zeroNumber = 0;
        for (int i = 0; i < lottosArrayList.size(); i++) {
            if(lottosArrayList.get(i) == 0){
                zeroNumber++;
            } else if (winNumsArrayList.contains(lottosArrayList.get(i))) {
                correctNumber++;
            }
        }
        //[높은 순위, 낮은 순위]
        switch (correctNumber){
            case 6:
                answer[0] = 1;
                answer[1] = 1;
                break;
            case 5:
                answer[1] = 2;
                answer[0] = 2 - zeroNumber;
                break;
            case 4:
                answer[1] = 3;
                answer[0] = 3 - zeroNumber;
                break;
            case 3:
                answer[1] = 4;
                answer[0] = 4 - zeroNumber;
                break;
            case 2:
                answer[1] = 5;
                answer[0] = 5 - zeroNumber;
                break;
            default:
                answer[1] = 6;
                if(zeroNumber != 6) answer[0] = 6 - zeroNumber;
                else answer[0] = 1;
        }
        return answer;
    }
}