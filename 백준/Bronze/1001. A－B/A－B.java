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

        int sub = arr[0] - arr[1];
        bw.write(String.valueOf(sub));

        bw.flush();
        bw.close();

    }
}