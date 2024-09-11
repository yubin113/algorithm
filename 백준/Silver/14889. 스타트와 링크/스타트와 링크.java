import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/**
	 * 스타트와 링크
	 * 핵심 풀이: 조합, 이중반복문으로 같은 팀인지 확인하는 것
	 * 
	 * 1. 인풋 케이스 받기(N, arr)
	 * 2. 조합(visited)으로 N/2명씩 두팀을 만든다.
	 * 3. 이중 반복문을 돌면서 두 애들이 같은 팀인지 확인하면 더하기 시켜준다.
	 * 4. 최종적으로 나온 값중 최소값을 구한다.(answer)
	 * 
	 */
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		//1. 인풋 케이스 받기(N, arr)
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//2. 조합(visited)으로 N/2명씩 두팀을 만든다.
		visited = new boolean[N];
		answer = Integer.MAX_VALUE;
		combination(0,0);
		
		System.out.println(answer);
		
	}
	static void combination(int cnt, int idx) {
		// 기저조건: N/2명 조합 만들었을때 true인 애듫은 A팀, false인 애들은 B팀
		if(cnt == N / 2) {
//			for (int i = 0; i < N; i++) {
//				System.out.print(visited[i] ? i : " ");
//			}
//			System.out.println();
			
			//3. 이중 반복문을 돌면서 두 애들이 같은 팀인지 확인하면 더하기 시켜준다.
			//4. 최종적으로 나온 값중 최소값을 구한다.(answer)
			answer = Math.min(answer, checkTeam(visited));
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(cnt + 1, i + 1);
				visited[i] = false;
			}
		}
	}
	
	static int checkTeam(boolean[] visited) {
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i] && visited[j]) {
					sumA += arr[i][j];
				}else if(!visited[i] && !visited[j]) {
					sumB += arr[i][j];
				}
			}
		}
		
		return Math.abs(sumA - sumB);
	}
}