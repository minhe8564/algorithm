/*
 * SWEA 5215번 : 햄버거 다이어트_DP
 * 메모리 : 37,896kb
 * 시간 : 118ms
 */

import java.io.*;
import java.util.*;

public class SWEA5215_햄버거다이어트_DP {
	static int N, L;
	static int[] T;
	static int[] K;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			T = new int[N+1]; // 맛에 대한 점수
			K = new int[N+1]; // 맛에 대한 칼로리
			for(int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine());
				T[n] = Integer.parseInt(st.nextToken());
				K[n] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[N+1][L+1];
			for(int n = 1; n <= N; n++) {
				for(int l = 1; l <= L; l++) {
					if(l < K[n]) {
						dp[n][l] = dp[n-1][l];
					} else {
						dp[n][l] = Math.max(dp[n-1][l], dp[n-1][l-K[n]]+T[n]);
					}
				}
			}
			
			sb.append(dp[N][L]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
