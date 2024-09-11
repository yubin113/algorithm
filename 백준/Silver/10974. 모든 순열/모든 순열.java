import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N;
	static boolean[] visited;
	static int[] result;
	public static void main(String[] args) throws IOException{
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N];
		result = new int[N];
		permutation(0);
		System.out.println(sb);
	}
	static void permutation(int cnt) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[cnt] = i + 1;
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}
}