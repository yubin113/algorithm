import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static int[] arr;
	public static int[] visitedArr;
	public static boolean[] visited;
	public static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visitedArr = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		
		backTracking(0);
		
		System.out.println(sb);
	}
	public static void backTracking(int depth) {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(visitedArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			visitedArr[depth] = arr[i];
			backTracking(depth+1);
			visited[i] = true;
		}
	}
}
