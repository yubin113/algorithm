import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int mul = arr[0] *  arr[1];
        int add = arr[0] +  arr[1];
        int sub = arr[0] -  arr[1];
        int div = arr[0] /  arr[1];
        int div2 = arr[0] % arr[1];


        bw.write(String.valueOf(add));
        bw.write(" ");
        bw.write(String.valueOf(sub));
        bw.write(" ");
        bw.write(String.valueOf(mul));
        bw.write(" ");
        bw.write(String.valueOf(div));
        bw.write(" ");
        bw.write(String.valueOf(div2));

        bw.flush();
        bw.close();

    }
}