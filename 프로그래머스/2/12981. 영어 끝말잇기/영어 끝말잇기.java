import java.util.*;
import java.io.*;

//map 이용
//첫번째 단어일 경우, 그냥 넣기
//두번째 단어이상일때부터
    //if: 이전에 들어갔던 단어 맨 마지막 알파벳와 현재 비교 단어 제일 첫 번째 알파벳 비교 && map에 해단 단어가 없는지 확인
        //true: map에 넣기
        //else:  번호는 i% 3, + 1, i / n
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        HashMap<String, Integer> hashMap = new HashMap<>();

        String last = "";
        for(int i = 0; i < words.length; i++){
            //첫번째 단어일 경우, 그냥 넣기
            if(i == 0){
                hashMap.put(words[i], 0);
            }else{
                //두번째 단어이상일때부터
                //if: 이전에 들어갔던 단어 맨 마지막 알파벳와 현재 비교 단어 제일 첫 번째 알파벳 비교 && map에 해단 단어가 없는지 확인
                if(last.charAt(last.length()-1) == words[i].charAt(0) 
                  && !hashMap.containsKey(words[i])){
                    //true: map에 넣기
                    hashMap.put(words[i],0);
                }else{
                    //else:  번호는 i% 3 + 1, i / n
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    break;
                }
            }
                last = words[i];
        }

        return answer;
    }
}