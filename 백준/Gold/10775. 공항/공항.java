import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;

    static int gates;
    static int airplanes;
    static int[] parents;
    static int result;

    static void make(){
        parents = new int[gates+1];
        for (int i = 1; i <= gates; i++) {
            parents[i] = i;
        }
    }

    static int find(int num){
        if(parents[num] == num){
           return num;
        }

        return parents[num] = find(parents[num]);
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB){
            parents[rootA] = rootB;
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        gates = Integer.parseInt(br.readLine());
        make();

        airplanes = Integer.parseInt(br.readLine());

        for (int i = 0; i < airplanes; i++) {
            int gate = Integer.parseInt(br.readLine());

            int availableGate = find(gate);

            if(availableGate == 0){
                break;
            }

            union(availableGate, availableGate-1);
            result++;
        }
        System.out.println(result);
    }
}