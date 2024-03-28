class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        char[][] keypad = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};

        int leftXFinger = 3;
        int leftYFinger = 0;
        int rightXFinger = 3 ;
        int rightYFinger = 2;

        for (int i = 0; i < numbers.length; i++) {
            int x = 0;
            int y = 0;
            search : {
                for (int j = 0; j < keypad.length; j++) {
                    for (int k = 0; k < keypad[j].length; k++) {
                        if(Integer.parseInt(String.valueOf(keypad[j][k])) == numbers[i]){
                            x = j;
                            y = k;
                            break search;
                        }
                    }
                    x = 3;
                    y = 1;
                }
            }
            if(y == 0){
                answer += 'L';
                leftXFinger = x;
                leftYFinger = y;
            } else if (y == 2) {
                answer += 'R';
                rightXFinger = x;
                rightYFinger = y;
            }else{
                int leftMin = Math.abs(leftXFinger - x) + Math.abs(leftYFinger - y);
                int rightMin = Math.abs(rightXFinger - x) + Math.abs(rightYFinger - y);

                if(leftMin == rightMin){
                    if(hand.equals("left")){
                        answer += 'L';
                        leftXFinger = x;
                        leftYFinger = y;
                    }else{
                        answer += 'R';
                        rightXFinger = x;
                        rightYFinger = y;
                    }
                } else if (leftMin < rightMin) {
                    answer += 'L';
                    leftXFinger = x;
                    leftYFinger = y;
                }else {
                    answer += 'R';
                    rightXFinger = x;
                    rightYFinger = y;
                }
            }
        }
        return answer;
    }
}