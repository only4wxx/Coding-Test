class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        
        int allCase = 1;
        int rightTriangleCase = 1;
        for (int t = 2; t <= 2*n+1; t++) {
            int nextAllCase = allCase + rightTriangleCase;
            rightTriangleCase = allCase;
            
            if (t % 2 == 0 && tops[t/2-1] == 1) { // 위쪽 타일이 있는 경우
                nextAllCase += rightTriangleCase;
            }
            
            allCase = nextAllCase % 10007;
            
            // System.out.println(allCase + " " + rightTriangleCase);
        }
        answer = allCase;
        
        return answer;
    }
}