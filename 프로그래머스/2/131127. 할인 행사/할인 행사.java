import java.util.*;
import java.io.*;
class Solution {
    static StringBuilder stringBuilder;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        //물품 갯수 해시맵
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            hashMap.put(want[i], number[i]);
        }
        
        //일자별로 이제 확인
        for(int i = 0; i <= discount.length - 10; i++){
            HashMap<String, Integer> tHashMap = new HashMap<>();
            for(int j = i; j < i + 10; j++){
                if(tHashMap.containsKey(discount[j])){
                    tHashMap.replace(discount[j], tHashMap.get(discount[j])+1);
                }else{
                    tHashMap.put(discount[j],1);
                }
                
                //해시맵 같은지 확인
                Boolean check = true;
                for(String key: hashMap.keySet()){
                    if(hashMap.get(key) != tHashMap.get(key)){
                        check = false;
                        break;
                    }
                }
                if(check){
                    answer++;
                }
            }            
            
        }
        
        return answer;
    }
}