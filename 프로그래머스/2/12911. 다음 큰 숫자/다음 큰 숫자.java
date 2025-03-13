import java.io.*;
import java.util.*;
class Solution {
    //Integer.toBinaryString()
    //1. 입력된 n을 2진수로 변환
    //2. 변환된 2진수의 비트가 1인 개수를 카운팅
    //3. n+1부터 위 과정을 반복해 앞서 구한 개수의 일치하는 수를 찾기
    public int solution(int n) {
        int answer = 0;
        
        //1
        String binaryString = Integer.toBinaryString(n);
        //2
        int oneCount = 0;
        for(int i = 0; i < binaryString.length(); i++){
            if(binaryString.charAt(i)=='1') oneCount++;
        }
        //3
        for(int i = n+1; i <= 1000000; i++){
            String temp = Integer.toBinaryString(i);
            int tempOneCount = 0;
            for(int j = 0; j < temp.length(); j++){
                if(temp.charAt(j)=='1') tempOneCount++;
            }
            if(tempOneCount==oneCount){
                answer = i;
                break;
            }
        }
        return answer;
    }
}