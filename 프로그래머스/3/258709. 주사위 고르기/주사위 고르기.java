import java.util.*;

class Solution {
    public static int[][] dices; // 주사위
    public static int N; // 주사위의 길이
    public static boolean[] choice; // 선택한 주사위 조합. A는 true, B는 false
    
    public static int maxWin = 0; // 승리한 횟수 최대
    public static boolean[] maxChoice; // 승리한 횟수가 가장 많을 때 주사위 조합
    
    public int[] solution(int[][] dice) {
        dices = dice;
        N = dices.length;
        choice = new boolean[N];
        maxChoice = new boolean[N];
        
        selectDice(0);
        
        int[] answer = new int[N/2];
        int p = 0;
        for (int i = 0; i < N; i++){
            if (maxChoice[i]) {
                answer[p] = i+1;
                p += 1;
            }
        }
        return answer;
    }
    
    public void selectDice(int depth) {
        if (depth == N/2) {
            calcSum();
            return;
        }
        
        // 조합이 중복 없게끔
        int j = 0;
        for (int i = N-1; i >= 0; i--) {
            if (choice[i]) {
                j = i+1;
                break;
            }
        }
        
        for (; j < N; j++) {
            choice[j] = true;
            selectDice(depth+1);
            choice[j] = false;
        }
    }
    
    public void calcSum() {
        // 해당 조합으로 나올 수 있는 수
        List<Integer> A = generateSum(true);
        List<Integer> B = generateSum(false);
        
        // 이분 탐색으로 모든 조합에서 승리한 횟수 구함
        int win = 0;
        B.sort((o1, o2) -> {return o1 - o2;}); // 우선 내림차로 정렬
        for (int sum : A) {
            // A의 각 경우마다, B를 이기는 경우는 몇 번인지 구함
            win += countWin(sum, B);
            
            // 승리한 횟수가 더 크다면 업데이트
            if (win > maxWin) {
                maxWin = win;
                for (int i = 0; i < N; i++)
                    maxChoice[i] = choice[i];
            }
        }
    }
    
    public List<Integer> generateSum(boolean isA) {
        List<Integer> diceList = new ArrayList<>(); // 선택한 주사위 조합
        for (int i = 0; i < N; i++) 
            if (choice[i] == isA) diceList.add(i);
        
        List<Integer> sums = new ArrayList<>();
        sums.add(0);
        // 해당 주사위 조합으로 나올 수 있는 모든 점수 합
        for (int d : diceList) { // 각 주사위별로
            List<Integer> newSums = new ArrayList<>();
            for (int sum : sums) { // 기존의 총합에
                for (int face : dices[d]) newSums.add(sum + face); // 해당 주사위의 각 면을 합에 더함
            }
            sums = newSums;
        }
        return sums;
    }
    
    public static int countWin(int sum, List<Integer> B) {
        int win = 0; // 이긴 횟수
        for (int sumOfB : B){
            if (sum > sumOfB) win += 1;
            else break;
        }
        return win;
    }
}