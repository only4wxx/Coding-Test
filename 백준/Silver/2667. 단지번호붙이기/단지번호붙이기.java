import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int N;
    private static int[][] map;
    private static int countGroup = 1;
    private static List<Integer> groups;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] nextInput;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            nextInput = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(nextInput[j]);
            }
        }

        groups = new ArrayList<>(); // 각 단지내 집의 수
        for(int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (map[x][y] == 1) { // 집이 존재하고, 아직 탐색한 집이 아니라면
                    groups.add(0); // 단지 추가
                    countGroup++; // 단지의 번호가 됨
                    findGroup(x, y);
                }
            }
        }

        groups.sort(((a, b) -> a - b)); // 오름차순으로 정렬
        System.out.println(groups.size()); // 단지수 출력
        for (int number : groups) System.out.println(number); // 각 단지에 속하는 집의 수
        br.close();
    }

    public static void findGroup(int x, int y) {
        map[x][y] = countGroup; // 해당 집은 현재 단지에 속함
        groups.set(countGroup-2, groups.get(countGroup-2) + 1);

        // 상하좌우에 아직 탐색하지 않은 집이 있다면
        if (x < N-1 && map[x+1][y] == 1) {
            findGroup(x+1, y);
        }
        if (y < N-1 && map[x][y+1] == 1) {
            findGroup(x, y+1);
        }
        if (x > 0 && map[x-1][y] == 1) {
            findGroup(x-1, y);
        }
        if (y > 0 && map[x][y-1] == 1) {
            findGroup(x, y-1);
        }
    }
}
