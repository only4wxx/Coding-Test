// 9465
// 스티커

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int T; // 테스트 케이스의 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());; // 스티커는 2N개 존재
            int[][] sticker = new int[2][N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 1; n <= N; n++)
                sticker[0][n] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int n = 1; n <= N; n++)
                sticker[1][n] = Integer.parseInt(st.nextToken());

            System.out.println(findMaxScore(N, sticker));
        }
        br.close();

    }

    public static int findMaxScore(int N, int[][] sticker) {
        int result = sticker[0][1];
        if (sticker[1][1] > result) result = sticker[1][1];

        for (int i = 2; i <= N; i++) {
            // 1st row
            int currentMax = 0;
            if (sticker[0][i-2] > currentMax) currentMax = sticker[0][i-2];
            if (sticker[1][i-2] > currentMax) currentMax = sticker[1][i-2];
            if (sticker[1][i-1] > currentMax) currentMax = sticker[1][i-1];
            sticker[0][i] += currentMax;

            // 2nd row
            currentMax = 0;
            if (sticker[0][i-2] > currentMax) currentMax = sticker[0][i-2];
            if (sticker[0][i-1] > currentMax) currentMax = sticker[0][i-1];
            if (sticker[1][i-2] > currentMax) currentMax = sticker[1][i-2];
            sticker[1][i] += currentMax;

            // 최대 점수 찾기
            if (sticker[0][i] > result) result = sticker[0][i];
            if (sticker[1][i] > result) result = sticker[1][i];
        }

//        for (int i = 1; i <= N; i++)
//            System.out.print(sticker[0][i] + " ");
//        System.out.println();
//        for (int i = 1; i <= N; i++)
//            System.out.print(sticker[1][i] + " ");
//        System.out.println();

        return result;
    }
}