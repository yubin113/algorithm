class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n / a != 0){
            int num = (n / a) * b;
            n = n - ((a * (n /a))- num);
            answer += num;
        };
        return answer;
    }
}