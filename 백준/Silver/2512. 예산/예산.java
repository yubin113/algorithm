import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] budget;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        budget = new int[N];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            budget[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budget[i]);
        }

        M = Integer.parseInt(br.readLine());

        int lo = 1;
        int hi = max+1;
        while(lo+1<hi){
            int mid = (lo+hi)/2;

            if(check(mid)){
                lo = mid;
            }else{
                hi = mid;
            }
        }

        System.out.println(lo);
    }

    static boolean check(int mid){
        int total = 0;
        for(int i=0; i<budget.length; i++){
            if(mid>budget[i])total+=budget[i];
            else total+=mid;
        }
        return total<=M;
    }
}
