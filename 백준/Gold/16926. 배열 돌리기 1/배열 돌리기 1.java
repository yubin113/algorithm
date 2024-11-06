import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	/**
	 * BOJ 16962 G5 배열돌리기
	 * 1. 인풋받기
	 * 2. 
	 */
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int N,M, rotateNum;
	static int[][] arr;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		rotateNum = Integer.parseInt(st.nextToken());  //회전횟수
		
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < rotateNum; i++) {
			int row = 0, col = 0;
			while((row < (N-1)-row) && (col < (M-1)-col)) {
				//회전시키기
				rotate(row, col);
				//다음위치로
				row++;
				col++;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	//회전 함수
	static void rotate(int row, int col) {
		//제일 바깥값
		int firstRow = row;
		int firstCol = col;
		int endRow = (N-1)- row;
		int endCol = (M-1)- col;
		
		int index = 0;  //방향 인덱스
		int startValue = arr[row][col];  //첫번째값 저장
		
		while(true) {
			int nextX = row + dx[index];
			int nextY = col + dy[index];
			
			//자기자신에게 돌아오면
			if(nextX == firstRow && nextY == firstCol) {
				arr[row][col] = startValue;
				return;
			}
			//바깥으로 넘어가면
			if(nextX < firstRow || nextY < firstCol || nextX > endRow || nextY > endCol) {
				index++;
				if(index==4)return;
				continue;
			}
			//값 바꾸기
			arr[row][col] = arr[nextX][nextY];
			row = row + dx[index];
			col = col + dy[index];
		}
	}
}
