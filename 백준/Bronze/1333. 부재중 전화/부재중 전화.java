import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int N;  //몇번 재생
	static int L;  //안내멘트 초
	static int D;  //상담원 연결 초
	
	static int answer;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		int time = 0;
		
        for (int i = 0; i < N; i++) {
            time += L; 
            
            for (int j = 0; j < 5; j++) {
                if (time % D == 0) {
                    System.out.println(time);
                    return;
                }
                time++;
            }
        }

        while (time % D != 0) {
            time++;
        }

        System.out.println(time);

	}
}