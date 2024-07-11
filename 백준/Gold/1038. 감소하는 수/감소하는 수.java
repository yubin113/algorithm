import java.util.*;
import java.io.*;

public class Main {
	
	static List<Long> numbers = new ArrayList<Long>();

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if(n < 10) {
			System.out.println(n);
			return;
		}else if(n >= 1023) {
			System.out.println(-1);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			search(1,i);
		}
		
		Collections.sort(numbers);
		
		System.out.println(numbers.get(n));
	
	}
	
	private static void search(int idx, long acc) {
		if(idx > 10) return;
		numbers.add(acc);
		for (int i = 0; i < acc % 10; i++) {
			search(idx + 1, acc * 10 + i);
		}
	}


}
