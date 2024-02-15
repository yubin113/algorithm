class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        for (String[] user :
                db) {
            if(user[0].equals(id_pw[0])){
                if(user[1].equals(id_pw[1])){
                    answer = "login";
                    return answer;
                }else{
                    answer = "wrong pw";
                    return answer;
                }
            }else{
                answer = "fail";
            }
        }
        return answer;
    }
}