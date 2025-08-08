// 13549
// 숨바꼭질 3

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N; // 수빈이의 현재 위치
    public static int K; // 동생의 위치

    public static boolean[] visited = new boolean[100001]; // 탐색한 위치
    public static int result = Integer.MAX_VALUE;; // 수빈이가 동생을 찾을 수 있는 가장 빠른 시간

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        br.close();

        Queue<int[]> nextPos = new LinkedList<>(); // 다음으로 탐색할 위치, 탐색하는 시간(초)
        nextPos.add(new int[]{N, 0});

        bfs(nextPos);
        System.out.println(result);
    }

    public static void bfs (Queue<int[]> nextPos) {
        while (!nextPos.isEmpty()) {
            int[] pos = nextPos.poll(); // 탐색할 위치
            visited[pos[0]] = true; // 탐색 처리

            if (pos[0] == K) // 동생을 찾은 경우
                if (pos[1] < result)
                    result = pos[1]; // 가장 빠른 시간을 찾음

            if (pos[0] > 0 && !visited[pos[0]-1]) {
                nextPos.add(new int[]{pos[0]-1, pos[1]+1});
            }
            if (pos[0] < 100000 && !visited[pos[0]+1]) {
                nextPos.add(new int[]{pos[0]+1, pos[1]+1});
            }
            if (pos[0] * 2 <= 100000 && !visited[pos[0]*2]) {
                nextPos.add(new int[]{pos[0]*2, pos[1]});
            }
        }
    }
}