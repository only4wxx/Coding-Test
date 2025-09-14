class Solution {
    public int[] d;
    public int[] p;
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        d = deliveries;
        p = pickups;
        
        long total = 0;
        int last = n-1; // 체크해야하는 마지막 집
        while (true) {
            int cap_d = cap; // 배달할 수 있는 최대 택배
            int cap_p = cap; // 수거할 수 있는 최대 택배
            int dis = -1; // 탐색한 거리
            
            // 배달
            for (int i = last; i >= 0; i--) {
                if (cap_d == 0) break; // 배달 끝
                if (d[i] > 0) {
                    if (d[i] <= cap_d) { // 모두 배달할 수 있음
                        cap_d -= d[i];
                        d[i] = 0;
                    }
                    else { // 일부만 배달할 수 있음
                        d[i] -= cap_d;
                        cap_d = 0;
                    }
                    if (dis < i) dis = i; // 탐색 거리 추가
                }
            }
            
            // 수거
            for (int i = last; i >= 0; i--) {
                if (cap_p == 0) break; // 수거 끝
                if (p[i] > 0) {
                    if (p[i] <= cap_p) { // 모두 배달할 수 있음
                        cap_p -= p[i];
                        p[i] = 0;
                    }
                    else { // 일부만 배달할 수 있음
                        p[i] -= cap_p;
                        cap_p = 0;
                    }
                    if (dis < i) dis = i; // 탐색 거리 추가
                }
            }
            
            // System.out.println(dis);
            if (dis == -1) break; // 남은 배달, 수거가 없다면 종료
            total += (dis+1) * 2; // 총 거리 추가
            last = dis;
        }
        
        return total;
    }
}