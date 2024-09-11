import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 암호 만들기
	 * 풀이: 조합
	 * 
	 * 1. 인풋케이스 받는다.(L, C, char[] arr)
	 * 2. 모음과 자음 나눈다.(ArrayList mo, ja) 
	 * 		2.1 모음이 하나도 없는 경우나 모음만 있거나, 자음 1개만 있는 경우  아무것도 없이 출력
	 * 3. 조합 만들기
	 * 		3.1 모음 조합 만들기(1~모음 갯수까지)
	 * 		3.2 자음 조합 만들기
	 * 
	 * 4. 정렬시킨다.
	 */
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int L, C;
	static char[] arr;
	static ArrayList<Character> mo;
	static ArrayList<Character> ja;
	static boolean[] isSelected;
	static boolean[] isJaSelected;
	static ArrayList<String> resultArrayList;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		//1. 인풋케이스 받는다.(L, C, char[] arr)
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());  //암호문길이
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
			
		}

		//2. 모음과 자음 나눈다.(ArrayList mo, ja) 
		mo = new ArrayList<>();
		ja = new ArrayList<>();
		
		for (int i = 0; i < C; i++) {
			if(arr[i] == 'a' ||arr[i] == 'e' ||arr[i] == 'i' ||arr[i] == 'o' ||arr[i] == 'u') {
				mo.add(arr[i]);
			}else {
				ja.add(arr[i]);
			}
		}
		
		//2.1 모음이 하나도 없는 경우나 모음만 있거나, 자음 1개만 있는 경우  아무것도 없이 출력
		if(mo.size() == 0 || ja.size() == 0 || ja.size()== 1 || mo.size() + ja.size() < L) return;
		
		//3. 조합 만들기
		//3.1 모음 조합 만들기(1~모음 갯수까지)
		resultArrayList = new ArrayList<>();
		for (int i = 1; i <= L-2; i++) {
			isSelected = new boolean[mo.size()];
			moCombination(0, 0, i);
		}
		
		Collections.sort(resultArrayList);
		for (int i = 0; i < resultArrayList.size(); i++) {
			sb.append(resultArrayList.get(i)).append("\n");
		}
		System.out.println(sb);
	}
	static void moCombination(int cnt, int idx, int i) {
		if(cnt == i) {
			
//			for (int j = 0; j < isSelected.length; j++) {
//				System.out.print(isSelected[j] ? mo.get(j) : " ");
//			}
//			System.out.println();
			
			char[] tmp = new char[L];
			int resultIdx = 0;
			for (int j = 0; j < isSelected.length; j++) {
				if(isSelected[j]) tmp[resultIdx++] = mo.get(j);
			}
			//3.2 자음 조합 만들기
			isJaSelected = new boolean[ja.size()];
			jaCombination(0,0, L-i, tmp, resultIdx);
			return;
		}
		
		for (int j = idx; j < mo.size(); j++) {
			if(!isSelected[j]) {
				isSelected[j] = true;
				moCombination(cnt + 1, j + 1 , i);
				isSelected[j] = false;
			}
		}
	}
	
	static void jaCombination(int cnt, int idx, int i, char[] tmp, int resultIdx) {
		if(cnt == i) {
			for (int j = 0; j < isJaSelected.length; j++) {
				if(isJaSelected[j]) tmp[resultIdx++] = ja.get(j);
			}
			char[] copy = new char[tmp.length];
			for (int j = 0; j < tmp.length; j++) {
				copy[j] = tmp[j];
			}
			Arrays.sort(copy);
			resultArrayList.add(String.valueOf(copy));
			
			return;
		}
		
		for (int j = idx; j < ja.size(); j++) {
			if(!isJaSelected[j]) {
				isJaSelected[j] = true;
				jaCombination(cnt+1, j+1, i, tmp, resultIdx);
				isJaSelected[j] = false;
			}
		}
	}
}