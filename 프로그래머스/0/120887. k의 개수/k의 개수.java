class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int l = i; l <= j; l++) {
            answer += Integer.toString(l).length() - Integer.toString(l).replaceAll(Integer.toString(k), "").length();
        }
        return answer;
    }
}