class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        
        String a = A;
       //오른쪽으로 밀기
        for (int i = 0; i < A.length(); i++) {
            if(a.equals(B)) return answer;
            String tmp = a.substring(A.length() - 1);
            a = tmp + a.substring(0 , A.length() - 1);
            answer++;
        }
        
        return -1;
    }
}