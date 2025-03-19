/*
 * BOJ 2240번 : 자두나무 
 * 메모리 : 11,544kb
 * 시간 : 68ms
 * 
 * dp[t][w] = t초에 w번 이동했을 때 받을 수 있는 최대 자두
 * 짝수 w -> 1번 나무 
 * 홀수 w -> 2번 나무
 * 
 * 이동 안하는 경우 
 * dp[t][w] = dp[t-1][w]
 * 
 * 이동 하는 경우
 * dp[t][w] = Math.max(dp[t][w], dp[t-1][w-1])
 *  
 * 현재 위치에서 자두 받을 수 있으면++
 * 
 * T초 동안 최대 자두 개수 출력 (모든 이동 횟수 중 최소값!!!)
 */

package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2240_자두나무 {
	static int T, W;
	static int[] tree;
	static int[][] dp;
	static int maxCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		tree = new int[T+1];
		for(int t = 1; t <= T; t++) {
			tree[t] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[T+1][W+1];
		if(tree[1] == 1) dp[1][0] = 1;
		else dp[1][1] = 1;
		
		for(int t = 2; t <= T; t++) {
			for(int w = 0; w <= W; w++) {
				// 이동 안하는 경우 
				dp[t][w] = dp[t-1][w];
				
				// 이동 하는 경우 
				if(w>0) {
					dp[t][w] = Math.max(dp[t-1][w], dp[t-1][w-1]);
				}
				
				// 현재 위치에서 자두 받을 수 있으면++
				int pos;
				if(w%2==0) pos = 1;
				else pos = 2;
				if(tree[t] == pos) {
					dp[t][w]++;
				}
			}
		}
		
		// T초 동안 최대 자두 개수 출력 
		maxCnt = 0;
		for(int w = 0; w <= W; w++) {
			maxCnt = Math.max(maxCnt, dp[T][w]);
		}
		sb.append(maxCnt);
		System.out.print(sb);
		br.close();
	}
}
