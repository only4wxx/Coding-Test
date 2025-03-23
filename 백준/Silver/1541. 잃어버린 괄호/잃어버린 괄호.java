// 1541
// 잃어버린 괄호

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int result = 0;
        int numIndex = 0; // 숫자 인덱스 값
        int multiply = 1; // 곱할 값 -> 괄호 여부를 체크
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') { // 빼기 시작
                // 괄호가 열린 상태 -> 앞에 있는 숫자는 빼고 괄호 닫고 다시 열기
                // 괄호가 닫힌 상태 -> 앞에 있는 숫자는 더하고 괄호 열기
                result += multiply * (Integer.parseInt(str.substring(numIndex, i)));
                multiply = -1; // 괄호 열기
                numIndex = i + 1; // 숫자 인덱스 값 업데이트
            }
            else if (str.charAt(i) == '+') {
                // 괄호가 열린 상태 -> 앞에 있는 숫자 빼기
                // 괄호가 닫힌 상태 -> 앞에 있는 숫자 더하기
                result += multiply * (Integer.parseInt(str.substring(numIndex, i)));
                numIndex = i + 1; // 숫자 인덱스 값 업데이트
            }
            else { // 숫자인 경우
                continue;
            }
        }
        // 나머지 숫자 처리
        // 괄호가 열린 상태 -> 나머지 숫자 빼기
        // 괄호가 닫힌 상태 -> 나머지 숫자 더하기
        result += multiply * (Integer.parseInt(str.substring(numIndex, str.length())));

        System.out.println(result);
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}