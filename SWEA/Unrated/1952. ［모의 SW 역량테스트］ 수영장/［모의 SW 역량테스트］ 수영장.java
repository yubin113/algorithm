
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int[] InputMoney = new int[4];
	static int[] months = new int[12];
	
	static int result;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				InputMoney[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				months[i] = Integer.parseInt(st.nextToken());
			}
			
			result = Integer.MAX_VALUE;
			backTracking(0,0);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static void backTracking(int cnt, int sum) {
		if(cnt >= 12) {
			if(result > sum) {
				result = sum;
			}
			return;
		}
		
		//1일 요금쓴 경우
		backTracking(cnt + 1, sum + (months[cnt] * InputMoney[0]));
		
		//한달 요금을 쓴 경우
		backTracking(cnt + 1, sum + (InputMoney[1]));
		
		//3달 요금을 쓴 경우
		backTracking(cnt + 3, sum + (InputMoney[2]));
		
		//1년 요금을 쓴 경우
		backTracking(cnt + 12,  sum + InputMoney[3]);
	}
	
}
