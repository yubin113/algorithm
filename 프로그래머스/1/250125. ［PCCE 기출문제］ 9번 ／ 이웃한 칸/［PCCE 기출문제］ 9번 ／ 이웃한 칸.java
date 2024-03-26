class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        //1
        int n = board.length;

        //2 -> answer

        //3
        int[] dh = {0,1,-1,0};
        int[] dw = {1,0,0,-1};

        //4
        for (int i = 0; i < 4; i++) {
            //4-1
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            //4-2
            if(h_check >= 0 && h_check < n && w_check >= 0  && w_check < n){
                //4-2-a
                if(board[h][w].equals(board[h_check][w_check])) answer++;
            }
        }
        
        return answer;
    }
}