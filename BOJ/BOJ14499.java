package algorithm;

import java.io.*;
import java.util.*;

public class BOJ14499 {
	static int N, M, x, y, K;
	static int[] dice = new int[7];
	static int[][] grid;
	static int[] dx = { 0, 0, -1, 1 }; // 동, 서, 북, 남
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				grid[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int k = 0; k < K; k++) {
			int dir = Integer.parseInt(st.nextToken());
			int nx = x + dx[dir - 1];
			int ny = y + dy[dir - 1];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}
			x = nx;
			y = ny;

//		    전개도      동:1        서:2        북:3       남:4
//		    1       1       1       3       6
//		  2 3 4   3 4 6   6 2 3   2 5 4   2 1 4
//		    5       5       5       6       3
//		    6       2       4       1       5

			int temp = dice[3];
			switch (dir) {
			case 1: // 동
				dice[2] = temp;
				dice[3] = dice[4];
				dice[4] = dice[6];
				dice[6] = dice[2];
				break;

			case 2: // 서
				dice[2] = dice[6];
				dice[3] = dice[2];
				dice[4] = temp;
				dice[6] = dice[4];
				break;

			case 3: // 북
				dice[1] = temp;
				dice[3] = dice[5];
				dice[5] = dice[6];
				dice[6] = dice[1];
				break;

			case 4: // 남
				dice[1] = dice[6];
				dice[3] = dice[1];
				dice[5] = temp;
				dice[6] = dice[5];
				break;
			}

			if (grid[x][y] == 0) { // 바닥면
				grid[x][y] = dice[6];
			} else {
				dice[6] = grid[x][y]; // 칸에 쓰여있는 수가 바닥면으로 복사
				grid[x][y] = 0; // 칸은 0
			}

			sb.append(dice[3]).append("\n"); // 윗면
		}

		System.out.println(sb);
		br.close();
	}

}
