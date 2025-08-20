// 12847
// 꿀 아르바이트

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static int n; // 월세를 내기 바로 전날
    public static int m; // 일을 할 수 있는 날
    public static long[] T; // 일급

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        T = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            T[i] = Long.parseLong(st.nextToken());
        }
        br.close();

        long maxPay = 0; // 최대 이익
        for (int start = 0; start <= n - m; start++) {
            long sumPay = 0;
            for (int i = 0; i < m; i++) sumPay += T[start + i];
            if (sumPay > maxPay) maxPay = sumPay;
        }
        System.out.println(maxPay);
    }
}