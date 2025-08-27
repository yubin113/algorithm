import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < priorities.length; i++){
            map.put(i+1, priorities[i]);
        }
        //큐에 넣기
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            queue.add(i+1);
        }
        int idx = 1;
        while(!queue.isEmpty()){
            //우선순위 높은 거 찾기
            int high = Integer.MIN_VALUE;
            for(int i = 0; i < priorities.length; i++){
                if(high < priorities[i]) high = priorities[i];
            }
            
            //큐에서 높은 우선순위 찾아서 없애기
            while(high != map.get(queue.peek())){
                int tmp = queue.poll();
                queue.add(tmp);
            }
            int process = queue.poll();
            priorities[process - 1] = Integer.MIN_VALUE;
            if(process == location + 1) {
                answer = idx;
                break;
            }
            idx++;
            
        }
        return answer;
    }
}