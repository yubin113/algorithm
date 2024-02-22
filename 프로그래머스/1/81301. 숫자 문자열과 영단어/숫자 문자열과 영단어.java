class Solution {
    public int solution(String s) {
        int answer = 0;
        String tmp = "";
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        while(!s.isEmpty()){
            if((int)s.charAt(0) <= (int) '9'){
                tmp += s.charAt(0);
                s = s.substring(1);
            }else{
                for (int j = 0; j < numbers.length; j++) {
                    if(s.substring(0, s.length() >= 5 ? 5 : s.length() == 4 ? 4 : 3).contains(numbers[j])){
                        tmp += Integer.toString(j);
                        s = s.substring(numbers[j].length());
                        break;
                    }
                }
            }
        }
        answer = Integer.parseInt(tmp);
        return answer;
    }
}