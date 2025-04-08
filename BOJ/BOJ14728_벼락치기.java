/*
 * BOJ 14728번 : 벼락치기
 * 메모리 : 15,948kb
 * 시간 : 92ms
 */

import java.io.*;
import java.util.*;

public class BOJ14728_벼락치기 {
	static int N, T;
	static int[] K;
	static int[] S;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 단원 개수
		T = Integer.parseInt(st.nextToken()); // 총 시간
		K = new int[N+1]; // 각 단원 예상 공부 시간
		S = new int[N+1]; // 각 단원 문제 배점
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			K[n] = Integer.parseInt(st.nextToken());
			S[n] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N+1][T+1];
		for(int n = 1; n <= N; n++) {
			for(int t = 1; t <= T; t++) {
				if(t < K[n]) {
					// 현재 시간 t가 n번째 단원을 공부할 시간보다 부족하면,
					// 이 단원을 선택할 수 없으므로 이전 단원까지의 최댓값 그대로 사용
					dp[n][t] = dp[n-1][t];
				} else {
					// 두 가지 경우 중 더 큰 점수를 선택
					// 1. n번째 단원을 선택하지 않는 경우 : dp[n-1][t]
					// 2. n번째 단원을 선택하는 경우 : dp[n-1][t-K[n]] + S[n]
					// -> 남은 시간 t-K[n]에서 얻은 점수 + 현재 단원의 점수
					dp[n][t] = Math.max(dp[n-1][t], dp[n-1][t-K[n]]+S[n]);
				}
			}
		}
		
		sb.append(dp[N][T]);
		System.out.print(sb);
		br.close();
	}
}
