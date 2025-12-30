/*
 * 1. 플러스 가입자 수 최대화
 * 2. 매출액 최대화
 * 
 * 할인율 10, 20, 30, 40 고정
 * 모든 조합 할인율 돌려보기
 */

import java.util.*;

class Solution_이모티콘할인행사 {
    static int[] sales = new int[] { 10, 20, 30, 40 };
    static int maxPlus, maxMoney; // 플러스 가입 수, 이모티콘 매출액
    static int[] checkSales;
    
    public int[] solution(int[][] users, int[] emoticons) {
        checkSales = new int[emoticons.length]; 
        maxPlus = 0; maxMoney = 0;
        dfs(0, users, emoticons);
        
        int[] answer = new int[] { maxPlus, maxMoney };
        return answer;
    }
    
    public void dfs(int idx, int[][] users, int[] emoticons) {
        // 정한 할인율로 결과 체크하기, 갱신하기
        if(idx == emoticons.length) {
            // System.out.println(Arrays.toString(checkSales));
            check(users, emoticons);
            return;
        }
         
        // 이모티콘 할인율 정하기
        for(int i = 0; i < sales.length; i++) {
            checkSales[idx] = sales[i];
            dfs(idx+1, users, emoticons);
        }
    }
    
    public void check(int[][] users, int[] emoticons) {
        int plus = 0;
        int money = 0;
        
        for(int i = 0; i < users.length; i++) {
            int minSales = users[i][0]; // 이 할인율 이상이면 구매
            int minJoin = users[i][1]; // 이 가격 이상이면 플러스 가입
            
            int sum = 0;
            
            for(int j = 0; j < emoticons.length; j++) {
                if(minSales <= checkSales[j]) { // 구매
                    // System.out.println("구매" + minSales + " " + minJoin + " " + checkSales[j]);
                    sum += emoticons[j] * (100-checkSales[j]) / 100;
                }
            }
            
            if(sum >= minJoin) {
                plus++;
            } else {
                money += sum;
            }
        }
        
        if(plus > maxPlus) {
            maxPlus = plus;
            maxMoney = money;
        } else if(plus == maxPlus && money > maxMoney) {
            maxMoney = money;
        }
    }
}
