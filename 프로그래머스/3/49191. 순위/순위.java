class Solution {
    static int[][] dist;
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        dist = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                else dist[i][j] = 100000000;
            }
        }
        
        for(int i = 0; i < results.length; i++){
            dist[results[i][1]-1][results[i][0]-1] = 1;
        }
        
        for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
        
        for (int i = 0; i < n; i++) {
    int count = 0;
    for (int j = 0; j < n; j++) {
        if (i == j) continue;
        // i가 j를 이겼거나, 졌거나 하면 count++
        if (dist[i][j] < 100000000 || dist[j][i] <          100000000) {
            count++;
        }
    }
    if (count == n - 1) answer++; // 모든 선수와의 승패가 결정됨
    }
        return answer;
    }
}