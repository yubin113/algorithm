class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int sum = 0;
        for (int i = 1; i < a; i++) {
            if(i == 2) sum += 29;
            else if (i <= 7) {
                if(i % 2 != 0) sum += 31;
                else sum += 30;
            }else{
                if( i % 2 == 0) sum += 31;
                else sum += 30;
            }
        }
        int result = (sum + b) % 7;
        if((result + 5) > 7){
            answer = week[result - 3];
        }else{
            answer = week[result + 4];
        }
        return answer;
    }
}