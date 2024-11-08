import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int TC;

    static int[] dx = {1, 0, -1, 0};  // 북동남서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            String command = br.readLine();
            int dir = 0;
            int x = 0;
            int y = 0;
            int maxDistance = 0;

            boolean infiniteLoop = false;
            Set<String> visited = new HashSet<>();

            int loopCount = 0;
            while (true) {
                loopCount++;
                for (int i = 0; i < command.length(); i++) {
                    if (command.charAt(i) == 'S') {
                        x += dx[dir];
                        y += dy[dir];
                    } else if (command.charAt(i) == 'L') {
                        dir = (dir - 1 + 4) % 4;
                    } else if (command.charAt(i) == 'R') {
                        dir = (dir + 1 + 4) % 4;
                    }

                    // 원점으로부터 거리 계산
                    int distance = x * x + y * y;
                    maxDistance = Math.max(distance, maxDistance);
                }

                String state = x + "," + y + "," + dir;

                if (visited.contains(state)) {
                    infiniteLoop = true;
                    break;
                } else {
                    if(loopCount >= 10){
                        break;
                    }
                    visited.add(state);
                }
            }

            if (!infiniteLoop) {
                sb.append("#").append(tc).append(" ").append("oo").append("\n");
            } else {
                sb.append("#").append(tc).append(" ").append(maxDistance).append("\n");
            }
        }
        System.out.println(sb);
    }
}