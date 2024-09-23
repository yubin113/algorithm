import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int n,m,k;
	static int[] friendmoney;
	static int[] parent;
	static int[] minValue;
	static ArrayList<Integer> parentlist;
	
	static void make() {
		parent = new int[n+1];
		minValue = new int[n+1];
		Arrays.fill(parent, -1);
		for (int i = 0; i < friendmoney.length; i++) {
			minValue[i] = friendmoney[i];
		}
	}
	
	static int find(int a) {
		if(parent[a] < 0) {
			return a; 
		}else {
			return parent[a] = find(parent[a]);
		}
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return false;
		
		minValue[rootA] = Math.min(minValue[rootA], minValue[rootB]);
		parent[rootA] += parent[rootB];
		parent[rootB] = rootA;
		return true;
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		friendmoney = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			friendmoney[i] = Integer.parseInt(st.nextToken());
		}
		
		make();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int sortedNum1 = Math.max(num1, num2);
			int sortedNum2 = Math.min(num1, num2);
			union(sortedNum2, sortedNum1);
		}
		
		
		int cnt = 0;
		
		for (int i = 1; i < parent.length; i++) {
			if(parent[i] < 0) {
				cnt += minValue[i];
			}
		}
		
		if(cnt > k) {
			System.out.println("Oh no");
		}else {
			System.out.println(cnt);
		}

	}
}