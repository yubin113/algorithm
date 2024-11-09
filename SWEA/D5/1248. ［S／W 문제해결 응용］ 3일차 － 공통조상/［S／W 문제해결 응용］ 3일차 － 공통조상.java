import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    /**
     * SWEA 1248 D5 공통조상
     */
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int TC;
    static int V,E, findNum1, findNum2;
    static ArrayList<ArrayList<Integer>> adjList;
    static int count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken()); //정점의 개수
            E = Integer.parseInt(st.nextToken()); //간선의 개수
            findNum1 = Integer.parseInt(st.nextToken());  //공통 조상을 찾는 두 개의 정점 번호
            findNum2 = Integer.parseInt(st.nextToken());

            adjList = new ArrayList<>();
            for (int i = 0; i < V+1; i++) {
                adjList.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                adjList.get(child).add(parent);
            }

            ArrayList<Integer> num1Parent = new ArrayList<>();
            //num1의 부모들 찾기
            while(true){
                if(findNum1 == 1){
                    break;
                }
                int parent = adjList.get(findNum1).get(0);
                num1Parent.add(parent);

                findNum1 = parent;
            }


            ArrayList<Integer> num2Parent = new ArrayList<>();
            //num1의 부모들 찾기
            while(true){
                if(findNum2 == 1){
                    break;
                }
                int parent = adjList.get(findNum2).get(0);
                num2Parent.add(parent);

                findNum2 = parent;
            }

            int commonParent = 1;
            for (int i = 0; i < num1Parent.size(); i++) {
                if(num2Parent.contains(num1Parent.get(i))){
                    commonParent = num1Parent.get(i);
                    break;
                }
            }

            //총 몇개인지 찾기
            count = 1;
            DFS(commonParent);

            sb.append("#").append(tc).append(" ").append(commonParent).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int start){
        for (int i = 0; i < adjList.size(); i++) {
            if(!adjList.get(i).isEmpty()){
                if(adjList.get(i).get(0) == start){
                    count++;
                    if(adjList.get(i).size() != 0){
                        DFS(i);
                    }
                }
            }
        }
    }
}
