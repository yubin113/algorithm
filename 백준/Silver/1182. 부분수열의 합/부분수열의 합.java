import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 부분수열의 합
	 * 핵심 풀이: 부분 집합
	 * 
	 * 1. 인풋 케이스 받는다.(N, S, arr[])
	 * 2. 부분집합 사용한다.(isSelected)
	 * 		2.1 기저조건: cnt == N일 때, 합 찾는다.
	 * 		2.2 포함시키는 경우와 포함시키지 않는 경우 재귀
	 * 3. 합 계산한다.
	 * 		3.1 만약 S가 0인 경우, 공집합이 있기 때문에 나오는 값에 -1시킨다.
	 * 		3.2 0이 아닌 경우, 그냥 출력시킨다.
	 */
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, S;
	static int[] arr;
	static boolean[] isSelected;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		//1. 인풋 케이스 받는다.(N, S, arr[])
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//2. 부분집합 사용한다.(isSelected)
		isSelected = new boolean[N];
		answer = 0;
		subSet(0);
		
		//3.1 만약 S가 0인 경우, 공집합이 있기 때문에 나오는 값에 -1시킨다.
		if(S == 0) answer--;
		
		System.out.println(answer);
		
	}
	static void subSet(int cnt) {
		//2.1 기저조건: cnt == N일 때, 합 찾는다.
		if(cnt == N) {
			//3. 합 계산한다.
			if(sumSet(isSelected)) answer++;
			return;
		}
		//2.2 포함시키는 경우와 포함시키지 않는 경우 재귀
		//포함시키는 경우
		isSelected[cnt] = true;
		subSet(cnt + 1);
		
		//포함시키지 않는 경우
		isSelected[cnt] = false;
		subSet(cnt + 1);
	}
	static boolean sumSet(boolean[] isSelected) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) sum += arr[i];
		}
		if(S == sum) {
			return true;
		}
		return false;

	}
}