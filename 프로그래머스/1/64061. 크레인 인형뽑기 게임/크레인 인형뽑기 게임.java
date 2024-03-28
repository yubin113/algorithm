import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j <= board.length - 1; j++) {
                if(board[j][moves[i] - 1] != 0){
                    if(stack.size() != 0 && stack.peek() == board[j][moves[i] - 1]){
                        answer = answer + 2;
                        stack.pop();
                        board[j][moves[i] - 1] = 0;
                        break;
                    }
                    stack.push(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}