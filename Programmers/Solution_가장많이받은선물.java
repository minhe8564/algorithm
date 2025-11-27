import java.util.*;

class Solution_가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        Map<String, Integer> friendIdx = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            friendIdx.put(friends[i], i); 
        }
        
        int[][] giftLog = new int[n][n];
        int[] giftPoint = new int[n];
        for(String gift : gifts) {
            String[] g = gift.split(" ");
            int give = friendIdx.get(g[0]);
            int receive = friendIdx.get(g[1]);
            
            giftLog[give][receive]++;
            giftPoint[give]++;
            giftPoint[receive]--;
        }
        
        int[] nextMonth = new int[n];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++){
                if(giftLog[i][j] > giftLog[j][i]) {
                    nextMonth[i]++;
                } else if(giftLog[i][j] < giftLog[j][i]) {
                    nextMonth[j]++;
                } else {
                    if(giftPoint[i] > giftPoint[j]) {
                         nextMonth[i]++;
                    } else if(giftPoint[i] < giftPoint[j]) {
                        nextMonth[j]++;
                    }
                }
            }
        }
        
        Arrays.sort(nextMonth);
        answer = nextMonth[n-1];
        return answer;
    }
}
