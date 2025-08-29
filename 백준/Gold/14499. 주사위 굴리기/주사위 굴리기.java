// 14499
// 주사위 굴리기


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N; // 지도의 세로 크기
    public static int M; // 지도의 가로 크기
    public static int x, y; // 주사위를 놓은 곳의 좌표 x, y
    public static int K; // 명령의 개수

    public static int[][] map; // 지도
    public static int[] order; // 명령

    public static int[][] dice = new int[4][4]; // 주사위 전개도
    public static int[] diceNum = new int[7]; // 주사위의 각 면에 쓰인 숫자

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        order = new int[K];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++)
                map[n][m] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) order[k] = Integer.parseInt(st.nextToken());
        br.close();


        dice[0][1] = 2;
        dice[1][0] = 4; dice[1][1] = 1; dice[1][2] = 3; dice[1][3] = 6;
        dice[2][1] = 5; dice[3][1] = 6;

        for (int k = 0; k < K; k++) {
            rollDice(order[k]);
        }
    }

    public static void rollDice(int order) {
        // 주사위 굴림
        int temp = 0;
        switch (order) {
            case 1: // 동쪽
                if (y + 1 >= M) return;

                y += 1;
                temp = dice[1][3];
                dice[1][3] = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = temp;
                dice[3][1] = dice[1][3];
                break;
            case 2: // 서쪽
                if (y - 1 < 0) return;

                y -= 1;
                temp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[1][3];
                dice[1][3] = temp;
                dice[3][1] = dice[1][3];
                break;
            case 3: // 북쪽
                if (x - 1 < 0) return;

                x -= 1;
                temp = dice[0][1];
                dice[0][1] = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = temp;
                dice[1][3] = dice[3][1];
                break;
            case 4: // 남쪽
                if (x + 1 >= N) return;

                x += 1;
                temp = dice[3][1];
                dice[3][1] = dice[2][1];
                dice[2][1] = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[0][1] = temp;
                dice[1][3] = dice[3][1];
                break;
        }


        // 주사위 굴렸을 때 이동한 칸에 쓰여있는 수가
        if (map[x][y] == 0) { // 0이면
            // 주사위 바닥면에 쓰여 있는 수가 칸에 복사됨
            map[x][y] = diceNum[dice[1][3]];
        } else { // 0이 아니면
            // 칸에 쓰여 있는 수가 주사위 바닥면으로 복사됨
            diceNum[dice[1][3]] = map[x][y];
            // 칸에 쓰여 있는 수는 0이 됨
            map[x][y] = 0;
        }

//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(dice[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(diceNum[dice[1][1]]); // 주사위 상단에 쓰여있는 값
//        System.out.println("---------");
    }


}