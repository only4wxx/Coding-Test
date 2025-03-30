// 14888
// 연산자 끼워넣기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[] operand;
    public static int[] numOperator;
    public static int resultMax = -1000000000;
    public static int resultMin = 1000000000;

    public static void main(String[] args) throws Exception {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        operand = new int[N];
        numOperator = new int[4];
        List<Integer> operator = new ArrayList<>(); // 0(+), 1(-), 2(×), 3(÷)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) operand[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) numOperator[i] = Integer.parseInt(st.nextToken());
//        System.out.println(Arrays.toString(operand));
//        System.out.println(Arrays.toString(numOperator));

        calculate(numOperator, operator);
        br.close();

        System.out.println(resultMax);
        System.out.println(resultMin);
    }

    public static void calculate(int[] numOperator, List<Integer> operator) {
        if (operator.size() == N-1) { // 연산자를 다 채웠다면
            // 계산
//            System.out.println(operator.toString());
            int result = operand[0];
            for (int i = 0; i < N-1; i++) {
                if (operator.get(i) == 0) { // +
                    result += operand[i+1];
                } else if (operator.get(i) == 1) { // -
                    result -= operand[i+1];
                } else if (operator.get(i) == 2) { // ×
                    result *= operand[i+1];
                } else if (operator.get(i) == 3) { // ÷
                    result /= operand[i+1];
                }
            }

            if (result > resultMax) resultMax = result;
            if (result < resultMin) resultMin = result;
        }
        for (int i = 0; i < 4; i++) { // 모든 operator 별로
            if (numOperator[i] > 0) { // 해당 operator가 있다면
                // 연산자에 추가
                int[] nextNO = Arrays.copyOf(numOperator, numOperator.length);
                nextNO[i] -= 1;
                ArrayList<Integer> nextO = new ArrayList<>(operator);
                nextO.add(i);
                calculate(nextNO, nextO);
            }
        }
    }

}