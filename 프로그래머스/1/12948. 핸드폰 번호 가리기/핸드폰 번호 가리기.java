class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int len = phone_number.substring(0, phone_number.length() - 4).length();
        for (int i = 0; i < len; i++) {
            answer += '*';
        }
        answer += phone_number.substring(phone_number.length() - 4);
        return answer;
    }
}