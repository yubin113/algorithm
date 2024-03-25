class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder("abcdefghijklmnopqrstuvwxyz");

        for (int i = 0; i < skip.length(); i++) {
            for (int j = 0; j < sb.length(); j++) {
                if(sb.charAt(j) == skip.charAt(i)){
                    sb.deleteCharAt(j);
                    break;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < sb.length(); j++) {
                if(sb.charAt(j) == s.charAt(i)){
                    int idx = j + index % sb.length();
                    if(idx > sb.length() - 1){
                        answer += sb.charAt(idx - sb.length());
                    }else{
                        answer += sb.charAt(idx);
                    }
                }
            }
        }
        return answer;
    }
}