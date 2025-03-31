// 15686
// 치킨 배달

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int[][] city;
    public static ArrayList<ArrayList<Integer>> house = new ArrayList<>(); // 각 집의 위치
    public static ArrayList<ArrayList<Integer>> chicken = new ArrayList<>(); // 각 치킨집의 위치
    public static ArrayList<ArrayList<Integer>> distances = new ArrayList<>(); // 각 집의 치킨 거리
    public static int result = 100000; // 도시의 치킨 거리의 최솟값

    public static void main(String[] args) throws Exception {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) { // 집이면
                    house.add(new ArrayList<>(Arrays.asList(i, j))); // 집의 위치 저장
                } else if (city[i][j] == 2) { // 치킨집이면
                    chicken.add(new ArrayList<>(Arrays.asList(i, j))); // 치킨집의 위치 저장
                }
            }
        }

        // 치킨집마다 모든 각 집과의 치킨 거리 구함
        for (int c = 0; c < chicken.size(); c++) {
            ArrayList<Integer> distance = new ArrayList<>();
            for (int h = 0; h < house.size(); h++) {
                distance.add(Math.abs(house.get(h).get(0) - chicken.get(c).get(0))
                    + Math.abs(house.get(h).get(1) - chicken.get(c).get(1)));
            }
            distances.add(distance);
        }
//        for (int i = 0; i < distances.size(); i++) {
//            System.out.println(distances.get((i)).toString());
//        }

        // 모든 치킨집이 살아남았을 때를 시작으로 함수 시작
        ArrayList<Integer> alive = new ArrayList<>();
        for (int i = 0; i < chicken.size(); i++) alive.add(i);
        backtracking(alive, 0);

        System.out.println(result);

        br.close();
    }

    public static void backtracking(ArrayList<Integer> alive, int n) { // close: 폐업시킨 치킨집의 인덱스 번호
//        System.out.println(alive.toString());
        if (alive.size() == M) { // 폐업시켜야 하는 개수만큼 폐업시켰다면
            int sumDistance = 0;
            for (int h = 0; h < house.size(); h++) { // 각 집마다
                int d = 100000; // 치킨 거리를 구함
                for (int num = 0; num < M; num++) {
                    if (distances.get(alive.get(num)).get(h) < d) d = distances.get(alive.get(num)).get(h);
                }
                sumDistance += d;
            }

            // 최솟값인지 확인
            if (sumDistance < result) result = sumDistance;
            return;
        }

        for (int i = n; i < alive.size(); i++) {
            ArrayList<Integer> next = new ArrayList<>(alive);
            next.remove(i); // 해당 번호의 치킨집 폐업시킴
            backtracking(next, i);
        }
    }

}