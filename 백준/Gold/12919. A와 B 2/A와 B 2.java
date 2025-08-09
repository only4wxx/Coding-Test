// 12919
// A와 B 2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static String S;
    public static String T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        br.close();

        // S를 T로 바꿈. 다음 두 가지 연산만 가능
        // 1. 문자열 뒤에 A를 추가
        // 2. 문자열 뒤에 B를 추가하고 문자열을 뒤집음

        changeWord();
    }

    public static void changeWord() {
        int result = 0;
        Queue<String> nextWord = new LinkedList<>();
        nextWord.offer(S);

        while (!nextWord.isEmpty()) {
            String word = nextWord.poll();
//            System.out.println(word);

            if (word.equals(T)) { // T로 바꿀 수 있는 경우
                result = 1;
                break;
            }

            String wordReverse = "";
            for (int c = word.length()-1; c >= 0; c--)
                wordReverse += word.charAt(c);

            if (T.contains(word) || T.contains(wordReverse)) { // 단어를 포함하고 있으면
                // 문자열 뒤에 A를 추가
                String addA = word + "A";
                nextWord.offer(addA);

                // 문자열 뒤에 B를 추가하고 문자열을 뒤집음
                String addB = "B" + wordReverse;
                nextWord.offer(addB);
            }
        }

        System.out.println(result);
    }
}