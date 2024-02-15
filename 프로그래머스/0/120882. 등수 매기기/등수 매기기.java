class Solution {
    public int[] solution(int[][] score) {
        int[] avglist = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            avglist[i] = (score[i][0] + score[i][1]);
        }
        int[] sortedlist = new int[avglist.length];
        for (int i = 0; i < avglist.length; i++) {
            sortedlist[i] = avglist[i];
        }
        for (int i = 0; i < sortedlist.length; i++) {
            for (int j = i + 1; j < sortedlist.length; j++) {
                if (sortedlist[i] < sortedlist[j]) {
                    int tmp = sortedlist[i];
                    sortedlist[i] = sortedlist[j];
                    sortedlist[j] = tmp;
                }
            }

        }

        int[] answer = new int[score.length];
        int rank = 1;
        int max = 0;
        for (int i = 0; i < score.length; i++) {
            if(max == sortedlist[i]) {
                rank++;
                continue;
            }
            max = sortedlist[i];
            int idx = 0;
            for (int j = 0; j < avglist.length; j++) {
                if(max == avglist[j]){
                    answer[j] = rank;
                    idx++;
                }
            }
            rank++;
        }
        return answer;
    }
}