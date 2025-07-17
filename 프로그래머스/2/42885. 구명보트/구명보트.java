import java.io.*;
import java.util.*;

//최대 2명, 무게 제한
//answer: 모든 사람을 구출하기 위해 필요한 구명보틑 개수의 최솟값
//생각1: 배열 정렬 -> 최소 애들끼리 먼저 보낸 후 -> /2했을 때 넘는 경우 이제는 그냥 한명씩밖에 못탐
//문제 잘못 읽음 최대 2명을 여러명으로 생각함
//생각2: 가벼운 사람과 무거운 사람이 짝이 된다면 그렇게 보내는걸로

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        //1. 배열 정렬
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            if(people[left] + people[right] <= limit){
                answer++;
                left++;
                right--;
                continue;
            }
            
            answer++;
            right--;
        }
        return answer;
    }
}