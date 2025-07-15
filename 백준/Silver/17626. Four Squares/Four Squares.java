import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int[] dp; // 가능한 최소 경우의 수를 기록. 수:경우의 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        dp = new int[n + 1];
        dp[1] = 1;

        System.out.println(findSquare(n));
//        for (int i = 1; i <= n; i++) {
//            System.out.println(i + " : " + dp[i]);
//        }
    }

    private static int findSquare(int num) {
        if (dp[num] > 0) return dp[num]; // 이미 계산한 값이라면

        if (Math.sqrt(num) % 1 == 0) { // 제곱수인 경우
            dp[num] = 1;
            return 1;
        }

        int square = (int)(Math.sqrt(num)); // 가장 큰 제곱수
        int minimumRes = 4;
        for (int n = square; n > square / 2; n--) {
            int res = findSquare(num-(int)(Math.pow(n, 2)));
            if (res + 1 < minimumRes) minimumRes = 1 + res;
        }
        dp[num] = minimumRes;
        return minimumRes;
    }
}