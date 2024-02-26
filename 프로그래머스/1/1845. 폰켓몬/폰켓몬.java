import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!arr.contains(nums[i]))
                arr.add(nums[i]);
        }
        if(arr.size() > (nums.length / 2))
            answer = nums.length / 2;
        else 
            answer = arr.size();
        return answer;
    }
}