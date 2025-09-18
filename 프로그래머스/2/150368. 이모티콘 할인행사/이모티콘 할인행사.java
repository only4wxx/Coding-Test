class Solution {
    public int[] ratios = { 40, 30, 20, 10 }; // 할인율
    public int[][] u;
    public int[] emo;
    public int[] resultDiscount; // 이모티콘 할인률
    public int resultNum; // 이모티콘 플러스 서비스 가입자 수
    public int resultPrice; // 이모티콘 매출액
    
    public int[] solution(int[][] users, int[] emoticons) {
        u = users;
        emo = emoticons;
        resultDiscount = new int[emo.length];
        resultNum = 0;
        resultPrice = 0;
        
        // 1. 이모티콘 플러스 가입자를 최대로 늘리고
        // 2. 이모티콘 판매액을 최대로 늘려야 함
        
        int[] discount = new int[emo.length];
        for (int i = 0; i < discount.length; i++) discount[i] = 40;
        getAllCase(discount, 0);
    
        int[] answer = { resultNum, resultPrice };
        return answer;
    }
    
    public void getAllCase(int[] discount, int point) {
        if (point >= discount.length) { // 해당 경우의 수 계산
            isSignUp(discount);
            return;
        }
        
        // 할인율의 모든 경우의 수를 계산
        int start = 40;
        for (int ratio : ratios) { // 각 할인율
            int[] nextDis = new int[discount.length];
            for (int i = 0; i < discount.length; i++) nextDis[i] = discount[i];
            nextDis[point] = ratio;
            getAllCase(nextDis, point+1);
        }
    }
    
    public void isSignUp(int[] discount) {
        // 해당 할인율로 몇 명이나 이모티콘 플러스 서비스에 가입하는지 계산
        boolean[] signUser = new boolean[u.length]; // 이모티콘 플러스 서비스 가입자
        int num = 0; // 이모티콘 플러스 서비스 가입자 수
        for (int j = 0; j < u.length; j++) { // 각 사용자
            int price = 0; // 해당 사용자가 쓴 금액
            for (int i = 0; i < discount.length; i++) {
                if (discount[i] >= u[j][0]) {
                    float emoPrice = (float)(emo[i] * (100 - discount[i])) / 100;
                    price += emo[i] * (100 - discount[i]) / 100;
                }
            }
            if (price >= u[j][1]) {
                // 이모티콘 플러스 가입
                signUser[j] = true;
                num += 1;
            }
        }
        
        if (num > resultNum) { // 서비스 가입자를 더 늘리는 게 우선이므로
            resultPrice = 0;
        }
        if (num >= resultNum) {
            getMaxTotalPrice(discount, signUser, num);
        }
    }
    
    public void getMaxTotalPrice(int[] discount, boolean[] signUser, int num) {
        // 최대 이모티콘 매출액을 찾음
        // 해당 할인율로 이모티콘 매출액이 얼마 나올 수 있는지
        int price = 0; // 이모티콘 매출액
        for (int j = 0; j < u.length; j++) {
            for (int i = 0; i < discount.length; i++) {
                if (u[j][0] <= discount[i] && !signUser[j]) { // 해당 이모티콘을 구매한다면
                    price += emo[i] * (100 - discount[i]) / 100;
                }
            }
        }
        
        if (price >= resultPrice) {
            resultNum = num;
            resultDiscount = discount;
            resultPrice = price;
        }
    }
}