import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int T; // 테스트 케이스의 개수
    private static List<Integer> cases; // 경우의 수를 담을 리스트
    private static int[][] arr = new int[10001][4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스
        cases = new ArrayList<>(); // 경우의 수를 담을 리스트 -> DP를 위해
        for (int t = 0; t < T; t++)
            cases.add(Integer.parseInt(br.readLine()));
        br.close();

        // 초기값
        arr[1][1] = 1;
        arr[2][1] = 1; arr[2][2] = 1;
        arr[3][1] = 1; arr[3][2] = 1; arr[3][3] = 1;

        for (int i = 4; i <= 10000; i++) {
            arr[i][1] = arr[i-1][1];
            arr[i][2] = arr[i-2][1] + arr[i-2][2];
            arr[i][3] = arr[i-3][1] + arr[i-3][2] + arr[i-3][3];
        }

        for (int t = 0; t < T; t++) {
            int n = cases.get(t); // 1, 2, 3의 합으로 나타내야 되는 정수 n
            System.out.println(arr[n][1] + arr[n][2] + arr[n][3]);
        }
    }
}