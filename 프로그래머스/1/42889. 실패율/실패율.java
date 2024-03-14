import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            int people = 0;
            for (int j = 0; j < stages.length; j++) {
                if(i == stages[j]) sum++;
                if(i <= stages[j]) people++;
            }
            if(people == 0) people = 1;
            map.put(i, (double) sum / people);
        }
        System.out.println(map);
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (s1, s2) ->
                map.get(s2).compareTo(map.get(s1)));
        System.out.println(keySet);
        for (int i = 0; i < N; i++) {
            answer[i] = keySet.get(i);
        }
        return answer;
    }
}