// 2468
// 안전 영역


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] area;
    public static int result;

    public static void main(String[] args) throws Exception {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];

        int lowest = 100; // 최소 높이
        int highest = 0; // 최대 높이
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (lowest > area[i][j]) lowest = area[i][j]; // 최소 높이를 구함
                if (highest < area[i][j]) highest = area[i][j]; // 최대 높이를 찾음
            }
        }

        for (int h = lowest; h <= highest; h++) {
            int[][] rainArea = new int[N][N]; // area 배열 복사
            for (int i = 0; i < N; i++)
                rainArea[i] = area[i].clone(); // 2차원 배열 깊은 복사

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (rainArea[i][j] > h) { // 물에 잠기지 않았다면
                        rainArea[i][j] = 0; // 0으로 표시
                    }
                }
            }

            dfs(rainArea);
        }

        if (result == 0) result = 1; // 모든 지역의 높이가 똑같다면
        System.out.println(result);
        br.close();
    }

    public static void dfs(int[][] rainArea) {
        int sumArea = 0; // 영역의 개수
        ArrayList<int[]> stack = new ArrayList<>();
        int[] p = new int[]{0, 0}; // 0, 0부터 탐색

        while (p[0] < N) { // 모든 위치를 탐색할 때까지

//            System.out.println(Arrays.toString(p));
            if (rainArea[p[0]][p[1]] == 0) { // 비에 잠기지 않은 지역이라면
                sumArea += 1;
                stack.add(p);

                while (!stack.isEmpty()) { // 인접한 모든 지역을 탐색할 때까지
                    int[] a = stack.remove(stack.size()-1); // 마지막 요소
                    rainArea[a[0]][a[1]] = -1; // 방문처리

                    // 각 방향 탐색
                    if (a[0] > 0 && rainArea[a[0]-1][a[1]] == 0) {
                        stack.add(new int[]{a[0]-1, a[1]});
                    }
                    if (a[0] < N-1 && rainArea[a[0]+1][a[1]] == 0) {
                        stack.add(new int[]{a[0]+1, a[1]});
                    }
                    if (a[1] > 0 && rainArea[a[0]][a[1]-1] == 0) {
                        stack.add(new int[]{a[0], a[1]-1});
                    }
                    if (a[1] < N-1 && rainArea[a[0]][a[1]+1] == 0) {
                        stack.add(new int[]{a[0], a[1]+1});
                    }
                }
            }

//            for (int i = 0; i < N; i++) System.out.println(Arrays.toString(rainArea[i]));
//            System.out.println(sumArea);
            p[1] += 1; // 다음 col으로 이동
            if (p[1] == N) { // 한 row를 모두 탐색했다면
                p[0] += 1;
                p[1] -= N;
            }
        }
        if (sumArea > result) result = sumArea; // 안전한 영역의 최대 개수
    }

}