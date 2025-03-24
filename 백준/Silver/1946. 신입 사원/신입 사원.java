// 1946
// 신입 사원

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public void solution(BufferedReader br) throws Exception {
        // 입력 받기
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력 개수
        int[][] applicants = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // 각 지원자
            applicants[i][0] = Integer.parseInt(st.nextToken()); // 서류심사 순위
            applicants[i][1] = Integer.parseInt(st.nextToken()); // 면접 순위
        }

        Arrays.sort(applicants, (o1, o2) -> {
            // 서류심사 순위를 바탕으로 오름차순 정렬
            return o1[0] - o2[0];
        });

        int result = 0; // 결과값
        int highest = N+1; // 현재 가장 높은 순위
        for (int i = 0; i < N; i++) {
            // 반복문을 돌며 점차 서류심사 순위가 낮아짐.
            // 따라서 각 지원자는 현재까지의 지원자들보다 면접 순위가 높아야만 합격
            if (applicants[i][1] < highest) {
                // 합격
                result += 1;
                highest = applicants[i][1]; // 가장 높은 순위 업데이트
            }
        }

        System.out.println(result);
//        br.close();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int i = 0; i < T; i++) {
            new Main().solution(br);
        }
        br.close();
    }
}