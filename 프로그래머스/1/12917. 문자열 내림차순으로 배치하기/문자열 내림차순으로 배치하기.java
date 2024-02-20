class Solution {
    public String solution(String s) {
        String answer = "";
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = (int) s.charAt(i);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j =  i + 1; j < arr.length; j++) {
                if(arr[i] < arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            answer += (char) arr[i];
        }
        return answer;
    }
}