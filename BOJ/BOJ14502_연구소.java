package algorithm;

import java.io.*;
import java.util.*;

public class BOJ14502_연구소 {
	static int N, M;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int maxCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		buildWall(0);
		System.out.println(maxCount);
		br.close();

	}

	// 1. 벽(1) 3개 세우기
	// 벡트래킹(조합)
	private static void buildWall(int wallCount) {
		if (wallCount == 3) {
			maxCount = Math.max(maxCount, virusBfs());
			return;
		}
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m] == 0) {
					map[n][m] = 1;
					buildWall(wallCount + 1);
					map[n][m] = 0;
				}
			}
		}
	}

	// 2. 벽 안에 바이러스(2) 확산하기
	// bfs
	private static int virusBfs() {
		int[][] tempMap = new int[N][M];
		Queue<int[]> q = new ArrayDeque<int[]>();

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				tempMap[n][m] = map[n][m];
				if (tempMap[n][m] == 2) {
					q.offer(new int[] { n, m });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M && tempMap[nx][ny] == 0) {
					tempMap[nx][ny] = 2;
					q.offer(new int[] { nx, ny });
				}
			}
		}
		
		// 3. 안전영역(0) 세기
		int count = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (tempMap[n][m] == 0) {
					count++;
				}
			}
		}
		return count;
	}
}
