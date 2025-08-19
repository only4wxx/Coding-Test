// 16928
// 뱀과 사다리 게임

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N; // 사다리의 수
    public static int M; // 뱀의 수
    public static HashMap<Integer, Integer> move = new HashMap<>(); // 사다리 또는 뱀의 정보
    public static boolean[] visited = new boolean[101]; // 이미 방문했던 칸인지

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            move.put(start, end);
        }
        br.close();

        System.out.println(findShortestPath());
    }

    public static int findShortestPath() {
        Queue<int[]> point = new LinkedList<>(); // 현재 탐색 중인 칸, 주사위 몇 번 굴렸는지
        point.offer(new int[]{1, 0}); // 시작점

        while (!point.isEmpty()) {
            int[] currentPoint = point.poll();
            visited[currentPoint[0]] = true;

            if (currentPoint[0] + 6 >= 100) { // 도착할 수 있는 경우
                return currentPoint[1] + 1;
            }

            // 이동 1~6까지 모든 경우의 수를 계산
            for (int dice = 1; dice <= 6; dice++) {
                if (move.containsKey(currentPoint[0]+dice)) {
                    int next = move.get(currentPoint[0] + dice);
                    if (!visited[next]) // 아직 방문하지 않은 칸일 경우만
                        point.offer(new int[]{next, currentPoint[1] + 1});
                }
                else {
                    int next = currentPoint[0]+dice;
                    if (!visited[next]) // 아직 방문하지 않은 칸이 경우만
                        point.offer(new int[]{next, currentPoint[1]+1});
                }
            }
        }
        return 0;
    }
}