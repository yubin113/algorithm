import java.io.*;
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            priorityQueue.add(work);
        }
        
        while (n > 0 && !priorityQueue.isEmpty()) {
            int maxWork = priorityQueue.poll();
            if(maxWork > 0){
                priorityQueue.add(maxWork - 1);
            }
            n--;
        }
        
        while(!priorityQueue.isEmpty()){
            int work = priorityQueue.poll();
            answer += (long) work * work;
        }
        
        return answer;
    }
}