package algorithm;

import java.io.*;
import java.util.*;

public class BOJ10026_적록색약 {
	static int N;
	static char[][] grid;
	static boolean[][] visited;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = input.charAt(j);
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		sb.append(cnt).append(" ");

		cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		sb.append(cnt).append("\n");

		System.out.println(sb);

	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && grid[cx][cy] == grid[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}

			if (grid[cx][cy] == 'G') {
				grid[cx][cy] = 'R';
			}
		}

	}

}
