import java.util.*;
//1. s의 크기마다 반복
//2. 회전
//3. 올바른 괄호 문자열인지 확인
class Solution {
    static String rs = "";
    public int solution(String s) {
        int answer = 0;
        rs = new String(s);
        for(int i = 0; i < rs.length(); i++){
            //회전
            rotate();
            //확인
            if(isRight()) answer++;
        }
        return answer;
    }
    public void rotate(){
        //마지막꺼 기억한 뒤, 앞에꺼 땡겨주고 제일 첫번째에 넣기
        char last = rs.charAt(rs.length()-1);
        String tmp = rs.substring(0,rs.length()-1);
        rs = last + tmp;
    }
    public boolean isRight(){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < rs.length(); i++){
            Character c = rs.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                if(c == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
                else if(c == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                else if(c == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}