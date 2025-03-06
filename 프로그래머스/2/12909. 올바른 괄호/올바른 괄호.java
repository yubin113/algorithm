import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.empty()){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i) == '(' || stack.peek() == ')'){
                    stack.push(s.charAt(i));
                }else {
                    stack.pop();
                }
            }
        }
        
        if(!stack.empty()){
            answer = false;
        }
        
        return answer;
    }
}