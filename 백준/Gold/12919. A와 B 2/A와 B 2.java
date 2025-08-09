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

        changeWord(T);
        System.out.println(0);
    }

    public static void changeWord(String word) {
        if (word.isEmpty()) return;
        if (word.equals(S)) {
            System.out.println(1);
            System.exit(0);
        }

        if (word.charAt(word.length()-1) == 'A') { // 마지막 글자가 A인 경우
            String temp = "";
            // 마지막 글자를 뺌
            for (int i = 0; i < word.length()-1; i++)
                temp += word.charAt(i);
            changeWord(temp);
        }
        if (word.charAt(0) == 'B') { // 첫번째 글자가 B인 경우
            String temp = "";
            // 첫번째 글자를 빼고 뒤집음
            for (int i = word.length()-1; i > 0; i--)
                temp += word.charAt(i);
            changeWord(temp);
        }
    }
}