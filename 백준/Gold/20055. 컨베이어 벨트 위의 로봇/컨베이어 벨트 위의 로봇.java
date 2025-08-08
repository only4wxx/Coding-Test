// 20055
// 컨베이어 벨트 위의 로봇

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N; // 벨트의 길이
    public static int K; // 내구도가 0인 칸의 개수가 K개 이상이면 과정 종료
    public static int[] belts; // 벨트의 내구도

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belts = new int[2*N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < 2*N; n++) belts[n] = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(beltRobot());
    }

    public static int beltRobot() {
        int step = 0; // 진행되고 있는 단계

        boolean[] robots = new boolean[N]; // 로봇이 벨트의 해당 위치 위에 있는지
        while (true) {
            // 내구도가 0인 칸의 개수가 K개 이상이라면 종료
            int count = 0;
            for (int n = 0; n < 2*N; n++)
                if (belts[n] <= 0) count++;
            if (count >= K) return step;
            step += 1; // 단계 추가

            // 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
            int[] temp = new int[2*N-1];
            for (int i = 0; i < 2*N-1; i++) temp[i] = belts[i];
            belts[0] = belts[2*N-1];
            for (int i = 0; i < 2*N-1; i++) belts[i+1] = temp[i];

            if (robots[N-1]) // 내리는 위치에 로봇이 있다면
                robots[N-1] = false; // 로봇이 내림
            for (int r = N-1; r > 0; r--) {
                // 로봇이 한 칸 회전
                robots[r] = robots[r-1];
            }
            robots[0] = false;

            // 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동
            for (int r = N-1; r > 0; r--) {
                if (robots[r]) { // 해당 위치에 로봇이 있다면
                    if (r == N-1) // 로봇이 내리는 위치에 도달했다면
                        robots[N-1] = false; // 로봇이 내림
                    else if (!robots[r+1] && belts[r+1] >= 1) { // 이동하려는 칸에 로봇이 없고, 그 칸의 내구도가 1 이상 남아있다면
                        // 로봇이 이동
                        robots[r] = false;
                        robots[r+1] = true;

                        // 도착 칸의 내구도 감소
                        belts[r+1] -= 1;
                    }
                }
            }

            // 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올림
            if (belts[0] > 0) {
                robots[0] = true;
                belts[0] -= 1;
            }

//            System.out.println(step + "단계 종료");
//            for (int n = 0; n < 2 * N; n++)
//                System.out.print(belts[n] + " ");
//            System.out.println();
//            for (int r = 0; r < N; r++)
//                System.out.print(robots[r] + " ");
//            System.out.println();
        }
    }
}