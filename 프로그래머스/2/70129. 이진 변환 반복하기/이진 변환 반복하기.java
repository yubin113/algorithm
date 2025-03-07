class Solution {
    public int[] solution(String s) {
        
                int count_0 = 0;
        int count = 0;
        while(!s.equals("1")){
            count++;
            int count_1 = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') count_0++;
                else count_1++;
            }

            s = Integer.toBinaryString(count_1);
        }
        
        
        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = count_0;
        return answer;
    }
}