/*
 * BOJ 3067번 : Coins
 * 메모리 : 12,016kb
 * 시간 : 72ms
 */

import java.io.*;
import java.util.*;

public class BOJ3067_Coins {
	static int N;
	static int[] coins;
	static int M;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 동전의 개수
			coins = new int[N+1]; // 동전 종류
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 1; n <= N; n++) {
				coins[n] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine()); // 만들어야 하는 금액
			
			dp = new int[M+1]; // m원을 만드는 방법의 수
			dp[0] = 1; // 0원을 만드는 방법 : 아무것도 선택하지 않는 경우 1가지
			
			// 각 동전에 대해 경우의 수 누적
			for(int n = 1; n <= N; n++) {
				// 현재 동전 coins[n]을 사용해서 만들 수 있는 금액 갱신
				for(int m = coins[n]; m <= M; m++) {
					// coins[n]원을 쓰기 전의 경우의 수 dp[m-coins[n])을 더해준다.
					dp[m] += dp[m-coins[n]];
				}
				
				// 🌟 디버깅: 각 동전 사용 후 dp 배열 상태 출력
//			    System.out.println("동전 " + coins[n] + "원 사용 후 dp 상태:");
//			    for(int i = 0; i <= M; i++) {
//			        System.out.printf("dp[%d] = %d\n", i, dp[i]);
//			    }
//			    System.out.println("----------");
			}
			
			sb.append(dp[M]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
