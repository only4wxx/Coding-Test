class Solution {
    public int[] allCards;
    public int n;
    public boolean[] hand; // 손에 있는 카드
    public boolean[] isFree; // 처음에 뽑은 카드인지
    
    public int solution(int coin, int[] cards) {
        allCards = cards;
        n = allCards.length;
        hand = new boolean[n+1];
        isFree = new boolean[n+1];
        
        return cardGame(coin);
    }
    
    public int cardGame(int coin) {
        // 처음 카드
        for (int i = 0; i < n/3; i++) {
            hand[allCards[i]] = true;
            isFree[allCards[i]] = true;
        }
        
        int myCoin = coin;
        int round = 1;
        while (n/3 + (round-1) * 2 < n) {
            // 카드 두 장을 뽑음
            int card1 = allCards[n/3 + (round-1) * 2];
            int card2 = allCards[n/3 + (round-1) * 2 + 1];
            hand[card1] = true; hand[card2] = true;
            
            // 손에 있는 카드 중 합이 n+1인 카드 쌍 중, 비용이 최소인 카드 쌍을 버림
            int minCoin = 3; // 최소 비용
            int currentCard = -1; // 낼 카드
            for (int i = 1; i <= n/2; i++) {
                if (hand[i] && hand[n+1-i]) { // 합이 n+1인 카드 쌍
                    // 비용 지불이 되는지
                    int needCoin = 0;
                    if (!isFree[i]) needCoin += 1;
                    if (!isFree[n+1-i]) needCoin += 1;
                    
                    if (needCoin <= myCoin)
                        if (minCoin > needCoin) {
                            minCoin = needCoin;
                            currentCard = i;
                        }
                }
            }
            // 비용이 최소인 카드 쌍을 냄
            if (currentCard < 0) break;
            hand[currentCard] = false;
            hand[n+1-currentCard] = false;
            myCoin -= minCoin;
            // System.out.println(currentCard + " " + (n+1-currentCard));
            
            round += 1;
        }
        
        return round;
    }
}