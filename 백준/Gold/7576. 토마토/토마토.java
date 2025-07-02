import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int M;
    private static int N;
    private static int[][] box;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        System.out.println(bfs());
    }

    public static int bfs() {
        Set<int[]> nextTomatoes = new HashSet<>(); // 다음으로 익을 토마토의 위치
        // 익은 토마토가 있는지
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (box[x][y] == 1) { // 익은 토마토가 있다면
                    nextTomatoes.add(new int[]{x, y}); // 세트에 추가하여 이후 체크하도록
                }
            }
        }
//        for (int[] tomato : nextTomatoes) {
//            System.out.println(tomato[0] + " " + tomato[1]);
//        }

        int date = 0; // 토마토가 모두 익는 데 걸리는 최소 날짜
        while (true) {
//            for (int[] tomato : nextTomatoes) {
//                System.out.print("[" + tomato[0] + ", " + tomato[1] + "] ");
//            }
//            System.out.println();

            // 모든 토마토가 익었는지 확인
            boolean isFinish = true;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (box[x][y] == 0) { // 아직 안 익은 토마토가 있다면
                        isFinish = false;
                        break;
                    }
                }
                if (!isFinish) break;
            }
            if (isFinish) break; // 모든 토마토가 익었다면 종료
            else if (nextTomatoes.isEmpty()) return -1; // 토마토가 모두 익지는 못하는 상황인 경우

            // 아직 안 익은 토마토가 있는 경우
            date++; // 날짜 증가
            Set<int[]> latestTomato = new HashSet<>(); // 가장 최근에 익은 토마토들
            for (int [] tomato : nextTomatoes) latestTomato.add(tomato);
            nextTomatoes.clear();

            for (int[] tomato : latestTomato) { // 가장 최근에 익은 토마토들 기준으로
                int x = tomato[0]; int y = tomato[1];

                // 상하좌우에 아직 안 익은 토마토가 있다면
                // 다음으로 익을 토마토에 추가
                if (x < N-1 && box[x+1][y] == 0) {
                    nextTomatoes.add(new int[]{x+1, y});
                    box[x+1][y] = 1;
                }
                if (y < M-1 && box[x][y+1] == 0) {
                    nextTomatoes.add(new int[]{x, y+1});
                    box[x][y+1] = 1;
                }
                if (x > 0 && box[x-1][y] == 0) {
                    nextTomatoes.add(new int[]{x-1, y});
                    box[x-1][y] = 1;
                }
                if (y > 0 && box[x][y-1] == 0) {
                    nextTomatoes.add(new int[]{x, y-1});
                    box[x][y-1] = 1;
                }
            }
        }

        return date;
    }
}
