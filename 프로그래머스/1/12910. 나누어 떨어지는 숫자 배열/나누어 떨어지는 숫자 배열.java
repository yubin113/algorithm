class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] arr2 = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0){
                arr2[idx++] = arr[i];
            }
        }
        if(idx == 0){
            arr2[idx++] = -1;
        }

        int[] answer = new int[idx];
        for (int i = 0; i < idx; i++) {
            answer[i] = arr2[i];
        }
        for (int i = 0; i < answer.length; i++) {
            for (int j = i + 1; j < answer.length; j++) {
                if(answer[i] > answer[j]){
                    int tmp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = tmp;
                }
            }
        }
        return answer;
    }
}