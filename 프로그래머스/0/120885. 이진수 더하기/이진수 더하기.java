class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        int number1 = Integer.parseInt(bin1, 2);
        int number2 = Integer.parseInt(bin2, 2);

        int sum = number1 + number2;
        answer = Integer.toBinaryString(sum);
        
        return answer;
    }
}