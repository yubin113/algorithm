class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            for (String word :
                    words) {
                if(babbling[i].contains(word)){
                    babbling[i] = babbling[i].replace(word, "~");
                }
            }
            if(babbling[i].matches("^~*$")) answer++;
        }
        return answer;
    }
}