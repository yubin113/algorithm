class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {0,0};
        answer[0] = gcd(n, m);
        answer[1] = (n * m) / answer[0];
        
        return answer;
    }
    public static int gcd(int a, int b){
        int r = 0;
        while (b != 0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}