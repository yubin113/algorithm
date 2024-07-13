import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(st.hasMoreTokens()){
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (str.equals("top")) {
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.lastElement()).append("\n");
            } else if (str.equals("pop")) {
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            } else if (str.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (str.equals("empty")) {
                if(stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }


}