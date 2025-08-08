// 22251
// 빌런 호석

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N; // 엘레베이터는 1층부터 N층까지 이용 가능
    public static int K; // 자리수
    public static int P; // 반전시킬 수 있는 LED의 최대 개수
    public static String X; // 엘레베이터가 실제로 멈춰 있는 층

    public static int[][] numLED;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = st.nextToken();
        br.close();

        // 각 숫자를 만들기 위해 켜야 하는 LED
        numLED = new int[10][7];
        numLED[0] = new int[]{1, 1, 1, 0, 1, 1, 1};
        numLED[1] = new int[]{0, 0, 1, 0, 0, 1, 0};
        numLED[2] = new int[]{1, 0, 1, 1, 1, 0, 1};
        numLED[3] = new int[]{1, 0, 1, 1, 0, 1, 1};
        numLED[4] = new int[]{0, 1, 1, 1, 0, 1, 0};
        numLED[5] = new int[]{1, 1, 0, 1, 0, 1, 1};
        numLED[6] = new int[]{1, 1, 0, 1, 1, 1, 1};
        numLED[7] = new int[]{1, 0, 1, 0, 0, 1, 0};
        numLED[8] = new int[]{1, 1, 1, 1, 1, 1, 1};
        numLED[9] = new int[]{1, 1, 1, 1, 0, 1, 1};

        // 현재 층수에서 해당 숫자로 바꾸려면 반전시켜야 하는 LED의 개수를 계산
        String realFloor = "0".repeat(K-X.length()) + X; // 현재 층수. 최대 길이만큼 0을 붙임
        int[][] floorLED = new int[K][10];
        for (int k = 0; k < K; k++) { // 자리수별로
            int floorNum = realFloor.charAt(k) - '0'; // 해당 자리수 숫자
            for (int num = 0; num <= 9; num++) { // 각 숫자별로
                for (int i = 0; i < 7; i++) { // LED 번호별로 체크
                    if (numLED[floorNum][i] != numLED[num][i])
                        floorLED[k][num] += 1;
                }
            }
        }

        // 1층~최대 층수까지 반전시켜서 만들 수 있는 경우의 수를 셈
        int result = 0; // 경우의 수
        for (int floor = 1; floor <= N; floor++) {
            int reverse = 0 ; // 반전시킬 LED의 개수
            String currentFloor = Integer.toString(floor);
            currentFloor = "0".repeat(K-currentFloor.length()) + currentFloor; // 최대 길이만큼 0을 붙임

            for (int k = 0; k < K; k++) {
                int floorNum = currentFloor.charAt(k) - '0'; // 해당 자리수 숫자
                reverse += floorLED[k][floorNum];
            }
            if (reverse > 0 && reverse <= P) { // 최대 개수보다 작거나 같으면 가능, 같은 층수 제외
                // System.out.println(currentFloor + " " + reverse);
                result += 1;
            }
        }
        System.out.println(result);
    }
}