import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] infos;
    static int maxSheep;
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        graph = new ArrayList<>();
        infos = new int[info.length];
        infos = info;
        
        //노드 넣기
        for(int i = 0; i < info.length; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        
        //DFS
        maxSheep = Integer.MIN_VALUE;
        DFS(0,0,0,new ArrayList<>());
        
        //결과
        if(maxSheep == Integer.MIN_VALUE) maxSheep = 0;
        answer = maxSheep;
        return answer;
    }
    //DFS
    //현재 노드 번호, 양갯수, 늑대 갯수, 다음 노드 후보
    public void DFS(int currentNum, int sheepCnt, int wolfCnt, ArrayList<Integer> next){
        //양인지 늑대인지
        if(infos[currentNum] == 0) sheepCnt++;
        else wolfCnt++;
        
        //기저조건: 늑대가 많거나 같으면 끝
        if(wolfCnt >= sheepCnt) return;
        
        //양의 개수최대인지 확인
        maxSheep = Math.max(maxSheep, sheepCnt);
        
        //다음 후보
        ArrayList<Integer> nextGo = new ArrayList<>(next);
        //현재 노드의 자식들 후보에 추가
        nextGo.addAll(graph.get(currentNum));
        //현재 노드 제외
        nextGo.remove(Integer.valueOf(currentNum));
        
        // 후보 중 하나 선택해서 이동
        for (int i = 0; i < nextGo.size(); i++) {
            int nextNode = nextGo.get(i);
            DFS(nextNode, sheepCnt, wolfCnt, nextGo);
        }
    }
    
}

