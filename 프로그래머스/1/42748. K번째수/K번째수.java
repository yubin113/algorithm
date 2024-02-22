class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] array2 = new int[commands[i][1] - commands[i][0] + 1];
            int idx = 0;
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                array2[idx++] = array[j];
            }
            for (int j = 0; j < array2.length; j++) {
                for (int k = j + 1; k < array2.length; k++) {
                    if (array2[j] > array2[k]) {
                        int tmp = array2[j];
                        array2[j] = array2[k];
                        array2[k] = tmp;
                    }
                }
            }
            answer[i] = array2[commands[i][2] - 1];
        }
        return answer;
    }
}