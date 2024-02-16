class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int remainder = 0;
        while(chicken != 0){
            answer += chicken / 10;
            remainder += chicken % 10;
            chicken /= 10;
        }
        int remainder2 = 0;
        while(remainder != 0){
            answer += remainder / 10;
            remainder2 += remainder %10;
            remainder /= 10;
        }
         while(remainder2 != 0){
            answer += remainder2 / 10;
            remainder2 /= 10;
        }
        
        
        return answer;
    }
}