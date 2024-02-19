class Solution {
    public int[] solution(long n) {
        int[] tmp = new int[11];
        int idx = 0;
        while(n != 0){
            tmp[idx++] = (int) (n % 10);
            n /= 10;
        }
        int[] answer = new int[idx];
        for (int i = 0; i < idx; i++) {
            answer[i] = tmp[i];
        }
        return answer;
    }
}