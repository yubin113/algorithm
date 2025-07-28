import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 1; i <= elements.length; i++){  //길이
            for(int j = 0; j < elements.length; j++){   //수열 시작
                int sum = 0;
                for(int k = j; k < j+i; k++){   //부분 수열 합
                    sum += elements[k % elements.length];
                }
                hashMap.putIfAbsent(sum, 1);
            }               
        }
        answer = hashMap.size();
        return answer;
    }
}