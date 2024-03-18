class Solution {
    public int solution(String s) {
        int answer = 0;
        while(s.length() > 1){
            int xNumber = 1;
            int notXNumber = 0;
            char x = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if(s.charAt(i) == x) xNumber++;
                else notXNumber++;

                if(xNumber == notXNumber){
                    answer++;
                    s = s.substring(i + 1);
                    break;
                }
                if(i== s.length() - 1){
                    answer++;
                    s = "";
                }
            }
        }
        if(s.length() == 1) answer++;
        return answer;
    }
}