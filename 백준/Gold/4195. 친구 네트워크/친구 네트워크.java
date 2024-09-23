import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int relationNum;
	static HashMap<String, Integer> hashMap;
	
	static int[] parent;
	static int[] cnt;
	static void make() {
		parent = new int[200001];
		cnt = new int[200001];
		Arrays.fill(parent, -1);
		Arrays.fill(cnt, 1);
	}
	
	static int find(int a) {
		if(parent[a] < 0) return a;
		
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) {
			sb.append(cnt[rootA]).append("\n");
			return false;
		}
		
		cnt[rootA]+= cnt[rootB];
		parent[rootA] += parent[rootB];
		parent[rootB] = rootA;
		sb.append(cnt[rootA]).append("\n");
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for (int i = 0; i < TC; i++) {
			hashMap = new HashMap<>();
			int n = 1;
			make();
			relationNum = Integer.parseInt(br.readLine());
			for (int j = 0; j < relationNum; j++) {
				st = new StringTokenizer(br.readLine());
				String[] friends = new String[2];
				friends[0] = st.nextToken();
				friends[1] = st.nextToken();
				
				Arrays.sort(friends);
				
				if(!hashMap.containsKey(friends[0])) {
					hashMap.put(friends[0], n++);
				}
				if(!hashMap.containsKey(friends[1])) {
					hashMap.put(friends[1], n++);
				}
				
				
				union(hashMap.get(friends[0]), hashMap.get(friends[1]));
				
				
			}
		}
		System.out.println(sb);
	}
}