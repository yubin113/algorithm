import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        //1. 정렬
        Arrays.sort(citations);
        
        //2. 반복문 인용 갯수 감소, 인덱스 증가하면서 인용이 같거나 더큰 경우 정댭
        for(int i = 0; i < citations.length; i++){
            int len = citations.length - i;
            
            if(citations[i] >= len){
                answer = len;
                break;
            }
        }
        return answer;
    }
}