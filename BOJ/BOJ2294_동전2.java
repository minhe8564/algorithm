package algorithm;

/*
 * 1. N개의 동전들을 합해서 K원이 되도록 한다.
 * 2. 사용한 동전의 최소 개수를 출력한다.
 * 
 * 동전의 개수가 5개, 가치가 5, dp[5]=5 (동전의 가치가 1인 것 부터 생각)
 * 동전의 개수가 5개, 가치가 5, 하나의 동전의 가치가 5라면 dp[5]=1
 * 
 * dp[n] = min(dp[n], dp[n-동전의 가치]+1)
 */

import java.io.*;
import java.util.*;

public class BOJ2294_동전2 {
	static int N, K;
	static int[] coins;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coins = new int[N+1];
		for(int n = 1; n <= N; n++) {
			coins[n] = Integer.parseInt(br.readLine());
		}
//		System.out.println(Arrays.toString(coins));

		int[] dp = new int[K+1];
		for(int k = 1; k <= K; k++) {
			// dp[i-coins]+1 하면 오버플로우 발생할 수 있기 때문에 Integer.MAX_VALUE-1 해줘야 한다.
			dp[k] = Integer.MAX_VALUE-1; 
		}
		for(int n = 1; n <= N; n++) {
			for(int i = coins[n]; i <= K; i++) {
				dp[i] = Math.min(dp[i], dp[i-coins[n]]+1);
//				System.out.print(dp[i] + " ");
			}
//			System.out.println();
		}
		
		if(dp[K] == Integer.MAX_VALUE-1) {
			sb.append(-1);
		} else {
			sb.append(dp[K]);
		}
		
		System.out.print(sb);
		br.close();
	}
	
	

}
