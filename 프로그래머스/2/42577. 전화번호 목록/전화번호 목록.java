import java.util.*;
import java.io.*;
class Solution {
    static HashMap<String, Integer> hashMap;
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        //해시맵
        hashMap = new HashMap<>();
        for(int i = 0 ; i < phone_book.length; i++){
            hashMap.put(phone_book[i], i);
        }
        
        //확인
        for(int i = 0 ; i < phone_book.length; i++){
            for(int j = 0 ; j < phone_book[i].length(); j++){
                if(hashMap.containsKey(phone_book[i].substring(0,j)))
                    answer = false;
            }
        }
        return answer;
    }
}