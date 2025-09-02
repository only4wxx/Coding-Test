import java.util.HashMap;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {0, 0, 0, 0};
        
        HashMap<Integer, Integer> in = new HashMap<>(); // 들어오는 간선
        HashMap<Integer, Integer> out = new HashMap<>(); // 나가는 간선
        // 간선의 개수를 셈
        for (int[] edge : edges) {
            int A = edge[0]; int B = edge[1];
            // 나가는 간선
            if (out.containsKey(A)) out.put(A, out.get(A) + 1);
            else out.put(A, 1);
            // 들어오는 간선
            if (in.containsKey(B)) in.put(B, in.get(B) + 1);
            else in.put(B, 1);
        }
        
        // ‘생성된 정점’은 나가는 간선의 수가 2 이상이고, 들어오는 간선의 수가 0이다.
        // ‘막대 모양 그래프’의 수는 나가는 간선의 수가 0, 들어오는 간선의 수가 1 이상인 노드의 개수와 같다.
        // ‘8자 모양 그래프’의 수는 나가는 간선의 수가 2, 들어오는 간선의 수가 2 이상인 노드의 개수와 같다.
        // ‘도넛 모양 그래프’는 ‘생성된 정점’의 나가는 간선의 수에서 막대 모양 그래프와 8자 모양 그래프의 개수를 빼서 구한다.
        for (int v : out.keySet()) {
            if (out.get(v) >= 2 && !in.containsKey(v)) // 생성된 정점
                answer[0] = v;
            else if (out.get(v) == 2 && in.get(v) >= 2) // 8자 모양 그래프
                answer[3] += 1;
        }
        for (int v : in.keySet()) {
            if (in.get(v) >= 1 && !out.containsKey(v)) // 막대 모양 그래프
                answer[2] += 1;
        }
        answer[1] = out.get(answer[0]) - answer[2] - answer[3]; // 도넛 모양 그래프
        
        
        return answer;
    }
}