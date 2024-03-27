class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            if(!wallpaper[i].contains("#")) continue;
            if(luy > wallpaper[i].indexOf("#")) {
                luy = wallpaper[i].indexOf("#");   
            }
            if(lux > i) lux = i;
            if(rdy < wallpaper[i].lastIndexOf("#")){
                rdy = wallpaper[i].lastIndexOf("#");  
            }
            if(rdx < i) rdx = i;
        }

        rdy++;
        rdx++;
        
        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx;
        answer[3] = rdy;
        return answer;
    }
}