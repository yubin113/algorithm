class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < keymap.length; k++) {
                    for (int l = 0; l < keymap[k].length(); l++) {
                        if(targets[i].charAt(j) == keymap[k].charAt(l)){
                            min = Math.min(min, l + 1);
                            break;
                        }
                    }

                }
                if(min == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                }
                answer[i] = answer[i] + min;
            }
        }
        return answer;
    }
}