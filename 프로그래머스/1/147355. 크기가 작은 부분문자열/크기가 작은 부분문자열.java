class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (long i = 0; i <= t.length() - p.length(); i++) {
            long num = Long.parseLong(t.substring((int) i, (int) (i + p.length())));
            if(num <= Long.parseLong(p)) answer++;
        }
        return answer;
    }
}