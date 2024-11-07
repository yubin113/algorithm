
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	/**
	 * 방향전환
	 */
	
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			result = Integer.MAX_VALUE;
			//처음에 가로로 이동가능한 경우 체크
			move(true, x1,y1,x2,y2);
			//처음에 세로로 이동가능한 경우 체크
			move(false, x1,y1,x2,y2);
			
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	static void move(boolean check, int x1, int y1, int x2, int y2) {
		int dx = x1;
		int dy = y1;
		int count = 0;
		while(true) {
			//도착한 경우
			if(dx == x2 && dy == y2) {
				result = Math.min(result, count);
				return;
			}
			
			//세로로 이동하는 경우
			if(check) {  
				check = false;
				if(dx > x2) dx--;
				else dx++;
			}else {
				check = true;
				if(dy > y2) dy--;
				else dy++;
			}

			count++;
		}
	}
}
