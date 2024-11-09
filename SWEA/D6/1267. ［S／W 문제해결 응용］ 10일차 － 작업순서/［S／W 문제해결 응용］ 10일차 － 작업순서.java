import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int V,E;
    static ArrayList<ArrayList<Integer>> adjList;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            
            adjList = new ArrayList<>();
            for (int j = 0; j < V + 1; j++) {
                adjList.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < E; j++) {
                int after = Integer.parseInt(st.nextToken());
                int before = Integer.parseInt(st.nextToken());

                adjList.get(before).add(after);
            }

            //먼저 시작이 가능한 애들 찾기
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 1; j < adjList.size(); j++) {
                if(adjList.get(j).isEmpty()) queue.add(j);
            }

            sb.append("#").append(tc).append(" ");
            while(!queue.isEmpty()){
                int num = queue.poll();
                sb.append(num).append(" ");
                for (int i = 0; i < adjList.size(); i++) {
                    if(adjList.get(i).contains(num)){
                        adjList.get(i).remove(Integer.valueOf(num));
                        if (adjList.get(i).isEmpty()){
                            queue.add(i);
                        }
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
