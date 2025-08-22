import java.util.*;

//큐
//있으면 기존 거 지우고, 다시 넣기 (실행시간 + 1)
//없으면 없애고, 새로 넣기 (실행시간 + 5)
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < cities.length; i++){
            if(cacheSize == 0){
                answer += 5 * cities.length;
                break;
            }
            String city = cities[i].toLowerCase();
            //있는 경우
            if(queue.contains(city)){
                queue.remove(city);
                queue.add(city);
                answer += 1;
            }else{
                //없는 경우
                if (queue.size() == cacheSize) {
                    queue.remove();
                }
                queue.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}