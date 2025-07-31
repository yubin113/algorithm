class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n][n];
        //초기화
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i==j){
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = 1000000;
            }
        }
        
        //가중치
        for(int i = 0; i < fares.length; i++){
            int start = fares[i][0]-1;
            int end = fares[i][1]-1;
            int value = fares[i][2];
            
            //양방향
            dist[start][end] = Math.min(dist[start][end], value);
            dist[end][start] = Math.min(dist[end][start], value);
        }
        
        //플로이드-워셜 알고리즘
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
        
        //각자 간 경우
        int answer = dist[s-1][a-1] + dist[s-1][b-1];
        //경유지있는 경우
        for(int i = 0; i < n; i++){
            answer = Math.min(answer, dist[s-1][i] + dist[i][a-1] + dist[i][b-1]);
        }
        return answer;
    }
}