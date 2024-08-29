import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] num;
 	static int[] prefixSum;
	
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		prefixSum = new int[10];
		num = new int[10];
		for (int i = 0; i < 10; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		prefixSum[0] = num[0];
		for (int i = 1; i < 10; i++) {
			prefixSum[i] = prefixSum[i-1] + num[i]; 
			if(prefixSum[i] >= 100) {
				if(prefixSum[i] == 100) {					
					sb.append(100);
					break;
				}else {
					int max = Math.abs(100-prefixSum[i]);
					int min = Math.abs(100-prefixSum[i-1]);
					sb.append(max <= min ? prefixSum[i] : prefixSum[i - 1]);
					break;
				}
			}
            if(i == 9) sb.append(prefixSum[i]);
		}
		
		System.out.println(sb);
	}
}
