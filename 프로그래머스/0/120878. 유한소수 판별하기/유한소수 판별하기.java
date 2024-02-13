class Solution {
    public int solution(int a, int b) {
        int answer = 1;
        int a1 = a / gcd(a, b);
        int b1 = b / gcd(a, b);
        int[] arr= new int[b1];
        int index = 0;
        int i = 2;
        while(true){
            if(b1 == 1) break;
            if(b1 % i == 0){
                b1 /= i;
                arr[index++] = i;
            }else{
                i++;
            }
        }
        for(int j = 0; j < index; j++){
            if(arr[j] == 2 || arr[j] == 5 || arr[j] ==1){
                continue;
            }
            answer = 2;
        }
        return answer;
    }
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}