/*
 * BOJ 2579번 : 계단 오르기 
 * 메모리 : 11,612kb
 * 시간 : 64ms
 * 
 * 1. 계단을 오를 때 1칸, 2칸 오르기 가능
 * 2. 1칸 3번 연속으로 불가능
 * 3. 마지막 계단은 반드시 아야 한다.
 * 
 * n-1에서 n 올라가는 경우 (n-2는 건너뛰어야 함)
 * dp[n-3]+stair[n-1]+start[n]
 * 
 * n-2에서 n 올라가는 경우
 * dp[n-2]+stair[n]
 */

package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2579_계단오르기 {
	static int N;
	static int[] stair;
	static int[] dp;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		stair = new int[N+1];
		for(int n = 1; n <= N; n++) {
			stair[n] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[N+1];
		dp[1] = stair[1];
		dp[2] = stair[1]+stair[2];
		
		for(int n = 3; n <= N; n++) {
			dp[n] = Math.max(dp[n-3]+stair[n-1]+stair[n], dp[n-2]+stair[n]);
		}
		
		answer = dp[N];
		sb.append(answer);
		System.out.print(sb);
		br.close();
	}
}
