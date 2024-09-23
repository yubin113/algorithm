import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int N;
	static int[] parent;
	static int[] cnt;
	
	static void make() {
		parent = new int[1000001];
		cnt = new int[1000001];
		Arrays.fill(parent, -1);
		Arrays.fill(cnt, 1);
	}
	
	static int find(int a) {
		if(parent[a] < 0) {
			return a;
		}else {
			return parent[a] = find(parent[a]);
		}
	}
	
	static boolean union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		
		if(fa == fb) {
			return false;
		}else {
			parent[fa] += parent[fb];
			parent[fb] = fa;
			cnt[fa] += cnt[fb];
			return true;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		make();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			
			if(word.equals("I")) {
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				int min1 = Math.max(num1, num2);
				int min2 = Math.min(num1, num2);
				union(min1, min2);
			}else {
				int num = Integer.parseInt(st.nextToken());
				sb.append(cnt[find(num)] + "\n");
			}
		}
		
		System.out.println(sb);
		
	}
}