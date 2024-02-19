class Solution {
    public long solution(long n) {
        long answer = 0;
        
        int len = Long.toString(n).length();
        long[] arr = new long[len];
        int idx = 0;
        while(n != 0){
            arr[idx++] = n % 10;
            n /= 10;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] < arr[j]){
                    long tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        int num = 1;
        for (int i = arr.length - 1;  i >= 0; i--) {
            answer += arr[i] * num;
            num *= 10;
        }
        
        return answer;
    }
}