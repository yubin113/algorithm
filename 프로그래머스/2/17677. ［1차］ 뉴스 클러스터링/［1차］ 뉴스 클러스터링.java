import java.util.*;
import java.io.*;
class Solution {
    static ArrayList<String> A;
    static ArrayList<String> B;
    
    public int solution(String str1, String str2) {
        A = new ArrayList<>();
        B = new ArrayList<>();
        
        //다중집합원소
        for(int i = 0; i < str1.length() -1; i++){
            A.add(str1.substring(i,i+2));
        }
        for(int i = 0; i < str2.length() -1; i++){
            B.add(str2.substring(i,i+2));
        }
        
        //영문자로된 글자쌍만 남기기
        Iterator<String> iterA = A.iterator();
        while(iterA.hasNext()){
            String s = iterA.next();
            Character c1 = s.charAt(0);
            Character c2 = s.charAt(1);
            if(!((('a' <= c1 && c1 <= 'z') || ('A' <= c1 && c1 <= 'Z')) && (('a' <= c2 && c2 <= 'z') || ('A' <= c2 && c2 <= 'Z'))))
                iterA.remove();
        }
        
        Iterator<String> iterB = B.iterator();
        while(iterB.hasNext()){
            String s = iterB.next();
            Character c1 = s.charAt(0);
            Character c2 = s.charAt(1);
            if(!((('a' <= c1 && c1 <= 'z') || ('A' <= c1 && c1 <= 'Z')) && (('a' <= c2 && c2 <= 'z') || ('A' <= c2 && c2 <= 'Z'))))
                iterB.remove();
        }  
        
        if (A.isEmpty() && B.isEmpty()) return 65536;
        
        //소문자로 만들기
        for (int i = 0; i < A.size(); i++) A.set(i, A.get(i).toLowerCase());
        for (int i = 0; i < B.size(); i++) B.set(i, B.get(i).toLowerCase());
        
        //교집합
        int same = 0;
        ArrayList<String> tmpB = new ArrayList<>(B);
        for (String a : A) {
            if (tmpB.remove(a)) same++;
        }
        
        int sum = A.size() + B.size() - same;
        double result = ((double) same / (double) sum) * 65536.0;
        int answer = (int) Math.floor(result);
        
        return answer;
    }
}