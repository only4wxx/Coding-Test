class Solution {
    public String[] binarys;
    public int[] answer;
    
    public int[] solution(long[] numbers) {
        binarys = new String[numbers.length];
        answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            // 해당 숫자를 이진트리로 표현할 수 있는지
            String binary = "";
            while (number > 0) {
                if (number % 2 == 0) binary = "0" + binary;
                else binary = "1" + binary;
                number /= 2;
            }
            
            // 길이를 (2^k - 1) 꼴(포화 이진트리 노드 수)로 맞춰야 함
            int num = binary.length() + 1;
            // System.out.println(num);
            while (num > 1) {
                if (num % 2 == 1) {
                    binary = "0" + binary;
                    num = binary.length() + 1;
                    continue;
                }
                num /= 2;
            }
            // System.out.println(binary);
            binarys[i] = binary;
            
            // 루트 노드가 0이면 불가능
            if (binary.charAt(binary.length()/2) == '0') continue;
                        
            answer[i] = 1;
            // 각 서브트리를 탐색
            checkSubtree(i, 0, binary.length()-1);
        }
        
        return answer;
    }
    
    public void checkSubtree(int point, int s, int e) {
        if (answer[point] == 0) return; // 이미 불가능인 경우
        if (s >= e) return;
        
        String binary = binarys[point];
        int root = (s+e)/2;
        int left = (s+root-1)/2;
        int right = (root+1+e)/2;
        
        // 하위 노드가 1인데 상위 노드가 0인 경우 불가능
        if (binary.charAt(left) == '1' || binary.charAt(right) == '1')
            if (binary.charAt(root) == '0') {
                answer[point] = 0;
                return;
            }
        
        // 각 서브트리를 탐색
        checkSubtree(point, s, root-1);
        checkSubtree(point, root+1, e);
    }
}