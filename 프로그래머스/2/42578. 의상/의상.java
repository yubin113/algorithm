import java.util.*;

//해시 
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        //해시에 넣기
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            if(hashMap.containsKey(clothes[i][1])){
                hashMap.get(clothes[i][1]).add(clothes[i][0]);
            }else{
                ArrayList<String> arr = new ArrayList<>();
                arr.add(clothes[i][0]);
                hashMap.put(clothes[i][1], arr);
            }
        }
        for(String key: hashMap.keySet()){
            answer *= hashMap.get(key).size() + 1;
        }
        answer--;
        
        return answer;
    }
}