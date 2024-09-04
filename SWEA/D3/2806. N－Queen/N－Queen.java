import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int N;
	static int[] col;
	
	static int answer;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			
			answer = 0;
			col = new int[N + 1];
			setQueen(1);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	static void setQueen(int row) {
		if(!check(row-1)) return;
		
		if(row > N) {
			answer++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			col[row] = i;
			setQueen(row + 1);
		}
	}
	static boolean check(int row) {
		for (int i = 1; i < row; i++) {
			if(col[row] == col[i] || row-i == Math.abs(col[row]-col[i])) {
				return false;
			}
		}
		return true;
	}
}