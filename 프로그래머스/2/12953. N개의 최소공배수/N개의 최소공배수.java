//최소공배수
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        //최소공배수: num1 * num2 / GCD
        //첫번째
        answer = (arr[0] * arr[1]) / GCD(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++){
            answer = (answer * arr[i]) / GCD(answer, arr[i]);
        }
        return answer;
        
    }
    
    //최소공약수
    public static int GCD(int num1, int num2){
        if(num1 % num2 == 0) return num2;
        return GCD(num2, num1%num2);
    }
}