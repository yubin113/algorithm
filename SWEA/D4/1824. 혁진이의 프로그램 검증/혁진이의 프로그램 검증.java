
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	/**
	 * SWEA 1824 D4 혁신이의 프로그램 검증
	 * 구현문제
	 * 
	 * 4가지 상태를 관리해야한다 방향, 메모리, 행 , 열
	 * 
	 * 같은 상태로 방문했을 경우에만  pass해주기
	 */
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int TC;
	static int R,C;
	static boolean[][][][] visited;
	static char oper[][];
	static int result;  //성공 여부
	
	static int[] dx = {0,1,0,-1};  //동,남,서,북
	static int[] dy = {1,0,-1,0};
	
	static class Info{
		int x, y, dir, mem;

		public Info(int x, int y, int dir, int mem) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.mem = mem;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			oper = new char[R][C];
			result = -1;
			boolean isAno = false;
			
			for (int i = 0; i < R; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < C; j++) {
					char tmp2 = tmp.charAt(j);
					oper[i][j] = tmp2;
					if(tmp2 == '@') isAno = true;
				}
			}
			
			if(!isAno) {
				sb.append("#").append(tc).append(" ").append("NO").append("\n");
			}else {
				visited = new boolean[4][16][R][C];  //방향, 메모리, 행, 열
				//가장 처음 위치는 제일 왼쪽 위에 있는 문자이고, 이동 방향은 오른쪽
				process(new Info(0,0,0,0));
				
				if(result == 1) {
					sb.append("#").append(tc).append(" ").append("YES").append("\n");
				}else {
					sb.append("#").append(tc).append(" ").append("NO").append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	static void process(Info info) {
		//이미 방문한 곳이면 return
		//방향, 메모리, 행, 열
		if(visited[info.dir][info.mem][info.x][info.y]) return;
		
		Info newInfo = new Info(info.x, info.y, info.dir, info.mem);
		
		char now  = oper[newInfo.x][newInfo.y];
		visited[newInfo.dir][newInfo.mem][newInfo.x][newInfo.y] = true;
		
		//0~9 숫자 저장
		if(now >= '0' && now <= '9') newInfo.mem = now - '0';
		//동,남,서,북
		else if(now == '<') {
			//서쪽 방향
			newInfo.dir = 2;
		}else if(now == '>') {
			//동쪽 방향
			newInfo.dir = 0;
		}else if(now == 'v') {
			//남쪽 방향
			newInfo.dir = 1;
		}else if(now == '^') {
			//북쪽 방향
			newInfo.dir = 3;
		}else if(now == '_') {
			//메모리에 0이 저장되어 있으면 이동 방향을 오른쪽으로 바꾸고, 아니면 왼쪽으로 바꾼다.
			if(newInfo.mem == 0) {
				newInfo.dir = 0;
			}else {
				newInfo.dir = 2;
			}
		}else if(now == '|') {
			//메모리에 0이 저장되어 있으면 이동 방향을 아래쪽으로 바꾸고, 아니면 위쪽으로 바꾼다.
			if(newInfo.mem == 0) {
				newInfo.dir = 1;
			}else {
				newInfo.dir = 3;
			}
		}else if(now == '?') {
			//이동 방향을 상하좌우 중 하나로 무작위로 바꾼다. 방향이 바뀔 확률은 네 방향 동일하다.
			for (int i = 0; i < 4; i++) {
				int nextDir = (newInfo.dir + i) % 4;
				
				int nextX = newInfo.x + dx[nextDir];
				int nextY = newInfo.y + dy[nextDir];
				
				//다음 이동이 2차원 격자의 바깥으로 이동하는 방향이면, 반대편에 있는 위치로 이동한다. 
				if(nextX < 0) nextX = R - 1;
				else if(nextX >= R) nextX = 0;
				else if(nextY < 0) nextY = C - 1;
				else if(nextY >= C) nextY = 0;
				
				process(new Info(nextX, nextY, nextDir, newInfo.mem));
			}
			
			//밑에 이동 실행 안하게 막아줌
			return;
		}else if(now == '@') {
			//@	프로그램의 실행을 정지한다.
			result = 1;
		}else if(now == '+') {
			//+	메모리에 저장된 값에 1을 더한다. 만약 더하기 전 값이 15이라면 0으로 바꾼다.
			if(newInfo.mem == 15) {
				newInfo.mem = 0;
			}else {
				newInfo.mem++;
			}
		}else if(now == '-') {
			//-	메모리에 저장된 값에 1을 뺀다. 만약 빼기 전 값이 0이라면 15로 바꾼다.
			if(newInfo.mem == 0) {
				newInfo.mem = 15;
			}else {
				newInfo.mem--;
			}
		}
		//.	아무 것도 하지 않는다. -> 아무 처리 안함
		
		//이제 이동
		newInfo.x += dx[newInfo.dir];
		newInfo.y += dy[newInfo.dir];
        // 2차원 격자의 바깥으로 이동하는 방향이면, 반대편에 있는 위치로 이동
        if(newInfo.x < 0) newInfo.x = R - 1;
        else if(newInfo.x >= R) newInfo.x = 0;
        else if(newInfo.y < 0) newInfo.y = C - 1;
        else if(newInfo.y >= C) newInfo.y= 0;
        
        process(newInfo);
	}
}
