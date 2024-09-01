import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int TC;
    static int N; //건물의 개수
    static int K; //건설순서 규칙 개수
    static ArrayList<ArrayList<Integer>> adjList;
    static Queue<Integer> queue;
    static int[] time;
    static int checkBuildingNum;
    static int[] edgeCount;
    static int[] result;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            adjList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N + 1; i++) {
                adjList.add(new ArrayList<>());
            }

            time = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            edgeCount = new int[N+1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                adjList.get(num1).add(num2);
                edgeCount[num2]++;
            }

            checkBuildingNum = Integer.parseInt(br.readLine());

            result = new int[N + 1];
            queue = new LinkedList<>();
            for (int i = 1; i < N+1; i++) {
                if(edgeCount[i]==0){
                    queue.offer(i);
                    result[i] = time[i];
                }
            }

            while(!queue.isEmpty()){
                int num = queue.poll();

                ArrayList<Integer> numList = adjList.get(num);
                for (int i = 0; i < numList.size(); i++) {
                    int next = numList.get(i);
                    result[next] = Math.max(result[next], result[num] + time[next]);
                    edgeCount[numList.get(i)]--;

                    if(edgeCount[numList.get(i)] == 0){
                        queue.offer(numList.get(i));
                    }
                }
            }
            System.out.println(result[checkBuildingNum]);
        }

    }

}
