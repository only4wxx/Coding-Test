// 14502
// 연구소

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M; // 지도의 크기
    public static int[][] originMap; // 기존 지도
    public static int result = 0; // 얻을 수 있는 안전 영역의 최대 크기

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        originMap = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) originMap[n][m] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // 처음으로 벽을 세울 수 있는 모든 경우의 수
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (originMap[i][j] == 0) {
                    Stack<int[]> nextWalls = new Stack<>();
                    nextWalls.push(new int[]{i, j});
                    blockVirus(nextWalls);
                }
        System.out.println(result);
    }

    public static int getSafeArea(Stack<int[]> walls) {
        // 지도 복사
        int[][] virusMap = new int[N][M];
        for (int i=0; i<N; i++)
            for (int j=0; j<M; j++)
                virusMap[i][j] = originMap[i][j];
        // 벽을 세움
        for (int[] wall : walls) virusMap[wall[0]][wall[1]] = 1;

        // 바이러스가 퍼짐
        Queue<int[]> nextVirus = new LinkedList<>();
        for (int i=0; i<N; i++)
            for (int j=0; j<M; j++)
                if (virusMap[i][j] == 2) nextVirus.offer(new int[]{i, j});
        while (!nextVirus.isEmpty()) {
            int[] nextPos = nextVirus.poll(); // 바이러스가 있는 부분
            // 주위가 빈 칸이라면 바이러스가 퍼짐
            if (nextPos[0] > 0 && virusMap[nextPos[0]-1][nextPos[1]] == 0) {
                virusMap[nextPos[0]-1][nextPos[1]] = 2;
                nextVirus.offer(new int[]{nextPos[0]-1, nextPos[1]});
            } if (nextPos[1] > 0 && virusMap[nextPos[0]][nextPos[1]-1] == 0) {
                virusMap[nextPos[0]][nextPos[1]-1] = 2;
                nextVirus.offer(new int[]{nextPos[0], nextPos[1]-1});
            } if (nextPos[0] < N-1 && virusMap[nextPos[0]+1][nextPos[1]] == 0) {
                virusMap[nextPos[0]+1][nextPos[1]] = 2;
                nextVirus.offer(new int[]{nextPos[0]+1, nextPos[1]});
            } if (nextPos[1] < M-1 && virusMap[nextPos[0]][nextPos[1]+1] == 0) {
                virusMap[nextPos[0]][nextPos[1]+1] = 2;
                nextVirus.offer(new int[]{nextPos[0], nextPos[1]+1});
            }
        }

        // 안전 영역의 크기를 구함(바이러스가 퍼지지 않는 부분)
        int safeArea = 0;
        for (int i=0; i<N; i++)
            for (int j=0; j<M; j++)
                if (virusMap[i][j] == 0) safeArea += 1;
        return safeArea;
    }

    public static void blockVirus(Stack<int[]> walls) {
        if (walls.size() == 3) { // 벽을 세 개 모두 세웠다면
            int safeArea = getSafeArea(walls);
            if (safeArea > result) {
                result = safeArea;
            }

//            int[] wall1 = walls.get(0);
//            int[] wall2 = walls.get(1);
//            int[] wall3 = walls.get(2);
//            System.out.print(wall1[0] + " " + wall1[1] + " / ");
//            System.out.print(wall2[0] + " " + wall2[1] + " / ");
//            System.out.print(wall3[0] + " " + wall3[1] + " / ");
//            System.out.println("---> " + safeArea);
//            System.out.println("--------------");
            return;
        }

        // 벽을 세울 수 있는 모든 경우의 수를 계산
        int[] pre = walls.peek();
        for (int i = pre[0]; i < N; i++)
            for (int j = 0; j < M; j++)
                if (i == pre[0] && j <= pre[1]) continue;
                else if (originMap[i][j] == 0) {
                    Stack<int[]> nextWalls = new Stack<>();
                    for (int[] wall : walls) nextWalls.push(wall);
                    nextWalls.push(new int[]{i, j});
                    blockVirus(nextWalls);
                }
    }
}