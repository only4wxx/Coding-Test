// 11497
// 통나무 건너뛰기


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 통나무 개수
            int[] heights = new int[N]; // 통나무 높이를 나타내는 배열
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                heights[j] = Integer.parseInt(st.nextToken());
            }

            selectionSort(N, heights);
//            System.out.println(Arrays.toString(heights));

            int[] result = new int[N];
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0)
                    result[i/2] = heights[i];
                else
                    result[(N-1) - i/2] = heights[i];
            }

//            System.out.println(Arrays.toString(result));

            // 난이도 구하기
            int level = 0;
            for(int i = 0; i < N-1; i++) {
                if (Math.abs(result[i] - result[i+1]) > level) level = Math.abs(result[i] - result[i+1]);
            }
            System.out.println(level);
        }

        br.close();
    }

    public static void selectionSort(int N, int[] heights) {
        for (int i = 0; i < N; i++) {
            // 해당 범위 중 최솟값을 찾음
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (heights[j] < heights[min]) min = j;
            }

            // 최솟값과 교환
            int temp = heights[i];
            heights[i] = heights[min];
            heights[min] = temp;
        }
    }
}