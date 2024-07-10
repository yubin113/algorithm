import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr2.add(arr.get(i), i+1);
        }


        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr2.get(i) + " ");
        }


    }
}