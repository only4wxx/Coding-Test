class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] sendGift = new int[friends.length][friends.length]; // 선물을 주고받기
        for (String gift : gifts) {
            // 선물 기록 계산
            String[] send = gift.split(" ");
            int A = 0; int B = 0; // A -> B에게 선물
            for (int i = 0; i < friends.length; i++) {
                if (friends[i].equals(send[0])) A = i;
                else if (friends[i].equals(send[1])) B = i;
            }
            sendGift[A][B] += 1;
        }
        
        // for (int i=0; i<sendGift.length; i++) {
        //     for (int j=0; j<sendGift[0].length; j++) {
        //         System.out.print(sendGift[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int[] giftScore = new int[friends.length]; // 선물 지수
        int[] giftNumber = new int[friends.length]; // 선물의 수
        
        // 선물 지수 계산
        for (int A = 0; A < friends.length; A++) {
            for (int B = 0; B < friends.length; B++) {
                if (A == B) continue;
                // A -> B에게 선물을 줌
                giftScore[A] += sendGift[A][B];
                giftScore[B] -= sendGift[A][B];
            }
        }
        // for (int number : giftScore) {
        //     System.out.print(number + " ");
        // }
        
        // 선물 기록 체크
        for (int A = 0; A < friends.length; A++) {
            for (int B = A+1; B < friends.length; B++) {
                if (A == B) continue;
                
                // 두 사람이 선물 주고받은 기록이 있는지
                if (sendGift[A][B] > sendGift[B][A]) giftNumber[A] += 1;
                else if (sendGift[A][B] < sendGift[B][A]) giftNumber[B] += 1;
                else { // 주고받은 기록이 없거나 수가 같다면
                    if (giftScore[A] > giftScore[B]) giftNumber[A] += 1;
                    else if (giftScore[A] < giftScore[B]) giftNumber[B] += 1;
                }
                    
            }
        }
    
        for (int number : giftNumber) {
            // System.out.print(number + " ");
            if (number > answer) answer = number;
        }
        return answer; // 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수
    }
}