package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2468_안전영역 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int maxSafe = 0;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int maxRain = Integer.MIN_VALUE;
		int minRain = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxRain = Math.max(maxRain, map[i][j]);
				minRain = Math.min(minRain, map[i][j]);
			}
		}

		// 내리는 비의 양에 따른 모든 경우
		// 내리는 비의 양 (max - min)
		// 물에 잠기지 않는 안전한 영역 구하기
		for(int rain = minRain - 1; rain <= maxRain; rain++) {
			visited = new boolean[N][N];
			
			int safe = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > rain && !visited[i][j]) {
						bfs(i, j, rain);
						safe++;
					}
				}
			}
			
			if(maxSafe < safe) {
				maxSafe = safe;
			}
		}
		
		System.out.println(maxSafe);
		br.close();
	}

	private static void bfs(int x, int y, int rain) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y }); 
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] > rain && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}
		
	}
}
