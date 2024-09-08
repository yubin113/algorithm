import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    /**
     * 괄호 추가하기
     * 1. 인풋 케이스를 받는다.(N, nums, operators)
     * 2. 백트래킹한다.
     *      2.1 기저 조건: cnt == operators.size()까지 해서 나온결과와 비교해서 최대값 찾는다.
     *      2.2 괄호를 넣는 경우와 괄호를 안넣는 경우로 생각환다.
     *              2.2.1 괄호를 넣지 않으면 : 그냥 현재까지 sum한 값과 다음 숫자와 operators.get(cnt)시킨다.
     *              2.2.2. 괄호를 넣는 경우: 먼저 뒷 숫자와 그 뒷숫자 연산한 후 sum과 연산
     *                  주의점 배열 범위 안나가는 선에서 괄호를 만들어야 한다.
     */

    static BufferedReader br;
    static StringTokenizer st;

    static int N;
    static ArrayList<Integer> nums;
    static ArrayList<Character> operators;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        //1. 인풋 케이스를 받는다.(N, nums, operators)
        N = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();
        operators = new ArrayList<>();

        String mathExpression = br.readLine();
        for (int i = 0; i < N; i++) {
            if(i % 2 == 0){
                //숫자인 경우
                nums.add(mathExpression.charAt(i) - '0');
            }else{
                operators.add(mathExpression.charAt(i));
            }
        }

        //2. 백트래킹한다.
        backTracking(0,nums.get(0), 1);
        System.out.println(answer);
    }
    static void backTracking(int cnt, int sum, int numIndex){
        //2.1 기저 조건: cnt == operators.size()까지 해서 나온결과와 비교해서 최대값 찾는다.
        if(cnt == operators.size()){
            answer = Math.max(answer, sum);
            return;
        }

        //2.2.1 괄호를 넣지 않으면 : 그냥 현재까지 sum한 값과 다음 숫자와 operators.get(cnt)시킨다.
        backTracking(cnt + 1, operate(sum, nums.get(numIndex), operators.get(cnt)), numIndex+1);

        //2.2.2. 괄호를 넣는 경우: 먼저 뒷 숫자와 그 뒷숫자 연산한 후 sum과 연산
        //주의점 배열 범위 안나가는 선에서 괄호를 만들어야 한다.
        if(numIndex <= nums.size() - 2){
            backTracking(cnt + 2, operate(sum, operate(nums.get(numIndex),nums.get(numIndex+1),operators.get(cnt+1)), operators.get(cnt)), numIndex+2);

        }
    }
    static int operate(int a, int b, char operator){
        if(operator == '+'){
            return a + b;
        }else if (operator == '-'){
            return a-b;
        }
        return a * b;
    }
}