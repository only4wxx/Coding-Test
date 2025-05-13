// 14426
// 접두사 찾기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N; // 집합 S에 포함되어 있는 문자열의 개수
    private static int M; // 검사해야 하는 문자열의 개수
    private static List<String> wordSet = new ArrayList<>();
    private static List<String> checkWords = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) wordSet.add(br.readLine());
        for (int i = 0; i < M; i++) checkWords.add(br.readLine());

        wordSet.sort(null); // 오른차순으로 정렬
//        for (int i = 0; i < N; i++) System.out.println(wordSet.get(i));

        int count = 0;
        for (String checkWord : checkWords) count += checkPrefix(wordSet, checkWord);
        System.out.println(count);
        br.close();
    }

    public static int checkPrefix(List<String> wordSet, String checkWord) {
//        System.out.println(checkWord + " ----------");
        int left = 0; int right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            String currentWord = wordSet.get(mid);
//            System.out.println(currentWord);
            if (currentWord.length() < checkWord.length()) return 0;
            currentWord = currentWord.substring(0, checkWord.length()); // 확인해야 하는 만큼만 자름

            if (checkWord.compareTo(currentWord) < 0) {
                right = mid - 1;
            } else if (checkWord.compareTo(currentWord) > 0) {
                left = mid + 1;
            } else return 1;
        }

        return 0;
    }
}