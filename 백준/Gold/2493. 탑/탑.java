// 2493
// 탑

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int N; // 탑의 수
    public static int[] towers; // 탑
    public static int[] results;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        towers = new int[N]; // 1~N번
        results = new int[N];
        for (int i = 0; i < N; i++)
            towers[i] = Integer.parseInt(st.nextToken());
        br.close();

        Stack<Integer> stack = new Stack<>();
        for (int i = N-1; i >= 0; i--) {
//            for (int s : stack)
//                System.out.print(s + " ");
//            System.out.println("------");

            while (!stack.isEmpty()) {
                if (towers[i] >= towers[stack.peek()])
                    results[stack.pop()] = i + 1;
                else break;
            }
            stack.push(i);
        }

        // 출력
        for (int result : results)
            System.out.print(result + " ");
    }


}