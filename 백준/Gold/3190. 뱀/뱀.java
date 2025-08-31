// 3190
// 뱀

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Queue<int[]> snake = new LinkedList<>(); // 뱀의 몸 위치
    public static int[][] board; // 보드
    public static HashMap<Integer, String> changeDir = new HashMap(); // 방향 변환 정보

    public static int[][] move = new int[][]{new int[]{-1, 0}, new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}}; // 북, 동, 남, 서

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 보드의 크기
        int K = Integer.parseInt(br.readLine()); // 사과의 크기
        board = new int[N][N]; // 사과가 있으면 1, 사과가 없으면 0
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            // 사과의 위치 저장
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x-1][y-1] = 1;
        }
        int L = Integer.parseInt(br.readLine()); // 방향 변환 횟수
        for (int i = 0; i < L; i++) {
            // 방향 변환
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            changeDir.put(sec, dir);
        }
        br.close();

        System.out.println(snakeGame(N));
    }

    private static int snakeGame(int N) {
        // 뱀의 현재 머리 위치 row, col, 방향(0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽) -> 시계방향
        int row = 0; int col = 0; int dir = 1;
        snake.offer(new int[]{row, col});

        int count = 0; // 초 기록
        while (true) {
            count += 1;
            // 뱀 이동
            row += move[dir][0]; col += move[dir][1];
            if (row < 0 || col < 0 || row >= N || col >= N) return count; // 벽에 닿으면 게임이 끝남
            for (int[] s : snake) { // 머리가 자기자신의 몸에 닿으면 게임이 끝남
                if (Arrays.equals(s, new int[]{row, col})) return count;
            }
            snake.offer(new int[]{row, col});

            // 이동한 칸에 사과가 있는지
            if (board[row][col] == 1)  // 사과가 있다면
                board[row][col] = 0; // 사과가 없어짐
            else snake.poll(); // 사과가 없다면 꼬리가 위치한 칸을 비워줌

            // 방향 전환이 필요한지
            if (changeDir.containsKey(count)) {
                if (changeDir.get(count).equals("L")) { // 왼쪽으로 방향전환(반시계 방향)
                    dir = (dir + 4 - 1) % 4;
                } else { // 오른쪽으로 방향전환(시계 방향)
                    dir = (dir + 1) % 4;
                }
            }

            // System.out.println(count + " : " + (row+1) + " " + (col+1) + " (" + snake.size());
        }
    }
}