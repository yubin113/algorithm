
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int[] persons;
	static int personSize;
	static int topLimit;
	static int result; 
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			st = new StringTokenizer(br.readLine());
			personSize = Integer.parseInt(st.nextToken());
			topLimit = Integer.parseInt(st.nextToken());
			
			persons = new int[personSize];
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < personSize; j++) {
				persons[j] = Integer.parseInt(st.nextToken());
			}
			
			result = Integer.MAX_VALUE;
			isSelected = new boolean[personSize];
			subSet(0, 0);
			
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void subSet(int cnt, int sum) {
		if(sum >= topLimit) {
			result = Math.min(result, Math.abs(topLimit - sum));
			return;
		}
		
		if(cnt == personSize) {
			int tmp = 0;
			for (int i = 0; i < isSelected.length; i++) {
				if(isSelected[i]) {
					tmp += persons[i];
				}
			}
			if(tmp < result) {
				result = Math.min(result, Math.abs(topLimit - sum));
			}
			return;
		}
		
		isSelected[cnt] = true;
		subSet(cnt + 1, sum + persons[cnt]);
		
		isSelected[cnt] = false;
		subSet(cnt + 1, sum);
	}
}
