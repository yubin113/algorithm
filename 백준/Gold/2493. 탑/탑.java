import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Stack<Integer> stack;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
				
		Stack<Top> stack = new Stack<>();
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			if(stack.empty()) {
				sb.append("0 ");
				stack.push(new Top(i, height));
			}else {
				while(true) {
					if(stack.isEmpty()) {
						sb.append("0 ");
						stack.push(new Top(i, height));
						break;
					}
					
					Top top = stack.peek();
					
					if(top.height > height) {
						sb.append(top.num + " ");
						stack.push(new Top(i, height));
						break;
					}else {
						stack.pop();
					}
				}
			}
		}
		System.out.println(sb);
	}
}

class Top {
	int num;  //탑 번호
	int height;  //탑 높이
	
	Top(int num, int height){
		this.num = num;
		this.height = height;
	}
}
