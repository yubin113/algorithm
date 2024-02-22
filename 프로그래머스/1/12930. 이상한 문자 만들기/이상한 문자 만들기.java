class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" " , -1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                if(j % 2 == 0){
                    arr[i] = arr[i].substring(0 , j) + Character.toUpperCase(arr[i].charAt(j)) + arr[i].substring(j + 1);
                }else{
                    arr[i] = arr[i].substring(0 , j) + Character.toLowerCase(arr[i].charAt(j)) + arr[i].substring(j + 1);
                }
            }
            if(i == arr.length - 1){
                answer += arr[i];
                break;
            }
            answer += arr[i] + " ";
        }
        return answer;
    }
}