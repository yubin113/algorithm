
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] unf;
	public static int Find(int v) {
		if(v == unf[v]) return v;
		return unf[v] = Find(unf[v]);
	}
	public static void union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		if(fa != fb) {
			if( fa < fb ) {
				unf[fb] = fa;
			}else {
				unf[fa] = fb;
			}
		}
	}
	
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int TC;
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		unf = new int[N+1];
		for (int i = 1; i <= N; i++) {
				unf[i] = i;
		}
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(check == 0) {
				union(a,b);
			}else {
				int fa = Find(a);
				int fb = Find(b);
				if(fa == fb) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		System.out.print(sb.toString());	
	}
}
