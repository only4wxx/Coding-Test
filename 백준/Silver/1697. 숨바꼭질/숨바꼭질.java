// 1697
// 숨바꼭질

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N; // 수빈이의 위치
    public static int K; // 동생의 위치
    public static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> pos = new LinkedList<Integer>(); // 다음으로 탐색할 위치
        pos.add(N); // 수빈이의 처음 위치부터 시작

        bfs(pos, 0);

        br.close();
    }

    public static void bfs(Queue<Integer> pos, int num) {
        Queue<Integer> nextPos = new LinkedList<Integer>(); // 다음으로 탐색할 위치

        while (!pos.isEmpty()) {
            int P = pos.poll();

            if (P == K) { // 동생의 위치를 찾았다면
//                System.out.print(visited);
                System.out.println(num);
                System.exit(0);
            }
            else  {
                // 다음 위치들
                if (P * 2 <= 100000 && !visited[P * 2]) {
                    visited[P * 2] = true;
                    nextPos.add(P * 2);
                }
                if (P + 1 <= 100000 && !visited[P + 1]) {
                    visited[P + 1] = true;
                    nextPos.add(P + 1);
                }
                if (P - 1 >= 0 && !visited[P - 1]) {
                    visited[P - 1] = true;
                    nextPos.add(P - 1);
                }
            }

        }
//        System.out.print(visited.toString());
//        System.out.println(nextPos.toString());
        bfs(nextPos, num+1);

    }
}