import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < section.length; i++) {
            arrayList.add(section[i]);
        }
        for (int i = 1; i <= n; i++) {
            if(arrayList.contains(i)){
                for (int j = i; j < i + m; j++) {
                    if(arrayList.contains(j))
                        arrayList.remove(arrayList.indexOf(j));
                }
                answer++;
            }
        }
        return answer;
    }
}