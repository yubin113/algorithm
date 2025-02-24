import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    static StringBuilder sb;

    public String solution(String s) throws IOException {
        sb = new StringBuilder();

        String[] input = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            int num = Integer.parseInt(input[i]);

            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }

        sb.append(min).append(" ").append(max);
        return sb.toString();
        
    }
}