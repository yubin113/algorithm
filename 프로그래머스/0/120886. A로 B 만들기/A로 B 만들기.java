class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        while(!before.equals("")){
            int count1 = before.length() - before.replaceAll(Character.toString(before.charAt(0)),"").length();
            int count2 = after.length() - after.replaceAll(Character.toString(before.charAt(0)),"").length();

            String word = Character.toString(before.charAt(0));
            before = before.replaceAll(word,"");
            after = after.replaceAll(word,"");
            
            if(count1 != count2) answer = 0;
        }
        return answer;
    }
}