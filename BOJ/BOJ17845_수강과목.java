/*
 * BOJ 17845번 : 수강과목
 * 메모리 : 49,604kb
 * 시간 : 144ms
 */

import java.io.*;
import java.util.*;

public class BOJ17845_수강과목 {
	static int N, K;
	static int[] l;
	static int[] T;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 최대 공부 시간
		K = Integer.parseInt(st.nextToken()); // 과목 수
		l = new int[K+1]; // 중요도
		T = new int[K+1]; // 필요한 공부시간
		for(int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());
			l[k] = Integer.parseInt(st.nextToken());
			T[k] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[K+1][N+1]; // k번째 과목까지 고려했을 때, n번째 시간에 얻을 수 있는 최대 중요도
		for(int k = 1; k <= K; k++) {
			for(int n = 1; n <= N; n++) {
				if(n < T[k]) {
					// 현재 시간 n보다 필요한 공부 시간이 많을 때, 공부 못함
					// 이전의 중요도 그대로
					dp[k][n] = dp[k-1][n];
				} else {
					// 1. 현재 과목을 선택하지 않는 경우 
					// 2. 현재 과목을 선택하는 경우
					dp[k][n] = Math.max(dp[k-1][n], dp[k-1][n-T[k]]+l[k]);
				}
			}
		}
		sb.append(dp[K][N]);
		System.out.print(sb);
		br.close();
	}
}
