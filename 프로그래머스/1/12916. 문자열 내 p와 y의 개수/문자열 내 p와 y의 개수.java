class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();
        System.out.println(s);

        int pnum = 0;
        int ynum = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'p') pnum++;
            if(s.charAt(i) == 'y') ynum++;
        }

        if(pnum != ynum) answer = false;

        return answer;
    }
}