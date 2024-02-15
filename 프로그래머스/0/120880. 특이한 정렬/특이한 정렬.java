class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] gaplist = new int[numlist.length];
        int[] abslist = new int[numlist.length];
        for(int i = 0; i < gaplist.length; i++) {
            gaplist[i] = numlist[i] - n;
            if(gaplist[i] < 0) abslist[i] = -gaplist[i];
            else abslist[i] = gaplist[i];
        }
        
        int idx = -1;
        int[] answer = new int[numlist.length];
        for (int i = 0; i < abslist.length; i++) {
            int max = 10000;
            for (int j = 0; j < abslist.length; j++) {
               if(max >= abslist[j]) {
                    if(max > abslist[j]){
                        max = abslist[j];
                        idx = j;
                    }else{
                        if(gaplist[j] < 0){
                            continue;
                        }else{
                            max = abslist[j];
                            idx = j;
                        }
                    }
                }
            }
            answer[i] = numlist[idx];
            abslist[idx] = 20000;
        }
        return answer;
    }
}