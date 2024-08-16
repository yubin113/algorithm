
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	/**
	 * 
	 * 1. 테스트케이스(10)마다
	 * 		1.1 여덟 개의 데이터 받기
	 * 2. 데이터마다 사이클 돌기
	 * 		2.1 마지막 수가 0보다 작거나 같을때까지 while문 돌기
	 * 		2.2 사이클(5)마다,
	 * 			2.2.1 자리 옮기기
	 */
	static BufferedReader br;
	static StringTokenizer st;
	static int tc;
	static StringBuilder sb;
	static int[] beforePassword;
	static int[] afterPassword;
	public static void main(String[] args) throws Exception{
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		//1. 테스트케이스(10)마다
		for (int i = 1; i <= 10; i++) {
			
			inputCase();
			
			sb.append("#").append(i).append(" ");
			//2. 데이터마다 사이클 돌기
			cycle(beforePassword);
			sb.append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	public static void inputCase() throws Exception{
		
		tc = Integer.parseInt(br.readLine().trim());
		
		//1.1 여덟 개의 데이터 받기
		beforePassword = new int[8];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < 8; i++) {
			beforePassword[i] = Integer.parseInt(st.nextToken());
		}
		
	}
	
	public static void cycle(int[] nums) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			arrayList.add(nums[i]);
		}
		
		//2.1 마지막 수가 0보다 작거나 같을때까지 while문 돌기
		loopa:
		while(arrayList.get(arrayList.size() - 1) > 0) {
			//2.2 사이클(5)마다,
			for (int i = 0; i < 5; i++) {
				//2.2.1 자리 옮기기
				int first = arrayList.remove(0);
				first = first - (i + 1);
				if(first <= 0) {
					arrayList.add(0);
					break loopa;
				}
				arrayList.add(first);
				
			}
		}
		
		
		for (int i = 0; i < arrayList.size(); i++) {
			sb.append(arrayList.get(i)).append(" ");
		}
	}
}
