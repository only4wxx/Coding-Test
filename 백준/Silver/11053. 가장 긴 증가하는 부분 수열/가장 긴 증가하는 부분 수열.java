// 11053
// 가장 긴 증가하는 부분 수열

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N; // 입력 크기
    private static int[] seq; // 수열
    private static int[] seqLen; // 부분 수열의 길이

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        seqLen = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++)
            seq[n] = Integer.parseInt(st.nextToken());
        br.close();

        int result = 1; // 출력값. 가장 긴 증가하는 부분 수열의 길이
        for (int n = 0; n < N; n++) {
            int current = 1; // 현재 최대 길이
            for (int i = 0; i < n; i++) { // 보다 앞에 위치한 값들을 체크
                if (seq[i] < seq[n] && current < seqLen[i] + 1) // 증가하는 수열인 경우, 가장 긴 길이를 기록
                    current = seqLen[i] + 1;
            }
            seqLen[n] = current;
            if (result < current) result = current;
        }

        System.out.println(result);
    }
}