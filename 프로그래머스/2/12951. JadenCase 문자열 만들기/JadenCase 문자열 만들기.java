class Solution {
    public String solution(String s) {
        if (s.isEmpty()) return ""; // 빈 문자열 처리

        StringBuilder answer = new StringBuilder();
        String[] words = s.split(" ", -1); // 공백 유지

        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                answer.append(Character.toUpperCase(words[i].charAt(0)))
                      .append(words[i].substring(1).toLowerCase());
            }
            if (i < words.length - 1) {
                answer.append(" "); // 단어 사이의 공백 유지
            }
        }

        return answer.toString();
    }
}
