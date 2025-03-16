import java.util.*;
class Solution {
    static StringTokenizer stringTokenizer;
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        //최댓값, 최솟값 둘 다 제거하려면 두개의 우선순위 큐가 필요함
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();  //최소
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Collections.reverseOrder()); //최대
        
        for (int i = 0; i < operations.length; i++) {
            stringTokenizer = new StringTokenizer(operations[i]);
            String operation = stringTokenizer.nextToken();
            if(operation.equals("I")){
                int number = Integer.parseInt(stringTokenizer.nextToken());
                maxPriorityQueue.add(number);
                minPriorityQueue.add(number);
            }else{
                if(minPriorityQueue.isEmpty()) continue;
                String maxMin = stringTokenizer.nextToken();
                if(maxMin.equals("1")){
                    int max = maxPriorityQueue.poll();
                    minPriorityQueue.remove(max);
                }else{
                    int min = minPriorityQueue.poll();
                    maxPriorityQueue.remove(min);
                }
            }
        }
        
        if(minPriorityQueue.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = maxPriorityQueue.peek();
            answer[1] = minPriorityQueue.peek();
        }
        return answer;
    }
}