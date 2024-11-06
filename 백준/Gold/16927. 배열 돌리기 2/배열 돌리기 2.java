
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	/**
	 * BOJ 16927 G5 배열돌리기2
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
		
		int row = 0, col = 0;
		ArrayList<Integer> rotateCheck = new ArrayList<>();
		while((row < (N-1)-row) && (col < (M-1)-col)) {
			//회전시키기
			rotateCheck.add(rotate(row, col)+1);
			//다음위치로
			row++;
			col++;
		}
		
		int index = 0; 
		row = 0;
		col = 0;
		while((row < (N-1)-row) && (col < (M-1)-col)) {
			int realRotateNum = (rotateNum -1) % rotateCheck.get(index); 
			//회전시키기
			for (int i = 0; i < realRotateNum; i++) {
				rotate(row, col);		
			}
			
			//다음위치로
			row++;
			col++;
			index++;
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
	static int rotate(int row, int col) {
		//회전 갯수
		int count = 0;
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
				return count;
			}
			//바깥으로 넘어가면
			if(nextX < firstRow || nextY < firstCol || nextX > endRow || nextY > endCol) {
				index++;
				if(index==4) return count;
				continue;
			}
			//값 바꾸기
			arr[row][col] = arr[nextX][nextY];
			row = row + dx[index];
			col = col + dy[index];
			count++;
		}
	}
}
