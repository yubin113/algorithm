
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Solution {
	/**
	 * SWEA 14510 D2 나무 높이
	 * 
	 * 1. 인풋받는다.
	 * 2. 제일 큰 키 나무 찾는다.
	 * 3. 제일 큰 키와 차이값을 찾아서 짝수 갯수와 홀수 갯수를 찾는다.
	 * 4. 짝수가 더 크면 짝수와 홀수의 차이가 1이 될때까지 홀수로 변경해준다.
	 * 5. 홀수가 더 많은 경우 홀수*2-1
	 * 		짝수가 더 많은 경우는 짝수*2
	 * 		같은 경우는 홀수 + 짝수
	 */
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int N;
	static int[] arr;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			int maxTree = 0;
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				maxTree = Math.max(maxTree, num);
				arr[j] = num;
			}
			
			int odd = 0;
			int even = 0;
			
			for (int j = 0; j < N; j++) {
				int diff = maxTree - arr[j];
				
				if(diff == 0) continue;
				
				odd += diff % 2;
				even += diff / 2;
			}
			
			//4. 짝수가 더 크면 짝수와 홀수의 차이가 1이 될때까지 홀수로 변경해준다.
			if(even > odd) {
				while(Math.abs(even - odd) > 1) {
					even--;
					odd += 2;
				}
			}
			
			//	 * 5. 홀수가 더 많은 경우 홀수*2-1
//			 * 		짝수가 더 많은 경우는 짝수*2
//			 * 		같은 경우는 홀수 + 짝수
			
			int answer = 0;
			if(odd > even) {
				answer = odd * 2 - 1;
			}else if(odd < even) {
				answer = even * 2;
			}else {
				answer = even + odd;
			}
			
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
