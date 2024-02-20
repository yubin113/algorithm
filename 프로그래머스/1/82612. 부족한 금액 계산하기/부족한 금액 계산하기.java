class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        long charge = 0;
        int multi = 1;
        for (int i = 1; i <= count; i++) {
            charge += price * (i * multi);
        }
        if(money - charge > 0){
            answer = 0;
        }else{
            answer = -(money - charge);
        }

        return answer;
    }
}