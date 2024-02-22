class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer += ' ';
                continue;
            }
            if((int) s.charAt(i) <= 90){
                if((int) s.charAt(i) + n  > 90){
                    answer += (char) ((int) s.charAt(i) + n - 26);
                }else{
                    answer += (char) ((int) s.charAt(i) + n);

                }
            }else{
                if(((int) s.charAt(i) + n ) > 122){
                    answer += (char) ((int) s.charAt(i) + n - 26);
                }else{
                    answer += (char) ((int) s.charAt(i) + n);
                }
            }

        }
        return answer;
    }
}