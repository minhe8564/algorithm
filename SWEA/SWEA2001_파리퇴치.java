package algorithm;

import java.io.*;
import java.util.*;

/*
 * 메모리 : 25,600kb
 * 실행시간 : 81ms
 */

public class SWEA2001_파리퇴치 {
	static int N, M;
	static int[][] map;
	static int[] dx = new int[] { 0, -1, -1 }; // 우, 하, 우하
	static int[] dy = new int[] { 1, 0, 1 };
	static int maxCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			maxCount = Integer.MIN_VALUE;
			for (int i = 0; i <= N-M; i++) {
				for (int j = 0; j <= N-M; j++) {
					maxCount = Math.max(maxCount, max(i, j));
				}
			}

			sb.append("#").append(t).append(" ").append(maxCount).append("\n");
		}
		System.out.println(sb);
		br.close();

	}

	private static int max(int x, int y) {
		int count = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < M; j++) {
				count += map[x+i][y+j];
			}
		}
		return count;
	}

}
