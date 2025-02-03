package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2636 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M;
	static int[][] grid;
	static boolean[][] visited;
	static int cheeseCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				grid[n][m] = Integer.parseInt(st.nextToken());
				// 치즈 없는:0, 치즈 있는:1
				if (grid[n][m] == 1) {
					cheeseCnt++;
				}
			}
		}

		int time = 0;
		int count = cheeseCnt;
		while (cheeseCnt != 0) {
			count = cheeseCnt;
			time++;
			bfs();
		}
		
		sb.append(time).append("\n").append(count);
		System.out.println(sb);
		br.close();
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[N][M];
		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (grid[nx][ny] == 0) {
						q.offer(new int[] { nx, ny });
					} else {
						cheeseCnt--;
						grid[nx][ny] = 0;
					}
				}
			}
		}
	}
	
}
