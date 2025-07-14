import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int dest; // 도착 정점
        int weight; // 가중치

        Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static int V;
    private static int E;
    private static int[][] edges;

    private static HashMap<Integer, Map<Integer, Integer>> adjacent; // 인접 정점

    private static int[] results; // 최종 결과값

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int source = Integer.parseInt(br.readLine());
        edges = new int[E][3];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // 인접 정점 및 간선의 가중치 기록
        adjacent = new HashMap<>(); // 인접 정점
        results = new int[V+1]; // 최종 결과값
        for (int v = 1; v <= V; v++) {
            adjacent.put(v, new HashMap<>());
            results[v] = Integer.MAX_VALUE; // 초기값
        }
        for (int[] edge : edges) {
            if (adjacent.get(edge[0]).containsKey(edge[1])) { // 이미 두 정점을 잇는 간선이 있다면
                // 더 작은 값으로 넣음
                int smaller = adjacent.get(edge[0]).get(edge[1]);
                if (smaller > edge[2]) smaller = edge[2];
                adjacent.get(edge[0]).put(edge[1], smaller);
            }
            else adjacent.get(edge[0]).put(edge[1], edge[2]); // 인접 정점 추가
        }

//        for (int v : adjacent.keySet()) {
//            System.out.println(v + " : " + adjacent.get(v));
//        }

        SSSP(source);
    }

    /* Dijkstra's Algorithm 활용 */
    public static void SSSP(int source) {
        boolean[] visited = new boolean[V+1]; // 해당 정점 방문했는지
        Queue<Node> shortestPath = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));

        results[source] = 0; // 시작점
        shortestPath.offer(new Node(source, 0)); // 시작점 추가

        while (!shortestPath.isEmpty()) { // 비워질 때까지
            Node current = shortestPath.poll(); // 가장 짧은 거리의 정점 꺼냄
            int u = current.dest;
            visited[u] = true; // 방문 처리

            for (int v : adjacent.get(u).keySet()) { // 인접한 모든 정점
                if (!visited[v] && results[u] + adjacent.get(u).get(v) < results[v]) { // 아직 방문하지 않았고, relax할 수 있다면
                    results[v] = results[u] + adjacent.get(u).get(v); // relax
                    shortestPath.offer(new Node(v, results[v])); // 우선순위 큐에 추가
                }
            }

//            for (int v = 1; v <= V; v++) {
//                if (results[v] == Integer.MAX_VALUE)
//                    System.out.println("INF");
//                else System.out.println(results[v]);
//            }
//            System.out.println("-------------");
        }

        for (int v = 1; v <= V; v++) {
            if (results[v] == Integer.MAX_VALUE)
                System.out.println("INF");
            else System.out.println(results[v]);
        }
    }
}