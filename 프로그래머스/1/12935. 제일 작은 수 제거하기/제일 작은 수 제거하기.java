class Solution {
    public int[] solution(int[] arr) {
        int size = arr.length - 1;
        int[] answer = new int[size == 0 ? 1 : size];
        if(size == 0){
            answer[0] = -1;
        }else{
            answer = new int[size];
            int min = 20000;
            for (int i = 0; i < arr.length; i++) {
                if(min > arr[i]){
                    min = arr[i];
                }
            }
            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if(min == arr[i]) continue;
                answer[idx++] = arr[i];
            }
        }
        return answer;
    }
}