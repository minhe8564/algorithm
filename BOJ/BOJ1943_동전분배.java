/*
 * BOJ 1943번 : 동전 분배
 * 메모리 : 29,000kb
 * 시간 : 612ms
 * 
 * dp[i][j] = i번째 동전까지 사용했을 때 동전의 가치 j를 만들 수 있는지 여부
 *
 * 1번째 동전의 가치가 100이고, 3개 있을 때
 * dp[1][0] = true
 * dp[1][100] = true
 * dp[1][200] = true
 * dp[1][300] = true
 *
 * 점화식
 * dp[i-1][0 ~ j] = true
 * dp[i][j + {{0-k} * 동전의 가치}] = true
 */

import java.io.*;
import java.util.*;

public class BOJ1943_동전분배 {
    static class Coin {
        int price, count;
        public Coin(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }
    static Coin[] coins;
    static boolean[][] dp;
    static final int MAX_PRICE = 100000;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 3; t++) {
            N = Integer.parseInt(br.readLine());
            coins = new Coin[N];
            int sum = 0;

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(price, count);
                sum += price * count;
            }

            if(sum % 2 == 1) {
                sb.append(0).append("\n");
            } else {
                sum /= 2;
                dp = new boolean[N+1][sum+1];
                dp[0][0] = true;

                for(int i = 1; i <= N; i++) {
                    Coin curr = coins[i-1];
                    for(int j = 0; j <= sum; j++) {
                        if(dp[i-1][j]) {
                            for(int k = 0; k <= curr.count; k++) {
                                int temp = j + curr.price * k;
                                if(temp <= sum) {
                                    dp[i][temp] = true;
                                }
                            }
                        }
                    }
                }

                if(dp[N][sum]) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
