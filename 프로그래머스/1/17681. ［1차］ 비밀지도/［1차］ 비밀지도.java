class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer =  new String[n];
        String[] tmp1 = new String[arr1.length];
        String[] tmp2 = new String[arr2.length];


        for (int i = 0; i < arr1.length; i++) {
            answer[i] = "";

            String num1 = Integer.toBinaryString(arr1[i]);
            String num2 = Integer.toBinaryString(arr2[i]);

            if(num1.length() != n){
                String tmp = num1;
                for (int j = 0; j < n - num1.length(); j++) {
                    tmp = '0' + tmp;
                }
                num1 = tmp;
            }
            if(num2.length() != n){
                String tmp = num2;
                for (int j = 0; j < n - num2.length(); j++) {
                    tmp = '0' + tmp;
                }
                num2 = tmp;
            }

            tmp1[i] = num1;
            tmp2[i] = num2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(tmp1[i].charAt(j) == '1' || tmp2[i].charAt(j) == '1'){
                    answer[i] += '#';
                }else{
                    answer[i] += ' ';
                }
            }
        }
        return answer;
    }
}