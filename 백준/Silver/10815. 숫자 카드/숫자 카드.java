import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//2,147,483,647 - Integer
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int N;
	static int[] arrN;
	static int M;
	static int[] arrM;
	
	
	
	 public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arrN = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		arrM = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}
		
		//정렬
		Arrays.sort(arrN);
		
		//이분탐색
		for (int i = 0; i < M; i++) {
			binarySearch(arrM[i]);
		}
		
		System.out.println(sb);
	 }
	 
	 static void binarySearch(int num) {
		 int first = 0;
		 int end = arrN.length-1;
		 
		 while(first <= end) {
			 int midIndex = (first + end) / 2;
			 //숫자 같으면 멈춤
			 if(arrN[midIndex] == num) {
				 sb.append("1").append(" ");
				 return;
			 }
			 
			 
			 //가운데 숫자보다 큰 경우
			 if(arrN[midIndex] < num) {
				 first = midIndex + 1;
			 }else {
				 //가운데 숫자보다 작은 경우
				 end = midIndex-1;
			 }
		 }

		 sb.append("0").append(" ");
		 return;
	 }
}