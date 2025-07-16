import java.io.*;
import java.util.*;

//x = (BF - ED) / (AD - BC)
//y = (EC - AF) / (AD - BC)

class Solution {
    public String[] solution(int[][] line) {
        HashSet<Point> pSet= new HashSet<>();
        Point min = new Point(Long.MAX_VALUE, Long.MAX_VALUE);
        Point max = new Point(Long.MIN_VALUE, Long.MIN_VALUE);
        
        //하나씩 다 비교
        for(int i = 0; i < line.length - 1; i++){
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];
            
            //나머지들 비교
            for(int j = i + 1; j < line.length; j++){
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                
                //분모
                long down = (A * D) - (B * C);
                //0일 경우 두 직선 평행, 일치
                if(down == 0) continue;
                
                long xup = (B * F) - (E * D);
                //정수아님
                if(xup % down != 0) continue;
                
                long yup = (E * C) - (A * F);
                //정수아님
                if(yup % down != 0) continue;
                
                long x = xup / down;
                long y = yup / down;
                
                pSet.add(new Point(x, y));
                
                //전체 크기 찾기용
                min.x = Math.min(min.x, x);
                min.y = Math.min(min.y, y);
                max.x = Math.max(max.x, x);
                max.y = Math.max(max.y, y);
            }
        }
        
        //전체 높이, 너비
        long height = max.y - min.y + 1;
        long width = max.x - min.x + 1;
        
        //일단 .으로 채우기
        String[] answer = new String[(int)height];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<width; i++){
            sb.append(".");
        }
        Arrays.fill(answer, sb.toString());
        
        //*채우기
        long meetX, meetY;
        for(Point point: pSet){
            meetY = max.y - point.y;
            meetX = point.x - min.x;
            
            answer[(int)meetY] = answer[(int)meetY].substring(0, (int)meetX) + "*" + answer[(int)meetY].substring((int)meetX + 1);
        }
        
        return answer;
    }
    
    public class Point{
        long x;
        long y;
        
        public Point(long x, long y){
            this.x = x;
            this.y = y;
        } 
    }
}