import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int not1 = 0;
		int not2 = 0;

		Loop1:
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				int sum = 0;
				for (int j2 = 0; j2 < arr.length; j2++) {
					if(j2 == i || j2 == j) {
						continue;
					}else {
						sum += arr[j2];
						
					}
				}
				if(sum == 100) {
					not1 = i;
					not2 = j;
					break Loop1;
				}
			}
		}

		
		for (int i = 0; i < arr.length; i++) {
			if(i == not1 || i == not2) {
				continue;
			}else {
				System.out.println(arr[i]);
			}
		}
		
		
	}

}
