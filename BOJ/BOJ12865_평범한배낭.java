/*
 * BOJ 12865번 : 평범한 배낭
 * 메모리 :
 * 시간 :
 * 
 * 물품의 수 N, 버틸 수 있는 무게 K
 * W만큼 넣을 수 있고, 가치는 V
 * 배낭에 넣을 수 있는 가치의 최댓값
 */

import java.io.*;
import java.util.*;

public class BOJ12865_평범한배낭 {
	static int N, K;
	static int[] weight;
	static int[] value;
	static int max;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
//		weight = new int[N];
//		value = new int[N];
//		for(int n = 0; n < N; n++) {
//			st = new StringTokenizer(br.readLine());
//			weight[n] = Integer.parseInt(st.nextToken());
//			value[n] = Integer.parseInt(st.nextToken());
//		}
		weight = new int[N+1];
		value = new int[N+1];
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			weight[n] = Integer.parseInt(st.nextToken());
			value[n] = Integer.parseInt(st.nextToken());
		}
		
//		max = Integer.MIN_VALUE;
		dp = new int[N+1][K+1];
		
//		int max = recursive(0, 0); // idx, weight, value
		
		// 4. Bottom-Up 메모리:51404kb, 시간:144ms
//		for(int i = N-1; i >= 0; i--) {
//			for(int j = K; j >= 0; j--) {
//				if(j+weight[i] <= K) {
//					int a = dp[i+1][j+weight[i]] + value[i];
//					int b = dp[i+1][j];
//					dp[i][j] = Math.max(a, b);
//				} else {
//					dp[i][j] = dp[i+1][j];
//				}
//			}
//		}
//		sb.append(dp[0][0]);
		
		// 4. Bottom-Up 메모리:51436kb, 시간:140ms
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				if(weight[i] > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
				}
			}
		}
		sb.append(dp[N][K]);
		System.out.print(sb);
		br.close();
	}
	
	// 1. 재귀 풀이 : 시간초과
//	private static void recursive(int idx, int totalWeight, int totalValue) {
//		if(totalWeight > K) { // 가방의 무게 넘으면 종료
//			return;
//		}
//		
//		if(idx == N) { // 물건의 개수 N개 모으면 갱신, 종료
//			max = Math.max(max, totalValue);
//			return;
//		}
//		
//		recursive(idx+1, totalWeight+weight[idx], totalValue+value[idx]); // 고른 경우
//		recursive(idx+1, totalWeight, totalValue); // 고르지 않은 경우
//	}
	
	// 2. 재귀 풀이, 가치값을 반환하는 함수로 변경 : 시간초과
//	private static int recursive(int idx, int totalWeight) {
//		if(totalWeight > K) { // 가방의 무게 넘으면 종료
//			return Integer.MIN_VALUE; // 이 경우는 선택하면 안되므로 큰 음수 값
//		}
//		
//		if(idx == N) { // 물건의 개수 N개 모으면 갱신, 종료
//			return 0; // 이 경우는 선택해야 하니까 답에 영향이 가지 않게 0
//		}
//		
//		int a = recursive(idx+1, totalWeight+weight[idx]) + value[idx]; // 고른 경우
//		int b = recursive(idx+1, totalWeight); // 고르지 않은 경우
//		return Math.max(a, b);
//	}
	
	// 3. Top-Down 메모리:51,688kb, 시간:168ms
//	private static int recursive(int idx, int totalWeight) {
//		if(totalWeight > K) { // 가방의 무게 넘으면 종료
//			return Integer.MIN_VALUE;
//		}
//		
//		if(idx == N) { // 물건의 개수 N개 모으면 갱신, 종료
//			return 0;
//		}
//		
//		if(dp[idx][totalWeight] != 0) {
//			return dp[idx][totalWeight];
//		}
//		int a = recursive(idx+1, totalWeight+weight[idx]) + value[idx]; // 고른 경우
//		int b = recursive(idx+1, totalWeight); // 고르지 않은 경우
//		dp[idx][totalWeight] = Math.max(a, b);
//		return dp[idx][totalWeight];
//	}
}
