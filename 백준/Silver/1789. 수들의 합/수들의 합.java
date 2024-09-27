import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		long num = 1;
		long sum = 1;
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		while(sum <= N) {
			if(num != 1) {
				sum += num;
			}
			num++;				
		}
		
		System.out.println(num-2);
	}
}