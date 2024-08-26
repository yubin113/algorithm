
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int currentIndex;
	static int N, X, K;
	static boolean[] arr;

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
			
		N = Integer.parseInt(st.nextToken());  //종이컵의 수
		X = Integer.parseInt(st.nextToken());  //간식이 들어있는 종이컵 인덱스
		K = Integer.parseInt(st.nextToken());  //컵위 위치를 바꾸는 횟수
			
		arr = new boolean[N + 1];
		arr[X] = true;
		currentIndex = X;
			
		for (int j = 1; j <= K; j++) {
			st = new StringTokenizer(br.readLine());
				
			int[] tmp = new int[2];
			for (int j2 = 0; j2 < 2; j2++) {
				tmp[j2] = Integer.parseInt(st.nextToken()); 
			}
				
			for (int k = 0; k < tmp.length; k++) {
				if(tmp[k] == currentIndex) {
					if(k == 0) {
						arr[currentIndex] = false;
						arr[tmp[1]] = true;
						currentIndex = tmp[1];
						break;
					}else {
						arr[currentIndex] = false;
						arr[tmp[0]] = true;
						currentIndex = tmp[0];
						break;
					}
				}
			}
			
		}
		sb.append(currentIndex).append("\n");
		System.out.println(sb);
	}
}
