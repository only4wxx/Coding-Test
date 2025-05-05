// 11000
// 강의실 배정


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] classes = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            classes[i][0] = Integer.parseInt(st.nextToken());
            classes[i][1] = Integer.parseInt(st.nextToken());
        }

        assignClasses(classes);
        br.close();
    }



    public static void assignClasses(int[][] classes) {

        // 우선순위 큐 생성
        // 1. 시작 시간을 기준으로 정렬 -> 2. 종료 시간을 기준으로 정렬
        PriorityQueue<int[]> sortClass = new PriorityQueue<>(((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        }));

        for (int[]c : classes) sortClass.offer(c);

        PriorityQueue<Integer> rooms = new PriorityQueue<>(); // 강의실
        // 가장 일찍 끝나는 강의실부터 배정 -> 끝나는 시간을 큐에 넣음
        rooms.offer((sortClass.poll())[1]);
        while (!sortClass.isEmpty()) {
            int[] nextClass = sortClass.poll(); // 다음으로 배정할 수업이 끝나는 시간
            int earliest = rooms.poll(); // 가장 일찍 끝나는 강의실
            if (nextClass[0] >= earliest) { // 해당 강의실에 배정될 수 있다면
                rooms.offer(nextClass[1]); // 해당 강의실을 배정 -> 해당 수업의 끝나는 시간을 큐에 넣음
            }
            else { // 해당 강의실에 배정될 수 없다면
                rooms.offer(earliest); // 원래 강의실은 그대로 둠
                rooms.offer(nextClass[1]); // 새로운 강의실을 배정
            }
//            System.out.println(rooms);
        }

        System.out.println(rooms.size()); // 최종 강의실 개수를 출력
    }
}