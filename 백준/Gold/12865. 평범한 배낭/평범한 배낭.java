// 12865
// 평범한 배낭

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N; // 물품의 수
    public static int K; // 준서가 버틸 수 있는 무게
    public static int[][] objects; // 물건
    public static int[][] maxValue; // 총 무게: 무게로 얻을 수 있는 최대 가치

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        objects = new int[N+1][2];
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            objects[n][0] = Integer.parseInt(st.nextToken());
            objects[n][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        maxValue = new int[N+1][K+1];
        for (int w = 0; w <= K; w++) maxValue[0][w] = 0; // 값 초기화

        for (int n = 1; n <= N; n++) {
            for (int w = 0; w <= K; w++) {
                if (w < objects[n][0]) { // 이전 기록한 값 그대로
                    maxValue[n][w] = maxValue[n-1][w];
                }
                else {
                    // 물건의 무게 이상이면
                    // 이미 기록된 최대값 vs 현재 탐색하는 물건의 가치 + 물건의 무게를 뺀 나머지 무게로의 최대 가치 -> 더 큰 값을 기록
                    if (maxValue[n-1][w] < objects[n][1] + maxValue[n-1][w-objects[n][0]])
                        maxValue[n][w] = objects[n][1] + maxValue[n-1][w-objects[n][0]];
                    else maxValue[n][w] = maxValue[n-1][w];
                }
            }
        }

        System.out.println(maxValue[N][K]); // 배낭에 넣을 수 있는 물건들의 가치합의 최댓값
    }
}