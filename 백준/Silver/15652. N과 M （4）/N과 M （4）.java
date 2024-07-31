import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static int[] arr;
	public static boolean[] visited;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		sb = new StringBuilder();
		
		backTracking(0,0);
		
		System.out.println(sb);
	}
	
	public static void backTracking(int level, int at) {
		if(level == M) {
			
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = at; i < N; i++) {
			visited[i] = true;					
			arr[level] = i + 1;
			backTracking(level+1, i);
			visited[i] = false;
		}
	}
}