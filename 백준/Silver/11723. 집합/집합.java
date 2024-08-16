
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	/**
	 * 1. 테스트케이스 갯수 입력받는다.
	 * 2. 연산 입력 받는다.
	 * 3. 연산
	 * 		3.1 switch문으로 어떤 연산인지 확인
	 * 		3.1 연산 수행
	 * 			3.1.1 check이면 출력
	 */
	static int TC;
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		//1. 테스트케이스 갯수 입력받는다.
		TC = Integer.parseInt(br.readLine());
		
//		2. 연산 입력 받는다.
		inputCase();
		
		System.out.println(sb);
	}
	
	static int bitset = 0;
	static String[][] inputArr;
	public static void inputCase() throws Exception{
		
		inputArr = new String[TC][2];
		
		for (int i = 0; i < TC; i++) {
			st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			if(str.equals("all") || str.equals("empty")) {
				operate(str, 0);
			}else {
				operate(str, Integer.parseInt(st.nextToken()));
			}
		}
	}
	
	public static void operate(String str, int x) {
		
		int k = 1 << (x - 1);
		
		switch(str) {
		case "add":
			bitset = bitset | k;
			break;
		case "remove":
			bitset = bitset & ~k;
			break;
		case "check":
			if((bitset & k) != 0) {
				sb.append("1\n");
			}else {
				sb.append("0\n");
			}
			break;
		case "toggle":
			if((bitset & k) != 0) {  //있으면
				bitset = bitset & ~k;
			}else {
				bitset = bitset | k;
			}
			break;
		case "all":
			bitset = (1 << 21) - 1;
			break;
		case "empty":
			bitset = 0;
			break;	
		}
	}
	
}
