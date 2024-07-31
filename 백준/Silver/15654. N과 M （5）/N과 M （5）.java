import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static int[] arr;
	public static StringBuilder sb;
	public static boolean[] visited;
	public static int[] visitedArr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		visitedArr = new int[N]; 
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
		}
		
		for (int j = 0; j < N; j++) {
			if(!visited[j]) {
				visited[j] = true;
				visitedArr[depth] = arr[j];
				backTracking(depth+1);
				visited[j]=false;
			}
		}

		
	}
}
