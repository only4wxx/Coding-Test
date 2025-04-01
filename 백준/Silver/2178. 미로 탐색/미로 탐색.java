// 2178
// 미로 탐색


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static String[][] maze;

    public static void main(String[] args) throws Exception {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new String[N][M];
        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine().split("");
        }

        ArrayList<int[]> qlist = new ArrayList<>();
        qlist.add(new int[]{0, 0});
        maze[0][0] = "2";
        bfs(qlist, 1);

        br.close();
    }

    public static void bfs(ArrayList<int[]> qlist, int num) {

        ArrayList<int[]> queue = new ArrayList<>();
        while (!qlist.isEmpty()) { // 다음으로 가야하는 위치
            int[] start = qlist.remove(0);

            int x = start[0];
            int y = start[1];
            if (x == N-1 && y == M-1) { // 도착
                System.out.println(num);
                return;
            }

            // 2: 방문함
            if (x > 0 && maze[x-1][y].equals("1")) {
                // 위
                queue.add(new int[]{x - 1, y});
                maze[x - 1][y] = "2";
            }
            if (x < N-1 && maze[x+1][y].equals("1")) {
                // 아래
                queue.add(new int[]{x + 1, y});
                maze[x + 1][y] = "2";
            }
            if (y > 0 && maze[x][y-1].equals("1")) {
                // 왼쪽
                queue.add(new int[]{x, y - 1});
                maze[x][y - 1] = "2";
            }
            if (y < M-1 && maze[x][y+1].equals("1")) {
                // 오른쪽
                queue.add(new int[]{x, y + 1});
                maze[x][y + 1] = "2";
            }
        }

//        for (int i = 0; i < queue.size(); i++) {
//            System.out.print(Arrays.toString(queue.get(i)));
//        }
//        System.out.println();

        // 거리를 1 늘려서 bfs
        bfs(queue, num+1);
    }

}