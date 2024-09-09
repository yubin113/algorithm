import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	/**
	 * 1. 테스트 케이스 갯수를 받는다.
	 * 2. 테스트 케이스마다 돌리기
	 * 3. 인풋 받기
	 * 4. 제일 큰 나무를 찾는다.
	 * 5. 제일 큰 나무와 해당 나무의 키 차이 몫은 짝수에 더하고 나머지는 홀수에 더한다.
	 * 6. 짝수가 홀수보다 더 많은 경우 차이가 1이하일때까지 홀수에다가 2더해준다.
	 * 7. 홀수가 더 많은 경우 홀수 *2-1
	 * 		7.1 짝수가 더 많은 경우 짝수*2
	 * 		7.2 같은 경우 홀수+짝수
	 */
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int N;
	static int[] tree;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		//1. 테스트 케이스 갯수를 받는다.
		TC = Integer.parseInt(br.readLine());
		
		//2. 테스트 케이스마다 돌리기
		for (int tc = 1; tc <= TC; tc++) {
			
			//3. 인풋 받기
			N = Integer.parseInt(br.readLine());
			tree = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
			}
			
			//4. 제일 큰 나무를 찾는다.
			int maxTree = -1;
			for (int i = 0; i < N; i++) {
				maxTree = Math.max(maxTree, tree[i]);
			}
			
			int odd = 0;  //홀수
			int even = 0;  //짝수
			
			//5. 제일 큰 나무와 해당 나무의 키 차이 몫은 짝수에 더하고 나머지는 홀수에 더한다.
			for (int i = 0; i < N; i++) {
				int diff = maxTree - tree[i];
				
				//차이 같은 경우는 넘어가기
				if(diff == 0) continue;
				
				even += diff / 2;
				odd += diff % 2;
			}
			
			//6. 짝수가 홀수보다 더 많은 경우 차이가 1이하일때까지 홀수에다가 2더해준다.
			if(even > odd) {
				while(Math.abs(even-odd) > 1) {
					even--;
					odd += 2;
				}
			}
			
			//7. 홀수가 더 많은 경우 홀수 *2-1
			answer = 0;
			if(odd > even) {
				answer = odd*2 -1;
			}else if(odd < even) {
				answer = even * 2;
			}else {
				answer = odd+even;
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}