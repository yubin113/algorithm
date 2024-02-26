import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1,2,3,4,5};
       int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
       int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

       int result1 = 0;
       int result2 = 0;
       int result3 = 0;
       for (int i = 0; i < answers.length; i++) {
            if(answers[i] == person1[i % person1.length])
                result1++;
            if(answers[i] == person2[i % person2.length])
                result2++;
            if(answers[i] == person3[i % person3.length])
                result3++;
       }

       ArrayList<Integer> arr = new ArrayList<>();

       int max = Math.max(result1, result2);
       max = Math.max(max, result3);
       if(result1 == result2 && result2 == result3){
           arr.add(1);
           arr.add(2);
           arr.add(3);
       } else if (max == result1 && max == result2) {
           arr.add(1);
           arr.add(2);
       } else if (max == result2 && max == result3) {
           arr.add(2);
           arr.add(3);
       } else if (max == result1 && max == result3) {
           arr.add(1);
           arr.add(3);
       } else {
           arr.add(max == result1 ? 1 : max == result2 ? 2 : 3);
       }
       int[] answer = new int[arr.size()];
       for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
       }
        return answer;
    }
}