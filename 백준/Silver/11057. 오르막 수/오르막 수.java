// 11057
// 오르막 수

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int N; // 수의 길이
    private static int[][] counts; // 숫자 길이가 [0]이고 [1]로 시작하는 오르막 수의 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();

        counts = new int[N][10]; // 숫자 길이 [0]일 때 [1]로 시작하는 오르막 수의 개수
        // 길이가 1인 경우
        for (int i = 0; i < 10; i++) counts[0][i] = 1;

        for (int n = 1; n < N; n++) { // 각 숫자 길이마다 카운트
            for (int start = 0; start < 10; start++) { // 이 숫자로 시작하는 오르막수
                for (int i = start; i < 10; i++) {
                    counts[n][start] += counts[n - 1][i] % 10007;
                }
                counts[n][start] = counts[n][start] % 10007;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += counts[N-1][i] % 10007; // 개수의 합을 구함
        }
        System.out.println(result % 10007);
    }
}