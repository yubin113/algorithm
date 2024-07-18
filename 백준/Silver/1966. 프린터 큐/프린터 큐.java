import java.io.*;
import java.util.*;

public class Main {

    public static int TC;

    public static int N;
    public static int M;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            LinkedList<Q> list = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list.add(new Q(j, Integer.parseInt(st.nextToken())));
            }


            int result = 1;
            outLoop:
            while (true){
                Q q = list.pop();
                if(list.isEmpty()){
                    break;
                }else{
                    int size = list.size();
                    for (int j = 0; j < size; j++) {
                        if(q.value < list.get(j).value){
                            list.add(q);
                            break;
                        }
                        if(j == (size - 1)){
                            if(q.where == M){
                                break outLoop;
                            }else{
                                result++;
                            }

                        }
                    }
                }
            }

            System.out.println(result);
        }


    }

}
class Q{
    int where;
    int value;

    public Q(int where, int value){
        this.where = where;
        this.value = value;
    }
}