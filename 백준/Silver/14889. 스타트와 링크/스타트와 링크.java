// 14889
// 스타트와 링크

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] S;
    public static int result = 200;

    public static void main(String[] args) throws Exception {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken()); // Sij 값
            }
        }

        // 백트래킹 구현
        backtracking(new ArrayList<>(Arrays.asList(0)));
        System.out.println(result);

        br.close();
    }

    public static void backtracking(List<Integer> startTeam) {
        int teamLength = startTeam.size();
        if (teamLength == N/2) { // 팀 결성이 완료되었다면

            // 링크팀을 찾음
            List<Integer> linkTeam = new ArrayList<>();
            for (int num = 0; num < N; num++) {
                if (!startTeam.contains(num)) { // 해당 인물이 스타트팀이 아닌 경우
                    linkTeam.add(num);
                }
            }

//            System.out.print(startTeam.toString());
//            System.out.println(linkTeam.toString());
            
            // 능력치의 차를 계산
            // 스타트팀은 더하고, 링크팀은 뺌
            int diff = 0;
            for (int i = 0; i < teamLength; i++) {
                for (int j = i+1; j < teamLength; j++) {
                    diff += S[startTeam.get(i)][startTeam.get(j)] + S[startTeam.get(j)][startTeam.get(i)];
                    diff -= S[linkTeam.get(i)][linkTeam.get(j)] + S[linkTeam.get(j)][linkTeam.get(i)];
                }
            }
            if (diff < 0) diff *= -1; // 양수로 변환
//            System.out.println(diff);
            if (diff < result) result = diff; // 최솟값인지 확인
        }
        else {
            int e = startTeam.get(teamLength-1); // 인덱스의 마지막 요소
            for (int i = e+1; i <= N/2+teamLength; i++) { // 조합을 구현
                List<Integer> nextArr = new ArrayList<>(startTeam);
                nextArr.add(i);
                backtracking(nextArr);
            }
        }
    }
}