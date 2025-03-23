// 1931
// 회의실 배정

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력 개수
        int[][] meetings = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // 각 회의
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (o1, o2) -> {
            // 종료 시간을 바탕으로 오름차순 정렬
            if (o1[1] == o2[1]) { // 종료 시간이 같다면 시작 시간을 바탕으로 정렬
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int result = 0; // 결과값
        int lastFinish = 0; // 가장 마지막 회의의 종료 시간
        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= lastFinish) { // 회의가 종료한 후라면
                // 바로 회의 시작
                result += 1;
                lastFinish = meetings[i][1];
            }
            // 회의가 종료하지 않았다면 패스
        }

        System.out.println(result);
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}