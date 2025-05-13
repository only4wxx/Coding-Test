// 6236
// 용돈 관리

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int[] money;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];
        for (int i = 0; i < N; i++) money[i] = Integer.parseInt(br.readLine());

        int result = 0; // 최소 금액 K
        int left = 1; int right = 10000 * 100000;
        while (left <= right) {
            int mid = (right + left) / 2;
//            System.out.println(mid);
            int isPossible = checkMinumumPrice(mid);
            if (isPossible >= 0) {
                result = mid; // 인출 횟수 일치
                right = mid-1;
            }
            else left = mid+1;
        }

        System.out.println(result);

        br.close();
    }

    public static int checkMinumumPrice(int k) {
        // 인출 금액이 k라면 인출 횟수는 몇 번인지

        int price = k; // 현재 인출한 금액
        int number = 1;
        for (int i = 0; i < N; i++) {
            if (money[i] > k) return -1; // k보다 큰 금액이 있다면 이 k는 불가능

            if (price - money[i] < 0) { // k 금액이 부족하다면
                number += 1; // 인출
                price = k - money[i];
            } else {
                price -= money[i];
            }
        }

        return M - number; // +이면 k를 작게, -이면 k를 크게, 0이면 일치
    }

}