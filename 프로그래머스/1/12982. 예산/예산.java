class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        for (int i = 0; i < d.length; i++) {
            for (int j = i + 1; j < d.length; j++) {
                if (d[i] > d[j]) {
                    int tmp = d[i];
                    d[i] = d[j];
                    d[j] = tmp;
                }
            }
        }
        for (int i = 0; i < d.length; i++) {
            if(d[i] > budget) continue;
            int sum = d[i];
            int n = 1;
            for (int j = i + 1; j < d.length; j++) {
                if(sum + d[j] > budget) continue;
                sum += d[j];
                n++;
            }
            if(answer <= n){
                answer = n;
            }
        }
        return answer;
    }
}