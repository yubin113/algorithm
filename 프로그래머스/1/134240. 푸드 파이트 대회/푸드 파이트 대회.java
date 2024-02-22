class Solution {
    public String solution(int[] food) {
        String answer = "";
        for (int i = 1; i < food.length; i++) {
            int div = food[i] / 2;
            for (int j = 0; j < div; j++) {
                answer += Integer.toString(i);
            }
        }
        answer += '0';
        for (int i = food.length - 1; i >= 1; i--) {
            int div = food[i] / 2;
            for (int j = 0; j < div; j++) {
                answer += Integer.toString(i);
            }
        }
        return answer;
    }
}