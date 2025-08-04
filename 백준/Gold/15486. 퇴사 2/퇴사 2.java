// 15486
// 퇴사 2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N; // 퇴사 전 남은 날
    public static int[][] reservation; // 상담 예약 리스트
    public static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        reservation = new int[N+1][2];
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            reservation[n][0] = Integer.parseInt(st.nextToken());
            reservation[n][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        dp = new int[N+1]; // 인덱스는 종료일을 나타냄
        for (int n = 1; n <= N; n++) {
            int lastDay = n + reservation[n][0] - 1; // 상담 종료일

            if (dp[n-1] > dp[n]) // 해당 날짜 전까지의 수익의 최댓값
                dp[n] = dp[n-1];
            if (lastDay > N) // 종료일이 퇴사 이후인 경우
                continue; // 상담을 할 수 없음

            // max(시작일 전까지의 수익+현재 수익, dp[종료일])
            if (dp[lastDay] < dp[n-1] + reservation[n][1]) {
                dp[lastDay] = dp[n-1] + reservation[n][1];
            }

//            for (int i = 1; i <= N; i++) System.out.print(dp[i] + " ");
//            System.out.println();
        }

        System.out.println(dp[N]);
    }
}