// 2792
// 보석 상자

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int N; // 아이들의 수
    private static int M; // 색상의 수
    private static int[] jewels;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        jewels = new int[M];
        for (int i = 0; i < M; i++) jewels[i] = Integer.parseInt(br.readLine());

        int result = 0;
        int left = 1;
        int right = Arrays.stream(jewels).max().orElse(0);
        while (left <= right) {
            int mid = (left + right) / 2;
            if (distributeJewels(mid) == true) {
                right = mid - 1;
                result = mid;
            } else left = mid + 1;
        }

        System.out.println(result);
        br.close();
    }

    public static boolean distributeJewels(int maxNumber) {
//        System.out.println("지금: " + maxNumber);
        // maxNumber가 한 명에게 나눠줄 최대 보석 개수가 되어도 괜찮은지?

        int i = 0; // student
        for (int jewel : jewels) {
            while (jewel > 0) {
                jewel -= maxNumber;
                i += 1;
//                System.out.println(jewel + " " + i);
                if (i > N) {
                    return false;
                }
            }
        }
        return true; // true면 maxNumber를 줄여서 다시 검사 -> 최소값을 찾기 위해
    }

}