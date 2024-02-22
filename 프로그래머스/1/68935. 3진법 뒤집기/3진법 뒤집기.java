class Solution {
    public int solution(int n) {
        String changed1 = Integer.toString(n, 3);
        String changed2 = "";
        for (int i = changed1.length() - 1; i >= 0; i--) {
            changed2 += changed1.charAt(i);
        }
        int answer = Integer.parseInt(changed2, 3);
        return answer;
    }
}