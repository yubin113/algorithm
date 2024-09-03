import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int TC = 1;
		
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("Problem " +  + TC  + ": " + getMinTime(0, 0, N - 1, N-1));	
			TC++;
		}

	}
	static int getMinTime(int sr, int sc, int er, int ec) {
		final int INF = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];
		PriorityQueue<int[]> pQueue = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}
		
		minTime[0][0] = map[0][0];
		pQueue.offer(new int[] {sr,sc, minTime[0][0]});
		 
		 while(!pQueue.isEmpty()) {
			 int[] stopOver = pQueue.poll();
			 int r = stopOver[0];
			 int c = stopOver[1];
			 int time = stopOver[2];
			 
			 if(visited[r][c]) continue;
			 visited[r][c] = true;
			 
			 if(r==er && c==ec) return time;
			 
			 for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>=0 && nr < N && nc>=0 && nc < N && !visited[nr][nc] && minTime[nr][nc] > time + map[nr][nc]) {
					minTime[nr][nc] = time + map[nr][nc];
					pQueue.offer(new int[] {nr,nc, minTime[nr][nc]});
				}
			}
			 
		 }
		 return -1;
	}
}