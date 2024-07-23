import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Q> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(queue.isEmpty()) {
                    System.out.println("0");
                }else {
                    Q q = queue.poll();
                    if(q.minus) {
                        System.out.println(-(q.number));
                    }else {
                        System.out.println(q.number);
                    }
                }
            }else {
                boolean b = num < 0 ? true : false;
                int abs = num > 0 ? num : -(num);
                queue.add(new Q(abs, b));
            }
        }


    }
}

class Q implements Comparable<Q>{
    public int number;
    public boolean minus;

    Q(int number, boolean minus){
        this.number = number;
        this.minus = minus;
    }

    @Override
    public int compareTo(Q o) {
        if (this.number == o.number) {
            return Boolean.compare(o.minus, this.minus);
        }
        return this.number - o.number;
    }
}
