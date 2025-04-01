/*
 * SWEA 2115번 : 벌꿀채취
 * 메모리 : 28,416kb
 * 시간 : 95ms
 * 
 * 1. N*N의 격자에서 각 칸에 꿀이 주어짐
 * 2. 일꾼은 가로로 연속된 칸 M칸을 선택하고, 그 중에서 꿀 용량<=C를 만드는 꿀만 선택해서 채취
 * 3. 이익=꿀의 제곱합
 * 4. 2명의 일꾼이 겹치지 않게 꿀을 채취할 때마다 최대 이익을 구하는 문제
 */

import java.io.*;
import java.util.*;

public class SWEA2115_벌꿀채취 {
	static int N, M, C;
	static int[][] map;
	static int[][] honey;
	static int maxMoney;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			honey = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// honey[i][j] = (i,j)에서 시작하는 M칸 중 이익이 큰 부분집합 저장
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= N-M; j++) {
					int[] arr = new int[M];
					for(int k = 0; k < M; k++) {
						arr[k] = map[i][j+k];
					}
					honey[i][j] = bfs(arr);
				}
			}
			
			// 일꾼 조합 탐색
			maxMoney = 0;
			for(int i = 0; i < N; i++) { // 1번째 일꾼
				for(int j = 0; j <= N-M; j++) {
					for(int k = i; k < N; k++) { // 2번째 일꾼
						int lStart = 0;
						if(i==k) lStart=j+M; // 같은 행 일 경우
						for(int l = lStart; l <= N-M; l++) {
							int sum = honey[i][j]+honey[k][l];
							maxMoney = Math.max(maxMoney, sum);
						}
					}
				}
			}
			
			sb.append(maxMoney).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	// 부분집합 돌면서 최대 이익 계산
	private static int bfs(int[] arr) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0, 0 }); // 현재 인덱스, 누적 꿀 양, 누적 이익
		int max = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int idx = curr[0];
			int sum = curr[1];
			int cost = curr[2];
			
			max = Math.max(max, cost);
			
			for(int i = idx; i < arr.length; i++) {
				// 꿀 양이 C 이하일 경우만 유효한 조합이므로 큐에 넣음
				if(sum+arr[i] <= C) {
					q.offer(new int[] { i+1, sum+arr[i], cost+arr[i]*arr[i] });
				}
			}
		}
		
		return max;
	}
}
