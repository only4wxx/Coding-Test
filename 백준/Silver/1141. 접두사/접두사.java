// 1141
// 접두사

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static int N;
    public static ArrayList<String> words = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) words.add(br.readLine());

        // 가장 앞 알파벳이 같으면, 단어 길이 내림차순으로 정렬
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(0) == o2.charAt(0)) return o2.length() - o1.length();
                else return o2.compareTo(o1);
            }
        });
//        for (int i = 0; i < N; i++) System.out.println(words.get(i));

        findMaxNum(words);
        br.close();
    }

    public static void findMaxNum(ArrayList<String> words) {
        // 접두사X 집합인 부분집합의 최대 크기를 구함
        ArrayList<String> prefixWords = new ArrayList<>(); // 접두사 X 집합
        for (String word : words) {
            boolean isPresent = false;
            for (String prefixWord : prefixWords) {
                // 해당 단어가 이미 있는 부분집합의 접두사이면 부분집합에 넣지 않음
                if (word.length() <= prefixWord.length() && word.equals(prefixWord.substring(0, word.length()))) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) prefixWords.add(word);
        }

        System.out.println(prefixWords.size());
    }

}