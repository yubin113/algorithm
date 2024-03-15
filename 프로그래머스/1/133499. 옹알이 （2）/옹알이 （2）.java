class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] words = {"aya", "ye", "woo", "ma"};
        String[] repeatWords = {"ayaaya", "yeye", "woowoo", "mama"};

        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < words.length; j++) {
                babbling[i] = babbling[i].replaceAll(repeatWords[j], "~").replaceAll(words[j], " ");
            }
            if(babbling[i].trim().length() == 0) answer++;
        }
        
        return answer;
    }
}