// 12847
// 꿀 아르바이트

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static int T; // 게임의 수
    public static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            stringGame(W, K);
        }
        br.close();

        for (int i = 0; i < T; i++) {
            if (result.get(i).length == 1)
                System.out.println(-1);
            else System.out.println((result.get(i))[0] + " " + (result.get(i))[1]);
        }
    }

    public static void stringGame(String W, int K) {
        if (K == 1) {
            result.add(new int[]{1, 1});
            return;
        }

        int shortest = W.length() + 1; // 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이
        int longest = -1; // 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이

        for (int start = 0; start < W.length(); start++) {
            int count = 1; // 어떤 문자의 개수
            for (int i = start+1; i < W.length(); i++) {
                if (W.charAt(start) == W.charAt(i)) count += 1;

                if (count == K) { // 어떤 문자를 정확히 K개 포함했을 때
                    if (i - start + 1 < shortest)
                        shortest = i - start + 1; // 최솟값을 찾음

                    if (W.charAt(start) == W.charAt(i)) // 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 경우
                        if (i - start + 1 > longest) longest = i - start + 1; // 최댓값을 찾음

                    break;
                }
            }
        }

        if (shortest == W.length() + 1|| longest == -1 )
            result.add(new int[]{-1});
        else result.add(new int[]{shortest, longest});
    }
}