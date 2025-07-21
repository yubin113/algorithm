import java.io.*;
import java.util.*;

//서로 다른 종류의 수의 최솟값  구하기
//k: 한 상자에 담으려는 귤의 갯수
//tangerine: 귤의 크기를 담은 배열

//풀이 방법: 귤의 개수가 많은 애들부터 먼저 고르기
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            if(hashMap.containsKey(tangerine[i])){
                hashMap.put(tangerine[i], hashMap.get(tangerine[i]) + 1);
            }else{
                hashMap.put(tangerine[i], 1);
            }
        }
        
        //해시맵 정렬
        List<Integer> keySet = new ArrayList<>(hashMap.keySet());
        keySet.sort((o1, o2) -> hashMap.get(o2) - hashMap.get(o1));
        

        for(int i = 0; i < keySet.size(); i++){
            int key = keySet.get(i);         // 귤 크기
            int count = hashMap.get(key);    // 해당 크기의 개수
            k -= count;                      // 귤 개수 차감
            answer++;
            
            if(k <= 0) break;
        }
        
        return answer;
    }
}